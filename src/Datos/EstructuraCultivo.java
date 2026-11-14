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
public class EstructuraCultivo {
    static ArrayList<ObjCultivo> listaCultivos = new ArrayList<>();
    
    /*----------------------------------------------------------
    |              Metodos de trabajo de cultivos     |
    |                                                         |
    ----------------------------------------------------------*/
    public void agregarCultivo(ObjCultivo miCultivo){
        listaCultivos.add(miCultivo);
    }
    
    //modificar culti
    public void editarCultivo(int indice, ObjCultivo miCultivo){
        listaCultivos.set(indice, miCultivo);
    }
    
    //eliminar
    public void quitarzCultivo(int indece){
        listaCultivos.remove(indece);
    }
    
    
    //devilver lista
    public static ArrayList<ObjCultivo> listarCultivo() {
        return new ArrayList<>(listaCultivos);
    }
    
    public DefaultTableModel mostrarCultivo(){
        String[] titulo = {"Identificacion","Nombre Comercial","Nombre Cientifico","Estado"};
        
        DefaultTableModel modelo = new DefaultTableModel(titulo,0);
        
        for (int i = 0; i < listaCultivos.size(); i++) {
            
            //cambiar estado de numero a string
            String estado = "";
            if(listaCultivos.get(i).getEstado() == 0){
                estado = "Inactivo";
            }else{
                estado = "Activo";
            }
            
            String[] fila = {
                String.valueOf(listaCultivos.get(i).getId()),
                listaCultivos.get(i).getNombreComer(),
                listaCultivos.get(i).getNombreCientifico(),
                estado
            };
            
             modelo.addRow(fila);
        }
        return modelo;
    }
}
