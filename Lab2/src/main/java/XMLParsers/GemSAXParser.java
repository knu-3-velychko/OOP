package XMLParsers;

import XML.XMLBuilder;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;

public class GemSAXParser<T> implements GemXMLParser {
    private XMLBuilder<T> builder;

    public GemSAXParser(XMLBuilder<T> builder) {
        this.builder = builder;
    }

    @Override
    public Object parseGem(String xmlPath) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler<>(builder);
            parser.parse(new File(xmlPath), handler);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error " + e.getMessage());
        }
        return builder.getRoot();
    }

}
