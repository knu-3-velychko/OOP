package XMLParsers;

import XML.XMLBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

import static javax.xml.stream.XMLStreamConstants.END_DOCUMENT;
import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

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
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new Exception("Error " + e.getMessage());
        }
        return builder.getRoot();
    }

}
