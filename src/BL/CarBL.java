/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author Usuario
 */
public class CarBL {

    int id_car;
    String brand;
    String color;

    public CarBL() {
    }

    
    
    public CarBL(int id_car, String brand, String color) {
        this.id_car = id_car;
        this.brand = brand;
        this.color = color;
    }
    
       

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}
