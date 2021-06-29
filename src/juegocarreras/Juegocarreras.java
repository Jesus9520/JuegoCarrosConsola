
 package juegocarreras;

import BL.CarBL;
import BL.DriverBL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juegocarreras {
    
    Scanner reader = new Scanner(System.in);
    DriverBL driverBL = new DriverBL();
    CarBL car = new CarBL();
    
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
		
		System.out.println("\nHOLA JUGADOR\n");
		System.out.println("Escribe tu nombre:\n");
		
		String nameDriver;
		nameDriver = reader.next();
		
                int idDriver=getIdDriver();
                driverBL.setId(idDriver);
                driverBL.setContDriver(contDriver);
                driverBL.setName(nameDriver);
                
                insertDriver(driverBL);
                
                mostrarInterfazPrincipal();
               
		
	}
    
    public void insertDriver(DriverBL driver)
    {
        
        try {
            String strInsertDriver;
             
            strInsertDriver= String.format("INSERT INTO driver(id_driver, name_driver, cont_driver) "
                + "VALUES (%d,'%s',%d)", driver.getId(), driver.getName(), driver.getContDriver());
        
            conexion.ejecutarSetenciasSQL(strInsertDriver);
            System.out.println("\n Jugador creado con exito");
           
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
    public void carSelection() {
        
        int nCar=5;
        int numberCar;
		
	System.out.println("\nSELECCIÓN DE CARRO\n");
		
	ArrayList<CarBL> listCars = new ArrayList<>();
        ArrayList<String> listBrandsCar = new ArrayList<>();
        ArrayList<String> listColorsCar = new ArrayList<>();
        
        listColorsCar.add("AMARILLO");
        listColorsCar.add("AZUL");
        listColorsCar.add("ROJO");
        listColorsCar.add("VERDE");
        listColorsCar.add("BLANCO");
        
        listBrandsCar.add("MAZDA");
        listBrandsCar.add("TOYOTA");
        listBrandsCar.add("MERCEDEZ");
        listBrandsCar.add("AUDI");
        listBrandsCar.add("BMW");
        
        
        //aqui creamos los carros con sus caracteristicas y añadimos cada uno a la lista de carros
        for(int i=0; i<nCar; i++){
            CarBL car = new CarBL();
            car.setId_car(i+1);
            car.setBrand(listBrandsCar.get(i));
            car.setColor(listColorsCar.get(i));
            listCars.add(car);
        }
        
        int idCar;
        String brandCar;
        String colorCar;
        
        
        //aqui recorremos la lista de carros para mostrarlos        
        for(int x=0; x<nCar; x++)
        {
            idCar=listCars.get(x).getId_car();
            brandCar= listCars.get(x).getBrand();
            colorCar= listCars.get(x).getColor();
            System.out.println(idCar + " - " + brandCar+ " - " + colorCar);
        }
     	
		
	System.out.println("\nEscribe el número del carro con el que deseas jugar\n");
		
	numberCar = reader.nextInt();
		
	System.out.println("\nTu selección de carro se ha guardado.\n");
	mostrarInterfazPrincipal();		
	}
    
    
    
    public int getIdDriver(){
        
        DriverBL driver = new DriverBL();
        String strSentCheckTableDriver= "SELECT MAX(id_driver) AS id_driver FROM driver";
        int idDriver=0;
        try {
            ResultSet result = conexion.ConsultaRegistros(strSentCheckTableDriver);
            if(result.next())
            {
                idDriver=(result.getInt(1));
            }
               
            idDriver++;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return idDriver;
        
    }
    
    public void newPlay() {
        
        int i;
		
	System.out.println("JUEGO NUEVO\n");
		
        System.out.println("Escribe la cantidad de conductores que van a participar en la carrera - MAXIMO 3 JUGADORES\n");
		
	int cantidadConductores = 0;
	cantidadConductores = reader.nextInt();
		
        System.out.println("SELECCIÓN DE CONDUCTORES\n");
        
        ArrayList<DriverBL> listDrivers = new ArrayList<>();
        int idDriver;
        String nameDriver;
        
        int nDrivers=getDrivers(listDrivers).size();
        i=0;
        
        while (i<nDrivers) {
            
            idDriver=listDrivers.get(i).getId();
            nameDriver= listDrivers.get(i).getName();
            System.out.println(idDriver + " - " + nameDriver);
            i++;
        }
        
        int numberDriver;
        
        ArrayList<DriverBL> listCarsGamers = new ArrayList<>();
        int cont=1;
        
        for(i=0; i<cantidadConductores; i++)
        {
            System.out.println("Seleccione el conductor n." + cont + ":\n");
            numberDriver = reader.nextInt();
            numberDriver--;
            listCarsGamers.add(listDrivers.get(numberDriver));
            cont++;
        }
        
        
        
        System.out.println("\nSELECCIÓN DE CONDUCTORES EXITOSA\n");
        
        System.out.println("\nLOS CONDUCTORES SELECCIONADOS SON:\n");
        
        for(i=0; i<listCarsGamers.size();i++)
        {
            System.out.println("\n" + listCarsGamers.get(i).getId() + " - " + listCarsGamers.get(i).getName() + "\n");
            
        }
        
        carSelection();
        
        System.out.println("INGRESA LA DISTANCIA DE LAS PISTAS EN KILOMETROS\n");
        int distanciaPista = 0;
	distanciaPista = reader.nextInt();
		
	System.out.println("DISTANCIA DE PISTAS DEFINIDA! CADA PISTA TENDRÁ UNA DISTANCIA DE : " + distanciaPista + " KM. \n");
		        
	System.out.println("EL JUEGO YA SE HA CONFIGURADO, AHORA SI VAMOS A JUGAR!\n");
		
	
        
        
	}
    public ArrayList<DriverBL> getDrivers(ArrayList<DriverBL> listDriver){
        
        
        String strSentCheckTableDriver= "SELECT * FROM driver";
        
        try {
            ResultSet result = conexion.ConsultaRegistros(strSentCheckTableDriver);
            while(result.next())
            {
                DriverBL driver = new DriverBL();
                driver.setId(result.getInt("id_driver"));
                driver.setName(result.getString("name_driver"));
                listDriver.add(driver);
            }
               
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return listDriver;
    }
    
	


    public static void main(String[] args) {
        
        Juegocarreras principalClass = new Juegocarreras();
        principalClass.conectarDb();
        principalClass.mostrarInterfazPrincipal();
    

    }
    
   
    
}
