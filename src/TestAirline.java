import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

//if suddenly a lot of red, then file-> repair IDE

public class TestAirline {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Input scanner
        Random random = new Random(); //Random
        CheckIn checkIn = new CheckIn();

        //Arraylist for preset flight schedules, flights booked, checked in, loyalty members, upcoming flight schedule
        ArrayList<FlightDatabase> flightDatabaseArr = new ArrayList<>();
        ArrayList<FlightBooking> flightBookingArr = new ArrayList<>();
        ArrayList <CheckIn> boardingGateArr = new ArrayList<>();
        ArrayList<CheckIn> checkInArr = new ArrayList<>();
        ArrayList<User> userArr = new ArrayList<>();
        ArrayList<FlightSchedule> flightScheduleArr = new ArrayList<>();

        //Preset 10 available departure flights (5 for alternate days)
        flightDatabaseArr.add(new FlightDatabase("MH101", "MAS", "KUL", "BKI", "Economy", 750.00, "0800"));
        flightDatabaseArr.add(new FlightDatabase("AK512", "AirAsia", "KUL", "SIN", "Business", 680.00, "1200"));
        flightDatabaseArr.add(new FlightDatabase("OD802", "Batik Air", "KUL", "DPS", "Economy", 563.00, "1730"));
        flightDatabaseArr.add(new FlightDatabase("MH253", "MAS", "KUL", "CAN", "Economy", 670.00, "0910"));
        flightDatabaseArr.add(new FlightDatabase("AK301", "AirAsia", "KUL", "SGN", "Business", 893.00, "1400"));

        flightDatabaseArr.add(new FlightDatabase("AK133", "AirAsia", "KUL", "TPE", "Economy", 634.00, "2000"));
        flightDatabaseArr.add(new FlightDatabase("AK170", "AirAsia", "KUL", "HKG", "Business", 520.00, "1100"));
        flightDatabaseArr.add(new FlightDatabase("MH158", "MAS", "KUL", "KCH", "Business", 840.00, "0700"));
        flightDatabaseArr.add(new FlightDatabase("OD106", "Batik Air", "KUL", "LGK", "Economy", 370.00, "0900"));
        flightDatabaseArr.add(new FlightDatabase("AK275", "AirAsia", "KUL", "PEN", "Economy", 256.00, "1100"));

        //Preset 5 available returning flights (5 for alternate days)
        flightDatabaseArr.add(new FlightDatabase("MH237", "MAS", "BKI", "KUL", "Economy", 733.00, "1200"));
        flightDatabaseArr.add(new FlightDatabase("MH128", "MAS", "BKI", "KUL", "Economy", 673.00, "2300"));
        flightDatabaseArr.add(new FlightDatabase("AK384", "AirAsia", "TPE", "KUL", "Economy", 769, "1730"));
        flightDatabaseArr.add(new FlightDatabase("AK120", "AirAsia", "SGN", "KUL", "Business", 1029.00, "1400"));
        flightDatabaseArr.add(new FlightDatabase("OD184", "Batik Air", "DPS", "KUL", "Economy", 574.00, "1300"));

        flightDatabaseArr.add(new FlightDatabase("AK123", "AirAsia", "PEN", "KUL", "Economy", 230.00, "1130"));
        flightDatabaseArr.add(new FlightDatabase("AK340", "AirAsia", "PEN", "KUL", "Economy", 249.00, "1300"));
        flightDatabaseArr.add(new FlightDatabase("MH874", "MAS", "TPE", "KUL", "Economy", 670.00, "1230"));
        flightDatabaseArr.add(new FlightDatabase("AK985", "AirAsia", "HKG", "KUL", "Business", 580.00, "1030"));
        flightDatabaseArr.add(new FlightDatabase("MH093", "MAS", "CAN", "KUL", "Economy", 750.00, "0600"));

        flightDatabaseArr.add(new FlightDatabase("AK742", "AirAsia", "SIN", "KUL", "Business", 691.00, "1200"));
        flightDatabaseArr.add(new FlightDatabase("MH963", "MAS", "KCH", "KUL", "Business", 872.00, "1645"));
        flightDatabaseArr.add(new FlightDatabase("OD185", "Batik Air", "LGK", "KUL", "Economy", 312.00, "0930"));

