package et5.service.foot;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public static void main(String[] args) {
		FootService fs = new FootService(new Info());

		String country = "Germany";
		List<Integer> idPays = fs.getAllMatchesTeam("Germany");
		System.out.println("Route of '"+country+"' : \n");
		for (int id : idPays) {
			System.out.println(fs.getInfoMatchById(id));
		}

		System.out.println(fs.getCountryInformation(country));
	}
	
	/* parameters for wsdl acces*/
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
	 * @param info for wsdl access
	 */
	public FootService(Info info) {
		this.soap = info.getInfoSoap();
	}
	
	public void obtenirParcours(String pays){
		// Retourne un XML
	}
	
	public URI afficherCarte(String ville){
		// Retourne l'URL Google Maps de la ville
		return null;
	}

	/**
	 * print information about a country in param
	 * @param country
	 * @return String 
	 */
	private String getCountryInformation(String country) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nTimes at World Cup : "+this.soap.playedAtWorldCup(country));
		TFullTeamInfo teamInfo = this.soap.fullTeamInfo(country);
		sb.append("\n"+teamInfo.getSCoach());
		sb.append("\n"+teamInfo.getSCountryFlagLarge());		
		return sb.toString();
	}

	/**
	 * @param String country
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
	private String getInfoMatchById(int id) {
		StringBuilder sb = new StringBuilder();
		TGameInfo gameInfo = this.soap.gameInfo(id);

		/* print match category */
		int idMatch = Integer
				.parseInt(gameInfo.getSDescription().split(" ")[1]);
		sb.append("### Match " + idMatch + " : ");
		if (idMatch <= NB_FIRST_LAP) {
			sb.append("poules");
		} else if (idMatch <= NB_SECOND_LAP) {
			sb.append("1/8");
		} else if (idMatch <= NB_THIRD_LAP) {
			sb.append("1/4");
		} else if (idMatch <= NB_FOURTH_LAP) {
			sb.append("1/2");
		} else if (idMatch <= NB_FINAL_LAP) {
			sb.append("final");
		}

		/* final score */
		sb.append("\nFinal score : ");
		sb.append(gameInfo.getTeam1().getSName() + "\t" + gameInfo.getSScore()
				+ "\t" + gameInfo.getTeam2().getSName());

		/* Stade on maps  */
		sb.append("\nURL STADE : "+gameInfo.getStadiumInfo().getSGoogleMapsURL());

		/* goals */
		sb.append("\n\n### goals ###");
		ArrayOftGoal goals = gameInfo.getGoals();
		List<TGoal> listGoal = goals.getTGoal();
		Collections.sort(listGoal, GoalComparator.getminuteGoalComparator());

		for (TGoal goal : goals.getTGoal()) {
			sb.append("\n" + goal.getIMinute() + "' : " + goal.getSTeamName()
					+ " , " + goal.getSPlayerName());
		}

		/* cards*/
		sb.append("\n\n### Cards ###");
		ArrayOftGameCard cards = gameInfo.getCards();
		for (TGameCard card : cards.getTGameCard()) {
			sb.append("\n" + card.getSTeamName()
					+ " (" + card.getSPlayerName().trim() + ") ");
			if (card.isBRedCard()) {
				sb.append("RED CARD");
			} else {
				sb.append("YELLOW CARD");

			}
		}
		return sb.toString();
	}
}
