package vacation;

/**
 * A simple Java launcher for a decision "DetermineVacationDays"
 * 
 */

import com.openrules.ruleengine.Decision;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/DecisionVacationDays.xls"; 
		Decision decision = new Decision("DetermineVacationDays",fileName);
		decision.execute();
	}
}
