import java.util.LinkedList;

public class Inventory {
    private LinkedList<Item> items = new LinkedList<Item>();
    public LinkedList<Item> getItems(){
        return items;
    }
    public void setItems(LinkedList<Item> newItems){
        items = newItems;
    }
    public void addItem(Item item){
        items.addLast(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public Item searchItem(String name){
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    public Item searchItem(Item item){
        if (items.contains(item)){
            return item;
        } else {
            return null;
        }
    }
    public void editItem(String name){
        for (Item item : items) {
            if (item.getName().equals(name)) {
                // edit here
                return;
            }
        }
        System.out.println("No such item to edit");
    }
    public void editItem(Item item){
        int index = items.indexOf(item);
        if (index == -1){
            System.out.println("No such item to edit");
            return;
        }
        // edit here
    }

}
