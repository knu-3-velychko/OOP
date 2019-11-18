import org.junit.Test;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.logging.Handler;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class SSHClientTest {
    SSHClient client;

    @Test
    public void connect() {
        final String host = "localhost";
        final int port = 1051;
        client = new SSHClient(host, port);
        InetSocketAddress address = new InetSocketAddress("localhost", port);
        assertEquals(client.getAddress(), address);
        assertEquals(client.getAddress().getHostName(), host);
        assertEquals(client.getAddress().getPort(), port);

        client.connect();

        Handler[] handlers = Logger.getLogger(SSHClient.class.getName()).getHandlers();

        assertEquals(handlers.length, 0);
    }
}