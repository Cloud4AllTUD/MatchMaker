package hello;

public class Asset {
	String name;
	String status;
	
	public Asset() {
	}
	
	
	public Asset(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
