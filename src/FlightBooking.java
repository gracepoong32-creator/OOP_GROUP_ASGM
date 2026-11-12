public class FlightBooking {
    private String bookingNumber; //random generated
    private FlightDatabase flightId;
    private String lastName;
    private String tripType;
    private String depDate;
    private String inputCabinClass;
    private String optMeals;
    private String optBaggage;

    public FlightBooking(){}

    public FlightBooking(String tripType, String depDate, String inputCabinClass, String optBaggage, String optMeals){
        this.tripType = tripType;
        this.depDate = depDate;
        this.inputCabinClass = inputCabinClass;
        this.optBaggage = optBaggage;
        this.optMeals = optMeals;
    }

    public String getTripType() {
        return tripType;
    }

    public void setInputTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String inputDate) {
        this.depDate = depDate;
    }

    public String getInputCabinClass() {
        return inputCabinClass;
    }

    public void setInputCabinClass(String inputCabinClass) {
        this.inputCabinClass = inputCabinClass;
    }

    public String getOptBaggage() { return optBaggage;}

    public void setOptBaggage(String optBaggage) { this.optBaggage = optBaggage; }

    public String getOptMeals() { return optMeals; }

    public void setOptMeals(String optMeals) { this.optMeals = optMeals; }

    public static void printFlightBooking(String tripType, String depDate, String inputCabinClass){
        System.out.println("Type of trip flight: " + tripType + "\nDeparture date: " + depDate + "\nCabin Class: " + inputCabinClass);
    }//have to change

    public static void printInvoice(){

    }
}