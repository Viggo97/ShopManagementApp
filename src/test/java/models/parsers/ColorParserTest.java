package models.parsers;

import entity.enums.Color;
import entity.parser.ColorParser;
import org.junit.Assert;
import org.junit.Test;

public class ColorParserTest {
    @Test
    public void testParseColorBlack() {
        String strColor = "bLACK";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(color, Color.BLACK);
    }

    @Test
    public void testParseColorWhite() {
        String strColor = "WhItE";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(color, Color.WHITE);
    }

    @Test
    public void testParseColorRed() {
        String strColor = "red";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(color, Color.RED);
    }

    @Test
    public void testParseColorGreen() {
        String strColor = "GREEN";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(color, Color.GREEN);
    }

    @Test
    public void testParseColorBlue() {
        String strColor = "blue";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(color, Color.BLUE);
    }

    @Test
    public void testParseColorBlueYellow() {
        String strColor = "yeLLow";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(color, Color.YELLOW);
    }

    @Test
    public void testParseWrongColor() {
        String strColor = "fghfr";

        Color color = ColorParser.parseStrToColor(strColor);

        Assert.assertEquals(color, Color.WHITE);
    }
}
