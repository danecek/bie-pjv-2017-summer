/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.serverwithjdbc.protocol;

import biepjv.serverwithjdbc.repository.CustomerDAO;
import java.io.Serializable;

public abstract class Command implements Serializable {
    
    public static final String OK ="ok";

    public abstract Object execute(CustomerDAO customerDAO);
}
