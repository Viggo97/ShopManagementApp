package entity.parser;

import entity.enums.SkinType;

public class SkinParser {
    public static SkinType parseStrToSkinParser(String str) {
        String skinParser = str.toUpperCase();

        if (skinParser.equals("NATURAL")) {
            return SkinType.NATURAL;
        } else if (skinParser.equals("ARTIFICIAL")) {
            return SkinType.ARTIFICIAL;
        }
        return SkinType.ARTIFICIAL;
    }
}
