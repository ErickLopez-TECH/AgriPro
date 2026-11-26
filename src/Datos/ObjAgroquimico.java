/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author jdavi
 */
public class ObjAgroquimico {
    private int id;                  //llave primaria (automática)
    private String nombreComercial;  //ej: Picudo, Gramoxone
    private String reactivo;         //ingrediente activo del producto
    private String presentacion;     //ml, gramos u otros
    private double dosisHectarea;    //dosis recomendada por hectárea
    private String tipo;             //Herbicidas, Fungicidas, Insecticidas, Bactericidas o Fertilizante Foliar
    private int estado;              //0 = Inactivo | 1 = Activo

    public ObjAgroquimico() {
    }

    public ObjAgroquimico(int id, String nombreComercial, String reactivo, String presentacion, double dosisHectarea, String tipo, int estado) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.reactivo = reactivo;
        this.presentacion = presentacion;
        this.dosisHectarea = dosisHectarea;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getReactivo() {
        return reactivo;
    }

    public void setReactivo(String reactivo) {
        this.reactivo = reactivo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getDosisHectarea() {
        return dosisHectarea;
    }

    public void setDosisHectarea(double dosisHectarea) {
        this.dosisHectarea = dosisHectarea;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
