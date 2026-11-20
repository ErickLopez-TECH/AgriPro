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
 * 
 * usuarios, cultivos
 */
public class ArchivosE {
    
    //constructor
    public ArchivosE(){
        
    }
    
    EstructuraUser almacen = new EstructuraUser();
    EstructuraCultivo almacenCulti = new EstructuraCultivo();
    EstructuraAgroquimico almacenAgro = new EstructuraAgroquimico();
    
    //mensaje de error
    public void aviso(IOException e){
        JOptionPane.showMessageDialog(null, e.toString(), "Atencion", JOptionPane.ERROR_MESSAGE);
    }
    
    //-------metodos con cualquier archivo (crear/Limpiar)-------
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
    
   //-------Método para escribir los usuarios en formato JSON-------
   
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
            
            // Bucle for  para recorrer cada objeto JSON encontrado
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
    
    
    //-------Método para escribir los cultivos en formato JSON-------
    
    public void escribeCultivos(){
        try {
            ArrayList<ObjCultivo> miLista = almacenCulti.listarCultivo();
            StringBuilder jsonContructor = new StringBuilder();
            
            jsonContructor.append("[\n");
            
            for (int i = 0; i < miLista.size(); i++) {
                ObjCultivo culti = miLista.get(i);
                
                jsonContructor.append("  {\n");
                jsonContructor.append("    \"id\": ").append(culti.getId()).append(",\n");
                jsonContructor.append("    \"NombreComercial\": \"").append(culti.getNombreComer()).append("\",\n");
                jsonContructor.append("    \"NombreCientifico\": \"").append(culti.getNombreCientifico()).append("\",\n");
                jsonContructor.append("    \"Estado\": ").append(culti.getEstado()).append("\n");
                
                //validamos pata saber si es el ultimo obj o hay mas para poner una coma o no
                if (i < miLista.size() - 1) {
                    jsonContructor.append("  },\n");
                }else{
                    jsonContructor.append("   }\n");
                }
            }
            
            jsonContructor.append("]");
            
            //escribimos
            FileWriter escritor = new FileWriter("Cultivos.json");
            escritor.write(jsonContructor.toString());
            escritor.close();
            
            System.out.println("CUltivo guardados exitosamente en JSON.");
        } catch (IOException e) {
            aviso(e);
        }
    }
 
    public void leerCultivos(){
        File archivo = new File("Cultivos.json");
        if (!archivo.exists()) {
            System.out.println("El archivo Cultivos.json no existe todavía.");
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
            
            if (textoJson.equals("[]") || textoJson.isEmpty()) {
                return;
            }
            
            // Quitamos el corchete inicial '[' y final ']'
            textoJson = textoJson.substring(1, textoJson.length() - 1);
            
            // Separamos cada objeto por las llaves {}
            String[] objetosJson = textoJson.split("\\},\\s*\\{");
            
            for (int i = 0; i < objetosJson.length; i++) {
                String objStr = objetosJson[i];
                
                // Limpiamos llaves y comillas sobrantes
                String limpio = objStr.replace("{", "").replace("}", "").replace("\"", "").trim();
                String[] pares = limpio.split(",");
                
                ObjCultivo culti = new ObjCultivo();
                
                for (int j = 0; j < pares.length; j++) {
                    String par = pares[j];
                    String[] partes = par.split(":");
                    
                    if (partes.length >= 2) {
                        String clave = partes[0].trim();
                        String valor = partes[1].trim();
                        
                        switch (clave) {
                            case "id":
                                culti.setId(Integer.parseInt(valor));
                                break;
                            
                            case "NombreComercial":
                                culti.setNombreComer(valor);
                                break;
                            
                            case "NombreCientifico":
                                culti.setNombreCientifico(valor);
                                break;
                              
                            case  "Estado": 
                                culti.setEstado(Integer.parseInt(valor));
                                break;
                        }
                    }
                }
                almacenCulti.agregarCultivo(culti);
            }
            System.out.println("Usuarios leídos correctamente desde JSON.");
        } catch (IOException e) {
            aviso(e);
        }
    }
    
