public class Member extends User{
    private int pointsCollected;
    private String memberTier;
    private double totalSpent;

    //Default constructor
    public Member(){

    }

    //Parameterized constructor
    public Member(String firstName, String lastName, int age, String userId, int pointsCollected, String memberTier, double totalSpent){
        super(firstName, lastName, age, userId);
        this.pointsCollected = pointsCollected;
        this.memberTier = memberTier;
        this.totalSpent = totalSpent;
    }

    //Getter and setters
    public int getPointsCollected() { return pointsCollected; }
    public void setPointsCollected(int pointsCollected) { this.pointsCollected = pointsCollected; }

    public String getMemberTier() { return memberTier; }
    public void setMemberTier(String memberTier) { this.memberTier = memberTier; }

    public double getTotalSpent() { return totalSpent; }
    public void setTotalSpent(double totalSpent) { this.totalSpent = totalSpent; }

    //Method to print out all member details
    public String toString(){
        return "\n\n\n==========================================\n"
                +"           LOYALTY MEMBER DETAILS         \n"
                +"=========================================="
                + "\nUser Id: " + super.getUserId()
                + "\nFull name: " + super.getFirstName() + " " + super.getLastName()
                + "\nTier status: " + memberTier
                + "\n------------------------------------------"
                + "\nLoyalty points: " + pointsCollected + "pts";
    }

    public double pointsRedeem(){
        return pointsCollected * 0.01;
    }

    public double pointsEarned(){

    }

    public double newPointBalance(){

    }

    public double newTotalSpend(){

    }

    public String printUpdatedMember(){
        return "\nUPDATED MEMBER PROFILE (" + getUserId() + ")"
                + "\nName: " + getFirstName() + " " + getLastName() + "(" + memberTier + ")"
                + "\nPoints \nUsed: -RM" + pointsRedeem() + "Earned: +RM" + "pointsEarned"
                + "\nNew point balance: " + "pointsCollected-redeem+earned" + "pts"
                + "\nTotal spent: RM" + "totalSpend+ newTotalSpent"
                + "\n==========================================";
    }
}