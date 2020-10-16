package Task2;

import java.util.regex.Pattern;

public class GroceryCartItem extends GroceryItem {

    float price;
    float quantity;

    public GroceryCartItem(String name, int pricePerKg) {
        super(name, pricePerKg);
    }

    @Override
    public String toString() {
        return String.format(name+" (₹"+pricePerKg+" x "+quantity+"kg) = ₹"+price);
    }

    static float extractQuantity(String quantityStr) {

        quantityStr = quantityStr.replace("kg ", ".")
                .replace("kg","")
                .replace("g","");

        int index = quantityStr.indexOf(".");
        if(index == -1) {
            if(quantityStr.length() < 3)
               quantityStr = ".0"+quantityStr;
            else
                quantityStr = "."+quantityStr;
        }

        return Float.parseFloat(quantityStr);

//        String[] parts = quantityStr.split(" ");
//        parts[0] = parts[0].replace("kg","");
//        parts[1] = parts[1].replace("g","");
//        int kg = Integer.parseInt(parts[0]);
//        float g = Float.parseFloat(parts[1]);
//        float quantity = (float) kg + (g / 1000);
//        return quantity;
    }

    static GroceryCartItem createNew(GroceryItem item, String quantityStr) {
        if(!Pattern.compile("(\\d+kg \\d+g)|(\\d+kg)|(\\d+g)").matcher(quantityStr).matches()) {
            return null;
        }
        GroceryCartItem cartItem = new GroceryCartItem(item.name, item.pricePerKg);
        cartItem.quantity = GroceryCartItem.extractQuantity(quantityStr);
        cartItem.price = item.pricePerKg * cartItem.quantity;
        return  cartItem;
    }

}
