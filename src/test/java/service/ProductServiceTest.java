package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));
        products.add(new Cloth(654L, "T-shirt", 59.79f, 0.3f, "white", 10, "M", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> listFromTestClass = productService.getAllProducts();

        Assert.assertEquals(products, listFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));
        products.add(new Cloth(654L, "T-shirt", 59.79f, 0.3f, "white", 10, "M", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        products.add(new Cloth(912L, "Dress", 129.19f, 0.4f, "red", 3, "S", "Cotton"));
        List<Product> listFromTestClass = productService.getAllProducts();

        Assert.assertNotEquals(products, listFromTestClass);
    }

    @Test
    public void testGetCountWithProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));
        products.add(new Cloth(654L, "T-shirt", 59.79f, 0.3f, "white", 10, "M", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetCountWithoutProducts() {
        ProductServiceImpl productService = new ProductServiceImpl();

        final int result = productService.getCountProducts();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByNameWhenExist() {
        List<Product> products = new ArrayList<>();
        Product boots = new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true);
        products.add(boots);
        products.add(new Cloth(654L, "T-shirt", 59.79f, 0.3f, "white", 10, "M", "Cotton"));
        products.add(new Cloth(912L, "Dress", 129.19f, 0.4f, "red", 3, "S", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("Nike");

        Assert.assertEquals(boots, product);
    }

    @Test
    public void testGetProductByNameWhenNoExist() {
        List<Product> products = new ArrayList<>();
        Product boots = new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true);
        products.add(boots);
        products.add(new Cloth(654L, "T-shirt", 59.79f, 0.3f, "white", 10, "M", "Cotton"));
        products.add(new Cloth(912L, "Dress", 129.19f, 0.4f, "red", 3, "S", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("Non-existent product");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWarehouseWhenIs() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWarehouse = productService.isProductOnWarehouse("Nike");

        Assert.assertTrue(isProductOnWarehouse);
    }

    @Test
    public void testIsProductOnWarehouseWhenIsNot() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWarehouse = productService.isProductOnWarehouse("Dress");

        Assert.assertFalse(isProductOnWarehouse);
    }

    @Test
    public void testIsProductExistByNameWhenExist() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Nike");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Non-existent product");

        Assert.assertFalse(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenExist() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(123L);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenNoExist() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(123L, "Nike", 199.99f, 0.4f, "blue", 5, 42, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(555L);

        Assert.assertFalse(isProductExist);
    }


}
