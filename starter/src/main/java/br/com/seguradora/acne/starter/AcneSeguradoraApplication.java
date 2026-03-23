package br.com.seguradora.acne.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"br.com.seguradora.acne.*"})
@EnableFeignClients(basePackages = "br.com.seguradora.acne.*" )
public class AcneSeguradoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcneSeguradoraApplication.class, args);
    }
}
