package ar.nic.remedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "ar.nic.remedy"
})
public class RemedyApplication {
    public static void main(String[] args) {
        SpringApplication.run(RemedyApplication.class, args);
    }
}
