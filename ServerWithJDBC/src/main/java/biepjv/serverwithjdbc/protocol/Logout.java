/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.serverwithjdbc.protocol;

import biepjv.serverwithjdbc.repository.CustomerDAO;

/**
 *
 * @author danecek
 */
public class Logout extends Command {

    @Override
    public Object execute(CustomerDAO customerDAO) {
        return OK;
    }
    
}
