package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static final String fileName = "products.data";
    private static ProductDao instance = null;

    private ProductDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }

        return instance;
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveAllProducts(products);
    }

    @Override
    public void saveAllProducts(List<Product> products) throws IOException {
        FileUtils.createNewFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        for (Product product : products) {
            writer.write(product.toString() + "\n");
        }
        writer.close();
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        products.removeIf(product -> product.getId().equals(productId));
        saveAllProducts(products);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        products.removeIf(product -> product.getProductName().equals(productName));
        saveAllProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String readLine = reader.readLine();

        while(readLine != null) {
            Product product = ProductParser.stringToProduct(readLine);
            if (product != null) {
                products.add(product);
            }
            readLine = reader.readLine();
        }
        reader.close();

        return products;
    }
}
