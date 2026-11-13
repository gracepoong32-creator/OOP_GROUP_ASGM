public class FlightBooking {
    private int bookingNumber; //random generated
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
    public FlightBooking(int bookingNumber, String lastName, FlightDatabase flightId, String tripType, String depDate, String cabinClass, String optMeals, String optBaggage){
        this.bookingNumber = bookingNumber;
        this.flightId = flightId;
        this.lastName = lastName;
        this.tripType = tripType;
        this.depDate = depDate;
        this.cabinClass = cabinClass;
        this.optMeals = optMeals;
        this.optBaggage = optBaggage;
    }

    //Parameterized constructor for round trip
    public FlightBooking(int bookingNumber, FlightDatabase flightId, String lastName, String tripType, String depDate, String returnDate, String cabinClass, String optMeals, String optBaggage){
        this.bookingNumber = bookingNumber;
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
    public int getBookingNumber() { return bookingNumber; }
    public void setBookingNumber(int bookingNumber) { this.bookingNumber = bookingNumber; }

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

    @Override
    public String toString(){
        return "\n==========================================\n             CHECKOUT SUMMARY       \n=========================================="
                + "\nBooking reference: " + bookingNumber + "\nPassenger last name: " + lastName
                + "\n------------------------------------------" + "\nFLIGHT DETAILS"
                + "\nFlight Id: " + getFlightId().getFlightNum() + "\nRoute: " + getFlightId().getFrom() + " -> " + getFlightId().getTo()
                + "\nDeparture: " + depDate + " at " + getFlightId().getDepartureTime()
                + "\nTrip type: " + tripType + "\nCabin class: " + cabinClass
                + "\n------------------------------------------" + "\nPRICE BREAKDOWN"
                + "\nBase fare: RM" + flightId.getBasePrice() + "\nAdd-ons: \nBaggage: RM" + getBaggage()
                + "\nMeal: RM" + getMeal() + "\n------------------------------------------"
                + "\nTotal: " + calcTotalFare() + "\n==========================================\nContinue to payment >>>";
    }

    public double calcTotalFare(){
        double basePrice = getFlightId().getBasePrice();
        if(tripType.equalsIgnoreCase("round trip")){
            basePrice *= 2;
        }
        return basePrice + getMeal() + getBaggage();
    }

    public double getBaggage(){
        if (getOptBaggage().equalsIgnoreCase("Y")){
            return 50.0;
        }
        else{
            return 0.0;
        }
    }

    public double getMeal(){
        if(getOptMeals().equalsIgnoreCase("Y")){
            return 20.0;
        }
        else{
            return 0.0;
        }
    }


}