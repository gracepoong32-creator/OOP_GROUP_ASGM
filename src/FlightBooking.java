public class FlightBooking {
    private String inputTripType;
    private String inputDate;
    private String inputCabinClass;
    private String optMeals;
    private String optBaggage;

    public FlightBooking(){}

    public FlightBooking(String inputTripType, String inputDate, String inputCabinClass, String optBaggage, String optMeals){
        this.inputTripType = inputTripType;
        this.inputDate = inputDate;
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
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
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

    public static void printFlightBooking(String inputTripType, String inputDate, String inputCabinClass){
        System.out.println("Type of trip flight: " + inputTripType + "\nDeparture date: " + inputDate + "\nCabin Class: " + inputCabinClass);
    }
}