package Datos;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author triamus
 */
public class EstructuraAplicacion {
    
    //lista de almacenamiento
    static ArrayList<ObjAplicacion> listaAplicaciones = new ArrayList<>();

    public EstructuraAplicacion() {
    }
    
    //Insertar
    public void agregarAplicacion(ObjAplicacion miAplicacion){
        listaAplicaciones.add(miAplicacion);
    }

    //Modificar
    public void editarAplicacion(int indice, ObjAplicacion miAplicacion){
        listaAplicaciones.set(indice, miAplicacion);
    }

    //Borrar
    public void quitarAplicacion(int indice){
        listaAplicaciones.remove(indice);
    }

    //Mostrar (la lista): devuelve una copia para no modificar la original por accidente
    public ArrayList<ObjAplicacion> listarAplicacion(){
        return new ArrayList<>(listaAplicaciones);
    }
    
}
