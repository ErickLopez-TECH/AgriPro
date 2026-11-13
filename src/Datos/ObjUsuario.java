/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author triamus
 */
public class ObjUsuario {
    
    private int id;
    private String cedula;
    private String nombreCompleto;
    private String nombreUser;
    private String clave;
    private int rol; //1--> admin, 0--> normal
    private int estado;//1--> Actvio, 0 -->inactivo

    public ObjUsuario() {
    }

    public ObjUsuario(int id, String cedula, String nombreCompleto, String nombreUser, String clave, int rol, int estado) {
        this.id = id;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.nombreUser = nombreUser;
        this.clave = clave;
        this.rol = rol;
        this.estado = estado;
    }
    
    //setters

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    //gettesr

    public String getCedula() {
        return cedula;
    }

    public String getClave() {
        return clave;
    }

    public int getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public int getRol() {
        return rol;
    }
    
    
}
