package vaccineManagement;

import java.time.LocalDate;

public class ManagementFunctions {
	
	Boolean findFirstShotTaken(String aadharNumber){
		
		if(Database.personDb.containsKey(aadharNumber))
			return true;
		else
			return false;
		
	}
	
	Boolean findSecondShotTaken(String aadharNumber){
		
		if(Database.personDb.get(aadharNumber).getShotTwo() != null)
			return true;
		else
			return false;
	}
	
	Boolean findSecondShotEligible(String aadharNumber){
		
		 LocalDate eligibleDate = getSecondShotDate(aadharNumber);
		 if(eligibleDate.compareTo(LocalDate.now())<=0)
			 return true;
		 else
			 return false;
		
	}
	
	Boolean FindBothShotsTaken(String aadharNumber){
		
		return findFirstShotTaken(aadharNumber) && findSecondShotTaken(aadharNumber);
	}
	
	void updateVaccineBalance(){
		
		int index = Database.vaccineDb.size()-1;
		int avaliableCount = getAvailableVaccineCount();
		Database.vaccineDb.get(index).setBalance(avaliableCount-1);
	}
	
	LocalDate getSecondShotDate(String aadharNumber){
		
		return Database.personDb.get(aadharNumber).getShotOne().plusDays(28);
	}
	
	int getAvailableVaccineCount() {
		
		int vaccineDbsize = Database.vaccineDb.size();
		if(vaccineDbsize==0)
			return 0;
		else
			return Database.vaccineDb.get(vaccineDbsize-1).getBalance();
	}
	
	
	
	void insertFirstShotDetails(String aadharNumber, Person Details){
		Database.personDb.put(aadharNumber,Details);
		updateVaccineBalance();
	}
	
	void updateSecondShot(String aadharNumber){
		
		Database.personDb.get(aadharNumber).setShotTwo(LocalDate.now());
		updateVaccineBalance();
	}
	
	
	Boolean findVaccineDetailsAlreadyGiven(LocalDate date) {
		int vaccineDbsize =  Database.vaccineDb.size();
		
		if(vaccineDbsize == 0)
			return false;
		else
			return Database.vaccineDb.get(vaccineDbsize-1).getDate().equals(LocalDate.now());
	}
	
	
	void addVaccines(int addedVaccineCount){
		
		int availableVaccines = getAvailableVaccineCount()+ addedVaccineCount;
		int vaccineDbsize =  Database.vaccineDb.size();; 
		Database.vaccineDb.get(vaccineDbsize-1).setInitial(availableVaccines);
		Database.vaccineDb.get(vaccineDbsize-1).setBalance(availableVaccines);
	}
	
	
	void insertVaccine(Vaccine vaccineObj) {
		
		Database.vaccineDb.add(vaccineObj);
	}
	
	void printAvailableVaccinesCount(){
		
		System.out.println("vaccines available are "+getAvailableVaccineCount());
		
	}
}
