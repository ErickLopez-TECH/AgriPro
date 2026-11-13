/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//-- bibliotecas para trabajar los archivos JSON 
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author triamus
 */
public class ArchivosE {
    
    //constructor
    public ArchivosE(){
        
    }
    
    EstructuraUser almacen = new EstructuraUser();
    
    //mensaje de error
    public void aviso(IOException e){
        JOptionPane.showMessageDialog(null, e.toString(), "Atencion", JOptionPane.ERROR_MESSAGE);
    }
    
    //-- metodos con cualquier archivo (crear/Limpiar)
    public void crearArchivos(String nombreArch){
        File miArchivo = new File(nombreArch + ".json");
        try {
            if (miArchivo.createNewFile()) {
                System.out.println("Archivo JSON Creado");
            } else {
                System.out.println("Archivo JSON ya existia");
            }
        } catch (IOException e) {
            aviso(e);
        }
    }
    
    public void limpiarArchivos(String nombreArch){
        try {
            PrintWriter escritor = new PrintWriter(nombreArch + ".json");
            escritor.print(""); // Deja el archivo limpio
            escritor.close();
            System.out.println("Archivo JSON Limpio");
        } catch (IOException e) {
            aviso(e);
        }
    }
    
   // Método para escribir los usuarios en formato JSON 
   
    public void escribeUsuarios(){
        
        try {
            ArrayList<ObjUsuario> miLista = almacen.listarUser();
            StringBuilder jsonContructor = new StringBuilder();
            
            // Iniciamos el arreglo JSON 
            jsonContructor.append("[\n");
            
            for (int i = 0; i < miLista.size(); i++) {
                ObjUsuario usu = miLista.get(i);
                
                jsonContructor.append("  {\n");
                jsonContructor.append("    \"id\": ").append(usu.getId()).append(",\n");
                jsonContructor.append("    \"Cedula\": \"").append(usu.getCedula()).append("\",\n");
                jsonContructor.append("    \"NombreCompleto\": \"").append(usu.getNombreCompleto()).append("\",\n");
                jsonContructor.append("    \"NombreUser\": \"").append(usu.getNombreUser()).append("\",\n");
                jsonContructor.append("    \"Clave\": \"").append(usu.getClave()).append("\",\n");
                jsonContructor.append("    \"Rol\": ").append(usu.getRol()).append(",\n");
                jsonContructor.append("    \"Estado\": ").append(usu.getEstado()).append("\n");
                
                // Si no es el último elemento, ponemos coma al cerrar la llave
                if (i < miLista.size() - 1) {
                    jsonContructor.append("  },\n");
                } else {
                    jsonContructor.append("  }\n");
                }
            }
            
            // Cerramos el arreglo JSON 
            jsonContructor.append("]");
            
            // Escribimos todo
            FileWriter escritor = new FileWriter("Usuarios.json");
            escritor.write(jsonContructor.toString());
            escritor.close();
            
            System.out.println("Usuarios guardados exitosamente en JSON.");
            
        } catch (IOException e) {
            aviso(e);
        }
    }
    
    
    public void leerUsuarios(){
        
        File archivo = new File("Usuarios.json");
        if (!archivo.exists()) {
            System.out.println("El archivo Usuarios.json no existe todavía.");
            return;
        }

        try {
            FileReader miArchivo = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(miArchivo);
            
            StringBuilder contenido = new StringBuilder();
            String linea = lector.readLine();
            
            while (linea != null) {                
                contenido.append(linea.trim());
                linea = lector.readLine();
            }
            lector.close();
            
            String textoJson = contenido.toString().trim();
            
            // Si está vacío o solo tiene "[]", salimos
            if (textoJson.equals("[]") || textoJson.isEmpty()) {
                return;
            }
            
            // Quitamos el corchete inicial '[' y final ']'
            textoJson = textoJson.substring(1, textoJson.length() - 1);
            
            // Separamos cada objeto por las llaves {}
            String[] objetosJson = textoJson.split("\\},\\s*\\{");
            
            // Bucle for tradicional para recorrer cada objeto JSON encontrado
            for (int i = 0; i < objetosJson.length; i++) {
                String objStr = objetosJson[i];
                
                // Limpiamos llaves y comillas sobrantes
                String limpio = objStr.replace("{", "").replace("}", "").replace("\"", "").trim();
                String[] pares = limpio.split(",");
                
                ObjUsuario usu = new ObjUsuario();
                
                
                for (int j = 0; j < pares.length; j++) {
                    String par = pares[j];
                    String[] partes = par.split(":");
                    
                    
                    if (partes.length >= 2) {
                        String clave = partes[0].trim();
                        String valor = partes[1].trim();
                        
                        switch (clave) {
                            case "id": 
                                usu.setId(Integer.parseInt(valor)); 
                                break;
                            case "Cedula": 
                                usu.setCedula(valor); 
                                break;
                            case "NombreCompleto": 
                                usu.setNombreCompleto(valor); 
                                break;
                            case "NombreUser": 
                                usu.setNombreUser(valor); 
                                break;
                            case "Clave": 
                                usu.setClave(valor); 
                                break;
                            case "Rol": 
                                usu.setRol(Integer.parseInt(valor)); 
                                break;
                            case "Estado": 
                                usu.setEstado(Integer.parseInt(valor)); 
                                break;
                        }
                    }
                }
                
                almacen.agregarUser(usu);
            }
            
            System.out.println("Usuarios leídos correctamente desde JSON.");
            
        } catch (IOException e) {
            aviso(e);
        }
    }
}
