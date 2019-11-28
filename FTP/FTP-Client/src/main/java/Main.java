import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        try {
            client.connect("localhost",959);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
