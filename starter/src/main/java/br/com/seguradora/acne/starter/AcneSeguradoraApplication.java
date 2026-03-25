package br.com.seguradora.acne.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("br.com.seguradora.acne.*")
@EnableJpaRepositories("br.com.seguradora.acne.*")
@SpringBootApplication(scanBasePackages = "br.com.seguradora.acne.*")
@EnableFeignClients(basePackages = "br.com.seguradora.acne.*" )
public class AcneSeguradoraApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcneSeguradoraApplication.class, args);
    }
}
