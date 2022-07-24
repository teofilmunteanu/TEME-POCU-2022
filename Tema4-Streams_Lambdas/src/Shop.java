import java.util.List;

public class Shop {
    private String name;
    private String type;
    private int openingYear;
    private List<Product> products;

    public Shop(String name, String type, int openingYear, List products) {
        this.name = name;
        this.type = type;
        this.openingYear = openingYear;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getOpeningYear() {
        return openingYear;
    }

    public List<Product> getProducts() {
        return products;
    }
}
