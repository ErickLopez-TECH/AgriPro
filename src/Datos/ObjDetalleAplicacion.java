/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author triamus
 */
public class ObjDetalleAplicacion {
    
    private String tipoAgroquimico;
    private String producto;
    
    private double dosisHectarea;

    public ObjDetalleAplicacion() {
    }

    public ObjDetalleAplicacion(String tipoAgroquimico, String producto, double dosisHectarea) {
        this.tipoAgroquimico = tipoAgroquimico;
        this.producto = producto;
        this.dosisHectarea = dosisHectarea;
    }

    

    
  
    //setters

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setTipoAgroquimico(String tipoAgroquimico) {
        this.tipoAgroquimico = tipoAgroquimico;
    }

    

    public void setDosisHectarea(double dosisHectarea) {
        this.dosisHectarea = dosisHectarea;
    }
   
    
    //getters

    public String getProducto() {
        return producto;
    }

    public String getTipoAgroquimico() {
        return tipoAgroquimico;
    }

    

    public double getDosisHectarea() {
        return dosisHectarea;
    }
    
}
