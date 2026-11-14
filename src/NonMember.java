public class NonMember extends User {
    private int bookingCount;
    private boolean hasPromo;
    private final double newUserPromo = 0.1;

    //Default constructor
    public NonMember(){

    }

    //Parameterized constructor
    public NonMember(String firstName, String lastName, int age, String userId, int bookingCount, boolean hasPromo){
        super(firstName, lastName, age, userId);
        this.bookingCount = bookingCount;
        this.hasPromo = hasPromo;
    }

    //Getter and Setters
    public int getBookingCount() { return bookingCount; }
    public void setBookingCount(int bookingCount) { this.bookingCount = bookingCount; }

    public boolean isHasPromo() { return hasPromo; }
    public void setHasPromo(boolean hasPromo) { this.hasPromo = hasPromo; }

    public String toString(){
        return "\n\n\n==========================================\n"
                +"           NON MEMBER DETAILS         \n"
                +"=========================================="
                + "\nUser Id: " + super.getUserId()
                + "\nFull name: " + super.getFirstName() + " " + super.getLastName();
    }
}
