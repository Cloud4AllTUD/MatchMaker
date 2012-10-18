package hello;

import static java.lang.System.out;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;

import com.openrules.ruleengine.Decision;
import com.openrules.tools.DatabaseIterator;

public class MainDatabaseIterator {

	public static void main(String[] args) {
		
		String fileName = "file:rules/main/Decision.xls";
		Decision decision = new Decision("DetermineCustomerGreeting",fileName);
		decision.put("trace","Off");
		Response response = new Response();
		decision.put("response", response);
		String dbName = "TestDB";
		String tableName = "Customers";
		DatabaseIterator iter = new DatabaseIterator(dbName, tableName);
		int n = 0;
		while (iter.hasNext()) {
			DynaBean bean = iter.next();
			if (n == 0) {
				DynaClass dynaClass = bean.getDynaClass();
				DynaProperty properties[] = dynaClass.getDynaProperties();
				for (int i = 0; i < properties.length; i++) {
					System.out.println("Property: " + properties[i].toString());
				}
			}
			n++;
			Customer customer = new Customer();
			String name = (String)bean.get("customername");
			String gender = (String)bean.get("gender");
			String maritalStatus = (String)bean.get("maritalstatus");
			int age = (Integer)bean.get("age");
			customer.setName(name);
			customer.setGender(gender);
			customer.setMaritalStatus(maritalStatus);
			customer.setAge(age);
			out.println("\n"+customer);
			decision.put("customer", customer);
			decision.execute();
			out.println("Decision: " 
					    + response.getGreeting()
						+ ", " + response.getSalutation()
						+ " " + customer.getName() + "!");
		}
		iter.close();
	}
}
