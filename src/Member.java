public class Member extends User{
    private double pointsCollected;
    private String memberTier;
    private double totalSpent;

    //Default constructor
    public Member(){

    }

    //Parameterized constructor
    public Member(String firstName, String lastName, int age, String userId, double pointsCollected, String memberTier, double totalSpent){
        super(firstName, lastName, age, userId);
        this.pointsCollected = pointsCollected;
        this.memberTier = memberTier;
        this.totalSpent = totalSpent;
    }

    //Getter and setters
    public double getPointsCollected() { return pointsCollected; }
    public void setPointsCollected(double pointsCollected) { this.pointsCollected = pointsCollected; }

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
                + "\nTier status: " + " " + memberTier
                + "\n------------------------------------------"
                + "\nLoyalty points: " + pointsCollected + "pts";
    }

    public double pointsRedeem(){
        return pointsCollected * 0.01;
    }

    public String printUpdatedMember(double totalPaid, double discount){

        double pointsEarned = 0;
        //Points collection different multiplier for different tiers
        if (memberTier.equalsIgnoreCase("Bronze Tier")){
            pointsEarned += totalPaid;
        }
        else if (memberTier.equalsIgnoreCase("Silver Tier")){
            pointsEarned += totalPaid*1.5;
        }
        else if(memberTier.equalsIgnoreCase("Gold Tier")){
            pointsEarned += totalPaid*2;
        }
        else{
            pointsEarned += totalPaid*3;
        }

        //Update points and totalSpent
        this.pointsCollected = (this.pointsCollected - (discount*100)) + pointsEarned;
        this.totalSpent += totalPaid;

        //Auto update member tier
        if (totalSpent >= 10000.00){
            this.memberTier = "Platinum Tier";
        }
        else if (totalSpent >= 5000.00){
            this.memberTier = "Gold Tier";
        }
        else if (totalSpent >= 1500.00){
            this.memberTier = "Silver Tier";
        }
        else {
            this.memberTier = "Bronze Tier";
        }

        return "\nUPDATED MEMBER PROFILE (" + getUserId() + ")"
                + "\nName: " + getFirstName() + " " + getLastName() + "(" + memberTier + ")"
                + "\nPoints \nUsed: -" + (discount*100) + "pts | Earned: +" + pointsEarned + "pts"
                + "\nNew point balance: " + pointsCollected + "pts"
                + "\nTotal spent: RM" + totalSpent
                + "\n==========================================\n\n";
    }
}