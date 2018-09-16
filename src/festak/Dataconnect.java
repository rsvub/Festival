/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festak;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Student
 */
public class Dataconnect {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/festival";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456789";
    static java.sql.Connection conn = null;
    private Connection connection;
    protected static Statement stmt = null;

    public Connection connect() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Databáze je připojená");
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return connection;

    }

    public void disconect() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }//end finally try

        System.out.println("Goodbye!");

    }

}
