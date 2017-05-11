/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.serverwithjdbc.repository;

import biepjv.serverwithjdbc.domain.Customer;
import java.util.List;

public interface CustomerDAO {

    void add(Customer c);

    List<Customer> all();
    
}
