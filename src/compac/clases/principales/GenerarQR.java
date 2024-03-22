/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author IngenieroLuisTafurgm
 */
public class GenerarQR {

    public void generarCodigoQR(String rutaQR, String texto) {

        try {
            int qrTamAncho = 400;
            int qrTamAlto = 400;
            String formato = "png";
            String ruta = rutaQR;

            BitMatrix matriz;
            Writer writer = new QRCodeWriter();
            try {
                matriz = writer.encode(texto, BarcodeFormat.QR_CODE, qrTamAncho, qrTamAlto);
            } catch (WriterException e) {
                e.printStackTrace(System.err);
                return;
            }
            BufferedImage imagen = new BufferedImage(qrTamAncho,
                    qrTamAlto, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < qrTamAlto; y++) {
                for (int x = 0; x < qrTamAncho; x++) {
                    int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
                    imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
                }
            }
            FileOutputStream qrCode = new FileOutputStream(ruta);
            ImageIO.write(imagen, formato, qrCode);
            qrCode.close();
        } catch (IOException ex) {
            Logger.getLogger(GenerarQR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
