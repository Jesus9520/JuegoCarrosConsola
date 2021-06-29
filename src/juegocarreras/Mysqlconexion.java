/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocarreras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Mysqlconexion {
    
    Connection conn;
    
    public void connect() {
        
        try {
            String rutaDb = "C:/Users/Usuario/Documents/NetBeansProjects/juegocarreras/src/bd/SQLite/";
            String db = "db_juegocarros.s3db";
            String url = "jdbc:sqlite:" + rutaDb + db; 
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conexión establecida");
            
            
        } catch (Exception e) {
            
            System.out.println("Error de conexion" +e);
        }
        
    }
    
    public int ejecutarSetenciasSQL(String strSentenciaSQL) 
    {
        try {
            
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        
    }
    
     
    
    public ResultSet ConsultaRegistros(String strSentenciaSQL) 
    {
        try {
            
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
            
        }
        
    }
            
    
}
