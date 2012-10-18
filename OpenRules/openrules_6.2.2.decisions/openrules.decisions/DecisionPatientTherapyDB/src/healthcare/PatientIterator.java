package healthcare;

import java.sql.Timestamp;
import org.apache.commons.beanutils.DynaBean;
import com.openrules.tools.DatabaseIterator;

public class PatientIterator extends DatabaseIterator {

	public PatientIterator(String dbName, String tableName) {
		super(dbName, tableName);
	}
	
	public Patient nextPatient() {
		DynaBean bean = next();

		Patient patient = new Patient();
		String first = (String) bean.get("first name");
		String last = (String) bean.get("last name");
		String gender = (String) bean.get("gender");
		patient.setName(first + " " + last);
		patient.setGender(gender);
		Timestamp dob = (Timestamp) bean.get("date of birth");
		patient.setAge(dob);
		Double weight = (Double) bean.get("weight");
		patient.setWeight(weight.doubleValue());
		Double cl = (Double) bean.get("creatinine level");
		patient.setCreatinineLevel(cl.doubleValue());
		String allergies = (String) bean.get("allergies");
		if (allergies != null) {
			String[] array = allergies.split("\\r\\n");
			patient.setAllergies(array);
		}
		
		String medications = (String) bean.get("medications");
		if (medications != null) {
			String[] array = medications.split("\\r\\n");
			patient.setActiveMedication(array);
		}
		return patient;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PatientIterator iter = new PatientIterator("DBPatients", "Students");
		while(iter.hasNext()) {
			Patient patient = iter.nextPatient();
			System.out.println(patient.toString());
		}

	}

}
