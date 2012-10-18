package test;

/**
 * A simple Java launcher for a decision "DetermineVacationDays"
 * 
 */

import com.openrules.ruleengine.Decision;

public class Main {

	public static void main(String[] args) {
		String fileName = "file:rules/DecisionWithMap.xls";
		Decision decision = new Decision("SetMapVariables",fileName);
		MyObject obj = new MyObject();
		MyMap map = new MyMap();
		map.put("var1", "value1");
		map.put("var2", "value2");
		map.put("var3", "");
		obj.setMap(map);
		System.out.println("BEFORE: " + map);
		decision.put("object",obj);
		decision.execute();
		System.out.println("AFTER: " + map);
	}
}
