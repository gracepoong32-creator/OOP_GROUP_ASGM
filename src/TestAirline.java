import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestAirline {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Input scanner
        Random random = new Random(); //Random
        CheckIn checkIn = new CheckIn();

        //Arraylist for preset flight schedules, flights booked, checked in, loyalty members, upcoming flight schedule
        ArrayList<FlightDatabase> flightDatabaseArr = new ArrayList<>();
        ArrayList<Flight> flightArr = new ArrayList<>();
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


        //Preset the boarding Gate today
        String localDate = LocalDateTime.now().getDayOfMonth() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getYear();
        LocalDate scheduleDate = LocalDate.now();
        java.io.File file = new java.io.File("BoardingGate.txt");
        int add = 0;
        try{
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNext()){ //If file has information, load in arrayList
                boardingGateArr.add(new CheckIn(fileInput.next(), fileInput.next() , fileInput.next()));
            }
            for (CheckIn g: boardingGateArr){ //Check if arrayList have alr got today's date
                if (g.getDate().equals(localDate)){
                    add ++;
                }
            }
            System.out.println(add);
            if (add < 23|| file.length()==0){
                for (FlightDatabase f:flightDatabaseArr){
                    boardingGateArr.add(new CheckIn(f.getFlightNum(), localDate,checkIn.checkBoardingGate(boardingGateArr, localDate)));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Boarding gate File isn't exists.");
        }

        // Present flight schedules
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(0), scheduleDate.plusDays(0), boardingGateArr.get(0).getBoardingGate(), "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(1), scheduleDate.plusDays(0), boardingGateArr.get(1).getBoardingGate(), "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(2), scheduleDate.plusDays(0), boardingGateArr.get(2).getBoardingGate(), "Delayed"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(3), scheduleDate.plusDays(1), boardingGateArr.get(3).getBoardingGate(), "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(4), scheduleDate.plusDays(1), boardingGateArr.get(4).getBoardingGate(), "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(5), scheduleDate.plusDays(1), boardingGateArr.get(5).getBoardingGate(), "Cancelled"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(6), scheduleDate.plusDays(2), boardingGateArr.get(6).getBoardingGate(), "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(7), scheduleDate.plusDays(2), boardingGateArr.get(7).getBoardingGate(), "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(8), scheduleDate.plusDays(2), boardingGateArr.get(8).getBoardingGate(), "On Time"));
        flightScheduleArr.add(new FlightSchedule(flightDatabaseArr.get(9), scheduleDate.plusDays(2), boardingGateArr.get(9).getBoardingGate(), "On Time"));

        //Preset loyalty members in arraylist from User.txt
        try {
            file = new java.io.File("User.txt");         //Create a File instance
            Scanner fileInput = new Scanner(file);        //Create a scanner for the file
            while(fileInput.hasNext()){
                String firstName = fileInput.next();
                String lastName = fileInput.next();
                int age = fileInput.nextInt();
                String userId = fileInput.next();
                if (fileInput.hasNextInt()){
                    int bookingCount = fileInput.nextInt();
                    boolean hasPromo = fileInput.nextBoolean();
                    userArr.add(new NonMember(firstName,lastName,age,userId, bookingCount,hasPromo));
                }else {
                    double pointsCollected = fileInput.nextDouble();
                    String memberTier = fileInput.next() + " " + fileInput.next();
                    double totalSpent = fileInput.nextDouble();
                    userArr.add(new Member(firstName, lastName, age,userId,pointsCollected,memberTier,totalSpent));
                }
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("User File not exists");
        }

        //Preset the Booking Array
        try{
            file = new java.io.File("Booking.txt");
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNext()){
                int bookingNumber = fileInput.nextInt();
                String tripType = fileInput.next();
                String flight = fileInput.next();
                FlightDatabase flightDatabase = null;
                for (FlightDatabase f : flightDatabaseArr){
                    if (f.getFlightNum().equalsIgnoreCase(flight)){
                        flightDatabase = f; //Set the
                        break;
                    }
                }

                if (tripType.equalsIgnoreCase("One-way")){
                    flightArr.add(new Flight(bookingNumber,tripType,flightDatabase, fileInput.next(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextDouble()));
                } else {
                    String returnFlight = fileInput.next();
                    FlightDatabase returnflightDatabase = null;
                    for (FlightDatabase f : flightDatabaseArr) {
                        if (f.getFlightNum().equalsIgnoreCase(returnFlight)) {
                            returnflightDatabase = f;
                            break;
                        }
                    }
                    flightArr.add(new Flight(bookingNumber,tripType,flightDatabase, returnflightDatabase, fileInput.next(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.next(), fileInput.nextDouble()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Booking File not exists");
        }

        //Preset CheckIn Array
        try{
            file = new java.io.File("CheckIn.txt");
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNext()){
                String lastName = fileInput.next();
                int bookingNumber = fileInput.nextInt();
                boolean hasCheckIn = fileInput.nextBoolean();
                if (fileInput.hasNextBoolean()){
                    checkInArr.add(new CheckIn(lastName,bookingNumber,hasCheckIn,fileInput.nextBoolean(), fileInput.next(),fileInput.next(), fileInput.next(), fileInput.next()));
                }else {
                    checkInArr.add(new CheckIn(lastName,bookingNumber,hasCheckIn,fileInput.next(),fileInput.next()));
                }
            }
        } catch (Exception e) {
            System.out.println("Check In file isn't exists.");
        }

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
            try{
                option = input.nextInt();
                switch (option) {
                    case 1:
                        System.out.print("\n-----Flight Booking-----");
                        bookFlight(flightDatabaseArr, flightArr, input, random, checkInArr, userArr, boardingGateArr);
                        break;
                    case 2:
                        if (flightArr.isEmpty()){
                            System.out.println("There is no booking to check in.");
                        }else {
                            System.out.print("-----Check In-----");
                            checkIn(flightArr, checkInArr, userArr, input, boardingGateArr);
                        }
                        break;
                    case 3:
                        if (flightArr.isEmpty()){
                            System.out.println("There is no booking to check in.");
                        } else {
                            System.out.print("-----Flight cancellation-----");
                            fightCancellation(flightArr, checkInArr, input);
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
                        exit(boardingGateArr, checkInArr, flightArr, userArr);
                        break;
                    default:
                        System.out.println("Please enter again");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please enter 1 - 6 only");
                input.nextLine();
            }

        } while (option != 6);
    }

    //Feature 1: Flight booking
    public static void bookFlight(ArrayList<FlightDatabase> flightDatabaseArr, ArrayList<Flight> flightArr, Scanner input, Random random, ArrayList<CheckIn> checkInArr, ArrayList<User> userArr, ArrayList <CheckIn> boardingGateArr) {
        //Variables
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //date format
        String todayDate = LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear(); //initialize today's date
        LocalDate initialDate = LocalDate.parse(todayDate, dateFormat); //change format and save
        String inputReturnDate = null;
        String inputReturnFlight;
        FlightDatabase selectedReturnFlight = null;
        Flight flight;
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
            //Exception
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
            //Exception
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
        String inputFlight = " ";
        FlightDatabase selectedFlight = null;
        while (true){
            System.out.print("\nEnter departure flight Id: ");
            inputFlight = input.nextLine();
            selectedFlight = matchFlight(flightDatabaseArr, inputFlight);//Check for departure flight
            if (selectedFlight != null){
                break;
            }
        }
        //If is round trip
        if (inputTypeTrip.equalsIgnoreCase("round trip")) {
            System.out.print("\n\nRETURNING FLIGHTS");
            System.out.print("\nFLIGHT     AIRLINE      FROM   TO     CLASS        PRICE        TIME");
            System.out.println("\n---------------------------------------------------------------------");

            matchReturnFlight(flightDatabaseArr, inputFlight);

            while (true){
                System.out.print("\nEnter returning flight Id: ");
                inputReturnFlight = input.nextLine();
                selectedReturnFlight = matchFlight(flightDatabaseArr, inputReturnFlight); //Check for round-trip
                if (selectedReturnFlight != null){
                    break;
                }
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
            flight = new Flight(bookingNum,inputTypeTrip, selectedFlight, selectedReturnFlight, firstName, lastName, inputDepDate, inputReturnDate, inputCabinClass, optMeal, optBaggage, totalAmount);
        } else {
            flight = new Flight(bookingNum,inputTypeTrip, selectedFlight, firstName, lastName,inputDepDate, inputCabinClass, optMeal, optBaggage, totalAmount);
        }
        flightArr.add(flight);
        System.out.print(flight); //Print pre check-out summary

        //Enter check loyalty member
        int userIndex = checkoutLoyalty(input, userArr, flight, flightArr);
        if (flightArr.getLast().getBookingNumber() == bookingNum) {
            boolean checkIn = false; //exception if cancel booking don't come in this check in add
            boolean roundCheckIn = false;
            String boardingGate = "To-be-Determined";
            String returnBoardingGate = "To-be-Determined";
            String seatNumber = "To-be-Determined";
            String returnSeatNumber = "To-be-Determined";

            if (flightArr.getLast().getTripType().equalsIgnoreCase("one-way")) {
                checkInArr.add(new CheckIn(flightArr.getLast().getLastName(), bookingNum, checkIn, boardingGate, seatNumber));
            } else {
                checkInArr.add(new CheckIn(flightArr.getLast().getLastName(), bookingNum, checkIn, roundCheckIn, boardingGate, returnBoardingGate, seatNumber, returnSeatNumber));
            }

            //Add in checkInArr
            boolean checkFirstSame = false;
            boolean checkSecondSame = false;

            //Check if there is any same flight ID and dep date
            for (int i = 0; i < boardingGateArr.size(); i++) {
                //If the first trip/ one-way have alr the date in the ArrayList, no need add
                if (flightArr.getLast().getFlightId().getFlightNum().equalsIgnoreCase(boardingGateArr.get(i).getFlightNum()) && flightArr.getLast().getDepDate().equalsIgnoreCase(boardingGateArr.get(i).getDate())) {
                    checkFirstSame = true;
                }
                //If is round trip, check if the return trip have the information in the ArrayList
                if (flightArr.getLast().getTripType().equalsIgnoreCase("round trip")) {
                    if (flightArr.getLast().getReturnFlightId().getFlightNum().equalsIgnoreCase(boardingGateArr.get(i).getFlightNum()) && flightArr.getLast().getReturnDate().equalsIgnoreCase(boardingGateArr.get(i).getDate())) {
                        checkSecondSame = true;
                    }
                }
            }
            if (!checkFirstSame){
                boardingGateArr.add(new CheckIn(flightArr.getLast().getFlightId().getFlightNum(), flightArr.getLast().getDepDate(), boardingGate));
            }else if (!checkSecondSame){
                boardingGateArr.add(new CheckIn(flightArr.getLast().getReturnFlightId().getFlightNum(), flightArr.getLast().getReturnDate(), returnBoardingGate));
            }
        }
    }

    //Feature 1: Check user (member/non-member) during checkout
    public static int checkoutLoyalty(Scanner input, ArrayList<User> userArr, Flight flight, ArrayList<Flight> flightArr) {
        double discount = 0.0;
        int userIndex = 0;
        //Check memberId / sign up / forget memberId process
        User u = findUser(input, userArr);

        // check if user is member or nonMember
        if (u instanceof Member m) { //User is a member
            String optPoints = "";
            System.out.print(m); //Print member info

            //Ensure points balance > 0, display points redeemable, prompt user the option to redeem or not
            if (m.pointsRedeem() > 0) {
                System.out.println("\nPoints redeemable to cash: RM" + String.format("%.2f", m.pointsRedeem()));
                while (true) {
                    System.out.print("\nWould you like to use loyalty points as discount? (Y/N): ");
                    optPoints = input.nextLine();
                    if (optPoints.equalsIgnoreCase("Y")) {
                        discount = m.pointsRedeem();
                        //Only allow member to redeem the maximum points which is equal to total fare
                        if (discount > flight.calcTotalFare()) {
                            discount = flight.calcTotalFare();
                        }
                        System.out.print(flight.printPreCheckoutMember(discount, m.getPointsCollected()));
                        break;
                    } else if (optPoints.equalsIgnoreCase("N")){
                        System.out.print("Continue without redeeming loyalty points: ");
                        break;
                    }else{
                        System.out.println("Invalid input, please enter again");
                    }
                }
            } else {
                System.out.print("Oops, no points available to redeem\n");
            }

            while (true) {
                System.out.print("\nConfirm payment? (Y/N): ");
                String confirmPayment = input.nextLine();
                if (confirmPayment.equalsIgnoreCase("Y")) {
                    double amountPaid = flight.calcTotalFare() - discount;
                    double totalAmount = flight.checkoutMember(discount);
                    flightArr.getLast().setTotalPaid(totalAmount);

                    System.out.print(flight.printPayment(totalAmount));
                    System.out.print(m.updatedMemberProfile(amountPaid, discount));
                    flightArr.getLast().setLastName(m.getLastName());
                    flightArr.getLast().setFirstName(m.getFirstName());
                    break;
                } else if (confirmPayment.equalsIgnoreCase("N")){
                    flightArr.removeLast(); //Remove the flight booking from array once user cancel payment
                    System.out.println("You have cancelled the process");
                    break;
                }else {
                    System.out.println("Invalid input, please enter again");
                }
            }
        } else if (u instanceof NonMember nm) { //User is a nonMember
            System.out.print("Non-member profile found!");
            System.out.println(nm);

            boolean usePromo = false;
            flight.calcTotalFare();

            if (nm.isHasPromo()) {
                while (true) {
                    System.out.print("Would you like to use the one-time discount? (Y/N): ");
                    String optNewUserPromo = input.nextLine();
                    if (optNewUserPromo.equalsIgnoreCase("Y")) {
                        usePromo = true;
                        System.out.print(flight.printPreCheckoutNonMember(usePromo));
                        break;
                    } else if (optNewUserPromo.equalsIgnoreCase("N")) {
                        System.out.print("\nContinue without one-time new user promo");
                        break;
                    }else {
                        System.out.println("Invalid input, please enter again\n");
                    }
                }
            }

            while (true) {
                System.out.print("\nConfirm payment? (Y/N): ");
                String confirmPayment = input.nextLine();
                if (confirmPayment.equalsIgnoreCase("Y")) {
                    double totalAmount = flight.checkoutNonMember(usePromo);
                    flightArr.getLast().setTotalPaid(totalAmount);
                    System.out.print(flight.printPayment(totalAmount));
                    System.out.print(nm.updatedNonMemberProfile(usePromo));

                    //Check if bookingCount >= 10, upgrade to member
                    if (nm.getBookingCount() >= 10) {
                        //Create new object (Member) for nonMember
                        Member m = new Member(nm.getFirstName(), nm.getLastName(), nm.getAge(), nm.getUserId(), 0.0, "Bronze Tier", 0.0);
                        //Replace new object in array because previously user is a nonMember, now a Member
                        userArr.set(userArr.indexOf(nm), m);

                        //Upgraded to member message
                        System.out.print("\n\n=========================================="
                                + "\n       LOYALTY TIER UPGRADE!        "
                                + "\n=========================================="
                                + "\nCongrats!! You have reached 10 bookings"
                                + "\nAccount (" + nm.getUserId() + ") upgraded to Loyalty Member (Bronze)"
                                + "\n==========================================\n\n");
                    }
                    flightArr.getLast().setLastName(nm.getLastName());
                    flightArr.getLast().setFirstName(nm.getFirstName());
                    break;
                }else if (confirmPayment.equalsIgnoreCase("N")){
                    flightArr.removeLast();
                    System.out.print("Payment cancelled. Returning to main menu...\n\n");
                    break;
                } else {
                    System.out.println("Invalid input, please enter again");
                }
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

    //Feature 1: Sign up during checkout & Feature 5: Sign up as a user
    public static NonMember signUpNonMember(Scanner input, ArrayList<User> userArr) {
        System.out.print("\n\nNEW NON MEMBER SIGN UP\n------------------------\n");
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        int age = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter age: ");
                age = input.nextInt();
                input.nextLine(); //clears leftover newline from age input

                if (age <= 0) {
                    System.out.println("Invalid input, please enter again");
                } else {
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter again");
                input.nextLine(); //clears leftover newline
            }
        }

        String newUserId = "M" + (101 + userArr.size());
        NonMember nm = new NonMember(firstName, lastName, age, newUserId);
        userArr.add(nm);

        System.out.println("\n------------------------------------------");
        System.out.println("Account created successfully!");
        System.out.println("Your new User Id: " + newUserId);
        System.out.println("==========================================\n");

        return nm;
    }

    //Find user member id in Arraylist
    public static User findUser(Scanner input, ArrayList <User> userArr){
        User u = null;
        while (true){
            System.out.print("\nEnter user id (Enter '-' to sign up, or '?' if you forget your user Id): ");
            String userId = input.nextLine();

            if (userId.equalsIgnoreCase("-")){
                u = signUpNonMember(input, userArr);
                break;
            } else if (userId.equalsIgnoreCase("?")) {
                System.out.print("Enter first name: ");
                String firstName = input.nextLine();
                System.out.print("Enter last name: ");
                String lastName = input.nextLine();
                for (User user: userArr){
                    if (user.getFirstName().equalsIgnoreCase(firstName) && user.getLastName().equalsIgnoreCase(lastName)){
                        System.out.println("Member id found: " + user.getUserId());
                        u = user;
                        break;
                    }
                }
                if (u == null){
                    System.out.println("Name entered not found. Please try again.");
                }else {
                    break;
                }

            } else {
                for (User user : userArr){
                    if (user.getUserId().equalsIgnoreCase(userId)){
                        System.out.println("Loyalty member profile found!");
                        u = user;
                        break;
                    }
                }
                if (u == null){
                    System.out.println("The member id you entered is not found. Please enter again");
                }else {
                    break;
                }
            }
        }
        return u;
    }

    //Feature 2: Check in
    public static void checkIn(ArrayList<Flight> flightArr, ArrayList<CheckIn> checkInArr, ArrayList<User> userArr, Scanner input, ArrayList<CheckIn> boardingGateArr) {
        CheckIn checkIn = new CheckIn();
        //Variables
        boolean checkInValid = false;
        String name;
        int bookingNumber = 0;
        String boardingGate = null;
        Flight f = null;
        CheckIn ck = null;

        //Check Booking Number
        do{
            try{
                System.out.print("\nEnter your booking number: ");
                bookingNumber = input.nextInt();
                input.nextLine();
                for (Flight flight : flightArr){
                    if (flight.getBookingNumber() == bookingNumber){
                        f = flight;
                        checkInValid = true;
                        break;
                    }
                }
                if (f == null){
                    System.out.print("Please enter a valid booking number");
                    input.nextLine();
                }
            } catch (Exception e) {
                System.out.print("Invalid input, please enter again");
                input.nextLine();
            }
        } while ((!checkInValid));
        //Check Name
        checkInValid = false;
        input.nextLine();
        while (!checkInValid){
            System.out.print("Enter your last name: ");
            name = input.nextLine();
            if (f.getLastName().equalsIgnoreCase(name)) {
                //check user age, if under 16 can't online check in
                for (User user : userArr){
                    if (f.getLastName().equalsIgnoreCase(user.getLastName())){
                        if (user.getAge() < 16){
                            System.out.println("User under 16 is not allowed to check in online. Please proceed to the check-in counter. ");
                            return;
                        }
                        break;
                    }
                }
                checkInValid = true;
            }
            else{
                System.out.println("The name you entered is not found. Please try again");
            }
        } //If check name is true, break from while loop
        for (CheckIn c : checkInArr){
            if(c.getBookingNumber() == bookingNumber){
                ck = c;
            }
        }

        int bookingIndex = flightArr.indexOf(f); //Save the flight index from array
        //Check if checked in before
        if (ck.isCheckIn() && f.getTripType().equalsIgnoreCase("one-way")) {
            System.out.println("You have been checked in.");
            // If 2 trip is being checked in
        } else if (ck.isCheckIn() && ck.isRoundCheckIn()){
            System.out.println("You have been checked in this round trip.");
        } //First time check in
        else {
            for (CheckIn gate : boardingGateArr){
                if (gate.getFlightNum().equalsIgnoreCase(f.getFlightId().getFlightNum())){//If flightBookingArr Flight Num is same as boardingGateArr Flight Number
                    if (gate.getDate().equals(f.getDepDate())){ //If flightBookingArr Departure date is same with boardingGateArr Departure Date
                        if (gate.getBoardingGate().equalsIgnoreCase("To-be-Determined")){ //If boardingGateArr is to be determined, the boarding Gate have not been assigned yet/ randomly generated
                            boardingGate = checkIn.checkBoardingGate(boardingGateArr, gate.getDate()); //Check if any clash in boardingGate
                            gate.setBoardingGate(boardingGate); //set the boarding Gate
                            break;
                        }else {
                            boardingGate = gate.getBoardingGate(); //Alr have boardingGate
                            break;
                        }
                    }
                }
            }
            String seatNumber = checkIn.randomSeatNumber(flightArr, bookingIndex); //Random seat number
            System.out.print("Your seat has been automatically given as " + seatNumber);

            //Set back in arrayList
            ck.setCheckIn(true);
            ck.setSeatNumber(seatNumber);
            ck.setBoardingGate(boardingGate);
        }
        System.out.println(checkIn.toString(flightArr, bookingIndex, checkInArr));

        //Return trip
        if (!ck.isRoundCheckIn() && f.getTripType().equalsIgnoreCase("round trip")){
            System.out.print("\nDo you want to check in for return trip (Y/N): ");
            String checkInReturn = input.nextLine();
            //Do the boarding pass for return trip
            if (checkInReturn.equalsIgnoreCase("Y")){
                String boardingGateReturn = checkIn.checkBoardingGate(boardingGateArr, f.getReturnDate());
                String seatNumberReturn = checkIn.randomSeatNumber(flightArr, bookingIndex);
                System.out.println("Your seat has been automatically given as " + seatNumberReturn);

                ck.setReturnBoardingGate(boardingGateReturn);
                ck.setReturnSeatNumber(seatNumberReturn);
                ck.setRoundCheckIn(true);
                System.out.println(checkIn.toString(flightArr, bookingIndex, checkInArr));


            } else if (checkInReturn.equalsIgnoreCase("N")) {
                System.out.println("You can check in for the return trip 24 hours before the flight.");
            }else {
                System.out.println("Please enter again.");
            }
        }
    }

    //Feature 3: Flight Cancellation
    public static void fightCancellation(ArrayList<Flight> flightArr, ArrayList<CheckIn> checkInArr, Scanner input){
        int i = 0;
        boolean found = false;
        while (!found){ //Loop in to check booking Number
            try{
                System.out.print("\nEnter Booking Number: ");
                int bookingNumber = input.nextInt();
                for (i = 0 ; i < flightArr .size() ; i ++){
                    if (flightArr.get(i).getBookingNumber() == bookingNumber) {
                        found = true;
                        break;
                    }
                }
                if (!found){
                    System.out.print("Booking number not found. Try again.");
                }
            } catch (Exception e){ //If enter string, will come to exception and loop again
                System.out.println("\nEnter a valid booking number,");
                input.nextLine();
            }
        }

        input.nextLine();
        while (true){ //Loop in to check last name
            System.out.print("Enter last name: ");
            String name = input.nextLine();
            if (flightArr.get(i).getLastName() .equalsIgnoreCase(name)){
                System.out.println("\nUser is found");
                break;
            }else {
                System.out.println("User in not found. Please try again."); //exception to loop again
            }
        }


        System.out.println("\nFlight Details" +
                "\nName: " + flightArr.get(i).getFirstName() + " " + flightArr.get(i).getLastName() +
                "\nBooking Number: " + flightArr.get(i).getBookingNumber()+
                "\n" + flightArr.get(i).getFlightId().getFrom() + " ------> " + flightArr.get(i).getFlightId().getTo() +
                "\nDeparture Date: " + flightArr.get(i).getDepDate());

        while (true){    //check cancellation yes or no
            System.out.println("If you cancel the flight it will only refund 80%");
            System.out.print("Are you sure you want to cancel (Y/N)?: ");
            String yesOrNo = input.nextLine();
            if (yesOrNo.equalsIgnoreCase("Y") ){
                System.out.println("Flight cancellation successful");
                flightArr.remove(i);
                checkInArr.remove(i);
                break;
            }else if (yesOrNo.equalsIgnoreCase("N")){
                System.out.println("Flight cancellation unsuccessful");
                break;
            }else { //exception to loop again
                System.out.println("Please enter again.");
            }
        }
    }

    // Feature 4: Flight Schedule
    public static void displayFlightSchedule(ArrayList<FlightSchedule> flightSchedulesArr) {
        LocalDate today = LocalDate.now();
        boolean foundFlight = false;

        for (int i=0; i<3; i++){
            LocalDate currentDate = today.plusDays(i);
            System.out.print("\n\nDATE: " + currentDate);
            System.out.print("\nFLIGHT     FROM     TO       TIME       GATE       STATUS");
            System.out.println("\n---------------------------------------------------------------------");

            for (FlightSchedule schedule : flightSchedulesArr) {
                if (schedule.getDateTime().equals(currentDate)) {
                    foundFlight = true;
                    System.out.println(schedule);
                }
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
                        NonMember nm = signUpNonMember(input, userArr);
                        System.out.println(nm.toString());
                        break;
                    case 2:
                        input.nextLine();
                        User user = findUser(input, userArr);
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

    //Feature 6: Exit (Print and save everything to txt file)
    public static void exit(ArrayList <CheckIn> boardingGateArr, ArrayList <CheckIn> checkInArr, ArrayList <Flight> flightArr, ArrayList <User> userArr){
        LocalDateTime dateTime = java.time.LocalDateTime.now();
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String timestamp = dateTime.format(dateTimeFormat);

        java.io.File fileTracker = new java.io.File("latestFile.txt");
        java.io.File boardingGateFile = new java.io.File("BoardingGate_" + timestamp + ".txt");
        java.io.File checkInFile = new java.io.File("CheckIn_" + timestamp + ".txt");
        java.io.File bookingFile = new java.io.File("Booking_" + timestamp + ".txt");
        java.io.File userFile = new java.io.File("User_" + timestamp + ".txt");

        try{
            java.io.PrintWriter output = new java.io.PrintWriter(boardingGateFile);
            output.write("");
            for (CheckIn b:boardingGateArr){
                output.println(b.getFlightNum() + " " + b.getDate() + " " + b.getBoardingGate());
            }
            output.close();
            output = new java.io.PrintWriter(checkInFile);
            output.write("");
            for (int i = 0; i < checkInArr.size(); i ++){
                if (flightArr.get(i).getTripType().equalsIgnoreCase("Round trip")){
                    output.println(checkInArr.get(i).getLastName() + " " + checkInArr.get(i).getBookingNumber() + " " + checkInArr.get(i).isCheckIn()+ " " + checkInArr.get(i).isRoundCheckIn()  + " " + checkInArr.get(i).getBoardingGate() + " " + checkInArr.get(i).getReturnBoardingGate() + " " + checkInArr.get(i).getSeatNumber() + " " + checkInArr.get(i).getReturnSeatNumber());
                }else {
                    output.println(checkInArr.get(i).getLastName() + " " + checkInArr.get(i).getBookingNumber() + " " + checkInArr.get(i).isCheckIn() + " " + checkInArr.get(i).getBoardingGate() + " " + checkInArr.get(i).getSeatNumber());
                }
            }
            output.close();
            output = new java.io.PrintWriter(bookingFile);
            output.write("");
            for (Flight f : flightArr){
                if (f.getTripType().equalsIgnoreCase("Round trip")){
                    output.println(f.getBookingNumber() + " " + f.getTripType() + " " + f.getFlightId().getFlightNum() + " " + f.getReturnFlightId() + " " + f.getFirstName() + " " + f.getLastName()  + " " + f.getDepDate() + " " + f.getReturnDate() + " " + f.getCabinClass() + " " + f.getOptMeals() + " " + f.getOptBaggage() + " " + f.getTotalPaid());
                }else {
                    output.println(f.getBookingNumber() + " " + f.getTripType() + " " + f.getFlightId().getFlightNum() + " " + f.getFirstName() + " " + f.getLastName() + " " + f.getDepDate() + " " + f.getCabinClass() + " " + f.getOptMeals() + " " + f.getOptBaggage() + " " + f.getTotalPaid());
                }
            }
            output.close();
            output = new java.io.PrintWriter(userFile);
            output.write("");
            for (User u : userArr){
                if (u instanceof Member){
                    output.println(u.getFirstName() + " " + u.getLastName() + " " + u.getAge() + " " + u.getUserId() + " " + ((Member) u).getPointsCollected() + " " + ((Member) u).getMemberTier() + " " + ((Member) u).getTotalSpent());
                }else if (u instanceof NonMember) {
                    output.println(u.getFirstName() + " " + u.getLastName() + " " + u.getAge() + " " + u.getUserId() + " " +((NonMember) u).getBookingCount() + " " + ((NonMember)u).isHasPromo());
                }
            }
            output.close();

            output = new java.io.PrintWriter(fileTracker);
            output.write(timestamp);
            output.close();

        }catch (Exception exception){
            System.out.println("File isn't exists");
        }
    }
}
