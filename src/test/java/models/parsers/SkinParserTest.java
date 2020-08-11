package models.parsers;

import entity.enums.SkinType;
import entity.parser.SkinParser;
import org.junit.Assert;
import org.junit.Test;

public class SkinParserTest {

    @Test
    public void testSkinParserNaturalSkin() {
        String strSkin = "natural";

        SkinType skin = SkinParser.parseStrToSkinParser(strSkin);

        Assert.assertEquals(skin, SkinType.NATURAL);
    }

    @Test
    public void testSkinParserArtificialSkin() {
        String strSkin = "ARTIficiaL";

        SkinType skin = SkinParser.parseStrToSkinParser(strSkin);

        Assert.assertEquals(skin, SkinType.ARTIFICIAL);
    }

    @Test
    public void testSkinParserWrongSkinType() {
        String strSkin = "cvbvngr";

        SkinType skin = SkinParser.parseStrToSkinParser(strSkin);

        Assert.assertEquals(skin, SkinType.ARTIFICIAL);
    }
}
