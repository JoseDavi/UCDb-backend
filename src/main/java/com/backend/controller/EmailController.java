package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe que controla o envio de email de confirmacao de cadastro para o usuario que se cadastrou.
 * 
 * @author jd-davi
 *
 */
@RestController
public class EmailController {

    @Autowired private JavaMailSender mailSender;

    /**
     * Envia um email de confimacao para o email recebido.
     * 
     * @param email: email do usuario cadastrado.
     * @return 
     */
    @RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Cadastro ucdbufcgpsoft");
        message.setText("Bem Vindo ao ucdbufcgpsoft");
        message.setTo(email);
        message.setFrom("jose.davi.souza@ccc.ufcg.edu.br");

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}
