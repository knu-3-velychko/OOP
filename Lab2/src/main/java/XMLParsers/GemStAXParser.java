package XMLParsers;

import XML.XMLBuilder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javax.xml.stream.XMLStreamConstants.*;
import static javax.xml.stream.XMLStreamConstants.END_DOCUMENT;

public class GemStAXParser<T> implements GemXMLParser {
    private XMLBuilder<T> builder;
    private XMLStreamReader reader;

    public GemStAXParser(XMLBuilder<T> builder) {
        this.builder = builder;
    }

    @Override
    public Object parseGem(String xmlPath) throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            FileInputStream stream = new FileInputStream(xmlPath);
            reader = xmlInputFactory.createXMLStreamReader(stream);
            parse();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
            throw new Exception("Error " + e.getMessage());
        }
        return builder.getRoot();
    }

    private void parse() throws XMLStreamException {
        for (int event = reader.getEventType(); reader.hasNext(); event = reader.next()) {
            switch (event) {
                case START_ELEMENT:
                    builder.addOpenTag(reader.getLocalName());
                    addAttributes();
                    break;
                case CHARACTERS:
                    addData();
                    break;
                case END_ELEMENT:
                    builder.addCloseTag(reader.getLocalName());
                    break;
                case END_DOCUMENT:
                    break;
            }
        }
    }

    private void addAttributes() {
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeName(i).toString();
            String value = reader.getAttributeValue(i);
            builder.addAttribute(name, value);
        }
    }

    private void addData() {
        String data = reader.getText();
        data = data.replace("\n", "").trim();
        if (!data.equals(""))
            builder.addData(data);
    }

}
