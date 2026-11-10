public class FlightBooking {
    private String inputTripType;
    private String inputDate;
    private String inputCabinClass;

    FlightBooking(){

    }

    FlightBooking(String inputTripType, String inputDate, String inputCabinClass){
        this.inputTripType = inputTripType;
        this.inputDate = inputDate;
        this.inputCabinClass = inputCabinClass;
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

    public static void printFlightBooking(String inputTripType, String inputDate, String inputCabinClass){
        System.out.println("Type of trip flight: " + inputTripType + "\nDeparture date: " + inputDate + "\nCabin Class: " + inputCabinClass);
    }
}
