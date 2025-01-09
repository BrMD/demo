package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JavaMailService {
    private final JavaMailSender envioEmailDoJava;

    public JavaMailService(JavaMailSender envioEmailDoJava) {
        this.envioEmailDoJava = envioEmailDoJava;
    }

    public void enviar(){
        log.info("enviando email para confimacao do cadastro");

        var mensagem = new SimpleMailMessage();
        mensagem.setFrom("dorigon.matheus8@gmail.com");
        mensagem.setTo("matheusdorigon1818@gmail.com");
        mensagem.setSubject("vindo do java spring");
        mensagem.setText("sim isso veio do java spring");
        envioEmailDoJava.send(mensagem);

        log.info("mandou");
    }
}
