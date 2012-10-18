package upsell;

/**
 * A simple Java launcher for a decision "DetermineVacationDays"
 * 
 */

import com.openrules.ruleengine.Decision;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/DecisionUpSell.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		Decision decision = new Decision("DetermineUpSellOffers",fileName);
		Response response = new Response();
		decision.put("response",response);
//		decision.put("trace", "Off");
		decision.execute();
		//System.out.println(response);
	}
}
