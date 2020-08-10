package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductDao {

    void saveProduct(Product product) throws IOException;
    void saveAllProducts(List<Product> products) throws IOException;

    void removeProductById(Long productId) throws IOException;
    void removeProductByName(String productName) throws IOException;

    List<Product> getAllProducts() throws IOException;
}
