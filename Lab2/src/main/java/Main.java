import Entities.DiamondFund;
import Entities.Gem;
import XML.DiamondFundXMLBuilder;
import XMLParsers.DiamondFundParser;
import XMLParsers.DomParser;
import XMLParsers.GemSAXParser;
import XMLParsers.StAXParser;

import javax.xml.parsers.SAXParser;

public class Main {
    public static void main(String[] args) {
        String xml = "src\\main\\resources\\DiamondFund.xml";
        String xsd = "src\\main\\resources\\DiamondFund.xsd";

        DomParser<DiamondFund> domParser = new DomParser<>(new DiamondFundXMLBuilder());
        GemSAXParser<DiamondFund> saxParser=new GemSAXParser<>(new DiamondFundXMLBuilder());
        StAXParser<DiamondFund> staxParser=new StAXParser<>(new DiamondFundXMLBuilder());
        DiamondFundParser parser = new DiamondFundParser(staxParser);
        DiamondFund diamondFund = parser.parse(xml, xsd);

        System.out.println(diamondFund);
    }
}
