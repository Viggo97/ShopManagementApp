public class Product {
    private long id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private float productCount;

    public Product(long id, String productName, float price, float weight, String color, float productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public float getProductCount() {
        return productCount;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductCount(float productCount) {
        this.productCount = productCount;
    }
}
