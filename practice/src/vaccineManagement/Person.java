package vaccineManagement;

import java.time.LocalDate;

public class Person {
	private String aadharNumber;
	private int age;
	private String name;
	private LocalDate shotOne; // this done using date too;
	private LocalDate shotTwo;
	private String Status = "notTaken";
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public LocalDate getShotOne() {
		return shotOne;
	}
	public void setShotOne(LocalDate shotOne) {
		this.shotOne = shotOne;
	}
	public LocalDate getShotTwo() {
		return shotTwo;
	}
	public void setShotTwo(LocalDate shotTwo) {
		this.shotTwo = shotTwo;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
