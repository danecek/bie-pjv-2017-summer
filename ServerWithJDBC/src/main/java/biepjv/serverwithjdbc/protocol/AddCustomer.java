package biepjv.serverwithjdbc.protocol;

import biepjv.serverwithjdbc.domain.Customer;
import biepjv.serverwithjdbc.repository.CustomerDAO;

public class AddCustomer extends Command {
    
    private Customer customer;

    public AddCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public Object execute(CustomerDAO customerDAO) {
        customerDAO.add(customer);
        return OK;
    }

    @Override
    public String toString() {
        return "AddCustomer{" + "customer=" + customer + '}';
    }
    
}
