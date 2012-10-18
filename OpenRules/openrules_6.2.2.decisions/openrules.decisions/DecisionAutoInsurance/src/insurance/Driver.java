package insurance;

public class Driver extends DriverOrVehicle {
	String	name;
	int	age;
	String	gender;
	String	maritalStatus;
	int	dmvPoints;
	
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
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public int getDmvPoints() {
		return dmvPoints;
	}
	public void setDmvPoints(int dmvPoints) {
		this.dmvPoints = dmvPoints;
	}
	@Override
	public String toString() {
		return "Driver [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", dmvPoints="
				+ dmvPoints + "]";
	}
	
	
	
}
