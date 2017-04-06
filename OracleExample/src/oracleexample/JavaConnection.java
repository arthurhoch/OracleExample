/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracleexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// select instance_name from v$instance; //orcl

/**
 *
 * @author arthurhoch
 */
public class JavaConnection {
    public static Connection connectDB() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jbdc:oracle:thin:@localhost:1521:orcl", "user", "pass");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
