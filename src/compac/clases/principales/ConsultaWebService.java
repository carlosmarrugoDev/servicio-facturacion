/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;

import compac.vista.principal.alertas.AlertaError;
import java.io.IOException;
import javax.swing.JTextField;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author SERVIDOR
 */
public class ConsultaWebService {

    MediaType mediaType = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    public String consultarReniecDni(String nrodni, JTextField txtNombre) throws Exception {
        String valor = "";
        try {
            String response = post("https://apiperu.dev/api/dni/" + nrodni);

            if (response == null) {
                valor = "NO";
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(response);
                try {
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONObject data = (JSONObject) jsonObject.get("data");

                    String nombre_completo = (String) data.get("nombre_completo");
                    txtNombre.setText(nombre_completo.replace(",", ""));
                    valor = "SI";

                } catch (Exception e) {
                    valor = "NO";
                }
            }
        } catch (Exception e) {
            valor = "NO";
        }

        return valor;
    }

    public String consultarSunatruc(String nroruc, JTextField txtNombreR, JTextField txtdireccion) throws Exception {
        String valor = "";
        try {
            String response = post("https://apiperu.dev/api/ruc/" + nroruc);

            if (response == null) {
                valor = "NO";
            } else {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(response);
                try {
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONObject data = (JSONObject) jsonObject.get("data");

                    String estado = (String) data.get("estado");
                    String condicion = (String) data.get("condicion");

                    if (estado.equalsIgnoreCase("ACTIVO")) {
                        if (condicion.equalsIgnoreCase("HABIDO")) {

                            String nombre_o_razon_social = (String) data.get("nombre_o_razon_social");
                            String direccion_completa = (String) data.get("direccion_completa");
                            txtNombreR.setText(nombre_o_razon_social);
                            txtdireccion.setText(direccion_completa);
                            valor = "SI";

                        } else {
                            valor = "NO";
                            AlertaError alert = new AlertaError("Mensaje", "El RUC consultado se encuentra como NO HABIDO");
                            alert.setVisible(true);
                        }
                    } else {
                        valor = "NO";
                        AlertaError alert = new AlertaError("Mensaje", "El RUC consultado se encuentra INACTIVO");
                        alert.setVisible(true);
                    }

                } catch (Exception e) {
                    valor = "NO";
                }
            }
        } catch (Exception e) {
            valor = "NO";
        }

        return valor;

    }

    String post(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer bde393ec7a70c1e67f8711c7455ddf2f2ebf74df030d2fa543ba69d25300041e")
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
