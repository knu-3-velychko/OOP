import XML.XMLValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class XMLValidatorTest {

    @Test
    public void validateCorrect() {
        String xml = "src\\main\\resources\\DiamondFund.xml";
        String xsd = "src\\main\\resources\\DiamondFund.xsd";
        assertTrue(XMLValidator.validate(xml, xsd));
    }

    @Test
    public void validateInvalid() {
        String xml = "src\\main\\resources\\InvalidXML.xml";
        String xsd = "src\\main\\resources\\DiamondFund.xsd";
        assertFalse(XMLValidator.validate(xml, xsd));
    }

    @Test
    public void validateMissingFile() {
        String xml = "";
        String xsd = "";
        assertFalse(XMLValidator.validate(xml, xsd));
    }
}