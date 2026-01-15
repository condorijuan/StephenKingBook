package com.Juan.StephenKingBook;

import com.Juan.StephenKingBook.principal.Principal;
import com.Juan.StephenKingBook.repositorio.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StephenKingBookApplication implements ApplicationRunner {
    @Autowired
    private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(StephenKingBookApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Principal principal = new Principal(repository);
        principal.mostrarMenu();
    }
}
