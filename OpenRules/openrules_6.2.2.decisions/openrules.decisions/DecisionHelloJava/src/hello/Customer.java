package hello;

/**
 * @author Jacob
 *
 * A simple Java class Customer to be greeted from OpenRules
 */
public class Customer 
{
	String   name;
	String   maritalStatus;
	String   gender;
	int      age;
	String   ssn;
	String   email;
	Customer spouse;
	String 	 phone;

	public String getGender() {
		return gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public String getName() {
		return name;
	}
	public Customer getSpouse() {
		return spouse;
	}
	public void setGender(String string) {
		gender = string;
	}
	public void setMaritalStatus(String string) {
		maritalStatus = string;
	}
	public void setName(String string) {
		name = string;
	}
	public void setSpouse(Customer customer) {
		spouse = customer;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "Customer [name=" + name + ", maritalStatus=" + maritalStatus
				+ ", gender=" + gender + ", age=" + age + ", ssn=" + ssn 
				+ ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
}
