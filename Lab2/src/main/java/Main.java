import Entities.DiamondFund;
import XML.DiamondFundXMLBuilder;
import XMLParsers.DiamondFundParser;
import XMLParsers.DomParser;

public class Main {
    public static void main(String[] args) {
        String xml = "src\\main\\resources\\DiamondFund.xml";
        String xsd = "src\\main\\resources\\DiamondFund.xsd";

        DomParser<DiamondFund> domParser = new DomParser<>(new DiamondFundXMLBuilder());
        DiamondFundParser parser = new DiamondFundParser(domParser);
        DiamondFund diamondFund = parser.parse(xml, xsd);

        System.out.println(diamondFund);
    }
}
