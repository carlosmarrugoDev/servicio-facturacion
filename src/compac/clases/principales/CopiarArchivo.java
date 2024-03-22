package compac.clases.principales;
import java.io.*;
/**
 * @author IngenieroLuisTafurgm
 */
public class CopiarArchivo {
    /**
     * Instancia de la clase CopiarArchivo
     */
    private static CopiarArchivo copiarArchivo;
    /**
     * Constructor de la clase. Inicializa la instancia
     */
    private CopiarArchivo(){
      
    }
    /*Método que permite obtener una instancia de la clase CopiarArchivo
     * @return  */
    public static CopiarArchivo getInstance(){
        if(copiarArchivo == null){
            copiarArchivo = new CopiarArchivo();
        }
        return copiarArchivo;
    }   

    public boolean copiar(String origen, String destino){
        File archivoOrigen;
        File archivoDestino;
        FileInputStream in = null;
        FileOutputStream out = null;
        boolean b;
        try{
            archivoOrigen = new File(origen);
            archivoDestino = new File(destino);
            //Validamos que el archivo de origen exista. En caso de que no exista saldremos del método
            if(b = archivoOrigen.exists()) {
                // Validamos que el archivo de origen se pueda leer
                if(b = archivoOrigen.canRead()) {
                    //Creamos el lector y el escritor
                    in = new FileInputStream(archivoOrigen);
                    out = new FileOutputStream(archivoDestino);
                    // Mientras se lee de un lado por otro lado se escribe
                    int c;
                    while( (c = in.read() ) != -1) {
                        out.write(c);
                    }
                }
            }
        } catch(IOException ex){
            ex.printStackTrace(System.out);
            b = false;
        } finally {
            try{
                if(in != null) {
                    in.close();
                }
                if(out != null) {
                    out.close();
                }
            } catch(IOException ex) {
                ex.printStackTrace(System.out);
                b = false;
            }
        }
        return b;
    }
}