package insurance;

import java.util.Vector;

public class DriverOrVehicle {
	String	id;
	
	Vector<String> rejections;
	Vector<Discount> discounts;
	
	public DriverOrVehicle() {
		rejections = null;
		discounts = null;
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void addRejection(String reason) {
		getRejections().add(reason);
	}

	public Vector<String> getRejections() {
		if (rejections == null)
			rejections = new Vector<String>();
		return rejections;
	}

	public void setRejections(Vector<String> rejections) {
		this.rejections = rejections;
	}

	public Vector<Discount> getDiscounts() {
		if (discounts == null)
			discounts = new Vector<Discount>();
		return discounts;
	}

	public void setDiscounts(Vector<Discount> discounts) {
		this.discounts = discounts;
	}
	
	public void addDiscount(String type_value_show) {
		String[] triad = type_value_show.split(";");
		if (triad.length != 3) {
			throw new RuntimeException("Invalid discount: expects type;value,show");
		}
		Discount d = new Discount();
		d.setType(triad[0].trim());
		d.setValue(Double.parseDouble(triad[1].trim()));
		d.setShowInPolicy("show".equalsIgnoreCase(triad[2].trim()));
		getDiscounts().add(d);
	}
	
	


}
