package Task2;

import java.util.ArrayList;

public class Cart {

    ArrayList<GroceryCartItem> cartItems;
    float totalAmount;

    public Cart() {
        cartItems = new ArrayList<>();
        totalAmount = 0;
    }

    public Cart add(GroceryCartItem item) {
        cartItems.add(item);
        totalAmount += item.price;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart{\n")
                .append("\tgroceryCartItems = [\n");
        for(int i=0;i<cartItems.size();i++) {
            stringBuilder.append("\t\t"+cartItems.get(i)+",\n");
        }
        stringBuilder.append("\t],")
                .append("\n\ttotalAmount = ₹"+totalAmount+"\n")
                .append("}");
        return stringBuilder.toString();
    }

}
