import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

//if suddenly a lot of red, then go file-> repair IDE

public class TestAirline {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Input scanner
        Random random = new Random(); //Random

        //Arraylist to store preset available flights for booking
        ArrayList<FlightDatabase> flightDatabaseArr = new ArrayList<>();
        ArrayList <FlightBooking> flightBookingArr = new ArrayList<>();

        //Preset 10 available flights
        flightDatabaseArr.add(new FlightDatabase("MH101", "MAS", "KUL", "BKI", "Economy", 750.00, "0800"));
        flightDatabaseArr.add(new FlightDatabase("AK512", "AirAsia", "KUL", "SIN", "Business", 380.00, "1200"));
        flightDatabaseArr.add(new FlightDatabase("OD802", "Batik Air", "KUL", "DPS", "Economy", 563.00, "1730"));
        flightDatabaseArr.add(new FlightDatabase("MH253", "MAS", "KUL", "CAN", "Economy", 670.00, "0910"));
        flightDatabaseArr.add(new FlightDatabase("AK301", "AirAsia", "KUL", "SGN", "Business", 893.00, "1400"));

        flightDatabaseArr.add(new FlightDatabase("AK133", "AirAsia", "KUL", "TPE", "Economy", 634.00, "2000"));
        flightDatabaseArr.add(new FlightDatabase("AK170", "AirAsia", "KUL", "HKG", "Business", 520.00, "1100"));
        flightDatabaseArr.add(new FlightDatabase("MH158", "MAS", "KUL", "KCH", "Business", 840.00, "0700"));
        flightDatabaseArr.add(new FlightDatabase("OD106", "Batik Air", "KUL", "LGK", "Economy", 370.00, "0900"));
        flightDatabaseArr.add(new FlightDatabase("AK275", "AirAsia", "KUL", "PEN", "Economy", 256.00, "1100"));

