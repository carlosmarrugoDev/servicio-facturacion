/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;
 
import compac.vista.principal.alertas.Alerta;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author jason
 */
public class EnviarCorreos {

    String usuarioCorreo;
    String password;

    String rutaArchivo;
    String nombreArchivo;

    String destinatario;
    String asunto;
    String mensaje;

    public EnviarCorreos(String usuarioCorreo, String password, String rutaArchivo, String nombreArchivo, String destinatario, String asunto, String mensaje) {
        this.usuarioCorreo = usuarioCorreo;
        this.password = password;
        this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public EnviarCorreos(String usuarioCorre, String password, String destinatario, String mensaje) {
        this(usuarioCorre, password, "", "", destinatario, "", mensaje);
    }

    public EnviarCorreos(String usuarioCorre, String password, String destinatario, String asunto, String mensaje) {
        this(usuarioCorre, password, "", "", destinatario, asunto, mensaje);
    }

   /* public boolean sendMail() {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            if (!rutaArchivo.equals("")) {
                adjunto.setDataHandler(
                      new DataHandler(new FileDataSource(rutaArchivo)));
                adjunto.setFileName(nombreArchivo);
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!rutaArchivo.equals("")) {
                multiParte.addBodyPart(adjunto);
            }
            try {

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(usuarioCorreo));
                message.addRecipient(
                        Message.RecipientType.TO,
                        new InternetAddress(destinatario));
                message.setSubject(asunto);
                message.setContent(multiParte);

                Transport t = session.getTransport("smtp");
                t.connect(usuarioCorreo, password);
                t.sendMessage(message, message.getAllRecipients());
                t.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Revise su conexion a Internet... " + e.getMessage(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            /// EXPORTAR A EXEL UNA ALERTA 
            Alerta alerta = new Alerta("Mensaje", "Envio de Correo Exitoso");
            alerta.setVisible(true);
            //////////////////////////////////
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }*/
    }

