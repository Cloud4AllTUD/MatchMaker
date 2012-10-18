package insurance;

// A class for discounts (<1) or surcharges (>1):		

public class Discount {
	String type;
	double value;
	boolean showInPolicy;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public boolean isShowInPolicy() {
		return showInPolicy;
	}
	public void setShowInPolicy(boolean showInPolicy) {
		this.showInPolicy = showInPolicy;
	}
	@Override
	public String toString() {
		String d = "Discount [type=" + type + ", value=" + value
				+ ", showInPolicy=" + showInPolicy + "]";
		if (!isShowInPolicy())
			d += " - not shown in policy";
		return d;
	}
	
	

}