        //Present flight schedules
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(0), LocalDateTime.of(2026, 11, 20, 8, 0), "A12", "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(1), LocalDateTime.of(2026, 11, 20, 12, 0), "B6", "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(2), LocalDateTime.of(2026, 11, 20, 17, 30), "A1", "Delayed"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(3), LocalDateTime.of(2026, 11, 21, 9, 10), "B9", "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(4), LocalDateTime.of(2026, 11, 21, 14, 0), "C8", "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(5), LocalDateTime.of(2026, 11, 21, 20, 0), "D3", "Cancelled"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(6), LocalDateTime.of(2026, 11, 22, 11, 0), "H8", "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(7), LocalDateTime.of(2026, 11, 22, 7, 0), "G11", "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(8), LocalDateTime.of(2026, 11, 22, 9, 0), "D3", "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(9), LocalDateTime.of(2026, 11, 22, 11, 0), "C1", "On Time"));

        //Preset the boarding Gate today
        String localDate = LocalDateTime.now().getDayOfMonth() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getYear();
        for (int i = 0 ; i < flightDatabaseArr.size(); i++){
            boardingGateArr.add(new CheckIn(flightDatabaseArr.get(i).getFlightNum(), localDate , checkIn.checkBoardingGate(boardingGateArr, localDate)));
        }

        //Preset 5 loyalty members
        userArr.add(new Member("Jane", "Smith", 18, "M101", 50, "Bronze Tier", 700.00));
        userArr.add(new Member("Shaun", "Wong", 20, "M102", 100, "Platinum Tier", 10001.00));
        userArr.add(new Member("Daniel", "Fong", 22, "M103", 110, "Bronze Tier", 1150.00));
        userArr.add(new Member("Marcus", "Lee", 35, "M104", 1120, "Gold Tier", 9200.00));
        userArr.add(new Member("Lucas", "Wong", 40, "M105", 1450, "Platinum Tier", 12500.00));

