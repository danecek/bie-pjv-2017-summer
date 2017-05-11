/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.serverwithjdbc;

import biepjv.serverwithjdbc.protocol.Command;
import biepjv.serverwithjdbc.protocol.Logout;
import biepjv.serverwithjdbc.repository.CustomerDAO;
import biepjv.serverwithjdbc.repository.CustomerDAOImplDerby;
import biepjv.serverwithjdbc.repository.CustomerDAOImplMemory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread extends Thread {

    CustomerDAO customerDAO = new CustomerDAOImplDerby();
    Socket s;

    public ClientThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try (
                Socket s = this.s;
                ObjectInputStream is = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream())) {

            for (;;) {
                Command c = (Command) is.readObject();
                LOG.info(c.toString());
                if (c instanceof Logout) {
                    break;
                }

                Object result = c.execute(customerDAO);
                os.writeObject(result);
                os.flush();
            }
        } catch (IOException | ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

    }
    private static final Logger LOG = Logger.getLogger(ClientThread.class.getName());

}
