package hello;

/**
 * A simple Java class Customer to be greeted from OpenRules
 */
public class Customer 
{
	String   name;
	String   maritalStatus;
	String   gender;
	int      age;

	public String getGender() {
		return gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public String getName() {
		return name;
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

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Customer [name=" + name + ", maritalStatus=" + maritalStatus
				+ ", gender=" + gender + ", age=" + age + "]";
	}
	
}
