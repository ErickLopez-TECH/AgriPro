/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.EstructuraCultivo;
import Datos.ObjCultivo;
import java.util.ArrayList;

/**
 *
 * @author alvar
 */
public class MetodosCultivo {

    private EstructuraCultivo almacen = new EstructuraCultivo();

    //--Id correspondiente
    public int siguienteCultivo() {
        int resultado = 0;
        ArrayList<ObjCultivo> misCultivos = almacen.listarCultivo();
        for (int i = 0; i < misCultivos.size(); i++) {
            resultado = misCultivos.get(i).getId();
        }
        return resultado + 1;
    }

    //--Donde está el cultivo
    public int buscarCultivo(int buscar) {
        int resultado = -1;
        ArrayList<ObjCultivo> misCultivos = almacen.listarCultivo();
        for (int i = 0; i < misCultivos.size(); i++) {
            if (misCultivos.get(i).getId() == buscar) {
                resultado = i;
            }
        }
        return resultado;
    }

    //--Devuelve el Obj completo
    public ObjCultivo buscarObjCultivo(int buscar) {
        ObjCultivo resultado = null;
        ArrayList<ObjCultivo> misCultivos = almacen.listarCultivo();
        for (int i = 0; i < misCultivos.size(); i++) {
            if (misCultivos.get(i).getId() == buscar) {
                resultado = misCultivos.get(i);
            }
        }
        return resultado;
    }

    //--Devuelve solo cultivos Activos estado 1
    //-- otras ventanas (ej. Lotes) no se pueda elegir un cultivo Inactivo
    public ArrayList<ObjCultivo> listarCultivosActivos() {
        ArrayList<ObjCultivo> activos = new ArrayList<>();
        ArrayList<ObjCultivo> misCultivos = almacen.listarCultivo();
        for (int i = 0; i < misCultivos.size(); i++) {
            if (misCultivos.get(i).getEstado() == 1) {
                activos.add(misCultivos.get(i));
            }
        }
        return activos;
    }
}
