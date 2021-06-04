package vaccineManagement;

import java.time.LocalDate;

public class daovaccineconsole {
	
	Vaccine getNewVaccine(String name,int count) {
		Vaccine vaccine = new Vaccine();
		vaccine.setName(name);
		vaccine.setInitial(count);
		vaccine.setBalance(count);
		vaccine.setDate(LocalDate.now());
		return vaccine;
	}
	int getVaccineDbSize() {
		return Database.vaccineDb.size();
	}
	
	int getAvailableVaccineCount() {
		
		int vaccineDbsize = getVaccineDbSize();
			return Database.vaccineDb.get(vaccineDbsize-1).getBalance();
	}
	
	void updateVaccineBalance(){
		int avaliableCount = getAvailableVaccineCount();
		Database.vaccineDb.get(Database.vaccineDb.size()-1).setBalance(avaliableCount-1);
	}
	
	void insertVaccine(Vaccine vaccine) {
		Database.vaccineDb.add(vaccine);
	}
	
	void addVaccines(int addedVaccineCount){
		
		int availableVaccines = getAvailableVaccineCount()+ addedVaccineCount;
		int vaccineDbsize =  Database.vaccineDb.size(); 
		Database.vaccineDb.get(vaccineDbsize-1).setInitial(availableVaccines);
		Database.vaccineDb.get(vaccineDbsize-1).setBalance(availableVaccines);
	}
	
	LocalDate getLastupdateDate(){
		int vaccineDbSize = getVaccineDbSize();
		return Database.vaccineDb.get(Database.vaccineDb.size()-1).getDate();

	}
}
