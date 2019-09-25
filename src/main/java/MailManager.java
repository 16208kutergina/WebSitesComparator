import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


public class MailManager {

    public static void sendMessage(String subject,
                                   String message,
                                   String  ... recipient) {
        try {
            final Properties properties = loadProperties();
            String emailSender = (String) properties.get("mail.smtps.login");
            String password = (String) properties.get("mail.smtps.password");
            Session session = Session.getDefaultInstance(properties);
            MimeMessage mimeMessage = new MimeMessage(session);
            buildMimeMessage(mimeMessage, subject, message, emailSender, recipient);
            Transport transport = session.getTransport();
            transport.connect(emailSender, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (IOException | MessagingException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buildMimeMessage(MimeMessage mimeMessage, String subject, String message, String emailSender, String[] recipient) throws MessagingException {
        mimeMessage.setFrom(new InternetAddress(emailSender));
        for (String s : recipient) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
        }
        mimeMessage.setSubject(subject);
        mimeMessage.setText(message);
    }

    private static Properties loadProperties() throws IOException {
        final Properties properties = new Properties();
        properties.load(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("resources/../mail.properties")));
        return properties;
    }

}
