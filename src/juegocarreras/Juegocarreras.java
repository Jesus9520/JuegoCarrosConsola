
 package juegocarreras;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juegocarreras {
    
    Scanner reader = new Scanner(System.in);
    
    public void conectarDb(){
        Mysqlconexion conexion = new Mysqlconexion();
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
		case 1: guardarJugador();
		case 2: crearJuego();
		break;
		}
	}
    public void guardarJugador() {
		
		System.out.println("CREAR JUGADOR\n");
		System.out.println("Escribe el nombre de tu jugador\n");
		
		String nombreJugador;
		nombreJugador = reader.next();
		
		
		
	}
    
    public void crearJuego() {
		
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
