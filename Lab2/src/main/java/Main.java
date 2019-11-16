import Entities.DiamondFund;
import XML.DiamondFundXMLBuilder;
import XMLParsers.DiamondFundParser;
import XMLParsers.GemDOMParser;
import XMLParsers.GemSAXParser;
import XMLParsers.GemStAXParser;

public class Main {
    public static void main(String[] args) {
        String xml = "src\\main\\resources\\DiamondFund.xml";
        String xsd = "src\\main\\resources\\DiamondFund.xsd";

        GemDOMParser<DiamondFund> domParser = new GemDOMParser<>(new DiamondFundXMLBuilder());
        GemSAXParser<DiamondFund> saxParser=new GemSAXParser<>(new DiamondFundXMLBuilder());
        GemStAXParser<DiamondFund> staxParser=new GemStAXParser<>(new DiamondFundXMLBuilder());
        DiamondFundParser parser = new DiamondFundParser(staxParser);
        DiamondFund diamondFund = parser.parse(xml, xsd);

        System.out.println(diamondFund);
    }
}
