package mail;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	public static String OTP(int len) {
		String numbers = "0123456789";
		Random rndm_number = new Random();
		String otp="";
		for(int i=0 ;i<len; i++) {
			otp = otp + numbers.charAt(rndm_number.nextInt(numbers.length()));
		}
		return otp;
	}
	
	public static void sendMail(String recipient, String code) throws Exception {
		   System.out.println("Preparing to send mail");
		   Properties properties = new Properties();
		     
		   properties.put("mail.smtp.auth", "true");
		   properties.put("mail.smtp.starttls.enable", "true");
		   properties.put("mail.smtp.host", "smtp.gmail.com");
		   properties.put("mail.smtp.port", "587");
		     
		   String myEmail = "akash.ranjan1999@gmail.com";
		   String myPassword = "Github@2020";
		     
		   Session session = Session.getInstance(properties, new Authenticator() {
			   
			   @Override
			   protected PasswordAuthentication getPasswordAuthentication() {
				   return new PasswordAuthentication(myEmail, myPassword);
			   }
		   });
		     
		   Message message = prepareMessage(session, myEmail, recipient, code);
		   Transport.send(message);
		   System.out.println("Message sent syccessfully");
	   }
	   
	   private static Message prepareMessage(Session session, String myEmail, String recipient, String code) {
		   try {
			   Message message = new MimeMessage(session);
			   message.setFrom(new InternetAddress(myEmail));
			   message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			   message.setSubject("Verification Code for password reset");
			   message.setText(code);
			   return message;
		   } catch(Exception ex) {
			   Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
		   }
		   return null;
	   }
}
