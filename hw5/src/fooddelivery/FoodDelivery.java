package fooddelivery;

import java.util.ArrayList;
import java.util.List;

public class FoodDelivery {
	
	private int restaurantIndex;
    private List<Restaurant> restaurants;

    public FoodDelivery() {
        this.restaurantIndex = 0;
        this.restaurants = new ArrayList<Restaurant>();
        
        // 新增預設的三間餐廳
        restaurants.add(new Restaurant("Starbucks"));
        restaurants.add(new Restaurant("Mcdonald's"));
        restaurants.add(new Restaurant("KFC"));
    }

    public List<Restaurant> getRestaurants() {
    return this.restaurants;
    }
    
    public Restaurant selectRestaurant(int selectedrestaurantIndex) {
        List<Restaurant> restaurants = getRestaurants();

        if (selectedrestaurantIndex >= 1 && selectedrestaurantIndex <= restaurants.size()) {
            Restaurant selectedRestaurant = restaurants.get(selectedrestaurantIndex - 1);
            this.restaurantIndex = selectedrestaurantIndex;// 儲存目前在哪個餐廳
            return selectedRestaurant;
            
        } else {
        	return null;
        }
    }

    
}
