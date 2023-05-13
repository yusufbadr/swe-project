import java.util.LinkedList;
public class User {
    enum PaymentMethod {
        VOUCHERS,
        EWALLET,
        COD,
        LOYALTYPOINTSz
    }
    public User(){}

    public User(ShoppingCart shoppingCart, String name, String email, String password, String phoneNumber, Address address, double loyaltyPoints, double walletBalance, double vouchers, LinkedList<Order> orderHistory) {
        this.shoppingCart = shoppingCart;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.loyaltyPoints = loyaltyPoints;
        this.walletBalance = walletBalance;
        this.vouchers = vouchers;
        this.orderHistory = orderHistory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLoyaltyPoints(double loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public void setVouchers(double vouchers) {
        this.vouchers = vouchers;
    }

    public void setOrderHistory(LinkedList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    private ShoppingCart shoppingCart;

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;
    private double loyaltyPoints;
    private double walletBalance;

    // user car
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public double getVouchers() {
        return vouchers;
    }

    public LinkedList<Order> getOrderHistory() {
        return orderHistory;
    }

    private double vouchers;

    // order history
    private LinkedList<Order> orderHistory;

}
