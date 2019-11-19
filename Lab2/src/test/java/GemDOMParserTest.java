import Entities.DiamondFund;
import XML.DiamondFundXMLBuilder;
import XMLParsers.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GemDOMParserTest {
    private final String validXML = "src\\main\\resources\\DiamondFund.xml";
    private final String invalidXML = "src\\main\\resources\\InvalidXML.xml";

    private final String xsd = "src\\main\\resources\\DiamondFund.xsd";

    private GemDOMParser<DiamondFund> domParser = new GemDOMParser<>(new DiamondFundXMLBuilder());
    private DiamondFundParser parser = new DiamondFundParser(domParser);

    @Test
    public void parseCorrect() {
        assertNotNull(parser.parse(validXML, xsd));
    }

    @Test
    public void parseInvalid() {
        assertNull(parser.parse(invalidXML, xsd));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void parseGemCorrect() throws Exception {
        domParser.parseGem(validXML);
    }

    @Test
    public void parseGemInvalid() throws Exception {
        exceptionRule.expect(Exception.class);
        domParser.parseGem(invalidXML);
    }
}