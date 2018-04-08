package br.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"br.com.controller","br.com.service"})
@SpringBootApplication(scanBasePackages={
	"br.com.repository.ClienteRepository",
	
})
public class SpringAngularJsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularJsApplication.class, args);
	}
}
