public class FlightBooking {
    private String bookingNumber; //random generated
    private String flight;
    private String lastName;
    private String inputTripType;
    private String inputDepDate;
    private String inputCabinClass;
    private String optMeals;
    private String optBaggage;

    public FlightBooking(){}

    public FlightBooking(String inputTripType, String inputDate, String inputCabinClass, String optBaggage, String optMeals){
        this.inputTripType = inputTripType;
        this.inputDepDate = inputDate;
        this.inputCabinClass = inputCabinClass;
        this.optBaggage = optBaggage;
        this.optMeals = optMeals;
    }

    public String getInputTripType() {
        return inputTripType;
    }

    public void setInputTripType(String inputTripType) {
        this.inputTripType = inputTripType;
    }

    public String getInputDate() {
        return inputDepDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDepDate = inputDepDate;
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

    public static void printFlightBooking(String inputTripType, String inputDepDate, String inputCabinClass){
        System.out.println("Type of trip flight: " + inputTripType + "\nDeparture date: " + inputDepDate + "\nCabin Class: " + inputCabinClass);
    }//have to change

    public static void printInvoice(){

    }
}