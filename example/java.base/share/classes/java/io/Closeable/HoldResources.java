package share.classes.java.io.Closeable;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HoldResources implements Closeable {
    private Socket socket;
    private BufferedReader reader;

    public HoldResources(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}
