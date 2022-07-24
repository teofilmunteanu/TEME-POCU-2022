import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product prod1 = new Product(1, "Monitor", 1000);
        Product prod2 = new Product(2, "Laptop", 3000);
        Product prod3 = new Product(3, "Keyboard", 400);
        Shop shop1 = new Shop("TechS", "Technology", 2006, Arrays.asList(prod1,prod2,prod3));

        Product prod4 = new Product(4, "DesktopPC", 4000);
        Product prod5 = new Product(5, "Printer", 300);
        Product prod6 = new Product(6, "Keyboard", 500);
        Shop shop2 = new Shop("Tecc", "Technology", 2003, Arrays.asList(prod4,prod5,prod6));

        Product prod7 = new Product(7, "Pretzel", 2);
        Product prod8 = new Product(8, "Donut", 1.9);
        Product prod9 = new Product(9, "Pie", 3.5);
        Shop shop3 = new Shop("Ittenrof", "Bakery", 2015, Arrays.asList(prod7,prod8,prod9));

        List<Shop> shops = Arrays.asList(shop1, shop2, shop3);
        ShopManager manager = ShopManager.getInstance(shops);

        manager.printNamesCapital();
        System.out.println();
        manager.printShopsAfter2005();
        System.out.println();
        manager.printProductNames();
        System.out.println();
        manager.printCheapestProduct();
        System.out.println();
        manager.printPriceSumTechnologyShops();
        System.out.println();
        manager.printConcatenationOfNames();
        System.out.println();
        manager.buildProductsPriceList();
        System.out.println();
    }
}