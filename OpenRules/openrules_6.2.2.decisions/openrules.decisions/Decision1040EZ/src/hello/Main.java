package hello;

/**
 * A simple Java launcher for Decision.xls 
 * It read input data (taxReturn) from Excel file Data.xls
 * 
 */

import org.openl.types.impl.DynamicObject;

import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/main/Decision.xls";
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		Decision decision = new Decision("Apply1040EZ",engine);
		DynamicObject taxReturn = (DynamicObject) engine.run("getTaxReturn");
		engine.log("=== INPUT:\n" + taxReturn);
		decision.put("taxReturn",taxReturn);
		//decision.put("trace","Off");
		decision.execute();
		engine.log("=== OUTPUT:\n" + taxReturn);
	}
}
  