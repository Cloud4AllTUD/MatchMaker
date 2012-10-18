package hello;

import com.openrules.ruleengine.OpenRulesEngine;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/main/Main.xls";
		OpenRulesEngine engine = new OpenRulesEngine(fileName);

		Customer customer = new Customer();
		customer.setName("Robinson");
		customer.setGender("Female");
		customer.setMaritalStatus("Married");

		App app = new App();
		app.setCustomer(customer);

		engine.run("main", app);
		System.out.println("\nResult: " + app.getResult());
	}
}
