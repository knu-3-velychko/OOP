package XMLParsers;

import XML.XMLBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser<T> implements GemXMLParser {
    private XMLBuilder<T> builder;

    public DomParser(XMLBuilder<T> builder) {
        this.builder = builder;
    }

    @Override
    public T parseGem(String xmlPath) throws Exception {
        File xmlFile = new File(xmlPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlFile);
            parseNodes(document.getChildNodes());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
            throw new Exception("Error in DOM. Can't read file." + e.getMessage());
        }
        return builder.getRoot();
    }

    private void parseNodes(NodeList childNodes) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            parseNode(node);
            parseAttributes(node);

            if (node.hasChildNodes())
                parseNodes(node.getChildNodes());

            builder.addCloseTag(node.getNodeName());
        }
    }

    private void parseNode(Node node) {
        if (node.getNodeType() == Node.TEXT_NODE) {
            String text = node.getNodeValue().replace("\n", "").trim();
            if (!text.isEmpty()) {
                builder.addOpenTag(node.getParentNode().getNodeName()).addData(text);
            }
        }
        else
            builder.addOpenTag(node.getNodeName());
    }

    private void parseAttributes(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                builder.addAttribute(attribute.getNodeName(), attribute.getTextContent());
            }
        }
    }
}
