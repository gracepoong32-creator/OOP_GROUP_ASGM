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

    //Feature 1: Match user id if member/non-member
    public static User matchUser(ArrayList<User> userArr, String inputUserId) {
        for (User u : userArr) {
            if (u.getUserId().equalsIgnoreCase(inputUserId)) {
                return u;
            }
        }
        return null;
    }

    //Find user member id in Arraylist
    public static User findUser(Scanner input, ArrayList <User> userArr){
        input.nextLine();
        User u = null;
        while (true){
            System.out.print("\nEnter member id (Enter '-' to sign up, Enter '?' if you forget your memberId): ");
            String userId = input.nextLine();

            if (userId.equalsIgnoreCase("-")){
                u = signUpNonMember(input, userArr);
                break;
            } else if (userId.equalsIgnoreCase("?")) {
                System.out.print("Enter first name: ");
                String firstName = input.nextLine();
                System.out.print("Enter last name: ");
                String lastName = input.nextLine();
                boolean userCheck = false;
                for (User user: userArr){
                    if (user.getFirstName().equalsIgnoreCase(firstName) && user.getLastName().equalsIgnoreCase(lastName)){
                        System.out.println("Your member id is found: " + user.getUserId());
                        u = user;
                        userCheck = true;
                        break;
                    }
                }
                if (!userCheck){
                    System.out.println("The name you entered is not found. Please try again.");
                }else {
                    break;
                }

            } else{
                u = matchUser(userArr, userId);
                if (u != null){
                    System.out.println("Member id found.");
                    break;
                }else{
                    System.out.println("The member id you entered is not found. Please enter again.");
                }
            }
        }
        return u;
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