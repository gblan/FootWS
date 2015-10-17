package et5.service.foot;
import java.util.Comparator;

import eu.dataaccess.footballpool.TGoal;


public class GoalComparator {

	/**
	 * @return Comparator used to sort goals depending on the minute
	 */
	public static Comparator<? super TGoal> getminuteGoalComparator() {
		return new Comparator<TGoal>() {
			@Override
			public int compare(TGoal o1, TGoal o2) {
				int x = o1.getIMinute();
				int y = o2.getIMinute();
				return x < y ? -1 : x > y ? 1 : 0;
			}
		};
	}

}
