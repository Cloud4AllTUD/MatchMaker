package hello;

/**
 * A simple Java launcher for Rules.xls with
 * data defined in Java objects
 * 
 * @author jf 
 */

import com.openrules.ruleengine.Decision;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "file:rules/main/Decision.xls";
		Decision decision = new Decision("DetermineCustomerGreeting",fileName);
		Customer[] customers = (Customer[])decision.getEngine().run("getCustomers");
		for (int i = 0; i < customers.length; i++) {
			Customer customer = customers[i];
			out.println("\n=== Before decision's run:\n" + customer);
			decision.put("customer", customer);
			decision.execute();
			out.println("After decision's run:\n" + customer);
		}
		
	}
}
