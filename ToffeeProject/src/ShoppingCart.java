import java.util.LinkedList;

public class ShoppingCart {
    private LinkedList<Item> addedItems;
    User user;
    double totalSum;
    void addItem(Item item){
        addedItems.addLast(item);
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
