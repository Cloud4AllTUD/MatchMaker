package loan;

/* 
 * Developed by OpenRules Inc.
 */

import com.openrules.ruleengine.Decision;

public class Main {
	public static void main(String[] args) {
		String fileName = "file:rules/main/Decision.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		Decision decision = new Decision("DetermineLoanPreQualificationResults",fileName);
		
		decision.put("trace", "Off");
		decision.execute();
	}
}
