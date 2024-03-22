/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author LuisT
 */
public class CopiarCarpetas {

    public static void copiar_archivos(File original, File copia) {
        try {
            InputStream entrada = new FileInputStream(original);
            OutputStream salida = new FileOutputStream(copia);

            byte[] buffer = new byte[1024];
            int datos;
            while ((datos = entrada.read(buffer)) > 0) {
                salida.write(buffer, 0, datos);
            }
            entrada.close();
            salida.close();
            System.out.println("copiando: " + original.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copiar_directorios(File original, File copia) {
        if (original.isDirectory()) {
            if (!copia.isDirectory()) {
                copia.mkdir();
                System.out.println("creando directorio: " + copia.toString());
            }
            String[] archivos = original.list();
            for (int i = 0; i < archivos.length; i++) {
                copiar_directorios(new File(original, archivos[i]), new File(copia, archivos[i]));
            }
        }else{
            copiar_archivos(original, copia);
        }
    }
}
