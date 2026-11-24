import java.time.LocalDateTime;
public class FlightSchedule {
    private FlightDatabase flight;
    private LocalDateTime dateTime;
    private String gate;
    private String status;

    public FlightSchedule(FlightDatabase flight,LocalDateTime dateTime,String gate,String status){
        this.flight = flight;
        this.dateTime = dateTime;
        this.gate = gate;
        this.status = status;
    }

    public FlightDatabase getFlight() {
        return flight;
    }

    public void setFlight(FlightDatabase flight) {
        this.flight = flight;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}