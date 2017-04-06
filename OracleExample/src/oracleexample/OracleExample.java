/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracleexample;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

// select instance_name from v$instance; //orcl
/**
 *
 * @author arthurhoch
 */
public class OracleExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        simpleSelect();
    }

    public static void simpleInsert() {
        String sql = "inser into table(id, tableName) values(?, ?)";

        Connection con = JavaConnection.connectDB();
        OraclePreparedStatement pst = null;

        try {
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "1");
            pst.setString(2, "tabela");
            pst.executeUpdate();

            pst.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(OracleExample.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public static void simpleSelect() {
        String sql = "select * from table where table.id = ?";

        Connection con = JavaConnection.connectDB();

        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;

        try {
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "100");
            rs = (OracleResultSet) pst.executeQuery();

            while (rs.next()) {
                String string1 = rs.getString(1);
                System.out.println(string1);
            }

            rs.close();
            pst.close();
            con.close();


        } catch (SQLException ex) {
            Logger.getLogger(OracleExample.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
