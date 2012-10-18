package hello;

/**
 * A simple Java launcher for Rules.xls with
 * data defined in Java objects
 * 
 * @author jf 
 */

import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

import static java.lang.System.out;

public class MainData {

	public static void main(String[] args) {
		
		String fileName = "file:rules/main/Decision.xls";
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		Customer[] customers = (Customer[])engine.run("getCustomers");
		for (int i = 0; i < customers.length; i++) {
			Customer customer = customers[i];
			out.println("\nBefore decision's run: " + customer);
//			Response response = new Response();
//			decision.put("customer", customer);
//			decision.put("response", response);
//			decision.execute();
			out.println("\nAfter decision's run: " + customer);
//			out.println("Decision: " 
//					    + response.getGreeting()
//						+ ", " + response.getSalutation()
//						+ customers[0].getName() + "!");
		}
		
	}
}
