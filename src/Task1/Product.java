package Task1;

import java.util.Objects;

public class Product {

    String name;
    int price;

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Name : %s @ Rs.%d",this.name, this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(name, product.name);
    }

}
