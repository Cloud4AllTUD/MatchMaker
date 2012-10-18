package hello;

/**
 * A simple Java launcher for Rules.xls with
 * data defined in Excel file Data.xls
 * 
 */

import com.openrules.ruleengine.Decision;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/main/Decision.xls";
		Decision decision = new Decision("DetermineCustomerGreeting",fileName);
		decision.execute();
		System.out.println("Decision: " + decision.get("result")); 
	}
}
  