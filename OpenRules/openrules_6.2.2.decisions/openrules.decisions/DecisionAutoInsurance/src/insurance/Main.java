package insurance;

import com.openrules.ruleengine.Decision;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "file:rules/main/Decision.xls";
		Decision decision = new Decision("DetermineInsurancePremium",fileName);
		Policy p = new Policy();
		p.setDrivers((Driver[])decision.getEngine().run("getDrivers"));
		p.setVehicles((Vehicle[])decision.getEngine().run("getVehicles"));
		p.setUsages((Usage[])decision.getEngine().run("getUsage"));
		p.setAddress((Address)decision.getEngine().run("getAddress"));
		out.println("*** Policy: "+ p);
		decision.put("policy", p);
//		decision.put("driver",p.getDrivers()[0]);
//		decision.put("vehicle",p.getVehicles()[0]);
		decision.execute();
		out.println("After decision's run:\n" + p);
	}
}
