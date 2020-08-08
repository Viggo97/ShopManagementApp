package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {
    public static Product stringToProduct(String productStr, String productType) {
        if (productType.equals("PRODUCT")) {
            return convertToProduct(productStr);
        }
        else if (productType.equals("CLOTH")) {
            return convertToCloth(productStr);
        }
        else if (productType.equals("BOOTS")) {
            return convertToBoots(productStr);
        }
        return null;
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[0]);
        String productName = productInformation[1];
        Float price = Float.parseFloat(productInformation[2]);
        Float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        Integer productCount = Integer.parseInt(productInformation[5]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Product convertToCloth(String productStr) {
        String[] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[0]);
        String productName = productInformation[1];
        Float price = Float.parseFloat(productInformation[2]);
        Float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        Integer productCount = Integer.parseInt(productInformation[5]);
        String size = productInformation[6];
        String material = productInformation[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToBoots(String productStr) {
        String[] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[0]);
        String productName = productInformation[1];
        Float price = Float.parseFloat(productInformation[2]);
        Float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        Integer productCount = Integer.parseInt(productInformation[5]);
        Integer size = Integer.parseInt(productInformation[6]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInformation[7]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }
}
