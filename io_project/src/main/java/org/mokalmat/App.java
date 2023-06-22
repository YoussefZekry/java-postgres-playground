package org.mokalmat;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
            connection = dataSource.getConnection();
            Scanner myReader = new Scanner(csv);
            myReader.nextLine();

            while (myReader.hasNext()) {
                String[] data = myReader.nextLine().split(",");
                String sql = "insert into orders (customer_id,order_date,amount,status) values (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(data[0]));
                    statement.setDate(2, Date.valueOf(data[1]));
                    statement.setInt(3, Integer.parseInt(data[2]));
                    statement.setString(4, data[3]);
               
                statement.executeUpdate();
            }
            System.out.println(connection);
        } catch (Exception e) {
            System.out.println("my message -> failed to connect to database: "
                    + e.getMessage());
        }

        

    }
}