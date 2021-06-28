/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocarreras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Mysqlconexion {
    public void connect() throws SQLException{
        String serveraddress = "127.0.0.1:3306";
        String db = "db_juegocarros";
        String user = "root";
        String pass = "12345";
        String url = "jdbc:mysql://" + serveraddress + "/" + db; 
        Connection conn = DriverManager.getConnection(url, user, pass);
        
        
        
    }
            
    
}
