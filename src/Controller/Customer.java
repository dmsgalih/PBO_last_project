package Controller;

import Model.ModelCustomer;

import java.sql.SQLException;

public class Customer {
    ModelCustomer customer = new ModelCustomer();

    public Customer() throws SQLException {
    }

    public void showCustomer() throws SQLException {
        customer.showCustomer();
    }
}
