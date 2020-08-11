package models.parsers;

import entity.enums.Material;
import entity.parser.MaterialParser;
import junit.framework.Assert;
import org.junit.Test;

public class MaterialParserTest {
    @Test
    public void testParseLeather() {
        String strMaterial = "leaTHEr";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.LEATHER, material);
    }

    @Test
    public void testParseFur() {
        String strMaterial = "Fur";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.FUR, material);
    }

    @Test
    public void testParseCotton() {
        String strMaterial = "CotTON";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.COTTON, material);
    }

    @Test
    public void testParseWool() {
        String strMaterial = "wOOl";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.WOOL, material);
    }

    @Test
    public void testParsePolyesters() {
        String strMaterial = "PolyestERS";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.POLYESTER, material);
    }

    @Test
    public void testParseWrongMaterial() {
        String strMaterial = "any-no-exist";

        Material material = MaterialParser.parseStrToMaterial(strMaterial);

        Assert.assertEquals(Material.POLYESTER, material);
    }
}
