import java.util.ArrayList;
import java.util.Random;

public class CheckIn extends FlightBooking{  //find implement user interface
    private boolean checkIn = false;
    private String boardingGate;
    private String seatNumber;

    //default constructor
    public CheckIn(){
    }

    public CheckIn(String lastName, int bookingNumber, boolean checkIn){
        super(lastName, bookingNumber);
        this.checkIn = checkIn;
    }

    public CheckIn(String lastName, int bookingNumber, boolean checkIn, String boardingGate, String seatNumber){
        super(lastName,bookingNumber);
        this.checkIn = checkIn;
        this.boardingGate = boardingGate;
        this.seatNumber = seatNumber;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public String getBoardingGate(){
        return  boardingGate;
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

    //Online Boarding Pass
    public String toString(ArrayList<FlightBooking> flightBookingArr, int bookingIndex, ArrayList<CheckIn> checkInArr) {
        return "\n\n-----Boarding Pass-------" +
                "\nName: " + flightBookingArr.get(bookingIndex).getLastName() +
                "\n" + flightBookingArr.get(bookingIndex).getFlightId().getFrom() + "  ------>  " + flightBookingArr.get(bookingIndex).getFlightId().getTo()+
                "\nDeparture Date: " + flightBookingArr.get(bookingIndex).getDepDate() +
                "\n " +
                "\nBoarding time: " + flightBookingArr.get(bookingIndex).getFlightId().getDepartureTime() +
                "\nBoarding Gate: " + checkInArr.get(bookingIndex).getBoardingGate() +
                "\nSeat: " + checkInArr.get(bookingIndex).getSeatNumber();
    }


    //Random Seat Number
    public String randomSeatNumber(ArrayList<FlightBooking> flightBookingArr, int bookingIndex){
        Random random = new Random();

        if (flightBookingArr.get(bookingIndex).getCabinClass().equalsIgnoreCase("Business")){ //Business class
            int randomNum = random.nextInt(1,5); // Random Row
            String[] seatAlphabet = {"A", "C" , "D", "F"};
            int randomAlphabet = random.nextInt(0,4); //Random Seat A, C, D or F
            seatNumber = randomNum + seatAlphabet[randomAlphabet];
        }else if (flightBookingArr.get(bookingIndex).getCabinClass().equalsIgnoreCase("economy")){  //Economy
            int randomNum = random.nextInt(5,31); // Random Row
            String[] seatAlphabet = {"A", "B","C","D","E","F"};
            int randomAlphabet = random.nextInt(0,6); //Random Seat A,B,C,D,E,F
            seatNumber = randomNum + seatAlphabet[randomAlphabet];
        }
        return seatNumber;
    }

    public String randomBoardingGate(){
        Random random = new Random();

        int randomNum = random.nextInt(1,31);
        String[] boardingGateAlphabet = {"J","K","L","P","Q"};
        int randomBoardingGateAlphabet = random.nextInt(0,5);
        return boardingGate = randomNum + boardingGateAlphabet[randomBoardingGateAlphabet];
    }


}
