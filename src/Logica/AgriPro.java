/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;

import Datos.ArchivosE;
import Presentacion.FrmHome;

/**
 *git config user.name "Tu Nombre Específico"
git config user.email "correo-especifico-para-este-proyecto@dominio.com"
 * @author triamus
 */
public class AgriPro {

    /**
     * @param args the command line arguments
     */
    static ArchivosE arch = new ArchivosE();
    
    public static void crearArchivos(){
        arch.crearArchivos("Usuarios");
        
    }
    
    public static void llenarListas(){
        arch.leerUsuarios();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        crearArchivos();
        llenarListas();
        FrmHome miVentana = new FrmHome();
        miVentana.setLocale(null);
        miVentana.setVisible(true);
    }
    
}
