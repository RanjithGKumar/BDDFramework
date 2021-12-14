package com.bdd.ExtentReport;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.bdd.fileReaderManager.FileReaderManager;

public class SendEmailReport extends ExtentReportConfig{
	
	String[] toIDs = {"g.ranjithkumar183@gmail.com","g.ranjith37@gmail.com"};
	String from ="g.ranjith37@gmail.com";
	String host="10.49.67.151";
	Properties properties=System.getProperties();
	Session session=Session.getDefaultInstance(properties);
	public void sendEmail() {
		properties.setProperty("mail.smtp.host", host);
		try {
			for(String to: toIDs) {
				MimeMessage message=new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				String subject=report.getFilePath();
				String[] reportPath=subject.split("/");
				String reportName=reportPath[reportPath.length-1];
				String environment=FileReaderManager.getFileReaderManagerInstance().getConfigInstance().getEnvironment();
				message.setSubject("Applicatio Name "+environment);
				BodyPart messageBodyPart=new MimeBodyPart();
				messageBodyPart.setText("Application Report");
				
				Multipart multiPart=new MimeMultipart();
				multiPart.addBodyPart(messageBodyPart);
				messageBodyPart=new MimeBodyPart();
				String fileName=report.getFilePath();
				DataSource source= new FileDataSource(fileName);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(reportName);
				multiPart.addBodyPart(messageBodyPart);
				message.setContent(multiPart);
				Transport.send(message);
				System.out.println("Report Emailed successfuly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
