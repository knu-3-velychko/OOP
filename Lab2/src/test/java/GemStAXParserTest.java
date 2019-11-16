import Entities.DiamondFund;
import XML.DiamondFundXMLBuilder;
import XMLParsers.DiamondFundParser;
import XMLParsers.GemDOMParser;
import XMLParsers.GemStAXParser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GemStAXParserTest {
    private final String validXML = "src\\main\\resources\\DiamondFund.xml";
    private final String invalidXML = "src\\main\\resources\\InvalidXML.xml";

    private final String xsd = "src\\main\\resources\\DiamondFund.xsd";

    private GemStAXParser<DiamondFund> staxParser = new GemStAXParser<>(new DiamondFundXMLBuilder());
    private DiamondFundParser parser = new DiamondFundParser(staxParser);

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
        staxParser.parseGem(validXML);
    }

    @Test
    public void parseGemInvalid() throws Exception {
        exceptionRule.expect(Exception.class);
        staxParser.parseGem(invalidXML);
    }
}