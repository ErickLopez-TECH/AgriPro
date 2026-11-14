/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author triamus
 */
public class ObjCultivo {
    
    private  int id;
    private String nombreComer;
    private String nombreCientifico;
    private int estado;//0--> inactivo 1--> activo

    public ObjCultivo() {
    }

    public ObjCultivo(int id, String nombreComer, String nombreCientifico, int estado) {
        this.id = id;
        this.nombreComer = nombreComer;
        this.nombreCientifico = nombreCientifico;
        this.estado = estado;
    }
    
    //setters

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public void setNombreComer(String nombreComer) {
        this.nombreComer = nombreComer;
    }
    
    
    //getters

    public int getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public String getNombreComer() {
        return nombreComer;
    }
    
    
}
