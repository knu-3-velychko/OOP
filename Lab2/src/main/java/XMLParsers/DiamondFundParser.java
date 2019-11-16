package XMLParsers;

import Entities.DiamondFund;
import XML.XMLValidator;

public class DiamondFundParser {
    private GemXMLParser<DiamondFund> parser;

    public DiamondFundParser(GemXMLParser<DiamondFund> parser) {
        this.parser = parser;
    }

    public DiamondFund parse(String xmlPath, String xsdPath) {
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
