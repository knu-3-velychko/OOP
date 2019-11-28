import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class FTPServer {
    private Conf conf;
    private ServerSocketChannel serverChannel;
    private Selector selector;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public FTPServer() {
        conf = new Conf();
    }

    public void start() throws IOException {
        configureServer();
        acceptConnections();
    }

    public void setAddress(String host,int port){
        conf.setAddress(host, port);
    }

    public InetAddress getAddress(){
        return serverChannel.socket().getInetAddress();
    }

    private void configureServer() throws IOException {
        selector = Selector.open();
        serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(conf.getAddress());
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    private void acceptConnections() throws IOException {
        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> i = selectedKeys.iterator();

            while (i.hasNext()) {
                SelectionKey key = i.next();

                if (key.isAcceptable()) {
                    handleAccept();
                } else if (key.isReadable()) {
                    handleRead(key);
                }
                else if(key.isWritable()){
                    handleWrite(key);
                }
                i.remove();
            }
        }
    }

    private void handleWrite(SelectionKey key) throws IOException {
        System.out.println("write");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer b = ByteBuffer.allocate(1024);
        client.read(b);
    }

    private void handleAccept() throws IOException {
        SocketChannel client = serverChannel.accept();
        logger.info("Connection from " + client.toString() + " accepted.");
        client.configureBlocking(false);
        String response = "125 \r\n";
        System.out.println(response);
        ByteBuffer b = ByteBuffer.allocate(100);
        b.put(response.getBytes());
        b.flip();
        client.write(b);
    }

    private void handleRead(SelectionKey key) throws IOException {
        System.out.println("read");
        SocketChannel client = (SocketChannel) key.channel();
        Path path = Paths.get(conf.getOut());
        FileChannel fileChannel = FileChannel.open(path,
                EnumSet.of(StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING,
                        StandardOpenOption.WRITE));
        System.out.println(1);
        int numOfReadedBytes = FTPReader.readFile(client,fileChannel,conf.getBufferSize());
        System.out.println(2);
        ByteBuffer b = ByteBuffer.allocate(1024);
        String answer = new String(b.array(), StandardCharsets.UTF_8).trim();
        logger.info(numOfReadedBytes + " bytes were readed");
        logger.info(answer);
        String response = "230 \r\n";
        ByteBuffer b1 = ByteBuffer.allocate(100);
        b1.put(response.getBytes());
        b1.flip();
        client.write(b1);
        fileChannel.close();

        client.close();
    }
}
