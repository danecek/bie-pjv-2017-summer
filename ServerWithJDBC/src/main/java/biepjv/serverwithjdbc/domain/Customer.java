package biepjv.serverwithjdbc.domain;

import java.io.Serializable;


public class Customer implements Serializable {
    
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + '}';
    }

    public String getName() {
        return name;
    }
    
}
