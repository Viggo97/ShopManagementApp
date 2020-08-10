package entity;

import entity.enums.Color;
import entity.enums.ProductSeparators;

public class Product {
    private Long id;
    private String productName;
    private Float price;
    private Float weight;
    private Color color;
    private Integer productCount;

    public Product(Long id, String productName, Float price, Float weight, Color color, Integer productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Float getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getBasicProductString() {
        return  id + ProductSeparators.PRODUCT_SEPARATOR.toString() + productName +
                ProductSeparators.PRODUCT_SEPARATOR.toString() +  price +
                ProductSeparators.PRODUCT_SEPARATOR.toString() + weight +
                ProductSeparators.PRODUCT_SEPARATOR.toString() + color +
                ProductSeparators.PRODUCT_SEPARATOR.toString() + productCount;
    }

    @Override
    public String toString() {
        return  ProductSeparators.PRODUCT_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString();
    }
}