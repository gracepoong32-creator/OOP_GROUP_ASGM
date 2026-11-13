public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String userId;

    //Default constructor
    public User(){

    }

    //Parameterized constructor
    public User(String firstName, String lastName, int age, String userId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userId = userId;
    }

    //Getter and Setter
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    @Override
    public String toString(){
        return "";
    }
}
