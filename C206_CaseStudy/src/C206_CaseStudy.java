import java.util.ArrayList;


public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
		
		buyerList.add(new Buyer("Mahirah", "90105231", "mahirahS@gmail.com", "64521, #02-1078"));
		buyerList.add(new Buyer("Melissa", "80015002", "MelissaT@hotmail.com", "760030, #09-103"));
		
		int option = 0;
		
		while (option != 6) {
		MainMenu();
			
			option = Helper.readInt("Enter Option > ");

			//Mahirah - visitor
			if (option == 1) { 
				while (option != 4) {
				menuVisitor();
				int option1 = Helper.readInt("Enter option > ");
				
				if (option1 == 1) {
					viewBuyerAcct(buyerList);
				} else if (option1 == 2) {
					addBuyer(buyerList, null);
				} else if (option1 == 3) {
					deleteBuyer(buyerList);
				}else 
					System.out.println("Thank You!");
				}
			} else if (option == 2 ) {
				
			}else if (option == 3 ) {
				
			} else if (option == 4) {
				
			} else if (option == 5) {
				
			}else {
				System.out.println("Thank for using our Website. Goodbye!");
			}
		
	}
}
	
	
	private static void MainMenu() {
		Helper.line(60, "-");
		System.out.println("Welcome To Radio control Car lover’s Community");
		Helper.line(60, "-");
		System.out.println("1. Visitor");
		System.out.println("2. Radio Control Car");
		System.out.println("3. Radio Control Car Part");
		System.out.println("4. Appointment");
		System.out.println("5. Appointment");
		System.out.println("6. Quit");
		
	}
	
	//Mahirah - DISPLAY Visitor Registration Option Menu
	private static void menuVisitor() {
		Helper.line(60, "-");
		System.out.println("VISITOR REGISTRATION");
		Helper.line(60, "-");
		System.out.println("1. View Buyers Account");
		System.out.println("2. Add Buyer");
		System.out.println("3. Delete Buyer");
		System.out.println("4. Quit");
		
	}
	
	
	//Mahirah - View Buyer account
	public static void viewBuyerAcct(ArrayList<Buyer> buyerList) {
		String output = " ";
		Helper.line(60, "-");
		output += String.format("%-20s %-10s %10s %30s\n", "NAME", "PHONE", "EMAIL", "ADDRESS");
	
		for (Buyer i : buyerList) {
			output += String.format("%-20s %-10s %10s %30s\n", i.getName(), i.getPhone(), i.getEmail(), i.getHouseInfo());
		}
		System.out.println(output);
	
	}
	
	//Mahirah - Add Buyer account
	public static void addBuyer(ArrayList <Buyer> buyerList, Buyer b) {
	String name = Helper.readString("Enter Full Name > ");
	String phone = Helper.readString("Enter Contact Number > ");
	String email = Helper.readString("Enter Email Address > ");
	String address = Helper.readString("Enter Home Address(ZipCode, Unit No.) > ");
	
	Buyer buyerInfo = new Buyer(name,phone,email,address);
	buyerList.add(buyerInfo);
	System.out.println("Account added!");
	
	}
	//Mahirah - Delete Buyer Account
	public static void deleteBuyer(ArrayList <Buyer> buyerList) {
		String phone1 = Helper.readString("Enter contact number > ");
		
		for (Buyer i : buyerList) {
			if (phone1.equals(i.getPhone())) {
				String toDelete = Helper.readString("Delete this phone account? (y/n) > ");
					if (toDelete.equalsIgnoreCase("y")) {
						buyerList.remove(i);
						System.out.println("Buyer deleted successfully.");
						}
					}
				}
			}
	
	//Mahirah - Retrieve Buyer account
	public static String retrieveAllBuyer(ArrayList<Buyer> buyerList) {
		String output = "";
		
		for (Buyer b : buyerList) {
			output += String.format("%-20s %-10s %-10s %-30s\n", b.getName(), b.getPhone(), b.getEmail(), b.getHouseInfo());
		}
		return output;
		}
	}

