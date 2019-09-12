package atmdb;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataSource {

    private String filename;

    /**
     * @param filename the name of the customer file
     */
    public DataSource(String filename) {
        this.filename = filename;
    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, Customer> readCustomers() throws IOException {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:" + filename;
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null){
                String query = "SELECT * FROM customer";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    int customerNumber = resultSet.getInt(1);
                    int pin = resultSet.getInt(2);
                    int account = resultSet.getInt(3);
                    Customer c = new Customer(customerNumber,pin,account);
                    customers.put(c.getCustomerNumber(),c);
                }
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
