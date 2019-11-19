package XMLParsers;

import XML.XMLBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GemSAXParser<T> implements GemXMLParser {
    private XMLBuilder<T> builder;

    public GemSAXParser(XMLBuilder<T> builder) {
        this.builder = builder;
    }

    @Override
    public Object parseGem(String xmlPath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler<>(builder);
            parser.parse(new File(xmlPath), handler);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            Logger.getLogger(GemSAXParser.class.getName()).log(Level.INFO, "Got an exception.", e);
        }
        return builder.getRoot();
    }

}
