package hello;

public class Response {
	
	int hour;
	String greeting;
	String salutation;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	} 
	
	public String toString() {
		return  "Response: hour=<" + getHour() + "> greeting=<" + getGreeting()
		+ "> salutation=<" + getSalutation() +">";
	}
}
