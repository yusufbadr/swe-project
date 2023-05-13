
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;



public class Interface {
    static Scanner sc = new Scanner(System.in);
    static File usersFile = new File("users.txt");

    static User currentUser;

    public static void Register() throws IOException {
        User newUser = new User();
        // set user attributes
        System.out.println("Please enter your name:");
        String name = sc.next();
        newUser.setName(name);

        System.out.println("Please enter your email:");
        String email = sc.next();
        while (!validEmail(email) || checkEmail(email)) {
            System.out.println("Please enter a valid email:");
            email = sc.next();
        }
        newUser.setEmail(email);

        System.out.println("Please enter your password:");
        String password = sc.next();
        newUser.setPassword(password);
        System.out.println("Please enter your phone number:");
        String phoneNumber = sc.next();
        newUser.setPhoneNumber(phoneNumber);
        //Address(String street, String city, String district, String governorate, String Landmark, String Country)
        System.out.println("Please enter your street:");
        String street = sc.next();
        System.out.println("Please enter your city:");
        String city = sc.next();
        System.out.println("Please enter your district:");
        String district = sc.next();
        System.out.println("Please enter your governorate:");
        String governorate = sc.next();
        System.out.println("Please enter your landmark:");
        String landmark = sc.next();
        System.out.println("Please enter your country:");
        String country = sc.next();
        Address address = new Address(street, city, district, governorate, landmark, country);
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

    public static boolean  Login(String email, String password) throws IOException {
        Scanner sc = new Scanner(usersFile);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(", ");
            if (lineArray[1].equals(email) && lineArray[2].equals(password)) {
                // create new user object
                User newUser = new User();
                // set user attributes
                newUser.setName(lineArray[0]);
                newUser.setEmail(lineArray[1]);
                newUser.setPassword(lineArray[2]);
                newUser.setPhoneNumber(lineArray[3]);
                // create new address object and first get the address attributes
                String street = lineArray[4];
                String city = lineArray[5];
                String district = lineArray[6];
                String governorate = lineArray[7];
                String country = lineArray[8];
                String postalCode = lineArray[9];
                // then create the address object
                Address address = new Address(street, city, district, governorate, country, postalCode);
                // set the address attribute of the user object
                newUser.setAddress(address);
                // set the loyalty points, wallet balance, vouchers, and order history attributes of the user object
                newUser.setLoyaltyPoints(Double.parseDouble(lineArray[10]));
                newUser.setWalletBalance(Double.parseDouble(lineArray[11]));
                LinkedList<Order> orderHistory = new LinkedList<Order>();
                newUser.setOrderHistory(orderHistory);
                currentUser = newUser;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Toffee!");
        System.out.println("Please select an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Please enter your email:");
            String email = sc.next();
            System.out.println("Please enter your password:");
            String password = sc.next();
            try {
                if (Login(email, password)) {
                    System.out.println("Login successful!");

                    // welcome user
                    System.out.println("Welcome " + currentUser.getName() + "!");
                    System.out.println("Please select an option:");
                    System.out.println("1. View products");
                    System.out.println("2. View cart");
                    System.out.println("3. View orders");
                    System.out.println("4. View vouchers");
                    System.out.println("5. View wallet");
                    System.out.println("6. View loyalty points");
                    System.out.println("7. View profile");
                    System.out.println("8. Logout");

                    int choice2 = sc.nextInt();

                    if(choice2 == 1) {
                        Inventory inventory = new Inventory();
                        inventory.viewProducts();
                        // now we need to ask the user to select a product(s) and add it to the cart
                        // user can select multiple products
                        // user can select a product bu entering its index in the list and then entering the quantity
                        // if user enters -1, then we exit the loop

                        System.out.println("Please select a product by entering its index in the list:");
                        int index = sc.nextInt();
                        while(index != -1) {
                            System.out.println("Please enter the quantity:");
                            int quantity = sc.nextInt();
                            Item selcted_item = new Item();
                            // check if index is valid and if quantity is valid
                            while(index < 0 || index >= inventory.getItems().size())
                            {
                                System.out.println("Invalid index!");
                                System.out.println("Please select a product by entering its index in the list:");
                                index = sc.nextInt();
                            }
                            while(quantity < 0 || quantity >= inventory.getItems().get(index).getQuantity())
                            {
                                System.out.println("Invalid quantity!");
                                System.out.println("Please enter the quantity:");
                                quantity = sc.nextInt();
                            }
                            selcted_item = inventory.getItems().get(index);
                            selcted_item.setQuantity(quantity);
                            currentUser.getShoppingCart().addItem(selcted_item);
                            System.out.println("Please select a product by entering its index in the list:");
                            index = sc.nextInt();
                        }
                    }
                } else {
                    System.out.println("Login failed!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            try {
                Register();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (choice == 3) {
            System.out.println("Thank you for using Toffee!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static boolean checkEmail(String email) throws IOException {
        Scanner sc = new Scanner(usersFile);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(", ");
            if (lineArray[1].equals(email)) {
                return true;
            }
        }
        return false;
    }

    // valid email regex function
    public static boolean validEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}



