package vaccineManagement;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonDetailsManagement {
	daoperosnConsole daoPerson = new daoperosnConsole();
	daovaccineconsole daoVaccine = new daovaccineconsole();
	Scanner ScannerObject = new Scanner(System.in);
	Boolean aadharNumberValidity(String aadharNumber) {
		return (aadharNumber.length()==12)? true : false;
			
	}
	/*String shotStatus(String aadharNumber) {
		String status;
		try {
			status = daoPerson.getShotStatus(aadharNumber);
		}
		catch(Exception e) {
			status = "notTaken";
		}
		return status;
	}*/
	/*enum Status{
		notTaken{
			 void shot(String aadharNumber,Person person) throws Exception{
				daoPerson.updateFirstShotDetails(aadharNumber, person);
				daoVaccine.updateVaccineBalance();
				throw new Exception("First shot details updated successfully");
			}
		},
		firstShot{
			void Shot(String aadharNumber,Person person) throws Exception{
				if(findSecondShotEligibility(aadharNumber)){
					daoPerson.updateSecondShot(aadharNumber);
					daoVaccine.updateVaccineBalance();
					throw new Exception("The second shot details are updated for the above mentioned aadharNumber");
				}
				else{
					throw new Exception("Not eligible to take second shot, can take the shot on or after "+getSecondShotDate(aadharNumber));
				}
				
			}
		},
		secondShot{
			void shot(String aadharNumber,Person person) throws Exception {
				throw new Exception("Both the vaccines are taken");
			}
		}
	}*/
	void takeShot(String aadharNumber,String name,int age) throws Exception{
		
		if(daoVaccine.getVaccineDbSize()!=0 && daoVaccine.getAvailableVaccineCount()>0){
			String status = daoPerson.getShotStatus(aadharNumber);
			if(status.equals("notTaken")) {
				Person person = daoPerson.getPerson(aadharNumber,name,age);
				takeFirstShot(aadharNumber,person);
			}
			else if(status.equals("firstTaken")) {
				takeSecondShot(aadharNumber);
			}
			else {
				throw new Exception("Both the shots are taken");
			}
		}
		else{
			throw new Exception("vaccine is unavailable");
		}
	}
	
	void takeFirstShot(String aadharNumber,Person person) throws Exception {
			daoPerson.updateFirstShotDetails(aadharNumber, person);
			daoVaccine.updateVaccineBalance();
			throw new Exception("First shot details updated successfully \n Avalaiable vaccine count :"+daoVaccine.getAvailableVaccineCount());
	}
	
	LocalDate getSecondShotDate(String aadharNumber) {
		return daoPerson.getFirstShotDate(aadharNumber).plusDays(28);
	}
	
	Boolean findSecondShotEligibility(String aadharNumber) {
		LocalDate date = getSecondShotDate(aadharNumber);
		return date.compareTo(LocalDate.now())<=0 ?true:false;
	}
	
	void takeSecondShot(String aadharNumber) throws Exception{
		if(findSecondShotEligibility(aadharNumber)){
			daoPerson.updateSecondShot(aadharNumber);
			daoVaccine.updateVaccineBalance();
			throw new Exception("The second shot details are updated for the above mentioned aadharNumber \n Avalaiable vaccine count:"+daoVaccine.getAvailableVaccineCount());
		}
		else{
			throw new Exception("Not eligible to take second shot, can take the shot on or after "+getSecondShotDate(aadharNumber));
		}
		
	}
	
	
}
