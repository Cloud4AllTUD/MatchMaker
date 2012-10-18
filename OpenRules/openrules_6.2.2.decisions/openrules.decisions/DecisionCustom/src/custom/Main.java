package custom;

/**
 * A simple Java launcher for a decision "DetermineVacationDays"
 * 
 */

import com.openrules.ruleengine.Decision;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/DecisionCustom.xls";
		Decision decision = new Decision("DecisionSenior",fileName);
		Customer customer = new Customer();
		customer.setName("Joe Brown");
		customer.setAge(65);
		customer.setMaritalStatus("Married");
		customer.setGender("Male");
		decision.put("customer",customer);
		decision.execute();
		System.out.println(customer);
	}
}
