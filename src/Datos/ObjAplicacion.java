/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author triamus
 */
public class ObjAplicacion {
    
    private int id;
    private String nombre;
    private String justificacion;
    private int estado;
    private ArrayList<ObjDetalleAplicacion> detalle = new ArrayList<>();

    public ObjAplicacion() {
    }

    public ObjAplicacion(int id, String nombre, String justificacion, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.justificacion = justificacion;
        this.estado = estado;
    }

    
    
    
    public String getNumero(){
        return String.format("APL-%04d", id);
    }
    //setters

    public void setDetalle(ArrayList<ObjDetalleAplicacion> detalle) {
        this.detalle = detalle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    //getters

    public ArrayList<ObjDetalleAplicacion> getDetalle() {
        return new ArrayList<>(detalle);
    }

    public int getId() {
        return id;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }
    
    
    
    //manejo de detalle
    public void agregarLinea(ObjDetalleAplicacion linea){
        detalle.add(linea);
    }
    
    public void quitarLinea(int indice){
        if (indice >=0 && indice <detalle.size()) {
            detalle.remove(indice);
        }
    }
}
