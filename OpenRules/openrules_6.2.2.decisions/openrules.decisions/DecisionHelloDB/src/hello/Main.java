package hello;

/**
 * A simple Java launcher for Rules.xls with
 * accessing data from a database using DbUtil
 * 
 * @author jf 
 */

import java.sql.ResultSet;

import com.openrules.ruleengine.Decision;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "file:rules/main/Decision.xls";
		Decision decision = new Decision("DetermineCustomerGreeting",fileName);
		decision.put("trace","Off");
		Response response = new Response();
		decision.put("response", response);
		TestDB db = new TestDB();
		ResultSet rs = db.openTable("Customers");
		Customer customer;
		while((customer = db.nextCustomer(rs)) != null) {
			out.println("\n"+customer);
			decision.put("customer", customer);
			decision.execute();
			out.println("Decision: " 
					    + response.getGreeting()
						+ ", " + response.getSalutation()
						+ " " + customer.getName() + "!");
		}
		db.closeTable(rs);
	}
}
