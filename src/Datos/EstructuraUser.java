/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author triamus
 */

//arrayList

public class EstructuraUser {
    static ArrayList<ObjUsuario> listaUsuarios = new ArrayList<>();
    
    /*----------------------------------------------------------
    |              Metodos de trabajo de usuarios       |
    |                                                         |
    ----------------------------------------------------------*/
    public void agregarUser(ObjUsuario miUser){
        listaUsuarios.add(miUser);
    }
    
    //modificar user
    public void editarUser(int indice, ObjUsuario miUser){
        listaUsuarios.set(indice, miUser);
    }
    
    //eliminar
    public void quitarUser(int indece){
        listaUsuarios.remove(indece);
    }
    
    
    //devilver lista
    public static ArrayList<ObjUsuario> listarUser() {
        return new ArrayList<>(listaUsuarios);
    }
    
    public DefaultTableModel mostrarUser(){
        String[] titulo = {"Identificacion","Nombre User","Nombre","Cedula"};
        
        DefaultTableModel modelo = new DefaultTableModel(titulo,0);
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            
            String[] fila = {
                String.valueOf(listaUsuarios.get(i).getId()),
                listaUsuarios.get(i).getNombreUser(),
                listaUsuarios.get(i).getNombreCompleto(),
                
                listaUsuarios.get(i).getCedula()
            };
            
             modelo.addRow(fila);
        }
        return modelo;
    }
}
