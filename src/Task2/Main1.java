package Task2;

import java.util.regex.Pattern;

public class Main1 {

    public static void main(String[] args) {

        GroceryItem apple = new GroceryItem("apple", 20);
        GroceryItem banana = new GroceryItem("banana", 30);
        GroceryItem mango = new GroceryItem("mango", 40);
        GroceryItem orange = new GroceryItem("orange", 50);

        Cart cart = new Cart();
        cart.add(GroceryCartItem.createNew(apple, "2kg"))
                .add(GroceryCartItem.createNew(banana, "75g"))
                .add(GroceryCartItem.createNew(mango, "1kg 150g"))
                .add(GroceryCartItem.createNew(orange, "4kg 750g"))
                .add(GroceryCartItem.createNew(apple, "2kg 0g"));

        System.out.println(cart);

    }

}
