package org.rec.mso.core.configuration.mail;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.InputStream;
import java.io.IOException;

public class EmailSender {

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = EmailSender.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo properties.");
                return null;
            }
            properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        }
        return properties;
    }

    public static void enviarCorreo(String destinatario)  throws IOException {
        final String remitente = "kevinbastidas784@gmail.com";
        final String clave = "yvxs ygul xzfz dgqv"; // No es tu contraseña normal
        final String smtpHost = "smtp.gmail.com";

        Properties properties = loadProperties();

        if (properties == null) {
            System.out.println("Error al cargar las propiedades.");
            return;
        }


        String nombreClinica = properties.getProperty("nombre.clinica");
        String telefonoContacto = properties.getProperty("telefono.contacto");
        String correoContacto = properties.getProperty("correo.contacto");
        String nombreUsuario = properties.getProperty("nombre.usuario");


        final String asunto = "Confirmación de Cita Odontológica";
        final String cuerpo = "Estimado/a [Nombre del paciente],\n\n" +
                "Le recordamos que tiene una cita odontológica programada en nuestra clínica para el [fecha] a las [hora]. A continuación, le proporcionamos los detalles:\n\n" +
                "- Fecha de la cita: [Fecha de la cita]\n" +
                "- Hora: [Hora de la cita]\n" +
                "- Lugar: " + nombreClinica + "\n\n" +
                "Por favor, asegúrese de llegar unos minutos antes de la cita. Si no puede asistir, le pedimos que nos avise con al menos 24 horas de anticipación para reprogramar su cita.\n\n" +
                "Si tiene alguna pregunta o necesita más información, no dude en contactarnos al teléfono: " + telefonoContacto + " o por correo electrónico: " + correoContacto + ".\n\n" +
                "Gracias por elegirnos para su cuidado dental. ¡Esperamos verlo/a pronto!\n\n" +
                "Atentamente,\n" +
                nombreUsuario + "\n" +
                nombreClinica + "\n" +
                telefonoContacto + "\n" +
                correoContacto;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);
            System.out.println("✅ Correo enviado correctamente a " + destinatario);
        } catch (MessagingException e) {
            System.out.println("❌ Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
