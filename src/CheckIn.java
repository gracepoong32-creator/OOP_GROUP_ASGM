import java.util.ArrayList;
import java.util.Random;

public class CheckIn {  //find implement user interface
    private boolean checkIn = false;
    private boolean roundCheckIn = false;
    private String boardingGate;
    private String seatNumber;
    private String lastName;
    private int bookingNumber;

    //default constructor
    public CheckIn() {
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

    //Online Boarding Pass
    public String toString(ArrayList<FlightBooking> flightBookingArr, int bookingIndex, ArrayList<CheckIn> checkInArr) {
        String boardingPass = " ";
        if (flightBookingArr.get(bookingIndex).getTripType().equalsIgnoreCase("one-way") || (!checkInArr.get(bookingIndex).isRoundCheckIn())){
            boardingPass = "\n\n-----Boarding Pass-------" +
                    "\nName: " + flightBookingArr.get(bookingIndex).getFirstName() + " " + checkInArr.get(bookingIndex).getLastName() +
                    "\n" + flightBookingArr.get(bookingIndex).getFlightId().getFrom() + "  ------>  " + flightBookingArr.get(bookingIndex).getFlightId().getTo() +
                    "\nDeparture Date: " + flightBookingArr.get(bookingIndex).getDepDate() +
                    "\nCabin Class:  " + flightBookingArr.get(bookingIndex).getCabinClass() +
                    "\nBoarding time: " + flightBookingArr.get(bookingIndex).getFlightId().getDepartureTime() +
                    "\nBoarding Gate: " + checkInArr.get(bookingIndex).getBoardingGate() +
                    "\n\nSeat: " + checkInArr.get(bookingIndex).getSeatNumber();
        }else {
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

public String randomBoardingGate() {
    Random random = new Random();

    int randomNum = random.nextInt(1, 31);
    String[] boardingGateAlphabet = {"J", "K", "L", "P", "Q"};
    int randomBoardingGateAlphabet = random.nextInt(0, 5);
    return boardingGate = randomNum + boardingGateAlphabet[randomBoardingGateAlphabet];
}
}