    //-------Método para escribir los Agro Quimicos en formato JSON-------
    public void escribeAgroquimicos(){
        try {
            ArrayList<ObjAgroquimico> miLista = almacenAgro.listarAgroquimico();
            StringBuilder jsonConstructor = new StringBuilder();

            //Iniciamos el arreglo JSON
            jsonConstructor.append("[\n");

            for (int i = 0; i < miLista.size(); i++) {
                ObjAgroquimico agro = miLista.get(i);

                jsonConstructor.append("  {\n");
                jsonConstructor.append("    \"id\": ").append(agro.getId()).append(",\n");
                jsonConstructor.append("    \"NombreComercial\": \"").append(limpiarTexto(agro.getNombreComercial())).append("\",\n");
                jsonConstructor.append("    \"Reactivo\": \"").append(limpiarTexto(agro.getReactivo())).append("\",\n");
                jsonConstructor.append("    \"Presentacion\": \"").append(limpiarTexto(agro.getPresentacion())).append("\",\n");
                jsonConstructor.append("    \"DosisHectarea\": ").append(agro.getDosisHectarea()).append(",\n");
                jsonConstructor.append("    \"Tipo\": \"").append(limpiarTexto(agro.getTipo())).append("\",\n");
                jsonConstructor.append("    \"Estado\": ").append(agro.getEstado()).append("\n");

                //si no es el último objeto se pone coma al cerrar la llave
                if (i < miLista.size() - 1) {
                    jsonConstructor.append("  },\n");
                } else {
                    jsonConstructor.append("  }\n");
                }
            }

            //Cerramos el arreglo JSON
            jsonConstructor.append("]");

            //Escribimos todo el texto de una vez
            FileWriter escritor = new FileWriter("Agroquimicos.json");
            escritor.write(jsonConstructor.toString());
            escritor.close();

            System.out.println("Agroquimicos guardados exitosamente en JSON.");

        } catch (IOException e) {
            aviso(e);
        }
    }

    public void leerAgroquimicos(){
        File archivo = new File("Agroquimicos.json");
        if (!archivo.exists()) {
            System.out.println("El archivo Agroquimicos.json no existe todavía.");
            return;
        }

        try {
            FileReader miArchivo = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(miArchivo);

            //Se junta todo el archivo en un solo texto
            StringBuilder contenido = new StringBuilder();
            String linea = lector.readLine();
            while (linea != null) {
                contenido.append(linea.trim());
                linea = lector.readLine();
            }
            lector.close();

            //Cada objeto empieza donde aparece "id":, así que se parte el texto en esos puntos.
            //La posición 0 es lo que había antes del primer id (el corchete y la llave), se ignora.
            //Si el archivo está vacío o es "[]", el for no se ejecuta.
            String[] objetos = contenido.toString().split("\"id\":");

            for (int i = 1; i < objetos.length; i++) {
                String objeto = "\"id\":" + objetos[i];

                ObjAgroquimico agro = new ObjAgroquimico();
                agro.setId(Integer.parseInt(valorJson(objeto, "id")));
                agro.setNombreComercial(valorJson(objeto, "NombreComercial"));
                agro.setReactivo(valorJson(objeto, "Reactivo"));
                agro.setPresentacion(valorJson(objeto, "Presentacion"));
                agro.setDosisHectarea(Double.parseDouble(valorJson(objeto, "DosisHectarea")));
                agro.setTipo(valorJson(objeto, "Tipo"));
                agro.setEstado(Integer.parseInt(valorJson(objeto, "Estado")));

                almacenAgro.agregarAgroquimico(agro);
            }

            System.out.println("Agroquimicos leidos correctamente desde JSON.");

        } catch (IOException e) {
            aviso(e);
        }
    }

    //Busca una clave dentro del texto de un objeto JSON y devuelve su valor sin comillas.
    private String valorJson(String objeto, String clave){
        String buscar = "\"" + clave + "\":";
        int inicio = objeto.indexOf(buscar);
        if (inicio == -1){
            return "";
        }

        //el valor empieza justo después de los dos puntos
        String resto = objeto.substring(inicio + buscar.length()).trim();
        String valor = "";

        if (resto.startsWith("\"")){
            int fin = resto.indexOf("\"", 1);
            valor = resto.substring(1, fin);
        } else{
            int fin = resto.length();
            int coma = resto.indexOf(",");
            int llave = resto.indexOf("}");
            if (coma != -1 && coma < fin){
                fin = coma;
            }
            if (llave != -1 && llave < fin){
                fin = llave;
            }
            valor = resto.substring(0, fin).trim();
        }
        return valor;
    }

    //Cambia las comillas dobles por simples: una comilla doble dentro del texto
    //cerraría el valor del JSON antes de tiempo
    private String limpiarTexto(String texto){
        return texto.replace("\"", "'");
    }
    
}
