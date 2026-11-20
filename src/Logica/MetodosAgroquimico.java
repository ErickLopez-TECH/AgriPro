/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.EstructuraAgroquimico;
import Datos.ObjAgroquimico;
import java.util.ArrayList;

/**
 *
 * @author jdavi
 */
public class MetodosAgroquimico {
    EstructuraAgroquimico almacen = new EstructuraAgroquimico();

    //funcion para obtener el id del agroquímico de manera automática
    public int siguienteAgroquimico(){
        int resultado = 0;
        ArrayList<ObjAgroquimico> misAgros = almacen.listarAgroquimico();
        for (int i = 0; i < misAgros.size(); i++){
            //extrae el último id que hay en la lista
            resultado = misAgros.get(i).getId();
        }
        return resultado + 1;
    }

    //busca por id y devuelve la POSICIÓN en la lista (-1 si no existe). Sirve para editar y quitar
    public int buscarAgroquimico(int buscar){
        int resultado = -1;
        ArrayList<ObjAgroquimico> misAgros = almacen.listarAgroquimico();
        for (int i = 0; i < misAgros.size(); i++){
            if (misAgros.get(i).getId() == buscar){
                resultado = i;
                break;
            }
        }
        return resultado;
    }

    //busca por id y devuelve el OBJETO (null si no existe)
    public ObjAgroquimico buscarObjAgroquimico(int buscar){
        ObjAgroquimico miAgro = null;
        ArrayList<ObjAgroquimico> misAgros = almacen.listarAgroquimico();
        for (int i = 0; i < misAgros.size(); i++){
            if (misAgros.get(i).getId() == buscar){
                miAgro = misAgros.get(i);
                break;
            }
        }
        return miAgro;
    }

    //devuelve solo los agroquímicos Activos. los únicos que se pueden elegir en otras ventanas
    public ArrayList<ObjAgroquimico> listarAgroquimicosActivos(){
        ArrayList<ObjAgroquimico> activos = new ArrayList<>();
        ArrayList<ObjAgroquimico> misAgros = almacen.listarAgroquimico();
        for (int i = 0; i < misAgros.size(); i++){
            if (misAgros.get(i).getEstado() == 1){
                activos.add(misAgros.get(i));
            }
        }
        return activos;
    }

    //Valida los datos digitados: devuelve "" si todo está bien, o el mensaje del primer error encontrado
    public String validarAgroquimico(String nombre, String reactivo, String presentacion, String dosis, String tipo){
        String error = "";
        if (nombre.equals("")){
            error = "Digite el nombre comercial";
        } else if (reactivo.equals("")){
            error = "Digite el reactivo";
        } else if (presentacion.equals("")){
            error = "Digite la presentación (ml, gramos u otra)";
        } else if (dosis.equals("")){
            error = "Digite la dosis recomendada por hectárea";
        } else if (!dosisValida(dosis)){
            error = "La dosis debe ser un número mayor que cero (use punto decimal, ej: 2.5)";
        } else if (!(tipo.equals("Herbicidas") || tipo.equals("Fungicidas") || tipo.equals("Insecticidas")
                || tipo.equals("Bactericidas") || tipo.equals("Fertilizante Foliar"))){
            error = "Seleccione un tipo válido";
        }
        return error;
    }

    //revisa que el texto sea un número mayor que cero
    private boolean dosisValida(String dosis){
        boolean valida = false;
        try {
            double valor = Double.parseDouble(dosis);
            if (valor > 0){
                valida = true;
            }
        } catch (NumberFormatException ex){
            valida = false;
        }
        return valida;
    }

    //revisa si ya existe OTRO agroquímico con ese nombre comercial (se ignora el mismo id, para poder modificar)
    public boolean nombreDuplicado(String nombre, int id){
        boolean duplicado = false;
        ArrayList<ObjAgroquimico> misAgros = almacen.listarAgroquimico();
        for (int i = 0; i < misAgros.size(); i++){
            if (misAgros.get(i).getNombreComercial().equals(nombre) && misAgros.get(i).getId() != id){
                duplicado = true;
                break;
            }
        }
        return duplicado;
    }
}