        //Airline Management System Menu UI
        int option = 0;
        do {
            System.out.print("\nWelcome to AirWorld. Please choose the option below to proceed:" +
                    "\n1. Flight Booking" +
                    "\n2. Flight Check In" +
                    "\n3. Flight Cancellation" +
                    "\n4. Flight Schedule" +
                    "\n5. Loyalty member" +
                    "\n6. Exit");
            System.out.print("\n\nEnter your option(1-6): "); //menu interface
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.print("-----Flight Booking-----");
                    bookFlight(flightDatabaseArr, flightBookingArr, input, random);

                    break;
                case 2:
                    System.out.print("-----Check In-----");
                    checkIn(flightBookingArr);
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
                    break;
                default:
                    System.out.println("Please enter again");
                    break;
            }

        } while (option != 6);
    }



    //Feature 1: Flight booking
    public static void bookFlight(ArrayList<FlightDatabase> flightDatabaseArr, ArrayList<FlightBooking> flightBookingArr, Scanner input, Random random){

        //Gather all user input for flight booking
        System.out.print("\nEnter trip type (one-way/round trip): ");
        input.nextLine();
        String inputTypeTrip = input.nextLine();
        System.out.print("Enter departure date (DD-MM-YYYY): ");
        String inputDepDate = input.nextLine();

        //Round trip requires returning date input
        if(inputTypeTrip.equalsIgnoreCase("round trip")){
            System.out.print("Enter returning date (DD-MM-YYYY): ");
            String inputReturnDate = input.nextLine();
        }

        System.out.print("Enter cabin class (Business/Economy): ");
        String inputCabinClass = input.nextLine();

        //for loop to display available flights for booking
        System.out.println("\nFLIGHT     AIRLINE      FROM   TO     CLASS        PRICE        TIME");
        System.out.println("---------------------------------------------------------------------");

        //Odd days 5 flights, even days 5 flights
        int hyphenIndex = inputDepDate.indexOf("-"); //Find index of first hyphen
        String extractedDate = inputDepDate.substring(0, hyphenIndex); //Extract the date from inputCabin
        int date = Integer.parseInt(extractedDate); //Convert string to integer for Date

        if (date % 2 == 0){
            for (int i=0; i<5; i++){
                if (flightDatabaseArr.get(i).getCabinClass().equalsIgnoreCase(inputCabinClass)){
                    //Format specifier to space out the String
                    System.out.printf("%-10s %-12s %-6s %-6s %-12s RM%-10.2f %-6s\n",
                            flightDatabaseArr.get(i).getFlightNum(), flightDatabaseArr.get(i).getAirline(),
                            flightDatabaseArr.get(i).getFrom(), flightDatabaseArr.get(i).getTo(),
                            flightDatabaseArr.get(i).getCabinClass(), flightDatabaseArr.get(i).getBasePrice(),
                            flightDatabaseArr.get(i).getDepartureTime());
                }
                else{ continue; }
            }
        }
        else{
            for (int i=5; i<10; i++){
                if (flightDatabaseArr.get(i).getCabinClass().equalsIgnoreCase(inputCabinClass)){
                    System.out.printf("%-10s %-12s %-6s %-6s %-12s RM%-10.2f %-6s\n",
                            flightDatabaseArr.get(i).getFlightNum(), flightDatabaseArr.get(i).getAirline(),
                            flightDatabaseArr.get(i).getFrom(), flightDatabaseArr.get(i).getTo(),
                            flightDatabaseArr.get(i).getCabinClass(), flightDatabaseArr.get(i).getBasePrice(),
                            flightDatabaseArr.get(i).getDepartureTime());
                }
                else{ continue; }
            }
        }
        //User choose flight option
        System.out.print("\nEnter chosen flight Id: ");
        String inputFlight = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Add-Ons: \nBaggage (Y/N): ");
        String optBaggage = input.nextLine();
        System.out.print("Meal (Y/N): ");
        String optMeal = input.nextLine();

        FlightDatabase selectedFlight = matchFlight(flightDatabaseArr, inputFlight);

        int bookingNum = random.nextInt(10000, 99999);
        FlightBooking flightBooking = new FlightBooking(bookingNum, lastName, selectedFlight, inputTypeTrip, inputDepDate, inputCabinClass, optMeal, optBaggage);
        flightBookingArr.add(flightBooking);
        System.out.println(flightBooking.toString());
    }

    //Match inputFlight with flightNum in FlightDatabase
    public static FlightDatabase matchFlight(ArrayList<FlightDatabase> flightDatabaseArr, String inputFlight){
        for (FlightDatabase flight : flightDatabaseArr){
            if (flight.getFlightNum().equals(inputFlight)){
                return flight;
            }
        }
        System.out.println("No matching flights");
        return null;
    }

    //Feature 2: Check in
    public static void checkIn(ArrayList<FlightBooking> flightBookingArr){
        Scanner input = new Scanner(System.in);
        CheckIn checkIn = new CheckIn();

        int bookingIndex = 0; //initial number
        boolean checkName = false;
        do{
            System.out.print("\nEnter your last name: ");
            String name = input.nextLine();
            for (bookingIndex = 0; bookingIndex < flightBookingArr.size(); bookingIndex++) {
                if (name.equals(flightBookingArr.get(bookingIndex).getLastName())){
                    checkName = true;
                }
                else {
                    System.out.println("The name you entered is not found. Please try again");
                }
            }
        }while (!checkName);

        bookingIndex --;

        boolean checkBookingNumber = false;
        do{
            System.out.print("Enter your booking number: ");
            int bookingNumber = input.nextInt();
            if (bookingNumber == flightBookingArr.get(bookingIndex).getBookingNumber()) {
                checkBookingNumber = true;
            }else{
                System.out.println("The booking number is invalid or not found. Please try again.");
                }

        }while (!checkBookingNumber);

        if (checkIn.isCheckIn()){
            System.out.println("You have been checked in.");
        }else{
            System.out.println("Your seat has been automatically given as " +checkIn.randomSeatNumber(flightBookingArr,bookingIndex));
            checkIn.setCheckIn(false);
        }
        System.out.println(checkIn.toString());
    }
}