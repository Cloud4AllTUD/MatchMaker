package simple;

/**
 * A simple Java launcher for a decision "DetermineVacationDays"
 * 
 */

import com.openrules.ruleengine.Decision;

public class Main {

	public static void main(String[] args) { 
		String fileName = "file:rules/DecisionOneOrTwo.xls";
		Decision decision = new Decision("DecisionSwap",fileName);
		decision.execute();
	}
}
