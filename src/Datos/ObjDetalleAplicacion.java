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
    
    private String producto;

    public ObjDetalleAplicacion() {
    }

    public ObjDetalleAplicacion(String producto) {
        this.producto = producto;
    }
    
    //setters

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    //getters

    public String getProducto() {
        return producto;
    }
    
}
