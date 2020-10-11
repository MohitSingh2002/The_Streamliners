package Task1;

public class Main {

    public static void main(String[] args) {

        Product banana = new Product("Banana", 30);
        Product banana1 = new Product("Banana", 30);
        Product mango = new Product("Mango", 50);

        System.out.println(banana);
        System.out.println(banana1);
        System.out.println(mango);

        System.out.println(banana.equals(banana1));
        System.out.println(banana.equals(mango));

        SpecialProduct orange = SpecialProduct.applyOffOnProduct(mango, 20);
        System.out.println(orange);

    }

}
