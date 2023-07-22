import fooddelivery.*;

public class Main {

    public static void main(String[] args){
        FoodDelivery foodDelivery = new FoodDelivery();
        FoodDeliveryUI ui = new FoodDeliveryUI(foodDelivery);
        ui.start();
    }
}
