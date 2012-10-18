package healthcare;

/* 
 * Developed by OpenRules Inc.
 */

import com.openrules.ruleengine.Decision;

public class Main {
	public static void main(String[] args) {
		String fileName = "file:rules/DecisionPatientTherapy.xls";
		Decision decision = new Decision("DeterminePatientTherapy",fileName);
		PatientIterator iter = new PatientIterator("DBPatients", "Students");
		while(iter.hasNext()) {
			Patient patient = iter.nextPatient();
			System.out.println("\n" + patient);
			Visit visit = new Visit();
		    visit.setPatient(patient);
		    decision.put("patient",patient);
		    decision.put("visit",visit);
			decision.execute();
		}
		iter.close();
	}
}
