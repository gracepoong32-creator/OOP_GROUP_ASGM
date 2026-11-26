public class Flight {
    private int bookingNumber; //random generated
    private FlightDatabase flightId; //from flightDatabase
    private FlightDatabase returnFlightId;
    private String firstName;
    private String lastName;
    private String tripType;
    private String depDate;
    private String returnDate;
    private String cabinClass;
    private String optMeals;
    private String optBaggage;
    private double totalPaid;

    public Flight(){
    }

    //Parameterized constructor for one-way
    public Flight(int bookingNumber, String tripType,FlightDatabase flightId,  String firstName, String lastName,  String depDate, String cabinClass, String optMeals, String optBaggage, double totalPaid){
        this.bookingNumber = bookingNumber;
        this.flightId = flightId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tripType = tripType;
        this.depDate = depDate;
        this.cabinClass = cabinClass;
        this.optMeals = optMeals;
        this.optBaggage = optBaggage;
        this.totalPaid = totalPaid;
    }

    //Parameterized constructor for round trip
    public Flight(int bookingNumber, String tripType, FlightDatabase flightId, FlightDatabase returnFlightId, String firstName , String lastName, String depDate, String returnDate, String cabinClass, String optMeals, String optBaggage, double totalPaid){
        this.bookingNumber = bookingNumber;
        this.flightId = flightId;
        this.returnFlightId = returnFlightId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tripType = tripType;
        this.depDate = depDate;
        this.returnDate = returnDate;
        this.cabinClass = cabinClass;
        this.optMeals = optMeals;
        this.optBaggage = optBaggage;
        this.totalPaid = totalPaid;
    }

    //Getter and Setters
    public int getBookingNumber() { return bookingNumber; }
    public void setBookingNumber(int bookingNumber) { this.bookingNumber = bookingNumber; }

    public FlightDatabase getFlightId(){ return flightId; }
    public void setFlightId(FlightDatabase flightId) { this.flightId = flightId; }

    public FlightDatabase getReturnFlightId() { return returnFlightId; }
    public void setReturnFlightId(FlightDatabase returnFlightId) { this.returnFlightId = returnFlightId; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getTripType() { return tripType; }
    public void setTripType(String tripType) { this.tripType = tripType; }

    public String getDepDate() { return depDate; }
    public void setDepDate(String depDate) { this.depDate = depDate; }

    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }

    public String getCabinClass() {
        return cabinClass;
    }
    public void setCabinClass(String cabinClass) { this.cabinClass = cabinClass; }

    public String getOptMeals() { return optMeals; }
    public void setOptMeals(String optMeals) { this.optMeals = optMeals; }

    public String getOptBaggage() { return optBaggage; }
    public void setOptBaggage(String optBaggage) { this.optBaggage = optBaggage; }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    @Override
    public String toString(){
        double basePrice = flightId.getBasePrice();
        String roundTripLine = "";

        if (tripType.equalsIgnoreCase("round trip")){
            basePrice += returnFlightId.getBasePrice();
            roundTripLine = "\n------------------------------------------"
                    + "\nReturn Flight Id: " + getReturnFlightId().getFlightNum()
                    + "\nRoute: " + getReturnFlightId().getFrom() + " -> " + getReturnFlightId().getTo()
                    + "\nReturn: " + returnDate + " at " + getReturnFlightId().getDepartureTime();
        }

        return "\n==========================================\n             CHECKOUT SUMMARY       \n=========================================="
                + "\nFLIGHT DETAILS"
                + "\nDeparture Flight Id: " + getFlightId().getFlightNum() + "\nRoute: " + getFlightId().getFrom() + " -> " + getFlightId().getTo()
                + "\nDeparture: " + depDate + " at " + getFlightId().getDepartureTime()
                + roundTripLine
                + "\nTrip type: " + tripType + "\nCabin class: " + cabinClass
                + "\n------------------------------------------" + "\nPRICE BREAKDOWN"
                + "\nBase fare: RM" + String.format("%.2f", basePrice) + "\nAdd-ons \nBaggage: RM" + String.format("%.2f", getBaggage())
                + "\nMeal: RM" + String.format("%.2f", getMeal()) + "\n------------------------------------------"
                + "\nTotal: RM" + String.format("%.2f", calcTotalFare()) + "\n==========================================\nContinue to payment >>>";
    }

    public double calcTotalFare(){ //Calculate total price before minus points
        double basePrice = getFlightId().getBasePrice();
        if(tripType.equalsIgnoreCase("round trip")){
            basePrice += getReturnFlightId().getBasePrice();
        }
        return basePrice + getMeal() + getBaggage();
    }

    public double getBaggage(){
        if (getOptBaggage().equalsIgnoreCase("Y")){
            return 50.0;
        } else{
            return 0.0;
        }
    }

    public double getMeal(){
        if(getOptMeals().equalsIgnoreCase("Y")){
            return 20.0;
        } else{
            return 0.0;
        }
    }

    public String printPreCheckoutMember(double discount, double pointsCollected){
        return "\n\n------------------------------------------\n"
                + "UPDATED PAYMENT SUMMARY\n"
                + "Subtotal: RM" + String.format("%.2f", calcTotalFare())
                + "\nPoints redeemed (" + pointsCollected + "): - RM" + String.format("%.2f", discount)
                + "\n------------------------------------------"
                + "\nTotal to pay: RM" + String.format("%.2f", (calcTotalFare()-discount))
                + "\n=========================================="
                + "\nContinue to payment >>>\n";
    }

    public String printPreCheckoutNonMember(boolean usePromo){
        String promoLine = "";
        double promoTotal = calcTotalFare();

        if (usePromo){
            promoLine = "\nOne-time user promo: 10%";
            promoTotal = calcTotalFare()*0.9;
        }

        return "\n\n------------------------------------------\n"
                + "UPDATED PAYMENT SUMMARY\n"
                + "Subtotal: RM" + String.format("%.2f", calcTotalFare())
                + promoLine
                + "\n------------------------------------------"
                + "\nTotal to pay: RM" + String.format("%.2f", promoTotal)
                + "\n=========================================="
                + "\nContinue to payment >>>";
    }


    public double checkoutMember(double discount){
        return (calcTotalFare()-discount);
    }

    public double checkoutNonMember(boolean usePromo){
        double totalPayment = calcTotalFare();
        if (usePromo){
            totalPayment = calcTotalFare()*0.9;
        }
        return totalPayment;
    }

    public String printPayment(double totalPayment){
        return "\n\n\n==========================================\n"
                +"            PAYMENT SUCCESSFUL!!            \n"
                +"=========================================="
                + "\nBooking reference: " + bookingNumber
                + "\nAmount paid: RM" + String.format("%.2f", totalPayment)
                + "\n------------------------------------------";
    }
}