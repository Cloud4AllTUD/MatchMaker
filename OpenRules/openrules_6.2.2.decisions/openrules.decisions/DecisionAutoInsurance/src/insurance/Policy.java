package insurance;

import static java.lang.System.out;

import java.util.Arrays;

import com.openrules.tools.Methods;

public class Policy {
	Driver[] drivers;
	Vehicle[] vehicles;
	Usage[] usages;
	Address address;
	boolean rejectedDrivers;
	boolean rejectedVehicles;
	double premium;

	public Policy() {
		premium = -1;
	}

	public String getState() {
		return address.getState();
	}

	public void setState(String state) {
		address.setState(state);
	}

	public Driver[] getDrivers() {
		return drivers;
	}

	public void setDrivers(Driver[] drivers) {
		this.drivers = drivers;
	}

	public Vehicle[] getVehicles() {
		return vehicles;
	}

	public void setVehicles(Vehicle[] vehicles) {
		this.vehicles = vehicles;
	}

	public Usage[] getUsages() {
		return usages;
	}

	public void setUsages(Usage[] usages) {
		this.usages = usages;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isRejectedDrivers() {
		return rejectedDrivers;
	}

	public void setRejectedDrivers(boolean invalidDrivers) {
		this.rejectedDrivers = invalidDrivers;
	}

	public boolean isRejectedVehicles() {
		return rejectedVehicles;
	}

	public void setRejectedVehicles(boolean invalidVehicles) {
		this.rejectedVehicles = invalidVehicles;
	}

	public void printRejections() {
		if (isRejectedDrivers()) {
			out.println("=== Rejections for Driver(s):");
			for (int i = 0; i < drivers.length; i++) {
				for (int j = 0; j < drivers[i].getRejections().size(); j++) {
					out.println("\t" + drivers[i].getRejections().elementAt(j)
							+ " - " + drivers[i].getName());
				}
			}
		}
		if (isRejectedVehicles()) {
			out.println("=== Rejections for Vehicle(s):");
			for (int i = 0; i < vehicles.length; i++) {
				for (int j = 0; j < vehicles[i].getRejections().size(); j++) {
					out.println("\t" + vehicles[i].getRejections().elementAt(j)
							+ " - " + vehicles[i].getId());
				}
			}
		}
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		String p = "Policy [drivers=" + Arrays.toString(drivers)
				+ ", vehicles=" + Arrays.toString(vehicles) + ", usages="
				+ Arrays.toString(usages) + ", address=" + address
				+ ", rejectedDrivers=" + rejectedDrivers
				+ ", rejectedVehicles=" + rejectedVehicles + "]";
		if (premium >= 0)
			p += "\nCalculated Premium = " + Methods.format(premium);
		return p;
	}

}
