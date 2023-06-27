package com.gestorfinancas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestorfinancasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorfinancasApplication.class, args);


		TipoConta corrente = TipoConta.CORRENTE;
		corrente.getType();

		TipoConta poupanca = TipoConta.POUPANCA;
		poupanca.getType();
	}

}
