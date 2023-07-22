package fooddelivery;

public class Food {
    private String name;
    private String description;
    private double price;
    private int id;
    
    public Food(String foodName, String foodDescription, double foodPrice, int foodId){
        this.name = foodName;
        this.description = foodDescription;
        this.price = foodPrice;
        this.id = foodId;
    }
    
    public String getName() {
        return name;
    }
    
//    public void setName(String foodName) {
//        name = foodName;
//    }
    
    public String getDescription() {
        return description;
    }
    
//    public void setDescription(String foodDescription) {
//        description = foodDescription;
//    }
    
    public double getPrice() {
        return price;
    }
    
//    public void setPrice(double foodPrice) {
//        price = foodPrice;
//    }
    
//    public void setId(int foodId) {
//    	id = foodId;
//    }
    public int getId() {
    	return id;
    }
    
}






