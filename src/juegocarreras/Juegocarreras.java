
 package juegocarreras;

import BL.DriverBL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juegocarreras {
    
    Scanner reader = new Scanner(System.in);
    DriverBL driverBL = new DriverBL();
    Mysqlconexion conexion = new Mysqlconexion();
    int contDriver=0;
    
    public void conectarDb(){
        
        conexion.connect();
    }
    
    public void mostrarInterfazPrincipal() {
		
		System.out.println("INTERFAZ PRINCIPAL\n");
		System.out.println("1. CREAR JUGADOR\n");
		System.out.println("2. JUEGO NUEVO\n");
		System.out.println("3. SALIR\n");
		System.out.println("Escribe el número de la opción que deseas elegir\n");
		
		int opcionPrincipal = 0;
		opcionPrincipal = reader.nextInt();
		
		switch(opcionPrincipal) {
		case 1: 
                    savePlayer();
                    break;
		case 2: 
                    newPlay();
                    break;
		}
	}
    public void savePlayer() {
		
		System.out.println("HOLA JUGADOR\n");
		System.out.println("Escribe tu nombre:\n");
		
		String nameDriver;
		nameDriver = reader.next();
		
                boolean ifDriverIsEmpty= checkDbifEmpty();
                
                if(ifDriverIsEmpty==true)
                {
                    driverBL.setId(1);
                    
                }
                
                
                driverBL.setContDriver(contDriver);
                driverBL.setName(nameDriver);
                
                insertDriver(driverBL, ifDriverIsEmpty);
                
                
               
		
	}
    
    public void insertDriver(DriverBL driver, boolean ifDriverIsEmpty)
    {
        
       
        try {
            String strInsertDriver;
             if(ifDriverIsEmpty==true)
             {
            strInsertDriver= String.format("INSERT INTO driver(id_driver, name_driver, cont_driver) "
                + "VALUES (%d,'%s',%d)", driver.getId(), driver.getName(), driver.getContDriver());
        
            }
             else
            {
                 strInsertDriver= String.format("INSERT INTO driver(name_driver, cont_driver) "
                + "VALUES ('%s',%d)", driver.getName(), driver.getContDriver());
        
            }
            
            conexion.ejecutarSetenciasSQL(strInsertDriver);
            System.out.println("Jugador se creo con exito");
           
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
    
    public boolean checkDbifEmpty(){
        
        String strSentCheckTableDriver= "SELECT COUNT(DISTINCT id_driver) FROM driver;";
        int countDriver=0;
        try {
            countDriver = conexion.ejecutarSetenciasSQL(strSentCheckTableDriver);
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        if(countDriver==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        
    }
    
    public void newPlay() {
		
	System.out.println("JUEGO NUEVO\n");
		
        System.out.println("Escribe la cantidad de conductores que van a participar en la carrera\n");
		
	int cantidadConductores = 0;
	cantidadConductores = reader.nextInt();
		
        System.out.println("SELECCIÓN DE CONDUCTORES\n");
        
        List<String> listaDriversNames = new ArrayList<String>();
		
        for (int i=1;i<=cantidadConductores;i++) {
        	
            System.out.println("Escriba el nombre del conductor Número " + i + "\n");
            String nameConductor;
            nameConductor = reader.next();
            listaDriversNames.add(nameConductor);
        }
        
        System.out.println("SELECCIÓN DE CONDUCTORES EXITOSA\n");
        
        System.out.println("INGRESA LA DISTANCIA DE LAS PISTAS EN KILOMETROS\n");
        int distanciaPista = 0;
	distanciaPista = reader.nextInt();
		
	System.out.println("DISTANCIA DE PISTAS DEFINIDA! CADA PISTA TENDRÁ UNA DISTANCIA DE : " + distanciaPista + " KM. \n");
		        
	System.out.println("EL JUEGO YA SE HA CONFIGURADO, AHORA SI VAMOS A JUGAR!\n");
		
	
        
        
	}
    
	


    public static void main(String[] args) {
        
        Juegocarreras principalClass = new Juegocarreras();
        principalClass.conectarDb();
        principalClass.mostrarInterfazPrincipal();
    

    }
    
   
    
}
