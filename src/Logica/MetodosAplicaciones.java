/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.EstructuraAplicacion;
import Datos.ObjAplicacion;
import java.util.ArrayList;

/**
 *
 * @author triamus
 */

public class MetodosAplicaciones {
    
    EstructuraAplicacion almacen = new EstructuraAplicacion();

    
    public int siguienteAplicacion(){
        int resultado = 0;
        
        //copia de la lista de las user
        ArrayList<ObjAplicacion> misAplicaciones = almacen.listarAplicacion();
        //rrecotrer mi lista de user
        for (int i = 0; i < misAplicaciones.size(); i++) {
                
                //extrae el ultimo id que hay en la lista
                resultado = misAplicaciones.get(i).getId();
            }
        return resultado + 1;
    
    }
    
    public int buscarApliIndice(int id){
        int resultado = -1;
        
        //copia de la lista de las cajas
        ArrayList<ObjAplicacion> miApli = almacen.listarAplicacion();
        //rrecotrer mi lista de cajas
        for (int i = 0; i < miApli.size(); i++) {
                if(miApli.get(i).getId() == id){
                    //extrae el ultimo id que hay en la lista
                    resultado = i;
                } 
                
            }
        return resultado;
    }
}
