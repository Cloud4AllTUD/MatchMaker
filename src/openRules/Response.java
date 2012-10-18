package openRules;

public class Response {
	
	int hour;
	String platform;
        String result;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int tmpHour) {
		this.hour = tmpHour;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String tmpPlatform) {
		this.platform = tmpPlatform;
	}
        
        public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String toString() {
		return  "Response: hour=<" + getHour() + "> platform=<" + getPlatform()	+">";
	}
}
