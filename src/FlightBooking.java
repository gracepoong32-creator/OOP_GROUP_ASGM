public class FlightBooking {
    private String bookingNumber; //random generated
    private FlightDatabase flightId; //from flightDatabase
    private String lastName;
    private String tripType;
    private String depDate;
    private String returnDate;
    private String cabinClass;
    private String optMeals;
    private String optBaggage;

    public FlightBooking(){

    }

    //Parameterized constructor for one-way
    public FlightBooking(String bookingNumber, FlightDatabase flightId, String tripType, String depDate, String cabinClass, String optMeals, String optBaggage){
        this.bookingNumber = bookingNumber;
        this.flightId = flightId;
        this.tripType = tripType;
        this.depDate = depDate;
        this.cabinClass = cabinClass;
        this.optMeals = optMeals;
        this.optBaggage = optBaggage;
    }

    //Parameterized constructor for round trip
    public FlightBooking(String bookingNumber, FlightDatabase flightId, String lastName, String tripType, String depDate, String returnDate, String cabinClass, String optMeals, String optBaggage){this.bookingNumber = bookingNumber;
        this.flightId = flightId;
        this.lastName = lastName;
        this.tripType = tripType;
        this.depDate = depDate;
        this.returnDate = returnDate;
        this.cabinClass = cabinClass;
        this.optMeals = optMeals;
        this.optBaggage = optBaggage;
    }

    //Getter and Setters
    public String getBookingNumber() { return bookingNumber; }
    public void setBookingNumber(String bookingNumber) { this.bookingNumber = bookingNumber; }

    public FlightDatabase getFlightId(){ return flightId; }
    public void setFlightId(FlightDatabase flightId) { this.flightId = flightId; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getTripType() { return tripType; }
    public void setTripType(String tripType) { this.tripType = tripType; }

    public String getDepDate() { return depDate; }
    public void setDepDate(String depDate) { this.depDate = depDate; }

    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }

    public String getCabinClass() { return cabinClass; }
    public void setCabinClass(String cabinClass) { this.cabinClass = cabinClass; }

    public String getOptMeals() { return optMeals; }
    public void setOptMeals(String optMeals) { this.optMeals = optMeals; }

    public String getOptBaggage() { return optBaggage; }
    public void setOptBaggage(String optBaggage) { this.optBaggage = optBaggage; }

    public static void printFlightBooking(){
        System.out.println("Type of trip flight: ");
    }//have to change

    public static void printInvoice(){

    }
}