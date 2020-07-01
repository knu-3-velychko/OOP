import org.junit.Test;

import static org.junit.Assert.*;

public class ConfTest {

    private Conf conf = new Conf();
    private String out = "Out.zip";
    private int bufferSize = 10000;

    private String host = "localhost";
    private int port = 5555;

    @Test
    public void setConfiguration() {
        conf.setConfiguration(out, bufferSize);

        assertEquals(out, conf.getOut());
        assertEquals(bufferSize, conf.getBufferSize());
    }

    @Test
    public void setAddress() {
        conf.setAddress(host, port);
        assertEquals(host, conf.getAddress().getHostName());
        assertEquals(port, conf.getAddress().getPort());
    }

    @Test
    public void getAddress() {
        assertEquals("127.0.0.1", conf.getAddress().getHostName());
        assertEquals(5555, conf.getAddress().getPort());
    }

    @Test
    public void getOut() {
        assertEquals("Out.zip",conf.getOut());
    }

    @Test
    public void getBufferSize() {
        assertEquals(10240,conf.getBufferSize());
    }
}