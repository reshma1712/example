package vaccineManagement;

import java.util.Scanner;


public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDetailsManagement obj = new PersonDetailsManagement();
		VaccineStockManagement objV = new VaccineStockManagement();
		System.out.println("Enter 1 to add person details");
		System.out.println("Enter 2 to add vaccine details");
		System.out.println("Enter any other number to exit");
		System.out.println("enter option");
		int option = sc.nextInt();
		while(option==1||option==2){
			if(option==1) {
				System.out.println("Enter aadhar number");
				String aadharNumber = sc.next();
				while(!obj.aadharNumberValidity(aadharNumber)) {
					System.out.println("Enter valid aadharNumber");
					aadharNumber = sc.next();
				}
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				try {
				obj.takeShot(aadharNumber, name, age);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			if(option==2) {
				try {
				System.out.println("Enter the vaccineName");
				String name = sc.next();
				System.out.println("Enter Vaccine amount");
				int count = sc.nextInt();
				objV.addVaccine(name, count);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
			System.out.println();
			System.out.println("Enter 1 to add person details");
			System.out.println("Enter 2 to add vaccine details");
			System.out.println("enter option");
			option = sc.nextInt();
		}
	
	}

}
