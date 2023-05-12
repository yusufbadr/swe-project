
public class Item {
    enum ItemStatus{
        ONSALE,
        OUTOFSTOCK,
        NOTONSALE
    }
    enum UnitType{
        SEALED,
        LOOSE
    }
    private String name;
    private String category;
    private String description;
    private String brand;
    private double price;
    private UnitType unitType;
    private double discountAmount;
    private ItemStatus status;
    private int quantity;

//    public Item(){
//        this.name = "NULL";
//    }

    public Item(){}
    public Item(String name, String category, String description, String brand, double price, UnitType unitType,
                double discountAmount, ItemStatus status, int quantity) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.unitType = unitType;
        this.discountAmount = discountAmount;
        this.status = status;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // TO DO
    // string could be category or name
    public boolean applyDiscount(String category){
        return true;
    }

    public boolean applyDiscountToAll(){
        return true;
    }

}
