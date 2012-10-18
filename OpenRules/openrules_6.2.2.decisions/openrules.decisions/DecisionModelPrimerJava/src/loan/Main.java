package loan;

/**
 * A Java launcher for the Decision Model primer
 */

import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/DecisionModel.xls";
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		Object[] borrowers = (Object[]) engine.run("getBorrowers");
		Decision decision = new Decision("DetermineLikelihoodOfDefaultingOnLoan",engine);
		for (int i = 0; i < borrowers.length; i++) {
			decision.put("borrower",borrowers[i]);
			System.out.println("\n=== BORROWER: " + borrowers[i]);
			decision.execute();
		}
		
	}
}
