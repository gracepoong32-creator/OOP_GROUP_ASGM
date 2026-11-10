import java.util.ArrayList;

public class FlightDatabase {
    private String flightNum;
    private String airline;
    private String from;
    private String to;
    private String cabinClass;
    private double basePrice;
    private String departureTime;

    //Arraylist to store preset available flights for booking
    ArrayList <FlightDatabase> flightDatabaseArr = new ArrayList<>();

    //Default constructor
    public FlightDatabase(){
        flightDatabaseArr.add(new FlightDatabase("MH101", "Mas Airline", "KUL", "BKI", "Economy", 750.00, "0800"));
        flightDatabaseArr.add(new FlightDatabase("AK512", "AirAsia", "KUL", "SIN", "Business", 380.00, "1200"));
        flightDatabaseArr.add(new FlightDatabase("OD 802", "Batik Air", "KUL", "DPS", "Economy", 563.00, "1730"));
        flightDatabaseArr.add(new FlightDatabase("MH253", "Mas Airline", "KUL", "CAN", "Economy", 16700.00, "0910"));
        flightDatabaseArr.add(new FlightDatabase("AK301", "AirAsia", "KUL", "SGN", "Business", 893.00, "1400"));
    }

    //Parameterized constructor
    public FlightDatabase(String flightNum, String airline, String from, String to, String cabinClass, double basePrice, String departureTime){
        this.flightNum = flightNum;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.cabinClass = cabinClass;
        this.basePrice = basePrice;
        this.departureTime = departureTime;
    }

    //Getter and setters
    public String getFlightNum() { return flightNum; }
    public void setFlightNum(String flightNum) { this.flightNum = flightNum; }

    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public String getCabinClass() { return cabinClass; }
    public void setCabinClass(String cabinClass) { this.cabinClass = cabinClass; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

}
