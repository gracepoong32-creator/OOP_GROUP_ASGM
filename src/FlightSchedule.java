
import java.time.LocalDate;

public class FlightSchedule {
    private FlightDatabase flight;
    private LocalDate dateTime;
    private String gate;
    private String status;

    // Constructor
    public FlightSchedule(FlightDatabase flight, LocalDate dateTime, String gate, String status) {
        this.flight = flight;
        this.dateTime = dateTime;
        this.gate = gate;
        this.status = status;
    }

    // Getter
    public FlightDatabase getFlight() {
        return flight;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public String getGate() {
        return gate;
    }

    public String getStatus() {
        return status;
    }

    // Setter
    public void setFlight(FlightDatabase flight) {
        this.flight = flight;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