        //Preset 5 non Member
        userArr.add(new NonMember("Gina", "Wang", 52, "M106", 3, false));
        userArr.add(new NonMember("Jayden", "Cooper", 13, "M107", 7, false));
        userArr.add(new NonMember("Isabelle", "Kong", 21, "M108", 0, true));
        userArr.add(new NonMember("Miriam", "Grey", 48, "M109", 9, false));
        userArr.add(new NonMember("Lily", "Ketchman", 34, "M110", 1, true));

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
                    System.out.print("\n-----Flight Booking-----");
                    bookFlight(flightDatabaseArr, flightBookingArr, input, random, checkInArr, userArr, boardingGateArr);
                    break;
                case 2:
                    if (flightBookingArr.isEmpty()){
                        System.out.println("There is no booking to check in.");
                    }else {
                        System.out.print("-----Check In-----");
                        checkIn(flightBookingArr, checkInArr, userArr, input, boardingGateArr);
                    }
                    break;
                case 3:
                    if (flightBookingArr.isEmpty()){
                        System.out.println("There is no booking to check in.");
                    }else {
                        System.out.print("-----Flight cancellation-----");
                        flightCancellation(flightBookingArr, input);
                    }
                    break;
                case 4:
                    System.out.print("-----Summary of upcoming flight schedule-----");
                    displayFlightSchedule(flightScheduleArr);
                    break;
                case 5:
                    loyaltyMember(input, userArr);
                    break;
                case 6:
                    System.out.print("-----Exit------");
                    break;
                default:
                    System.out.println("Please enter again");
                    break;
            }

        } while (option != 6);
    }

    //Feature 1: Flight booking
    public static void bookFlight(ArrayList<FlightDatabase> flightDatabaseArr, ArrayList<FlightBooking> flightBookingArr, Scanner input, Random random, ArrayList<CheckIn> checkInArr, ArrayList<User> userArr, ArrayList <CheckIn> boardingGateArr) {

        //Variables
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //date format
        String todayDate = LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear(); //initialize today's date
        LocalDate initialDate = LocalDate.parse(LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear(), dateFormat); //change format and save
        String inputReturnDate = null;
        String inputReturnFlight;
        FlightDatabase selectedReturnFlight = null;
        FlightBooking flightBooking;
        boolean valid = false;
        String firstName = "", lastName = "", inputTypeTrip = "", inputCabinClass = "";
        String inputDepDate = "";
        LocalDate depDate;

        //Gather all user input for flight booking
        input.nextLine();

        //One-way or round trip
        while (!valid) {
            System.out.print("\nEnter trip type (one-way/round trip): ");
            inputTypeTrip = input.nextLine();

            if (inputTypeTrip.equalsIgnoreCase("one-way") || inputTypeTrip.equalsIgnoreCase("round trip")) {
                valid = true;
            } else {
                System.out.println("Invalid input, please enter again");
            }
        }

        //Departure date
        while (true){
            try{
                System.out.print("Enter departure date (DD-MM-YYYY): ");
                inputDepDate = input.nextLine();
                depDate = LocalDate.parse(inputDepDate, dateFormat);
                if (depDate.isBefore((initialDate)) || depDate.isEqual(initialDate)){
                    System.out.println("Please enter a date after " + todayDate);
                }else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid date.");
            }

        }

        //Round trip requires returning date input
        if (inputTypeTrip.equalsIgnoreCase("round trip")) {
            while (true){
                try{
                    System.out.print("Enter returning date (DD-MM-YYYY): ");
                    inputReturnDate = input.nextLine();
                    LocalDate returnDate = LocalDate.parse(inputReturnDate, dateFormat);
                    if (returnDate.isBefore(depDate) || returnDate.isEqual(depDate)){
                        System.out.println("Please enter a date after " + inputDepDate);
                    }else {
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Please enter a valid date.");
                }
            }

        }

        //Cabin class
        valid = false; //reinitialize
        while (!valid) {
            System.out.print("Enter cabin class (Business/Economy): ");
            inputCabinClass = input.nextLine();

            if (inputCabinClass.equalsIgnoreCase("Economy") || inputCabinClass.equalsIgnoreCase("Business")) {
                valid = true;
            } else {
                System.out.println("Invalid input, please enter again");
            }
        }

        //for loop to display available flights for booking
        System.out.print("\nFLIGHT     AIRLINE      FROM   TO     CLASS        PRICE        TIME");
        System.out.println("\n---------------------------------------------------------------------");

        //Odd days 5 flights, even days 5 flights
        int hyphenIndex = inputDepDate.indexOf("-"); //Find index of first hyphen
        String extractedDepDate = inputDepDate.substring(0, hyphenIndex); //Extract the date from inputCabin
        int date = Integer.parseInt(extractedDepDate); //Convert string to integer for Date

        if (date % 2 == 0) {
            for (int i = 0; i < 5; i++) {
                if (flightDatabaseArr.get(i).getCabinClass().equalsIgnoreCase(inputCabinClass)) {
                    //Format specifier to space out the String
                    System.out.printf("%-10s %-12s %-6s %-6s %-12s RM%-10.2f %-6s\n",
                            flightDatabaseArr.get(i).getFlightNum(), flightDatabaseArr.get(i).getAirline(),
                            flightDatabaseArr.get(i).getFrom(), flightDatabaseArr.get(i).getTo(),
                            flightDatabaseArr.get(i).getCabinClass(), flightDatabaseArr.get(i).getBasePrice(),
                            flightDatabaseArr.get(i).getDepartureTime());
                } else {
                    continue;
                }
            }
        } else {
            for (int i = 5; i < 10; i++) {
                if (flightDatabaseArr.get(i).getCabinClass().equalsIgnoreCase(inputCabinClass)) {
                    System.out.printf("%-10s %-12s %-6s %-6s %-12s RM%-10.2f %-6s\n",
                            flightDatabaseArr.get(i).getFlightNum(), flightDatabaseArr.get(i).getAirline(),
                            flightDatabaseArr.get(i).getFrom(), flightDatabaseArr.get(i).getTo(),
                            flightDatabaseArr.get(i).getCabinClass(), flightDatabaseArr.get(i).getBasePrice(),
                            flightDatabaseArr.get(i).getDepartureTime());
                } else {
                    continue;
                }
            }
        }

        //User choose flight option
        System.out.print("\nEnter departure flight Id: ");
        String inputFlight = input.nextLine();
        FlightDatabase selectedFlight = matchFlight(flightDatabaseArr, inputFlight); //Check for departure flight

        while (selectedFlight == null){
            System.out.print("\nEnter departure flight Id: ");
            inputFlight = input.nextLine();
            selectedFlight = matchFlight(flightDatabaseArr, inputFlight);
        }

        //If is round trip
        if (inputTypeTrip.equalsIgnoreCase("round trip")) {
            System.out.print("\n\nRETURNING FLIGHTS");
            System.out.print("\nFLIGHT     AIRLINE      FROM   TO     CLASS        PRICE        TIME");
            System.out.println("\n---------------------------------------------------------------------");

            matchReturnFlight(flightDatabaseArr, inputFlight);

            System.out.print("\nEnter returning flight Id: ");
            inputReturnFlight = input.nextLine();
            //Match return flight with database
            selectedReturnFlight = matchFlight(flightDatabaseArr, inputReturnFlight); //Check for round-trip

            while (selectedReturnFlight == null){
                System.out.print("\nEnter returning flight Id: ");
                inputReturnFlight = input.nextLine();
                selectedReturnFlight = matchFlight(flightDatabaseArr, inputReturnFlight);
            }
        }

        //Variables
        String optMeal = "";
        String optBaggage = "";

        //Additional option
        System.out.print("\nAdd-Ons:");

        //Add on baggage
        valid = false;
        while (!valid) {
            System.out.print("\nBaggage (Y/N): ");
            optBaggage = input.nextLine();

            if (optBaggage.equalsIgnoreCase("Y") || optBaggage.equalsIgnoreCase("N")) {
                valid = true;
            } else {
                System.out.println("Invalid input, please enter again");
            }
        }

        //Add on meals
        valid = false;
        while (!valid) {
            System.out.print("Meal (Y/N): ");
            optMeal = input.nextLine();

            if (optMeal.equalsIgnoreCase("Y") || optMeal.equalsIgnoreCase("N")) {
                valid = true;
            } else {
                System.out.println("Invalid input, please enter again");
            }
        }

        //Random booking Number in 5 digits
        int bookingNum = random.nextInt(10000, 99999);
        double totalAmount = 0;

        //Add into array
        if (inputTypeTrip.equalsIgnoreCase("round trip")) {
            flightBooking = new FlightBooking(bookingNum, selectedFlight, selectedReturnFlight, firstName, lastName, inputTypeTrip, inputDepDate, inputReturnDate, inputCabinClass, optMeal, optBaggage, totalAmount);
        } else {
            flightBooking = new FlightBooking(bookingNum, firstName, lastName, selectedFlight, inputTypeTrip, inputDepDate, inputCabinClass, optMeal, optBaggage, totalAmount);
        }
        flightBookingArr.add(flightBooking);
        System.out.print(flightBooking); //Print pre check-out summary

        boolean checkIn = false; //exception if cancel booking dont come in this check in add
        boolean roundCheckIn = false;
        String boardingGate = "To be Determined";
        String seatNumber = " ";
        int userIndex = 0;

        if (flightBookingArr.getLast().getTripType().equalsIgnoreCase("one-way")){
            checkInArr.add(new CheckIn(userArr.get(userIndex).getLastName(), bookingNum, checkIn, boardingGate, seatNumber));
        }else {
            checkInArr.add(new CheckIn(userArr.get(userIndex).getLastName(), bookingNum, roundCheckIn,checkIn, boardingGate, seatNumber));
        }

        //Enter check loyalty member
        userIndex = checkoutLoyalty(input, userArr, flightBooking, flightBookingArr);
        if (flightBookingArr.isEmpty()){
            checkInArr.removeLast();

        }else if (flightBookingArr.getLast().getBookingNumber() == checkInArr.getLast().getBookingNumber()){
            //Set back the user last name
            checkInArr.getLast().setLastName(userArr.get(userIndex).getLastName());

            //Add in checkInArr
            boolean checkSame = false;
            //Check if there is any same flight Id and dep date
            for (int i = 0; i < boardingGateArr.size(); i++){
                if (flightBookingArr.getLast().getFlightId().getFlightNum().equalsIgnoreCase(boardingGateArr.get(i).getFlightNum()) && flightBookingArr.getLast().getDepDate().equalsIgnoreCase(boardingGateArr.get(i).getDepDate())){
                    checkSame = true;
                    break;
                }
            }
            if (!checkSame){ //Don't have the same flight Id and dep date, the boarding gate is not generated
                boardingGateArr.add(new CheckIn(flightBookingArr.getLast().getFlightId().getFlightNum(), flightBookingArr.getLast().getDepDate(),boardingGate ));
            }
        }else {
            checkInArr.removeLast();
        }




    }

    //Feature 1: Check user (member/non-member) during checkout
    public static int checkoutLoyalty(Scanner input, ArrayList<User> userArr, FlightBooking flightBooking, ArrayList<FlightBooking> flightBookingArr) {
        double discount = 0.0;
        User u = null;
        boolean valid = false;
        int userIndex = 0;

        //Check have member or not
        while (u == null) {
            System.out.print("\nEnter user Id (or '-' to sign up): ");
            String inputUserId = input.nextLine();

            if (inputUserId.equals("-")) {
                System.out.println("\nPlease sign up to continue to checkout >>>");
                u = User.signUpNonMember(input, userArr);
                userIndex = userArr.indexOf(u);
            } else {
                u = User.matchUser(userArr, inputUserId);
                userIndex = userArr.indexOf(u);
            }

            if (u == null) {
                System.out.print("Invalid input, please enter again\n");
            }
        }

        //Have member
        if (u instanceof Member m) { //Is a member
            String optPoints = "";
            System.out.print("Loyalty member profile found!");
            System.out.println(m);

            if (m.pointsRedeem() > 0) {
                System.out.print("Points redeemable to cash: RM" + String.format("%.2f", m.pointsRedeem()));

                while (!valid) {
                    System.out.print("\nWould you like to use loyalty points as discount? (Y/N): ");
                    optPoints = input.nextLine();

                    if (optPoints.equalsIgnoreCase("Y") || optPoints.equalsIgnoreCase("N")) {
                        valid = true;
                    } else {
                        System.out.println("Invalid input, please enter again");
                    }
                }

                if (optPoints.equalsIgnoreCase("Y")) {
                    discount = m.pointsRedeem();
                    //Only allow member to redeem the maximum points which is equal to total fare
                    if (discount > flightBooking.calcTotalFare()) {
                        discount = flightBooking.calcTotalFare();
                    }
                    System.out.print(flightBooking.printPreCheckoutMember(discount, m.getPointsCollected()));
                } else {
                    System.out.print("Continue without redeeming loyalty points: ");
                }
            } else {
                System.out.print("Oops, no points available to redeem\n");
            }

            String confirmPayment = "";
            valid = false;
            while (!valid) {
                System.out.print("\nConfirm payment? (Y/N): ");
                confirmPayment = input.nextLine();

                if (confirmPayment.equalsIgnoreCase("Y") || confirmPayment.equalsIgnoreCase("N")) {
                    valid = true;
                } else {
                    System.out.println("Invalid input, please enter again");
                }
            }

            if (confirmPayment.equalsIgnoreCase("Y")) {
                double amountPaid = flightBooking.calcTotalFare() - discount;
                double totalAmount = flightBooking.checkoutMember(discount);
                flightBookingArr.getLast().setTotalPaid(totalAmount);

                System.out.print(flightBooking.printPayment(totalAmount));
                System.out.print(m.updatedMemberProfile(amountPaid, discount));
                flightBookingArr.getLast().setLastName(userArr.get(userIndex).getLastName());
                flightBookingArr.getLast().setFirstName(userArr.get(userIndex).getFirstName());
            } else {
                flightBookingArr.removeLast();
                System.out.println("You have cancelled the process");
            }

        } else if (u instanceof NonMember nm) { // For nonmember

            System.out.print("Non-member profile found!");
            System.out.println(nm);

            boolean usePromo = false;
            double totalPayable = flightBooking.calcTotalFare();

            if (nm.isHasPromo()) {
                String optNewUserPromo = "";
                valid = false;
                while (!valid) {
                    System.out.print("Would you like to use the one-time discount? (Y/N): ");
                    optNewUserPromo = input.nextLine();

                    if (optNewUserPromo.equalsIgnoreCase("Y") || optNewUserPromo.equalsIgnoreCase("N")) {
                        valid = true;
                    } else {
                        System.out.println("Invalid input, please enter again\n");
                    }
                }

                if (optNewUserPromo.equalsIgnoreCase("Y")) {
                    usePromo = true;
                    System.out.print(flightBooking.printPreCheckoutNonMember(totalPayable, usePromo));

                } else {
                    System.out.print("\nContinue without one-time new user promo");
                }
            }

            String confirmPayment = "";
            valid = false;
            while (!valid) {
                System.out.print("\nConfirm payment? (Y/N): ");
                confirmPayment = input.nextLine();

                if (confirmPayment.equalsIgnoreCase("Y") || confirmPayment.equalsIgnoreCase("N")) {
                    valid = true;
                } else {
                    System.out.println("Invalid input, please enter again");
                }
            }

            if (confirmPayment.equalsIgnoreCase("Y")) {
                double totalAmount = flightBooking.checkoutNonMember(usePromo);
                flightBookingArr.getLast().setTotalPaid(totalAmount);
                System.out.print(flightBooking.printPayment(totalAmount));
                System.out.print(nm.updatedNonMemberProfile(usePromo));

                //Check if bookingCount >= 10, upgrade to member
                if (nm.getBookingCount() >= 10) {
                    //Create new object (Member) for nonMember
                    Member m = new Member(nm.getFirstName(), nm.getLastName(), nm.getAge(), nm.getUserId(), 0.0, "Bronze Tier", 0.0);
                    //Replace new object in array
                    userArr.set(userArr.indexOf(nm), m);

                    //Upgraded to member message
                    System.out.print("\n\n=========================================="
                            + "\n       LOYALTY TIER UPGRADE!        "
                            + "\n=========================================="
                            + "\nCongrats!! You have reached 10 bookings"
                            + "\nAccount (" + nm.getUserId() + ") upgraded to Loyalty Member (Bronze)"
                            + "\n==========================================\n\n");
                }
                flightBookingArr.getLast().setLastName(userArr.get(userIndex).getLastName());
                flightBookingArr.getLast().setFirstName(userArr.get(userIndex).getFirstName());

            } else {
                flightBookingArr.removeLast();
                System.out.print("Payment cancelled. Returning to main menu...\n\n");
            }
        }
        return userIndex;
    }

    //Feature 1: Match inputFlight with flightNum in FlightDatabase
    public static FlightDatabase matchFlight(ArrayList<FlightDatabase> flightDatabaseArr, String inputFlight) {
        for (FlightDatabase flight : flightDatabaseArr) {
            if (flight.getFlightNum().equalsIgnoreCase(inputFlight)) {
                return flight;
            }
        }
        System.out.println("No matching flights");
        return null;
    }

    //Feature 1: Match return flight with chosen flight locations (reverse from, 1to)
    public static void matchReturnFlight(ArrayList<FlightDatabase> flightDatabaseArr, String inputFlight) {
        FlightDatabase selectedFlight = matchFlight(flightDatabaseArr, inputFlight);

        if (selectedFlight == null) {
            return;
        }
        boolean foundReturn = false;

        for (int i = 10; i < flightDatabaseArr.size(); i++) {
            FlightDatabase returnFlight = flightDatabaseArr.get(i);

            if (selectedFlight.getTo().equalsIgnoreCase(returnFlight.getFrom()) && selectedFlight.getFrom().equalsIgnoreCase(returnFlight.getTo())) {
                foundReturn = true;
                System.out.printf("%-10s %-12s %-6s %-6s %-12s RM%-10.2f %-6s\n",
                        returnFlight.getFlightNum(), returnFlight.getAirline(),
                        returnFlight.getFrom(), returnFlight.getTo(),
                        returnFlight.getCabinClass(), returnFlight.getBasePrice(),
                        returnFlight.getDepartureTime());
            }
        }
        if (!foundReturn) {
            System.out.print("No matching flights available");
        }
    }

    //Feature 2: Check in
    public static void checkIn(ArrayList<FlightBooking> flightBookingArr, ArrayList<CheckIn> checkInArr, ArrayList<User> userArr, Scanner input, ArrayList<CheckIn> boardingGateArr) {
        CheckIn checkIn = new CheckIn();

        //Variables
        int bookingIndex = 0; //initial number
        boolean checkName = false; //Initial haven't checkName
        boolean checkBookingNumber = false;
        int ageRestrict = 0;
        String name;
        int bookingNumber = 0;
        String boardingGate = null;

        //Check Booking Number
        do {
            try{
                System.out.print("\nEnter your booking number: ");
                bookingNumber = input.nextInt();
                for (bookingIndex = 0; bookingIndex < flightBookingArr.size(); bookingIndex++) {
                    if (bookingNumber == flightBookingArr.get(bookingIndex).getBookingNumber()) {
                        checkBookingNumber = true;
                        break;
                    }
                }
                if (!checkBookingNumber){
                    System.out.println("The booking number is invalid or not found. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid booking number");
                input.nextLine();
            }

        } while (!checkBookingNumber);

        //Check Name
        input.nextLine();
        do {
            System.out.print("Enter your last name: ");
            name = input.nextLine();
            if (name.equalsIgnoreCase(flightBookingArr.get(bookingIndex).getLastName())) {
                //check user age, if under 16 can't online check in
                for (int checkAge = 1; checkAge < userArr.size(); checkAge++){
                    if (flightBookingArr.get(bookingIndex).getFirstName().equalsIgnoreCase(userArr.get(checkAge).getFirstName())){
                        if (userArr.get(checkAge).getAge() < 16){
                            ageRestrict ++;
                        }
                    }
                }
                checkName = true;
                break;
            }

            if (!checkName) {
                System.out.println("The name you entered is not found. Please try again");
            }

        } while (!checkName); //If check name is true, break from while loop

        //Age under 16 cannot online check in
        boolean checkBoardingGate = false;
        int boardingGateIndex = 0;
        if (ageRestrict > 0){
            System.out.println("User under 16 is not allowed to check in online. Please proceed to the check-in counter. ");
        } //Check if check in before
        else if (checkInArr.get(bookingIndex).isCheckIn() && flightBookingArr.get(bookingIndex).getTripType().equalsIgnoreCase("one-way")) {
            System.out.println("You have been checked in.");
        }else if (checkInArr.get(bookingIndex).isCheckIn() && checkInArr.get(bookingIndex).isRoundCheckIn()){
            System.out.println("You have been checked in this round trip.");
        } else { //First time check in
            for (boardingGateIndex =0; boardingGateIndex < boardingGateArr.size(); boardingGateIndex++){
                if (boardingGateArr.get(boardingGateIndex).getFlightNum().equalsIgnoreCase(flightBookingArr.get(bookingIndex).getFlightId().getFlightNum())){ //If flight booking Array Flight Number is same as boardingGate Array Flight Number
                    if (boardingGateArr.get(boardingGateIndex).getDepDate().equals(flightBookingArr.get(bookingIndex).getDepDate())){  //If flight Booking Array Departure date is same with boarding Gate Array Departure Date
                        if (boardingGateArr.get(boardingGateIndex).getBoardingGate().equalsIgnoreCase("To be Determined")){ //If boarding Gate Array is to be determined, the boarding Gate have not been random before
                            boardingGate = checkIn.checkBoardingGate(boardingGateArr, boardingGateArr.get(boardingGateIndex).getDepDate());
                            boardingGateArr.get(boardingGateIndex).setBoardingGate(boardingGate);
                            checkBoardingGate = true;
                            break;
                        }else {
                            break;
                        }
                    }
                }

            }
            if (!checkBoardingGate){
                boardingGate = boardingGateArr.get(boardingGateIndex).getBoardingGate();
            }
            String seatNumber = checkIn.randomSeatNumber(flightBookingArr, bookingIndex);
            System.out.println("Your seat has been automatically given as " + seatNumber);
            checkInArr.get(bookingIndex).setCheckIn(true);
            checkInArr.get(bookingIndex).setSeatNumber(seatNumber);
            checkInArr.get(bookingIndex).setBoardingGate(boardingGate);

        }
        //Avoid age under 16 print boarding pass
        if (ageRestrict != 1) {
            System.out.println(checkIn.toString(flightBookingArr, bookingIndex, checkInArr));
        }

        if (!checkInArr.get(bookingIndex).isRoundCheckIn() && flightBookingArr.get(bookingIndex).getTripType().equalsIgnoreCase("round trip")){
            System.out.print("\nDo you want to check in for the return trip (Y for yes/ N for no): ");
            String checkInReturn = input.nextLine();
            if (checkInReturn.equalsIgnoreCase("y")){
                String boardingGateReturn = checkIn.randomBoardingGate();
                String seatNumberReturn = checkIn.randomSeatNumber(flightBookingArr, bookingIndex);
                System.out.println("Your seat has been automatically given as " + seatNumberReturn);
                checkInArr.get(bookingIndex).setRoundCheckIn(true);
                checkInArr.get(bookingIndex).setBoardingGate(boardingGateReturn);
                checkInArr.get(bookingIndex).setSeatNumber(seatNumberReturn);
                System.out.println(checkIn.toString(flightBookingArr, bookingIndex, checkInArr));

            } else if (checkInReturn.equalsIgnoreCase("N")) {
                System.out.println("You can check in for the return trip 24 hours before the flight.");
            }else {
                System.out.println("Please enter again.");
            }
        }
    }

    //Feature 3: Flight Cancellation
    public static void flightCancellation(ArrayList<FlightBooking> flightBookingArr, Scanner input) {

        //variables
        boolean checkBookingNumber = false;
        boolean checkLastName = false;
        int bookingIndex = 0;
        int reset = 0;
        String lastName = "";
        String cancelFlight = "";

        //Check Booking Number
        do {
            System.out.print("\nEnter your booking number: ");
            int bookingNumber = input.nextInt();
            for (bookingIndex = 0; bookingIndex < flightBookingArr.size(); bookingIndex++) {
                if (bookingNumber == flightBookingArr.get(bookingIndex).getBookingNumber()) {
                    checkBookingNumber = true;
                    break;
                }
            }
            if (!checkBookingNumber){
                System.out.println("The booking number is invalid or not found. Please try again.");
            }
        } while (!checkBookingNumber);

        //Check Name
        input.nextLine();
        do {
            System.out.print("Enter your last name: ");
            lastName = input.nextLine();
            if (lastName.equalsIgnoreCase(flightBookingArr.get(bookingIndex).getLastName())) {
                checkLastName = true;
                break;
            }

            if (!checkLastName) {
                System.out.println("The name you entered is not found. Please try again");
            }

        } while (!checkLastName); //If check name is true, break from while loop

        //Print flight Details
        System.out.println("\n-----Flight Details-----" +
                "\nFlight Id: " + flightBookingArr.get(bookingIndex).getFlightId().getFlightNum() +
                "\nRoute: " + flightBookingArr.get(bookingIndex).getFlightId().getFrom() + " -> " + flightBookingArr.get(bookingIndex).getFlightId().getTo() +
                "\nDeparture: " + flightBookingArr.get(bookingIndex).getDepDate() + " at " + flightBookingArr.get(bookingIndex).getFlightId().getDepartureTime() +
                "\nTrip type: " + flightBookingArr.get(bookingIndex).getTripType() +
                "\nCabin class: " + flightBookingArr.get(bookingIndex).getCabinClass());

        boolean cancelProcess = false;
        do {
            if (reset == 0) {
                System.out.println("\nCancel a flight only will refund 80% of the total amount paid.");
                System.out.print("Are you sure to cancel this flight (y for yes/ n for no): ");
                cancelFlight = input.nextLine();
                reset++;
            } else {
                System.out.println("\nCancel a flight only will refund 80% of the total amount paid.");
                System.out.print("Are you sure to cancel this flight (y for yes/ n for no): ");
                cancelFlight = input.nextLine();
            }

            if (cancelFlight.equalsIgnoreCase("y")) {
                //Cancel Flight
                double flightRefund = (flightBookingArr.get(bookingIndex).getTotalPaid()) * 0.8;
                System.out.print("Your refund for this flight is " + flightRefund);
                System.out.println("The refund is success.");
                flightBookingArr.remove(bookingIndex);
                cancelProcess = true;

            } else if (cancelFlight.equalsIgnoreCase("n")) {
                //Cancel cancel Flight
                System.out.print("You cancel this process.\n");
                cancelProcess = true;

            } else {
                //Exception
                System.out.print("Please enter Y/N only.");
            }
        } while (!cancelProcess);
    }

    // Feature 4: Flight Schedule
    public static void displayFlightSchedule(ArrayList<FlightSchedule> flightSchedulesArr) {
        LocalDateTime today = LocalDateTime.of(2026, 11, 20, 0, 0);
        LocalDateTime threeDaysLater = today.plusDays(3);

        boolean foundFlight = false;

        for (FlightSchedule schedule : flightSchedulesArr) {

            if (!schedule.getDateTime().isBefore(today) && schedule.getDateTime().isBefore(threeDaysLater)) {

                foundFlight = true;

                System.out.println("Flight Number: " + schedule.getFlight().getFlightNum());
                System.out.println("Date and Time: " + schedule.getDateTime());
                System.out.println("Gate: " + schedule.getGate());
                System.out.println("Status: " + schedule.getStatus());
                System.out.println("-------------------------");

            }
        }

        if (!foundFlight) {
            System.out.println("No upcoming flights");
        }
    }

    //Feature 5: Loyalty member
    public static void loyaltyMember(Scanner input, ArrayList <User> userArr){
        int choice = 0;
        while (true){
            System.out.println("\n-----Loyalty Programme-----");
            System.out.println("1. Sign up as a new user" +
                    "\n2. Check user details");
            System.out.print("Enter your choice (1-2): ");
            try{
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        input.nextLine();
                        NonMember nm = User.signUpNonMember(input, userArr);
                        System.out.println(nm.toString());
                        break;
                    case 2:
                        User user = User.findUser(input, userArr);
                        if (user instanceof Member member) {
                            System.out.println(member.toString());
                        } else if (user instanceof NonMember nonMember) {
                            System.out.println(nonMember.toString());
                        }
                        break;
                    default:
                        System.out.println("Please enter 1 or 2 only.");
                }
                if (choice == 1 || choice == 2){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter again.");
                input.nextLine(); //Clear
            }
        }

    }
}