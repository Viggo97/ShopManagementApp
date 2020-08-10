package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.*;

import static entity.parser.ColorParser.parseStrToColor;
import static entity.parser.MaterialParser.parseStrToMaterial;

public class ProductParser {
    public static Product stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getIdByChar(productStr.substring(0,1));

        switch (productType) {
            case PRODUCT_ID :
                return convertToProduct(productStr);

            case CLOTH_ID :
                return convertToCloth(productStr);

            case BOOTS_ID :
                return convertToBoots(productStr);
        }

        return null;
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformation = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float price = Float.parseFloat(productInformation[3]);
        Float weight = Float.parseFloat(productInformation[4]);
        Color color = parseStrToColor(productInformation[5]);
        Integer productCount = Integer.parseInt(productInformation[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Product convertToCloth(String productStr) {
        String[] productInformation = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float price = Float.parseFloat(productInformation[3]);
        Float weight = Float.parseFloat(productInformation[4]);
        Color color = parseStrToColor(productInformation[5]);
        Integer productCount = Integer.parseInt(productInformation[6]);
        String size = productInformation[7];
        Material material = parseStrToMaterial(productInformation[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToBoots(String productStr) {
        String[] productInformation = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float price = Float.parseFloat(productInformation[3]);
        Float weight = Float.parseFloat(productInformation[4]);
        Color color = parseStrToColor(productInformation[5]);
        Integer productCount = Integer.parseInt(productInformation[6]);
        Integer size = Integer.parseInt(productInformation[7]);
        SkinType skinType = SkinParser.parseStrToSkinParser(productInformation[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }
}
