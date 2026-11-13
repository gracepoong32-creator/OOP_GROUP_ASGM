public class User {
    private String firstName;
    private String lastName;
    private int age;
    private double totalSpent;

    //Default constructor
    public User(){

    }

    //Parameterized constructor
    public User(String firstName, String lastName, int age, double totalSpent){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.totalSpent = totalSpent;
    }

    //Getter and Setter
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getTotalSpent() { return totalSpent; }
    public void setTotalSpent(double totalSpent) { this.totalSpent = totalSpent; }
}
