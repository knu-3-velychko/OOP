package XMLParsers;

import Entities.DiamondFund;
import XML.XMLValidator;

import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger(DiamondFund.class.getName()).log(Level.INFO, "Got an exception.", e);
            return null;
        }
    }
}
