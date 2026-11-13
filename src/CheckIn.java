import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class CheckIn extends FlightBooking {  //find implement user interface
    private boolean checkIn = false;
    private String boardingGate;
    private String seatNumber;
    private LocalTime boardingTime;


    public CheckIn(){

    }

    public CheckIn(boolean checkIn, String boardingGate, String seatNumber, int zone){
        this.checkIn = checkIn;
        this.boardingGate = boardingGate;
        this.seatNumber = seatNumber;
        LocalTime boardingTime = LocalTime.now();
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public String getBoardingGate(String boardingGate){
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


    @Override
    public String toString() {
        return "-----Boarding Pass-------" +
                "\nName: " + getLastName() +
                "Boarding time: " + boardingTime +
                "\nBoarding Gate: " + boardingGate +
                "\nSeat: " + seatNumber;
    }

    public String randomSeatNumber(ArrayList<FlightBooking> flightBookingArr, int bookingIndex){
        Random random = new Random();

        if (flightBookingArr.get(bookingIndex).getCabinClass().equalsIgnoreCase("Business")){
            int randomNum = random.nextInt(1,5); // Random Row
            String[] seatAlphabet = {"A", "C" , "D", "F"};
            int randomAlphabet = random.nextInt(0,5); //Random Seat A, C, D or F
            seatNumber = randomNum + seatAlphabet[randomAlphabet];
        }else{
            int randomNum = random.nextInt(5,31); // Random Row
            String[] seatAlphabet = {"A", "B","C","D","E","F"};
            int randomAlphabet = random.nextInt(0,7); //Random Seat A,B,C,D,E,F
            seatNumber = randomNum + seatAlphabet[randomAlphabet];
        }
        return seatNumber;


    }
}
