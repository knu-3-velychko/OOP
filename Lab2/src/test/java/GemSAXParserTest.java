import Entities.DiamondFund;
import XML.DiamondFundXMLBuilder;
import XMLParsers.DiamondFundParser;
import XMLParsers.GemDOMParser;
import XMLParsers.GemSAXParser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GemSAXParserTest {
    private final String validXML = "src\\main\\resources\\DiamondFund.xml";
    private final String invalidXML = "src\\main\\resources\\InvalidXML.xml";

    private final String xsd = "src\\main\\resources\\DiamondFund.xsd";

    private GemSAXParser<DiamondFund> saxParser = new GemSAXParser<>(new DiamondFundXMLBuilder());
    private DiamondFundParser parser = new DiamondFundParser(saxParser);

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
        saxParser.parseGem(validXML);
    }

    @Test
    public void parseGemInvalid() throws Exception {
        exceptionRule.expect(Exception.class);
        saxParser.parseGem(invalidXML);
    }
}