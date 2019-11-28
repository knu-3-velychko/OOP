import java.net.InetSocketAddress;

public class Conf {
    private InetSocketAddress address;
    private String out = "Out.zip";
    private int bufferSize = 10240;

    public Conf() {
        address = new InetSocketAddress("127.0.0.1", 5555);
    }

    public void setConfiguration(String out, int bufferSize) {
        this.out = out;
        this.bufferSize = bufferSize;
    }

    public void setAddress(String host, int port) {
        address = new InetSocketAddress(host, port);
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    public String getOut() {
        return out;
    }

    public int getBufferSize() {
        return bufferSize;
    }
}
