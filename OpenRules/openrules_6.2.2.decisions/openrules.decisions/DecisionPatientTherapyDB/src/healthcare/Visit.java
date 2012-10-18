package healthcare;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Visit {
	
	Date	date;
	Patient	patient;
	String	encounterDiagnosis;
	String	medication;
	String	dose;
	String	warning;
	String[] patients;
	
	public Visit() {
		encounterDiagnosis = "Acute Sinusitis";
		date = Calendar.getInstance().getTime();
		patients = null;
	}


	public void setPatient(String name) {
		this.patient = null;
		PatientIterator iter = new PatientIterator("DBStudents", "Students");
		while(iter.hasNext()) {
			Patient patient = iter.nextPatient();
			if (name.equals(patient.getName())) {
			   this.patient = patient;
			   break;
			}
		}
		iter.close();		
	}
	
	public void updatePatient() {
		String name = patient.name;
		setPatient(name);
	}
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public String getEncounterDiagnosis() {
		return encounterDiagnosis;
	}


	public void setEncounterDiagnosis(String encounterDiagnosis) {
		this.encounterDiagnosis = encounterDiagnosis;
	}


	public String getMedication() {
		return medication;
	}


	public void setMedication(String medication) {
		this.medication = medication;
	}


	public String getDose() {
		return dose;
	}


	public void setDose(String dose) {
		this.dose = dose;
	}


	public String getWarning() {
		return warning;
	}


	public void setWarning(String warning) {
		this.warning = warning;
	}
	

	@Override
	public String toString() {
		return "Visit [date=" + date + ", patient=" + patient
				+ ", encounterDiagnosis=" + encounterDiagnosis
				+ ", medication=" + medication + ", dose=" + dose
				+ ", warning=" + warning + "]";
	}
	
	public String[] getNames() {
		if (patients == null) {
			PatientIterator iter = new PatientIterator("DBPatients", "Students");
			ArrayList<String> names = new ArrayList<String>();
			while(iter.hasNext()) {
				Patient patient = iter.nextPatient();
				names.add(patient.getName());
			}
			iter.close();
			patients = new String[names.size()];
			for (int i = 0; i < patients.length; i++) {
				patients[i] = names.get(i);
			}
		}
		return patients;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Visit visit = new Visit();
		String[] names = visit.getNames();
		for (int i = 0; i < names.length; i++) {
			System.err.println(names[i]);
		}
	    visit.setPatient("John Smith");
	    System.out.println(visit.toString());
	    visit.getPatient().setName("Mary Smith");
	    visit.updatePatient();
	    System.out.println(visit.toString());
	}

}
