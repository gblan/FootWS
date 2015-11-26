package et5.service.foot;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import et5.service.route.Route;
import et5.service.route.Route.Matches;
import et5.service.route.Route.Matches.Match;
import et5.service.route.Route.Matches.Match.Cards;
import et5.service.route.Route.Matches.Match.Cards.Card;
import et5.service.route.Route.Matches.Match.Goals;
import et5.service.route.Route.Matches.Match.Goals.Goal;
import et5.service.utils.Utils;
import eu.dataaccess.footballpool.ArrayOftGameCard;
import eu.dataaccess.footballpool.ArrayOftGameInfo;
import eu.dataaccess.footballpool.ArrayOftGoal;
import eu.dataaccess.footballpool.Info;
import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.TFullTeamInfo;
import eu.dataaccess.footballpool.TGameCard;
import eu.dataaccess.footballpool.TGameInfo;
import eu.dataaccess.footballpool.TGoal;

/**
 * Class used to get information about football using the webservice
 * http://footballpool.dataaccess.eu/data/info.wso?wsdl
 */
public class FootServiceManager {
	/* parameters for wsdl acces */
	private InfoSoapType soap;
	private static final String responseQueue = "activemq:foot.responseQueue";
	private static final String requestQueue = "activemq:foot.requestQueue";
	private CamelContext camelcontext = new DefaultCamelContext();
	/**
	 * const to know the kind of match was played
	 */
	final static int NB_FIRST_LAP = 48;
	final static int NB_SECOND_LAP = 56; // 1/8 of final
	final static int NB_THIRD_LAP = 60; // 1/4 of final
	final static int NB_FOURTH_LAP = 62; // 1/2 final
	final static int NB_FINAL_LAP = 63; // final

	/**
	 * @param info
	 * Constructor need info parameter for wsdl access
	 */
	public FootServiceManager(Info info) {
		this.soap = info.getInfoSoap();
	}

	public String obtenirParcours(String country) throws JAXBException, IOException {
		// Retourne un XML : TODO : voir si retourner un string ou autre chose
		Route route = getCountryRoute(country);
		String filename = UUID.randomUUID().toString();
		Utils.marshal("et5.service.route", route, filename+".xml");
		return Utils.fileToString(filename+".xml");
	}

	public void connect() throws Exception {
		// Creation d'un contexte JNDI
		Context jndiContext = new InitialContext();
		
		// Lookup de la fabrique de connexion et de la destination
		ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");		

		camelcontext.addComponent("jms-test", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		camelcontext.start();		
	}


	/**
	 * @param message
	 * @param header
	 * @throws Exception
	 * envoi du code produit dans la queue
	 */
	public void sendMessageWithHeader(String message, String header) throws Exception {
		ProducerTemplate pt = camelcontext.createProducerTemplate();
		pt.sendBodyAndHeader(requestQueue, message, header);
	}
	
	/**
	 * print route information about a country in param
	 * 
	 * @param country
	 * @return String
	 */
	public Route getCountryRoute(String country) {
		TFullTeamInfo teamInfo = this.soap.fullTeamInfo(country);
		Route route = new Route();
		
		route.setCoachName(teamInfo.getSCoach());
		route.setFlagURL(teamInfo.getSCountryFlagLarge());
		route.setNbParticipation(BigInteger.valueOf(soap.playedAtWorldCup(country)));
		route.setTeamName(country);

		Matches matches = new Matches();
		List<Integer> idPays = getAllMatchesTeam(country);
		for (int id : idPays) {
			matches.getMatch().add(getInfoMatchById(id));
		}

		route.setMatches(matches);
		return route;
	}

	/**
	 * @param String 
	 * @return List of all matchs of team passed in param
	 */
	private List<Integer> getAllMatchesTeam(String country) {
		List<Integer> result = new ArrayList<Integer>();

		ArrayOftGameInfo games = this.soap.allGames();
		List<TGameInfo> listGames = games.getTGameInfo();

		for (TGameInfo game : listGames) {
			if (game.getTeam1().getSName().equals(country)
					|| game.getTeam2().getSName().equals(country)) {
				result.add(game.getIId());
			}
		}

		return result;
	}

	/**
	 * print info on a specific match passed in parameter
	 * @param idMatch
	 */
	public Match getInfoMatchById(int id) throws SOAPFaultException{
		Match match = new Match();
		TGameInfo gameInfo = this.soap.gameInfo(id);

		/* print match category */
		int idMatch = Integer
				.parseInt(gameInfo.getSDescription().split(" ")[1]);
		match.setIdMatch(BigInteger.valueOf(idMatch));

		if (idMatch <= NB_FIRST_LAP) {
			match.setCompetitionPhase("Group stage");
		} else if (idMatch <= NB_SECOND_LAP) {
			match.setCompetitionPhase("Round of 16");
		} else if (idMatch <= NB_THIRD_LAP) {
			match.setCompetitionPhase("Quarter-finals");
		} else if (idMatch <= NB_FOURTH_LAP) {
			match.setCompetitionPhase("Semi-finals");
		} else if (idMatch > NB_FINAL_LAP) {
			match.setCompetitionPhase("Final");
		}

		/* final score */
		match.setTeam1(gameInfo.getTeam1().getSName());
		match.setFinalScore(gameInfo.getSScore());
		match.setTeam2(gameInfo.getTeam2().getSName());

		/* Stade on maps */
		match.setStadiumMapsURL(gameInfo.getStadiumInfo().getSGoogleMapsURL());

		/* goals */
		ArrayOftGoal listTgoals = gameInfo.getGoals();
		List<TGoal> listGoal = listTgoals.getTGoal();
		Collections.sort(listGoal, GoalComparator.getminuteGoalComparator());

		Goals goals = new Goals();
		for (TGoal tgoal : listTgoals.getTGoal()) {
			Goal goal = new Goal();
			goal.setMinutes(BigInteger.valueOf(tgoal.getIMinute()));
			goal.setGoalTeam(tgoal.getSTeamName());
			goal.setStriker(tgoal.getSPlayerName().trim());
			goals.getGoal().add(goal);
		}
		match.setGoals(goals);

		/* cards */
		Cards cards = new Cards();
		ArrayOftGameCard listcards = gameInfo.getCards();
		for (TGameCard tCard : listcards.getTGameCard()) {
			Card card = new Card();
			card.setColor((tCard.isBRedCard()) ? "Red card" : "Yellow Card");
			card.setGoalTeam(tCard.getSTeamName());
			card.setPlayer(tCard.getSPlayerName().trim());
			cards.getCard().add(card);
		}
		match.setCards(cards);

		return match;
	}
}
