
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

// login and register
// login: check if email and password match
// register: create new user, save user to file, login
// exit



public class Interface {
    static Scanner sc = new Scanner(System.in);
    static File usersFile = new File("users.txt");
    public static void Register() throws IOException {
        // create new user object
        User newUser = new User();
        // set user attributes
        System.out.println("Please enter your name:");
        String name = sc.next();
        newUser.setName(name);
        System.out.println("Please enter your email:");
        String email = sc.next();
        newUser.setEmail(email);
        System.out.println("Please enter your password:");
        String password = sc.next();
        newUser.setPassword(password);
        System.out.println("Please enter your phone number:");
        String phoneNumber = sc.next();
        newUser.setPhoneNumber(phoneNumber);
        // create new address object and first get the address attributes
        System.out.println("Please enter your address:");
        System.out.println("Please enter your street:");
        String street = sc.next();
        System.out.println("Please enter your city:");
        String city = sc.next();
        System.out.println("Please enter your state:");
        String state = sc.next();
        System.out.println("Please enter your country:");
        String country = sc.next();
        System.out.println("Please enter your postal code:");
        String postalCode = sc.next();
        // then create the address object
        Address address = new Address(street, city, state, country, postalCode, country);
        // set the address attribute of the user object
        newUser.setAddress(address);
        // set the loyalty points, wallet balance, vouchers, and order history attributes of the user object
        newUser.setLoyaltyPoints(0);
        newUser.setWalletBalance(0);
        newUser.setVouchers(0);
        LinkedList<Order> orderHistory = new LinkedList<Order>();
        newUser.setOrderHistory(orderHistory);
        // save user to file users.txt
        FileWriter fw = new FileWriter(usersFile, true);
        fw.write(newUser.getName() + ", ");
        fw.write(newUser.getEmail() + ", ");
        fw.write(newUser.getPassword() + ", ");
        fw.write(newUser.getPhoneNumber() + ", ");
        fw.write(newUser.getAddress().getStreet() + ", ");
        fw.write(newUser.getAddress().getCity() + ", ");
        fw.write(newUser.getAddress().getDistrict() + ", ");
        fw.write(newUser.getAddress().getGovernorate() + ", ");
        fw.write(newUser.getAddress().getCountry() + ", ");
        fw.write(newUser.getLoyaltyPoints() + ", ");
        fw.write(newUser.getWalletBalance() + ", ");
        fw.write(newUser.getVouchers() + ", ");
        fw.write(newUser.getOrderHistory().toString() + "\n");
        fw.close();
    }

    public static boolean Login(String email, String password) throws IOException {
        Scanner sc = new Scanner(usersFile);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] user = line.split(", ");
            if (user[1].equals(email) && user[2].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Toffee!");
        System.out.println("Please select an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        if (choice == 1)
        {
            System.out.println("Please enter your email:");
            String email = sc.next();
            System.out.println("Please enter your password:");
            String password = sc.next();
            try {
                if (Login(email, password))
                {
                    System.out.println("Login successful!");
                    
                }
                else
                {
                    System.out.println("Login failed!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (choice == 2)
        {
            try {
                Register();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (choice == 3)
        {
            System.out.println("Thank you for using Toffee!");
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid choice!");
        }
    }
}

// login and register
// login: check if email and password match
// register: create new user, save user to file, login
// exit


