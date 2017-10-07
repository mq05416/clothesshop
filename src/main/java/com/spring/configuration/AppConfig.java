package com.spring.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
//nguyen viet luan
@SuppressWarnings("deprecation")
@Configuration
@ComponentScan(basePackages = "com.spring")
public class AppConfig {

	// Put Other Application configuration here.

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		// Using gmail.
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("luannv.aptech2015@gmail.com");
		mailSender.setPassword("luangaabc");
		mailSender.setDefaultEncoding("UTF-8");

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");
		javaMailProperties.put("mail.mime.charset", "UTF-8");

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

	/*
	 * FreeMarker configuration.
	 */
	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/fmtemplates/");
		bean.setDefaultEncoding("UTF-8");
		return bean;
	}

	
	
}
