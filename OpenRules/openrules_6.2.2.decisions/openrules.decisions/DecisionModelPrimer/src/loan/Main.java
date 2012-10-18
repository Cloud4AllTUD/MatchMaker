package loan;

/**
 * A Java launcher for the Decision Model primer
 */

import com.openrules.ruleengine.Decision;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/DecisionModel.xls";
		Decision decision = new Decision("DetermineLikelihoodOfDefaultingOnLoan",fileName);
		decision.execute();
	}
}
