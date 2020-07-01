import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class DecryptInputStreamTest {

    @Test
    public void decryptDataCaesar() throws IOException, ClassNotFoundException {
        Cypher cypher = new Cypher("1010");
        DecryptInputStream<String> decrypter = new DecryptInputStream<>();
        byte[] decryptedData = decrypter.decryptData("Some test text", cypher);
        EncryptOutputStream<String> encrypter = new EncryptOutputStream<>();
        String encrypted = encrypter.encryptData(decryptedData, cypher);
        assertEquals("Some test text", encrypted);
    }

    @Test
    public void decryptDataXOR() throws IOException, ClassNotFoundException {
        Cypher cypher = new Cypher(5);
        DecryptInputStream<String> decrypter = new DecryptInputStream<>();
        byte[] decryptedData = decrypter.decryptData(new String("Some test text"), cypher);
        EncryptOutputStream<String> encrypter = new EncryptOutputStream<>();
        String encrypted = encrypter.encryptData(decryptedData, cypher);
        assertEquals("Some test text", encrypted);
    }
}