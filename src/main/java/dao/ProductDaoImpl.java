package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final String fileName;
    private final String productType;

    public ProductDaoImpl(String fileName, String productType)  throws IOException{
        this.fileName = fileName;
        this.productType = productType;
        FileUtils.createNewFile(fileName);
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
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                products.remove(i);
            }
        }
        saveAllProducts(products);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(productName)) {
                products.remove(i);
            }
        }
        saveAllProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String readLine = reader.readLine();

        while(readLine != null) {
            Product product = ProductParser.stringToProduct(readLine, productType);
            if (product != null) {
                products.add(product);
            }
            readLine = reader.readLine();
        }
        reader.close();

        return products;
    }

    @Override
    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
