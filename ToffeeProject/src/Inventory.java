import java.io.File;
import java.util.LinkedList;
import java.io.FileWriter;
import java.util.Scanner;

public class Inventory {
    public Inventory(){readFromFile();}
    public Inventory(LinkedList<Item> newItems){
        items = newItems;
    }
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

    public void save(){
        updateFile();
    }
    private void updateFile(){
        try{
            FileWriter inventoryWriter = new FileWriter("inventory.txt");
            for (Item item : items) {
                inventoryWriter.write(item.getName()+"\n");
                inventoryWriter.write(item.getCategory()+"\n");
                inventoryWriter.write(item.getDescription()+"\n");
                inventoryWriter.write(item.getBrand()+"\n");
                inventoryWriter.write(item.getPrice()+"\n");
                inventoryWriter.write(item.getUnitType().name()+"\n");
                inventoryWriter.write(item.getDiscountAmount()+"\n");
                inventoryWriter.write(item.getStatus().name()+"\n");
                inventoryWriter.write(item.getQuantity()+"\n");
            }
            inventoryWriter.close();
        } catch (Exception e){
            System.out.println("Inventory file error!");
        }
    }

    private void readFromFile(){
        try {
            File inventoryReader = new File("inventory.txt");
            if (!inventoryReader.exists()){
                System.out.println("File doesn't exist!");
                return;
            }
            Scanner reader = new Scanner(inventoryReader);
            // each item has 9 consecutive lines in inventory file
            while (reader.hasNextLine()){
                Item newItem = new Item();
                newItem.setName(reader.nextLine());
                newItem.setCategory(reader.nextLine());
                newItem.setDescription(reader.nextLine());
                newItem.setBrand(reader.nextLine());
                newItem.setPrice(Double.parseDouble(reader.nextLine()));
                newItem.setUnitType(Item.UnitType.valueOf(reader.nextLine()));
                newItem.setDiscountAmount(Double.parseDouble(reader.nextLine()));
                newItem.setStatus(Item.ItemStatus.valueOf(reader.nextLine()));
                newItem.setQuantity(Integer.parseInt(reader.nextLine()));
                items.addLast(newItem);
            }
            reader.close();
        }catch (Exception e){
            System.out.println("Error while reading from inventory file");
        }
    }

}
