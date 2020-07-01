import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FTPReaderTest {

    @Test
    public void readFile() throws IOException {
        SocketChannel s = Mockito.mock(SocketChannel.class);
        FileChannel f = Mockito.mock(FileChannel.class);
        when(s.read((ByteBuffer)any())).thenReturn(-5);
        when(f.write((ByteBuffer)any())).thenReturn(0);
        FTPReader.readFile(s,f,1024);
        verify(s,atLeast(1)).read((ByteBuffer)any());
    }
}