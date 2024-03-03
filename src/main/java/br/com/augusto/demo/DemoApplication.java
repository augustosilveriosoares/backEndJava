package br.com.augusto.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.*;import br.com.augusto.domain.Cliente;
import br.com.augusto.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.augusto.repository")
@EntityScan("br.com.augusto.*")  
@ComponentScan(basePackages = "br.com.augusto.*")
public class DemoApplication implements CommandLineRunner  {
	

	

private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

@Autowired
private IClienteRepository repository;

public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
	
}

@Override
public void run(String... args) throws Exception {
	log.info("StartApplication...");
	Cliente cliente = createCliente();
	repository.save(cliente);
}

private Cliente createCliente() {
	Cliente cli =  new Cliente();
	return Cliente.builder()
			.cidade("SP")
			.cpf(12312312310L)
			.email("Teste@teste.com")
			.end("End")
			.estado("SP")
			.nome("Teste Spring Boot")
			.numero(102030)
			.tel(10203040L)
			.build();
}
}
