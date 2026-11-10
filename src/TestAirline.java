import java.util.ArrayList;
import java.util.Scanner;

public class TestAirline {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Input scanner

        //Arraylist to store preset available flights for booking
        ArrayList<FlightDatabase> flightDatabaseArr = new ArrayList<>();

        //Preset 15 available flights
        flightDatabaseArr.add(new FlightDatabase("MH101", "Mas Airline", "KUL", "BKI", "Economy", 750.00, "0800"));
        flightDatabaseArr.add(new FlightDatabase("AK512", "AirAsia", "KUL", "SIN", "Business", 380.00, "1200"));
        flightDatabaseArr.add(new FlightDatabase("OD 802", "Batik Air", "KUL", "DPS", "Economy", 563.00, "1730"));
        flightDatabaseArr.add(new FlightDatabase("MH253", "Mas Airline", "KUL", "CAN", "Economy", 16700.00, "0910"));
        flightDatabaseArr.add(new FlightDatabase("AK301", "AirAsia", "KUL", "SGN", "Business", 893.00, "1400"));

        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());

        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());
        flightDatabaseArr.add(new FlightDatabase());

        //Airline Management System Menu UI
        int x = 1;
        do {
            System.out.print("\nWelcome to AirWorld. Please choose the option below to proceed:" +
                    "\n1. Flight Booking" +
                    "\n2. Flight Check In" +
                    "\n3. Flight Cancellation" +
                    "\n4. Flight Schedule" +
                    "\n5. Loyalty member" +
                    "\n6. Exit");
            System.out.print("\n\nEnter your option(1-6): "); //menu interface
            int option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.print("-----Flight Booking-----");
                    gatherBookingInput();
                    break;
                case 2:
                    System.out.print("Check In");
                    break;
                case 3:
                    System.out.print("Flight cancellation");
                    break;
                case 4:
                    System.out.print("Summary of upcoming flight schedule");
                    break;
                case 5:
                    System.out.print("Loyalty Programme");
                    break;
                case 6:
                    System.out.print("Exit");
                    x++;
                    break;
                default:
                    System.out.print("Please enter again.");
            }
        } while (x == 1);

    }

    //Feature 1: Flight booking
    public static void gatherBookingInput(){
        //Gather all user input for flight booking
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter trip type (one-way/round trip): ");
        String inputTypeTrip = input.nextLine();
        System.out.print("Enter departure date (DD-MM-YYYY): ");
        String inputDate = input.nextLine();
        System.out.print("Enter cabin class (Business/Economy): ");
        String inputCabinClass = input.nextLine();

        //for loop to display available flights for booking
    }
}

