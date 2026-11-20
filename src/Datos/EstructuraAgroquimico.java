/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jdavi
 */
public class EstructuraAgroquimico {
    //ArrayList de almacenamiento (static: es la misma lista para todas las ventanas)
    static ArrayList<ObjAgroquimico> listaAgroquimicos = new ArrayList<>();

    //Constructor
    public EstructuraAgroquimico() {
    }

    //------------------------------------------Métodos de Trabajo (CRUD)------------------------------------------//
    //Insertar
    public void agregarAgroquimico(ObjAgroquimico miAgroquimico){
        listaAgroquimicos.add(miAgroquimico);
    }

    //Modificar
    public void editarAgroquimico(int indice, ObjAgroquimico miAgroquimico){
        listaAgroquimicos.set(indice, miAgroquimico);
    }

    //Borrar
    public void quitarAgroquimico(int indice){
        listaAgroquimicos.remove(indice);
    }

    //Mostrar (la lista): devuelve una copia para no modificar la original por accidente
    public ArrayList<ObjAgroquimico> listarAgroquimico(){
        return new ArrayList<>(listaAgroquimicos);
    }

    //Arma el modelo de la tabla con valores legibles
    public DefaultTableModel mostrarAgroquimico(){
        String[] titulos = {"Identificación", "Nombre Comercial", "Reactivo", "Presentación", "Dosis por Hectárea", "Tipo", "Estado"};

        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

        for (int i = 0; i < listaAgroquimicos.size(); i++){
            //cambiar el estado de número a texto
            String estado = "";
            if (listaAgroquimicos.get(i).getEstado() == 0){
                estado = "Inactivo";
            } else{
                estado = "Activo";
            }

            String[] fila = {
                String.valueOf(listaAgroquimicos.get(i).getId()),
                listaAgroquimicos.get(i).getNombreComercial(),
                listaAgroquimicos.get(i).getReactivo(),
                listaAgroquimicos.get(i).getPresentacion(),
                String.valueOf(listaAgroquimicos.get(i).getDosisHectarea()),
                listaAgroquimicos.get(i).getTipo(),
                estado
            };
            modelo.addRow(fila);
        }
        return modelo;
    }
}
