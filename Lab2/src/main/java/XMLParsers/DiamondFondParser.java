package XMLParsers;

import Entities.DiamondFund;
import XML.XMLValidator;

public class DiamondFondParser {
    private GemXMLParser<DiamondFund> parser;

    public DiamondFondParser(GemXMLParser<DiamondFund> parser) {
        this.parser = parser;
    }

    DiamondFund parse(String xmlPath, String xsdPath) {
        if (!XMLValidator.validate(xmlPath, xsdPath))
            return null;
        try {
            return parser.parseGem(xmlPath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
