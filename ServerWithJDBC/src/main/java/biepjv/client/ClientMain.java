/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.client;

import biepjv.serverwithjdbc.ServerMain;
import biepjv.serverwithjdbc.domain.Customer;
import biepjv.serverwithjdbc.protocol.AddCustomer;
import biepjv.serverwithjdbc.protocol.Command;
import biepjv.serverwithjdbc.protocol.GetAllCustomers;
import biepjv.serverwithjdbc.protocol.Logout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        try (
                Socket s = new Socket("localhost", ServerMain.PORT);
                ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(s.getInputStream())) {

            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Command com = null;
                switch (line) {
                    case "GET":
                        com = new GetAllCustomers();
                        break;
                    case "END":
                        com = new Logout();
                        break;
                    default:
                        com = new AddCustomer(new Customer(line));
                }
                System.out.println(com.toString());
                os.writeObject(com);
                os.flush();
                System.out.println(is.readObject().toString());
            }
        } catch (IOException | ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

    }
    private static final Logger LOG = Logger.getLogger(ClientMain.class.getName());

}
