package biepjv.serverwithjdbc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMain extends Thread {

    public static int PORT = 3333;

    public static void main(String[] args) {
        new ServerMain().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(PORT);
            for (;;) {
                LOG.info("waiting for client on: " + PORT);
                Socket s = ss.accept();
                new ClientThread(s).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private static final Logger LOG = Logger.getLogger(ServerMain.class.getName());

}
