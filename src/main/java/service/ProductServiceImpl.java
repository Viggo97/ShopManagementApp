package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Integer getCountProducts() {
        return products.size();
    }

    @Override
    public Product getProductByProductName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        for (Product product : products) {
            if (isProductExist(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(Long productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return true;
            }
        }
        return false;
    }
}
