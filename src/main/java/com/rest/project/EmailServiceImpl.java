package com.rest.project;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailServiceImpl{
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
    
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment, String fileName) {
    		    MimeMessage message = emailSender.createMimeMessage();
    		    try{
    		    	MimeMessageHelper helper = new MimeMessageHelper(message, true);
        		    helper.setTo(to);
        		    helper.setSubject(subject);
        		    helper.setText(text);
        		    FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        		    helper.addAttachment(fileName, file);
        		    emailSender.send(message);	
    		    }
    		    catch(Exception e){
    		    	System.out.println(e.getMessage());
    		    }
    		}
}