package healthcare;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;

import com.openrules.tools.DatabaseIterator;
import com.openrules.tools.Methods;

public class Patient {

	String name;
	int age;
	String gender;
	double creatinineLevel;
	double creatinineClearance;
	String[] allergies;
	double weight;
	String[] activeMedications;
	static int max = 3;
	
	public Patient() {
		allergies = new String[max];
		activeMedications = new String[max];
		for (int i = 0; i < max; i++) {
			allergies[i] = "None";
			activeMedications[i] = "None";
		}
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getCreatinineLevel() {
		return creatinineLevel;
	}

	public void setCreatinineLevel(double creatinineLevel) {
		this.creatinineLevel = creatinineLevel;
	}

	public double getCreatinineClearance() {
		return creatinineClearance;
	}

	public void setCreatinineClearance(double creatinineClearance) {
		this.creatinineClearance = creatinineClearance;
	}

	public String[] getAllergies() {
		return allergies;
	}

	public void setAllergies(String[] allergies) {
		for (int i = 0; i < allergies.length; i++) {
			if (i>=max)
				break;
			this.allergies[i] = allergies[i];
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String[] getActiveMedications() {
		return activeMedications;
	}

	public void setActiveMedication(String[] activeMedications) {
		for (int i = 0; i < activeMedications.length; i++) {
			if (i>=max)
				break;
			this.activeMedications[i] = activeMedications[i];
		}
	}
	
	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", creatinineLevel=" + creatinineLevel
				+ ", creatinineClearance=" + creatinineClearance
				+ ", allergies=" + Arrays.toString(allergies) + ", weight="
				+ weight + ", activeMedications=" + Arrays.toString(activeMedications) + "]";
	}

	public void setAge(Timestamp date) {
		age = Methods.date2Age(date);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
