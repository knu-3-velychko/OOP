package XMLParsers;

public interface GemXMLParser<T> {
    T parseGem(String xmlPath) throws Exception;
}
