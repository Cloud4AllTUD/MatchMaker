package insurance;

import static java.lang.System.out;

public class Vehicle extends DriverOrVehicle {
	String	make;
	String	model;
	int	year;
	boolean	hasAbs;
	boolean	hasAlarm;
	int	yearlyMileage;
	Driver designatedDriver;
	double premium;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isHasAbs() {
		return hasAbs;
	}
	public void setHasAbs(boolean hasAbs) {
		this.hasAbs = hasAbs;
	}
	public boolean isHasAlarm() {
		return hasAlarm;
	}
	public void setHasAlarm(boolean hasAlarm) {
		this.hasAlarm = hasAlarm;
	}
	public int getYearlyMileage() {
		return yearlyMileage;
	}
	public void setYearlyMileage(int yearlyMileage) {
		this.yearlyMileage = yearlyMileage;
	}
	
	
	public Driver getDesignatedDriver() {
		return designatedDriver;
	}
	public void setDesignatedDriver(Driver designatedDriver) {
		this.designatedDriver = designatedDriver;
		out.println("Vehicle " + id + " has designated driver " + designatedDriver.getName());
	}
	
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", year=" + year
				+ ", hasAbs=" + hasAbs + ", hasAlarm=" + hasAlarm
				+ ", yearlyMileage=" + yearlyMileage + "]";
	}

}
