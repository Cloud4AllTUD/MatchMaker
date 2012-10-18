package healthcare;

/* 
 * Developed by OpenRules Inc.
 */

import com.openrules.ruleengine.Decision;

public class Main {
	public static void main(String[] args) {
		String fileName = "file:rules/DecisionPatientTherapy.xls";
		Decision decision = new Decision("DeterminePatientTherapy",fileName);
		decision.execute();
	}
}
