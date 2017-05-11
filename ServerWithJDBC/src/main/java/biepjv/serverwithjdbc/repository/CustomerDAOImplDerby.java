/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.serverwithjdbc.repository;

import biepjv.serverwithjdbc.domain.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAOImplDerby implements CustomerDAO {

    PreparedStatement addPs;
    PreparedStatement allPs;

    public CustomerDAOImplDerby() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:~/MyCustomerDb;create=true");
            try {
                con.createStatement().executeUpdate("CREATE TABLE CUSTOMERS (NAME VARCHAR(256)) ");
                LOG.info("table crated");
            } catch (SQLException ex) {
            }

            addPs = con.prepareStatement("INSERT INTO CUSTOMERS VALUES(?)");
            allPs = con.prepareStatement("SELECT * FROM CUSTOMERS");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

    }
    private static final Logger LOG = Logger.getLogger(CustomerDAOImplDerby.class.getName());

    @Override
    public void add(Customer c) {
        try {
            addPs.setString(1, c.getName());
            addPs.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Customer> all() {
        try {
            ResultSet rs = allPs.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(new Customer(rs.getString(1)));
            }
            return customers;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
