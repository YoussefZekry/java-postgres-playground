package org.mokalmat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.postgresql.ds.PGSimpleDataSource;

public class App {
    public static void main(String[] args) {
        // new datasource object
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        // database connection properties
        dataSource.setServerNames(new String[] { "localhost" });
        dataSource.setPortNumbers(new int[] { 5432 });
        dataSource.setDatabaseName("sample_db");
        dataSource.setUser("postgres");
        dataSource.setPassword("2111976");

        Connection connection = null;
        // using datasource object to get a connection to the database
        try {
            connection = dataSource.getConnection();
            System.out.println("my message -> connected to database successfully.");
        } catch (SQLException e) {
            System.out.println("my message -> failed to connect to database: "
                    + e.getMessage());
        }

        try {
            //calling add order 
            // CallableStatement stm1 = connection.prepareCall("{ ? = call add_ordersAdv(?) }");
            // stm1.registerOutParameter(1, Types.INTEGER);
            // stm1.setString(2, "D:\\playground\\myCSV.csv");
            // stm1.execute();
            // int result1 = stm1.getInt(1);
            // System.out.println("add_orders result: " + result1);

            //calling delete order
            // CallableStatement stm2 = connection.prepareCall("{ ? = call delete_orderAdv(?) }");
            // stm2.registerOutParameter(1, Types.VARCHAR);
            // stm2.setInt(2, 56);
            // stm2.execute();
            // String result2 = stm2.getString(1);
            // System.out.println("delete_orderAdv result: " + result2);

            //calling update order
            CallableStatement stm3 = connection.prepareCall("{ ? = call update_orderAdv(?,?) }");
            stm3.registerOutParameter(1, Types.VARCHAR);
            stm3.setInt(2,-5);
            stm3.setString(3, "new status");
            stm3.execute();
             String result = stm3.getString(1);
            System.out.println("update_orderAdv result: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
