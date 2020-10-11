package Task1;

public class SpecialProduct extends Product {

    int regularPrice, percentageOff;

    public SpecialProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return String.format("Regular Price : %d, Percentage Off : %d", this.regularPrice, this.percentageOff);
    }

    static SpecialProduct applyOffOnProduct(Product product, int percentageOff) {
        percentageOff = product.price - (percentageOff * product.price) / 100;
        int discountedPrice = percentageOff;
        SpecialProduct specialProduct = new SpecialProduct(product.name, discountedPrice);
        specialProduct.regularPrice = product.price;
        specialProduct.percentageOff = percentageOff;
        return specialProduct;
    }

}
