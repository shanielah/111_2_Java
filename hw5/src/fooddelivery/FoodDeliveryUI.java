package fooddelivery;

import java.util.List;
import java.util.Scanner;

public class FoodDeliveryUI {
	
	private FoodDelivery foodDelivery;

    public FoodDeliveryUI(FoodDelivery foodDelivery) {
        this.foodDelivery = foodDelivery;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        int selectedRestaurantIndex = 0;
        int selectedAction = 0;
        Restaurant selectedRestaurant = null;
        int foodNo = 1;
        boolean isWrong = false;
        boolean invalid_restaurant = false;
        
        // 印出所有餐廳的名稱
        List<Restaurant> restaurants = foodDelivery.getRestaurants();
//        int i = 1;
//        for (Restaurant restaurant : restaurants) {
//            System.out.println(i + ". " + restaurant.getName());
//            i++;
//        }
        //功能
        
        do {
        	if(invalid_restaurant == false) {
            	// 印出所有餐廳的名稱
                int i = 1;
                for (Restaurant restaurant : restaurants) {
                    System.out.println(i + ". " + restaurant.getName());
                    i++;
                }
        	}
            System.out.print("Select Restaurant: ");
            
            // 讓使用者選擇餐廳
            selectedRestaurantIndex = scanner.nextInt();
            
            if (selectedRestaurantIndex == -1) {//結束程式
            	//System.out.println("程式已結束。");
            	System.exit(0);
            }
            selectedRestaurant = foodDelivery.selectRestaurant(selectedRestaurantIndex);
            
            if (selectedRestaurant == null) {
            	System.out.println("請選擇畫面上的餐廳");
            	invalid_restaurant = true;
            } else {
            	invalid_restaurant = false;
            	//印出目前選擇的餐廳和所有選擇
            	System.out.println("("+selectedRestaurant+")" + "1. 新增食物");	//Create Food
            	System.out.println("("+selectedRestaurant+")" + "2. 查看所有食物");//List Foods
            	System.out.println("("+selectedRestaurant+")" + "3. 返回餐廳選擇");//Back to Restaurant Selection
            	
            	do {
            		if (isWrong == false) {
            			System.out.print("請輸入選擇: ");
            		} else {
            			System.out.print("請輸入正確選項: ");
            		}
            		
            		//System.out.print("請輸入選擇: ");
	            	//讓使用者輸入選擇動作
	            	selectedAction = scanner.nextInt();
	            	
	            	switch (selectedAction) {
	            		
		            	case 1:
		            	    System.out.print("請輸入食物名稱: ");
		            	    scanner.nextLine(); // 讀取剩下的換行符
		            	    String foodName = scanner.nextLine();
		            	    System.out.print("請輸入食物描述: ");
		            	    String foodDescription = scanner.nextLine();
		            	    double foodPrice = -1;
		            	    while (foodPrice <= 0) {
		            	        System.out.print("請輸入食物價格: ");
		            	        foodPrice = scanner.nextDouble();
		            	        if (foodPrice <= 0) {
		            	            System.out.println("價錢必須大於零，請重新輸入。");
		            	        }
		            	    }
		            	    selectedRestaurant.addFood(new Food(foodName, foodDescription, foodPrice, foodNo));
		            	    
		            	    foodNo++;
		            	    isWrong = false;
		            	    break;
	            		case 2:
	            			if (selectedRestaurant.getFoods().size() == 0) {
	            				
	            				System.out.printf("%-8s %-16s %-8s %-8s\n", "No.", "Name", "Price", "Description");
	            			} else {
	            			    System.out.printf("%-8s %-16s %-8s %-8s\n", "No.", "Name", "Price", "Description");
	            			    //int foodNo = 1;
	            			    for (Food food : selectedRestaurant.getFoods()) {
	            			        System.out.printf("%-8d %-16s %-8.2f %-8s\n", food.getId(), food.getName(), food.getPrice(), food.getDescription());
	            			        //No++;
	            			    }
	            			}
	            			isWrong = false;
	            			break;
	            		case 3:
	            			//selectedRestaurant = null;
	            			isWrong = false;
	            			break;
	            			
	            		default:
	            			//System.out.print("請輸入正確選項: ");
	    	            	//讓使用者輸入選擇動作
	            			
	            			//selectedAction = scanner.nextInt();
	            			isWrong = true;	    	            	
	            			break;
	            		
	            		}
	            	
            		}while(selectedAction != 3);
            	
            	selectedRestaurant = null;
            }  
     
        } while (true);
        
    }

    
}
