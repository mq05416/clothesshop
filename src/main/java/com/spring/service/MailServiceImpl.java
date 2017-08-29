package com.spring.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.spring.model.Order;
import com.spring.model.Orderdetail;

import freemarker.template.Configuration;

@SuppressWarnings("deprecation")
@Service("mailService")
public class MailServiceImpl implements MailService{

	@Autowired
	JavaMailSender mailSender;
	
	
	
	@Autowired
	Configuration freemarkerConfiguration;
	

	@Override
	public void sendEmail(Object object1) {
		
		

		
		/*Orderdetail orderdetail = (Orderdetail) object1;*/
		Set<Orderdetail> orderdetails = new HashSet<>();
		orderdetails = (Set<Orderdetail>) object1;
		
		
		
		
		// soan noi dung, subject, from, to
		MimeMessagePreparator preparator = getMessagePreparator(orderdetails);
		
		
		// tien hanh gui di
		try {
			
            mailSender.send(preparator);
            System.out.println("Message has been sent.............................");
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
	}

	private MimeMessagePreparator getMessagePreparator(final Set<Orderdetail> orderdetails){
		
		// buoc nay soan noi dung de gui di, cung nhu la cac subject, from, to
		// noi dung duoc lay tu mau template
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				
				
            	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
 
               	helper.setSubject("Order Confirm Information");
               	/*helper.setFrom("customerserivces@yourshop.com");*/
               	helper.setFrom("luannv.aptech2015@gmail.com");
               	/*helper.setTo(orderdetail.getOrder().getUser().getEmail());*/
               	helper.setTo(orderdetails.iterator().next().getOrder().getUser().getEmail());
     
               	Map<String, Object> model = new HashMap<String, Object>();
                
                model.put("orderdetails", orderdetails);
                
            	String text = geFreeMarkerTemplateContent(model);
                System.out.println("Template content : "+text);

                // use the true flag to indicate you need a multipart message
            	helper.setText(text, true);

            	//Additionally, let's add a resource as an attachment as well.
            	/*helper.addAttachment("cutie.png", new ClassPathResource("linux-icon.png"));*/

            }
        };
        return preparator;
	}
	
	
	


	public String geFreeMarkerTemplateContent(Map<String, Object> model){
		StringBuffer content = new StringBuffer();
		try{
         content.append(FreeMarkerTemplateUtils.processTemplateIntoString( 
        		 freemarkerConfiguration.getTemplate("fm_mailTemplate.ftl"),model));
         return content.toString();
		}catch(Exception e){
			System.out.println("Exception occured while processing fmtemplate:"+e.getMessage());
		}
	      return "";
	}



}
