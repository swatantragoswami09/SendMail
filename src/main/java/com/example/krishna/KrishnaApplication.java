package com.example.krishna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class KrishnaApplication implements CommandLineRunner {

    @Value("${spring.mail.to}")
    private String to;

    @Autowired
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SpringApplication.run(KrishnaApplication.class, args);
        System.out.println("hello world");
    }
    @Override
    public void run(String... args) {

        System.out.println("Sending Email...");

        sendEmail();
        //sendEmailWithAttachment();

        System.out.println("Done");

    }
    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email by skg");

        javaMailSender.send(msg);

    }

}
