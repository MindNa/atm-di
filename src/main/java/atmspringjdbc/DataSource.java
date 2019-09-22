package atmspringjdbc;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataSource {

    private DataSourceDao dataSource;

    /**
     * @param filename the name of the customer file
     */
    public DataSource(DataSourceDaoImp dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, Customer> readCustomers() throws IOException {
        Map<Integer, Customer> customers = dataSource.findAll();
        return customers;
    }
}
