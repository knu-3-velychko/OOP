import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        Cypher cypher = new Cypher(5);
        String s1 = new String("qwerty");
        DecryptInputStream<String> decryptor = new DecryptInputStream<>();
        byte[]decryptedData = new byte[0];
        try {
            decryptedData = decryptor.decryptData(s1,cypher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        EncryptOutputStream<String> encryptor = new EncryptOutputStream<>();
        String s2 = null;
        try {
            s2 = encryptor.encryptData(decryptedData,cypher);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(s2);
    }
}
