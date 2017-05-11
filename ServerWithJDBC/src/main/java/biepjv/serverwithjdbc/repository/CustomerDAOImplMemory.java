/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.serverwithjdbc.repository;

import biepjv.serverwithjdbc.domain.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplMemory implements CustomerDAO {
    
    List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer c) {
        customers.add(c);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> all() {
        return customers;
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
