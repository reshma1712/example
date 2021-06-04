package vaccineManagement;

import java.time.LocalDate;
import java.util.Scanner;


public class VaccineStockManagement {
	daovaccineconsole daoVaccine = new daovaccineconsole();
	/*int getVaccineCount() {
		int count;
		try {
			count = daoVaccine.getAvailableVaccineCount();
		}
		catch(Exception e) {
			count = 0;
		}
		return count;
	}*/
	void addVaccine(String name , int receivedAmount)throws Exception {
		int vaccineDbSize = daoVaccine.getVaccineDbSize();
		if(vaccineDbSize>0) {
				receivedAmount += daoVaccine.getAvailableVaccineCount();
		}
		Vaccine vaccine = daoVaccine.getNewVaccine(name, receivedAmount);
		daoVaccine.insertVaccine(vaccine);
		throw new Exception("Avaliable vaccine count:"+daoVaccine.getAvailableVaccineCount());
	}

}
