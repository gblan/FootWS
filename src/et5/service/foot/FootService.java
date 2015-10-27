package et5.service.foot;

import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import et5.service.route.Route;
import et5.service.route.Route.Matches;
import et5.service.route.Route.Matches.Match;
import et5.service.route.Route.Matches.Match.Cards;
import et5.service.route.Route.Matches.Match.Cards.Card;
import et5.service.route.Route.Matches.Match.Goals;
import et5.service.route.Route.Matches.Match.Goals.Goal;
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
public class FootService {
	/* parameters for wsdl acces */
	private InfoSoapType soap;

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
	 *            for wsdl access
	 */
	public FootService(Info info) {
		this.soap = info.getInfoSoap();
	}

	public void obtenirParcours(String pays) {
		// Retourne un XML
	}

	public URI afficherCarte(String ville) {
		// Retourne l'URL Google Maps de la ville
		return null;
	}

	/**
	 * print information about a country in param
	 * 
	 * @param country
	 * @return String
	 */
	public Route getCountryRoute(String country) {
		TFullTeamInfo teamInfo = this.soap.fullTeamInfo(country);
		Route route = new Route();
		route.setCoachName(teamInfo.getSCoach());
		route.setFlagURL(teamInfo.getSCountryFlagLarge());
		route.setNbParticipation(BigInteger.valueOf(soap
				.playedAtWorldCup(country)));
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
	 *            country
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
	 * 
	 * @param idMatch
	 */
	private Match getInfoMatchById(int id) {
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
		} else if (idMatch <= NB_FINAL_LAP) {
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
