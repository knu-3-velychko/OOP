import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomXMLParser<T> implements GemXMLParser {
    @Override
    public T parseGem(String xmlPath) throws Exception {
        File xmlFile = new File(xmlPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlFile);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
            throw new Exception("Error in DOM. Can't read file." + e.getMessage());
        }
        return null;
    }
}
