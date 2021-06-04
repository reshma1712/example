package vaccineManagement;

import java.time.LocalDate;

public class daoperosnConsole {
	
	Person getPerson(String aadharNumber,String name,int age) {
		Person person = new Person();
		person.setAadharNumber(aadharNumber);
		person.setName(name);
		person.setShotOne(LocalDate.now());
		return person;
	}
	
	LocalDate getFirstShotDate(String aadharNumber){
		
		return Database.personDb.get(aadharNumber).getShotOne();
	}
	
	void updateFirstShotDetails(String aadharNumber, Person Details){
		Details.setStatus("firstTaken");
		Database.personDb.put(aadharNumber,Details);
	}
	
	void updateSecondShot(String aadharNumber){
		Database.personDb.get(aadharNumber).setStatus("secondTaken");
		Database.personDb.get(aadharNumber).setShotTwo(LocalDate.now());
	}
	
	String getShotStatus(String aadharNumber){
		return Database.personDb.containsKey(aadharNumber) ? Database.personDb.get(aadharNumber).getStatus(): "notTaken";
	}
	
}
