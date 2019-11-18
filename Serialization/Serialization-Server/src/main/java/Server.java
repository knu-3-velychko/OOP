import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;

    private ServerSocket serverSocket;
    private Socket client;

    private Logger logger;

    private PrintWriter storage;

    public Server(int port, PrintWriter storage) {
        logger = Logger.getLogger(Server.class.getName());
        this.storage = storage;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            logger.log(Level.INFO, "Exception handled: " + e.getMessage());
        }
    }

    public boolean checkConnection() {
        try {
            client = serverSocket.accept();
            logger.info("Connected");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void closeStreams() throws IOException {
        out.close();
        in.close();
        serverSocket.close();
    }

    public Object readData() {
        try {
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
            logger.info("Received object");
            Object object = in.readObject();
            closeStreams();
            client.close();
            saveData((Student) object);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.INFO, "Can't read data.");
        }
        return null;
    }


    private void saveData(Student student) {
        System.out.println(student.toString());
        storage.println(student.toString());
        logger.log(Level.INFO, "Data stored.");
        storage.close();
    }
}
