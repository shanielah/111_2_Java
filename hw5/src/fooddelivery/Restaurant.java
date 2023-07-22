package fooddelivery;

import java.util.List;
import java.util.ArrayList;

public class Restaurant {
	
    private String name;
    private List<Food> foods;

    public Restaurant(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
        
    }

    public String getName() {
        return name;
    }
    
    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public String toString() {
    	return name;
    }

}
