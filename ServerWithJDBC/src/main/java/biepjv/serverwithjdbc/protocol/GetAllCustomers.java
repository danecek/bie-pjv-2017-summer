/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.serverwithjdbc.protocol;

import biepjv.serverwithjdbc.repository.CustomerDAO;

public class GetAllCustomers extends Command {

    @Override
    public Object execute(CustomerDAO customerDAO) {
        return customerDAO.all();
    }

    @Override
    public String toString() {
        return "GetAllCustomers{" + '}';
    }
    
}
