import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
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
    public abstract String toString();

    public void findUser(Scanner input, ArrayList <User> userArr){
        input.nextLine();

        System.out.print("Enter member id (- if dont have, ? for forgot): ");
        String userId = input.nextLine();

        if (userId.equalsIgnoreCase("-")){


        } else if (userId.equalsIgnoreCase("?")) {

        } else{

        }
    }

    //Feature 1: Sign up during checkout & Feature 5: Sign up as a user
    public static NonMember signUpNonMember(Scanner input, ArrayList<User> userArr) {
        System.out.print("\n\nNEW NON MEMBER SIGN UP\n------------------------\n");
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        int age = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter age: ");
                age = input.nextInt();
                input.nextLine(); //clears leftover newline from age input

                if (age <= 0) {
                    System.out.println("Invalid input, please enter again");
                } else {
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter again");
                input.nextLine(); //clears leftover newline
            }
        }

        String newUserId = "M" + (101 + userArr.size());
        NonMember nm = new NonMember(firstName, lastName, age, newUserId);
        userArr.add(nm);

        System.out.println("\n------------------------------------------");
        System.out.println("Account created successfully!");
        System.out.println("Your new User Id: " + newUserId);
        System.out.println("==========================================\n");

        return nm;
    }
}