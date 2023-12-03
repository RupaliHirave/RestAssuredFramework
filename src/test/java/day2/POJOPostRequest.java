package day2;

public class POJOPostRequest {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhine() {
		return phone;
	}
	public void setPhine(String phine) {
		this.phone = phine;
	}
	public String[] getArray() {
		return coursearray;
	}
	public void setArray( String[] courses) {
		this.coursearray = courses;
	}
	String name;
	String location;
	String phone;
	String[] coursearray;
	
	

}
