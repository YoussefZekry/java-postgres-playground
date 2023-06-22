package org.mokalmat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

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

        String csvFilePath = "D:\\playground\\myCSV.csv";
        File csv = new File(csvFilePath);

        Connection connection = null;
        // using datasource object to get a connection to the database
        try {
            Scanner myReader = new Scanner(csv);
            myReader.nextLine();
            while (myReader.hasNext()) {
                String[] data = myReader.nextLine().split(",");
                for ( String value : data) {
                    System.out.println(value + " ");
                }
            }
        } catch (Exception e) {
            System.out.println("my message -> failed to connect to database: "
                    + e.getMessage());
        }

        

    }
}
   // String sql = "insert into orders (customer_id,order_date,amount,status) values (?,?,?,?)";
            // PreparedStatement statement = connection.prepareStatement(sql);