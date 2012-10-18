package hello;

/**
 *         A simple Java class Customer to be greeted from OpenRules
 */
public class Customer {
	String 	name;
	String 	maritalStatus;
	String 	gender;
	int 	age;
	String 	ssn;
	Customer spouse;
	String 	phone;
	Asset[] assets;
	String	customerAssetsStatus;
	
	public Customer() {
		customerAssetsStatus = "Insufficient";
	}

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

	public Asset[] getAssets() {
		return assets;
	}

	public void setAssets(Asset[] assets) {
		this.assets = assets;
	}

	public String getCustomerAssetsStatus() {
		return customerAssetsStatus;
	}

	public void setCustomerAssetsStatus(String customerAssetsStatus) {
		this.customerAssetsStatus = customerAssetsStatus;
	}

	public String toString() {
		String general = "Customer [name=" + name + ", maritalStatus=" + maritalStatus
				+ ", gender=" + gender + ", age=" + age + ", ssn=" + ssn
				+ ", phone=" + phone + "]";
		String allAssets = "Assets: status=" + customerAssetsStatus + "\n\t";
		if (assets != null)
		for (int i = 0; i < assets.length; i++) {
			allAssets += " ["+assets[i].name+":"+assets[i].status+"]";
		}
		return general + "\n" + allAssets;
	}

}
