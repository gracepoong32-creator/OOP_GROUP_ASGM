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
}
