package com.api.controller;

import com.api.MailSender.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  26/10/2022
 */
@Controller
public class MailController {
    @Autowired
    public JavaMailSender mailSender;
    @ResponseBody
    @RequestMapping("/sendmail")
    public String sendEmail(@RequestParam(value = "toMail") String toMail){
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toMail);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");

        // Send Message!
        this.mailSender.send(message);

        return "Email Sent!";
    }
}
