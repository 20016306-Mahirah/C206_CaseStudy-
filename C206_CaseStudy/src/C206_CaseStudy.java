import java.util.ArrayList;


public class C206_CaseStudy {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ArrayList<Buyer> buyerList = new ArrayList<Buyer>();

        buyerList.add(new Buyer("Mahirah", "90105231", "mahirahS@gmail.com", "64521, #02-1078"));
        buyerList.add(new Buyer("Melissa", "80015002", "MelissaT@hotmail.com", "760030, #09-103"));

        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1, "ItemName", "ItemDesc", "price", true));
        itemList.add(new Item(2, "ItemName2", "ItemDesc2", "price2", true));

        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(new Appointment(buyerList.get(0), "2021-08-10", "10:30"));

        ArrayList<Item> orderedList = new ArrayList<Item>();


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
                    } else
                        System.out.println("Thank You!");
                }
            } else if (option == 2) {

            } else if (option == 3) {

            } else if (option == 4) {
                menuAppointment();
                int option4 = Helper.readInt("Enter option > ");

                while (option4 != 1 || option4 != 2 || option4 != 3 || option4 != 4) {

                    if (option4 == 1) {
                        viewAllAppointments(appointmentList);
                    } else if (option4 == 2) {
                        String mobileNo = Helper.readString("Enter customer mobileNo > ");
                        String date = Helper.readString("Enter scheduled appointment date eg. yyyy-mm-dd > ");
                        String time = Helper.readString("Enter scheduled appointment time eg. hh:mm > ");
                        addAppointment(appointmentList, buyerList, mobileNo, date, time);
                    } else if (option4 == 3) {
                        String mobileNo = Helper.readString("Enter customer mobileNo > ");
                        String date = Helper.readString("Enter scheduled appointment date eg. yyyy-mm-dd > ");
                        String time = Helper.readString("Enter scheduled appointment time eg. hh:mm > ");
                        cancelAppointment(appointmentList, mobileNo, date, time);
                    } else {
                        System.out.println("Exiting appointment menu");
                    }
                    break;
                }


            } else if (option == 5) {

            } else {
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
    public static void addBuyer(ArrayList<Buyer> buyerList, Buyer b) {
        String name = Helper.readString("Enter Full Name > ");
        String phone = Helper.readString("Enter Contact Number > ");
        String email = Helper.readString("Enter Email Address > ");
        String address = Helper.readString("Enter Home Address(ZipCode, Unit No.) > ");

        Buyer buyerInfo = new Buyer(name, phone, email, address);
        buyerList.add(buyerInfo);
        System.out.println("Account added!");

    }

    //Mahirah - Delete Buyer Account
    public static void deleteBuyer(ArrayList<Buyer> buyerList) {
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


    //Raiyan - Make Order
    public static void makeOrder(ArrayList<Item> itemList) {
        String order = "";

        String OrderItem = Helper.readString("Item to be bought > ");

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemname().equalsIgnoreCase(OrderItem)) {
                order += itemList.get(i).getItemname();
                order += "\n" + itemList.get(i).getDescription();
                order += "\n" + itemList.get(i).getPrice();

                Item ItemOrdered = itemList.get(i);
            } else {
                System.out.println("Item does not exist in our system");
            }
            System.out.println(order);
        }

    }

    // Junjie 
    public static Buyer searchBuyer(ArrayList<Buyer> buyerList, String mobileNumber) {
        for(Buyer buyer: buyerList) {
            if (buyer.getPhone().equals(mobileNumber)) {
                return buyer;
            }
        }
        return null;
    }

    //Junjie - display Appointment Option Menu
    private static void menuAppointment() {
        Helper.line(60, "-");
        System.out.println("APPOINTMENT");
        Helper.line(60, "-");
        System.out.println("1. View appointments");
        System.out.println("2. Add new appointment");
        System.out.println("3. Cancel existing appointment");
        System.out.println("4. Back to main menu");

    }

    // Junjie - make new appointment
    public static void addAppointment(ArrayList<Appointment> appointmentList, ArrayList<Buyer> buyerList, String mobileNo, String date, String time) {

        Buyer existingBuyer = searchBuyer(buyerList, mobileNo);
        if(existingBuyer != null) {
            appointmentList.add(new Appointment(existingBuyer, date, time));
            String msg = String.format("Appointment added successfully %s, %s %s", existingBuyer.getName(), date, time);
            System.out.println(msg);
        }
        else {
            System.out.println("Buyer does not exits, failed to make new appointment.");
        }
    }

    // Junjie - delete existing appointment
    public static void cancelAppointment(ArrayList<Appointment> appointmentList, String mobileNo, String date, String time) {
        for(Appointment appointment: appointmentList) {
            if(appointment.getBuyer().getPhone().equals(mobileNo)) {
                if(appointment.getAppointmentDate().equals(date) && appointment.getAppointmentTime().equals(time)) {
                    appointmentList.remove(appointment);
                    String msg = String.format("Appointment cancelled successfully %s, %s %s", appointment.getBuyer().getName(), date, time);
                    System.out.println(msg);
                    return;
                }
            }
        }

        System.out.println("No existing appointment found.");
    }

    // Junjie - View all Appointments
    public static void viewAllAppointments(ArrayList<Appointment> appointmentList) {
        String output = " ";
        Helper.line(60, "-");
        output += String.format("%-20s %-10s %-12s %-6s\n", "NAME", "PHONE", "DATE", "TIME");

        for (Appointment appointment : appointmentList) {
            output += String.format("%-20s %-10s %-12s %-6s\n", appointment.getBuyer().getName(), appointment.getBuyer().getPhone(), appointment.getAppointmentDate(), appointment.getAppointmentTime());
        }
        System.out.println(output);
    }

}

	

