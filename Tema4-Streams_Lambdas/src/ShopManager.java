import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopManager {
    private static ShopManager instance = null;
    private List<Shop> shops;

    private ShopManager(List<Shop> shops) {
        this.shops = shops;
    }

    public static ShopManager getInstance(List<Shop> shops)
    {
        if (instance == null){
            instance = new ShopManager(shops);
        }

        return instance;
    }

    public void printNamesCapital(){
        shops.stream().map(x->x.getName().toUpperCase()).forEach(y->System.out.println(y));
    }

    public void printShopsAfter2005(){
        shops.stream().filter(x->x.getOpeningYear() > 2005).map(Shop::getName).forEach(x->System.out.println(x));
    }

    public void printProductNames(){
        shops.stream().flatMap(x->x.getProducts().stream()).forEach(x->System.out.println(x.getName()));
    }

    public void printCheapestProduct(){
        Product p = shops.stream().flatMap(x->x.getProducts().stream()).min((p1,p2)-> (int)Math.signum(p1.getPrice()-p2.getPrice())).get();
        System.out.println(p.getName());
    }

    public void printPriceSumTechnologyShops(){
        double total = shops.stream().filter(x->x.getType() == "Technology").flatMap(x->x.getProducts().stream()).mapToDouble(Product::getPrice).sum();
        System.out.println(total);
    }

    public void printConcatenationOfNames(){
        String result = shops.stream().map(Shop::getName).collect(Collectors.joining("|"));
        System.out.println(result);
    }

    public void buildProductsPriceList(){
        List<String> shop_price = shops.stream().flatMap(x->x.getProducts().stream()).map(x-> "Product:" + x.getName() + " Price:" + x.getPrice()).toList();
        System.out.println(shop_price);
    }

}
