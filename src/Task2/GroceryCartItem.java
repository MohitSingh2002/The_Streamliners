package Task2;

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
        String[] parts = quantityStr.split(" ");
        parts[0] = parts[0].replace("kg","");
        parts[1] = parts[1].replace("g","");
        int kg = Integer.parseInt(parts[0]);
        float g = Float.parseFloat(parts[1]);
        float quantity = (float) kg + (g / 1000);
        return quantity;
    }

    static GroceryCartItem createNew(GroceryItem item, String quantityStr) {
        GroceryCartItem cartItem = new GroceryCartItem(item.name, item.pricePerKg);
        cartItem.quantity = GroceryCartItem.extractQuantity(quantityStr);
        cartItem.price = item.pricePerKg * cartItem.quantity;
        return  cartItem;
    }

}
