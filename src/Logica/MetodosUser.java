/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.EstructuraUser;
import Datos.ObjUsuario;
import java.util.ArrayList;

/**
 *
 * @author triamus
 */
public class MetodosUser {
    
    EstructuraUser almacen = new EstructuraUser();
    
    public int siguienteUser(){
        int resultado = 0;
        
        //copia de la lista de las user
        ArrayList<ObjUsuario> misUser = almacen.listarUser();
        //rrecotrer mi lista de user
        for (int i = 0; i < misUser.size(); i++) {
                
                //extrae el ultimo id que hay en la lista
                resultado = misUser.get(i).getId();
            }
        return resultado + 1;
    
    }
    
    public ObjUsuario buscarUser(String cedula){
        ObjUsuario resultado = null;
        
        //copia de la lista de las user
        ArrayList<ObjUsuario> misUser = almacen.listarUser();
        //rrecotrer mi lista de user
        for (int i = 0; i < misUser.size(); i++) {
                if(misUser.get(i).getCedula().equals(cedula)){
                    
                    resultado = misUser.get(i);
                } 
                
            }
        return resultado;
    }
    
    public int buscarUserId(int id){
        int resultado = -1;
        
        //copia de la lista de las cajas
        ArrayList<ObjUsuario> misUser = almacen.listarUser();
        //rrecotrer mi lista de cajas
        for (int i = 0; i < misUser.size(); i++) {
                if(misUser.get(i).getId() == id){
                    //extrae el ultimo id que hay en la lista
                    resultado = i;
                } 
                
            }
        return resultado;
    }
}
