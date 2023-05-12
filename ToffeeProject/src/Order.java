import java.util.LinkedList;

class Order {
    private double totalPrice;
    //date ----
    private LinkedList<Item> items;
    private Address address;

    private int gainedLoyaltyPoints;
    
    private User.PaymentMethod paymentMethod;
    private User user;
    public double getTotalPrice() {
        return totalPrice;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public Address getAddress() {
        return address;
    }

    public int getGainedLoyaltyPoints() {
        return gainedLoyaltyPoints;
    }

    public User.PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public User getUser() {
        return user;
    }

}
