
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Mail{
    public static void SendMess(String to,String sub,String content){
        String from = "TestPtProiect@gmail.com";
        String host = "localhost";
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");    
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        Session s = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("TestPtProiect@gmail.com","Pr01ectTeSt");
            }
        });
        try{
            MimeMessage m= new MimeMessage(s);
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            m.setSubject(sub);
            m.setText(content);
            Transport.send(m);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Adresa de email nu este valida!");
        }
    
    
    };
}
