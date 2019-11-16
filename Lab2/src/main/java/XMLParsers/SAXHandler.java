package XMLParsers;

import XML.XMLBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler<T> extends DefaultHandler {
    private XMLBuilder<T> builder;

    public SAXHandler(XMLBuilder<T> builder) {
        this.builder = builder;
    }

    public T getRoot() {
        return builder.getRoot();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        builder.addOpenTag(qName);
        for (int iter = 0; iter < attributes.getLength(); iter++) {
            builder.addAttribute(attributes.getQName(iter), attributes.getValue(iter));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        builder.addCloseTag(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        data = data.replace("\n", "").trim();
        if (!data.equals(""))
            builder.addData(data);
    }
}
