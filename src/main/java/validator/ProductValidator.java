package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

public class ProductValidator {
    private static ProductValidator instance = null;

    private ProductValidator() {
    }

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException,
            ProductWeightNoPositiveException, ProductNameEmptyException {

        if(isPriceNoPositive(product.getPrice()))
            throw new ProductPriceNoPositiveException("Product price is no positive.");

        if(isCountNegative(product.getProductCount()))
            throw new ProductCountNegativeException("Product count is less than 0.");

        if (isWeightNoPositive(product.getWeight()))
            throw new ProductWeightNoPositiveException("Product weight is less or equals 0.");

        if(isNameEmpty(product.getProductName()))
            throw new ProductNameEmptyException("Product name cannot be empty.");

        return true;
    }

    private boolean isPriceNoPositive(Float productPrice) {
        return productPrice <=0;
    }

    private boolean isCountNegative(Integer productCount) {
        return  productCount < 0;
    }

    private boolean isWeightNoPositive(Float productWeight) {
        return productWeight <= 0;
    }

    private boolean isNameEmpty(String productName) {
        return productName.length() == 0;
    }
}
