import java.util.ArrayList;
import java.util.Random;

public class CheckIn {  //find implement user interface
    private boolean checkIn = false;
    private boolean roundCheckIn = false;
    private String boardingGate;
    private String seatNumber;
    private String lastName;
    private int bookingNumber;
    private String flightNum;
    private String depDate;

    //default constructor
    public CheckIn() {
    }

    public CheckIn(String flightNum, String depDate, String boardingGate) {
        this.boardingGate = boardingGate;
        this.flightNum = flightNum;
        this.depDate = depDate;
    }

    public CheckIn(String lastName, int bookingNumber, boolean checkIn, String boardingGate, String seatNumber) {
        this.lastName = lastName;
        this.bookingNumber = bookingNumber;
        this.checkIn = checkIn;
        this.boardingGate = boardingGate;
        this.seatNumber = seatNumber;
    }

    public CheckIn(String lastName, int bookingNumber, boolean roundCheckIn, boolean checkIn, String boardingGate, String seatNumber) {
        this.lastName = lastName;
        this.bookingNumber = bookingNumber;
        this.checkIn = checkIn;
        this.roundCheckIn = roundCheckIn;
        this.boardingGate = boardingGate;
        this.seatNumber = seatNumber;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public String getBoardingGate() {
        return boardingGate;
    }

    public void setBoardingGate(String boardingGate) {
        this.boardingGate = boardingGate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isRoundCheckIn() {
        return roundCheckIn;
    }

    public void setRoundCheckIn(boolean roundCheckIn) {
        this.roundCheckIn = roundCheckIn;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    //Online Boarding Pass
    public String toString(ArrayList<FlightBooking> flightBookingArr, int bookingIndex, ArrayList<CheckIn> checkInArr) {
        String boardingPass = " ";
        if (flightBookingArr.get(bookingIndex).getTripType().equalsIgnoreCase("one-way") || (!checkInArr.get(bookingIndex).isRoundCheckIn())) {
            boardingPass = "\n\n-----Boarding Pass-------" +
                    "\nName: " + flightBookingArr.get(bookingIndex).getFirstName() + " " + checkInArr.get(bookingIndex).getLastName() +
                    "\n" + flightBookingArr.get(bookingIndex).getFlightId().getFrom() + "  ------>  " + flightBookingArr.get(bookingIndex).getFlightId().getTo() +
                    "\nDeparture Date: " + flightBookingArr.get(bookingIndex).getDepDate() +
                    "\nCabin Class:  " + flightBookingArr.get(bookingIndex).getCabinClass() +
                    "\nBoarding time: " + flightBookingArr.get(bookingIndex).getFlightId().getDepartureTime() +
                    "\nBoarding Gate: " + checkInArr.get(bookingIndex).getBoardingGate() +
                    "\n\nSeat: " + checkInArr.get(bookingIndex).getSeatNumber();
        } else {
            boardingPass = "\n\n-----Boarding Pass-------" +
                    "\nName: " + flightBookingArr.get(bookingIndex).getFirstName() + " " + checkInArr.get(bookingIndex).getLastName() +
                    "\n" + flightBookingArr.get(bookingIndex).getReturnFlightId().getFrom() + "  ------>  " + flightBookingArr.get(bookingIndex).getReturnFlightId().getTo() +
                    "\nDeparture Date: " + flightBookingArr.get(bookingIndex).getReturnDate() +
                    "\nCabin Class:  " + flightBookingArr.get(bookingIndex).getCabinClass() +
                    "\nBoarding time: " + flightBookingArr.get(bookingIndex).getReturnFlightId().getDepartureTime() +
                    "\nBoarding Gate: " + checkInArr.get(bookingIndex).getBoardingGate() +
                    "\n\nSeat: " + checkInArr.get(bookingIndex).getSeatNumber();
        }

        return boardingPass;
    }


    //Random Seat Number
    public String randomSeatNumber(ArrayList<FlightBooking> flightBookingArr, int bookingIndex) {
        Random random = new Random();

        if (flightBookingArr.get(bookingIndex).getCabinClass().equalsIgnoreCase("Business")) { //Business class
            int randomNum = random.nextInt(1, 5); // Random Row
            String[] seatAlphabet = {"A", "C", "D", "F"};
            int randomAlphabet = random.nextInt(0, 4); //Random Seat A, C, D or F
            seatNumber = randomNum + seatAlphabet[randomAlphabet];
        } else if (flightBookingArr.get(bookingIndex).getCabinClass().equalsIgnoreCase("economy")) {  //Economy
            int randomNum = random.nextInt(5, 31); // Random Row
            String[] seatAlphabet = {"A", "B", "C", "D", "E", "F"};
            int randomAlphabet = random.nextInt(0, 6); //Random Seat A,B,C,D,E,F
            seatNumber = randomNum + seatAlphabet[randomAlphabet];
        }
        return seatNumber;
    }

    //Random Boarding Gate
    public String randomBoardingGate() {
        Random random = new Random();
        int randomNum = random.nextInt(1, 31);
        String[] boardingGateAlphabet = {"J", "K", "L", "P", "Q"};
        int randomBoardingGateAlphabet = random.nextInt(0, 5);
        boardingGate = randomNum + boardingGateAlphabet[randomBoardingGateAlphabet];
        return boardingGate;
    }

    //Check Boarding Gate crash or not
    public String checkBoardingGate(ArrayList<CheckIn> boardingGateArr, String localDate) {

        while (true) {
            //Preset a random Boarding Gate
            boardingGate = randomBoardingGate();

            //Alr have information, maybe crash
            if (!boardingGateArr.isEmpty()) {
                boolean crash = false; //Initial did not crash

                for (int i = 0; i < boardingGateArr.size(); i++) { //Check in the Array
                    if (boardingGateArr.get(i).getBoardingGate() != null && boardingGateArr.get(i).getBoardingGate().equalsIgnoreCase(boardingGate) && boardingGateArr.get(i).getDepDate().equals(localDate)) {
                        crash = true;
                        break;
                    }
                }
                //If did not crash than jump out
                if (!crash) {
                    break;
                }

            //If is empty just jump out of loop
            } else {
                break;
            }
        }

        return boardingGate;
    }

}