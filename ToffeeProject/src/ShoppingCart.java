import java.util.LinkedList;

public class ShoppingCart {
    LinkedList<Item> addedItems = new LinkedList<Item>();
    User user;
    double totalSum;
    void addItem(Item item){
        addedItems.addLast(item);
    }
    void viewCart()
    {
        int totalprice = 0;
        // show all stuff in cart and the total sum of price
        for(Item item : addedItems)
        {
            System.out.println(item.getName() + " " + item.getPrice() + " " + item.getQuantity());
            totalprice += item.getPrice() * item.getQuantity();
        }
        System.out.println("Total Price: " + totalprice);
    }
    int GetTotalPrice()
    {
        int totalprice = 0;
        // show all stuff in cart and total price of price
        for(Item item : addedItems)
        {
            totalprice += item.getPrice() * item.getQuantity();
        }
        return totalprice;
    }
    LinkedList<Item> getItems(){
        return addedItems;
    }
    void removeItem(Item item){
        addedItems.remove(item);
    }
    void removeAllItems(){
        if (addedItems.size()>0)
            addedItems.clear();
    }
    void emptyCart(){
        removeAllItems();
    }
    User getUser(){
        return user;
    }
    double getTotalSum(){
        return totalSum;
    }
}
