
 package juegocarreras;

import java.sql.SQLException;

public class Juegocarreras {
    
    public static void conectarDb(){
         Mysqlconexion conexion = new Mysqlconexion();
        
        
        try {
                conexion.connect();
        }catch (SQLException e){
            System.err.println("Error al conectar a la base de datos");
        }
    }


    public static void main(String[] args) {
        
      conectarDb();
    

    }
    
   
    
}
