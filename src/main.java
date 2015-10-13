import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import et5.service.comparator.GoalComparator;
import eu.dataaccess.footballpool.ArrayOftGameCard;
import eu.dataaccess.footballpool.ArrayOftGameInfo;
import eu.dataaccess.footballpool.ArrayOftGoal;
import eu.dataaccess.footballpool.Info;
import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.TFullTeamInfo;
import eu.dataaccess.footballpool.TGameCard;
import eu.dataaccess.footballpool.TGameInfo;
import eu.dataaccess.footballpool.TGoal;

public class main {

	static Info info = new Info();
	static InfoSoapType soap = info.getInfoSoap();

	final static int NB_MATCHES_FIRST_LAP = 48;
	final static int NB_MATCHES_SECOND_LAP = 56; // huitièmes
	final static int NB_MATCHES_THIRD_LAP = 60; // quarts
	final static int NB_MATCHES_FOURTH_LAP = 62; // demis
	final static int NB_MATCHES_FINAL_LAP = 63; // finale

	public static void main(String[] args) {

		String country = "Germany";
		List<Integer> idPays = getAllIdTeam(country);
		System.out.println("Parcours : \n");
		for (int id : idPays) {
			printInfoMatchById(id);
		}
		
		getCountryInformation(country);
	}

	private static void getCountryInformation(String country) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nTimes at World Cup : "+soap.playedAtWorldCup(country));
		TFullTeamInfo teamInfo = soap.fullTeamInfo(country);
		sb.append("\n"+teamInfo.getSCoach());
		sb.append("\n"+teamInfo.getSCountryFlagLarge());		
		System.out.println(sb);
	}

	private static List<Integer> getAllIdTeam(String country) {
		List<Integer> result = new ArrayList<Integer>();

		ArrayOftGameInfo games = soap.allGames();
		List<TGameInfo> listGames = games.getTGameInfo();

		for (TGameInfo game : listGames) {
			if (game.getTeam1().getSName().equals(country)
					|| game.getTeam2().getSName().equals(country)) {
				result.add(game.getIId());
			}
		}

		return result;
	}

	private static void printInfoMatchById(int i) {
		StringBuilder sb = new StringBuilder();
		TGameInfo gameInfo = soap.gameInfo(i);

		int idMatch = Integer
				.parseInt(gameInfo.getSDescription().split(" ")[1]);
		sb.append("### Match " + idMatch + " : ");
		if (idMatch <= NB_MATCHES_FIRST_LAP) {
			sb.append("poules");
		} else if (idMatch <= NB_MATCHES_SECOND_LAP) {
			sb.append("1/8");
		} else if (idMatch <= NB_MATCHES_THIRD_LAP) {
			sb.append("1/4");
		} else if (idMatch <= NB_MATCHES_FOURTH_LAP) {
			sb.append("1/2");
		} else if (idMatch <= NB_MATCHES_FINAL_LAP) {
			sb.append("final");
		}

		sb.append("\nFinal score : ");
		sb.append(gameInfo.getTeam1().getSName() + "\t" + gameInfo.getSScore()
				+ "\t" + gameInfo.getTeam2().getSName());

		// Stade
		sb.append("\nURL STADE : "+gameInfo.getStadiumInfo().getSGoogleMapsURL());

		sb.append("\n\n### goals ###");
		// buteurs
		ArrayOftGoal goals = gameInfo.getGoals();
		List<TGoal> listGoal = goals.getTGoal();
		Collections.sort(listGoal, GoalComparator.getminuteGoalComparator());

		for (TGoal goal : goals.getTGoal()) {
			sb.append("\n" + goal.getIMinute() + "' : " + goal.getSTeamName()
					+ " , " + goal.getSPlayerName());
		}

		sb.append("\n\n### Cards ###");
		// cartons
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
		System.out.println(sb);
	}
}
