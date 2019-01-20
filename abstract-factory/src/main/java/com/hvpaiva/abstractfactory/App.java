package com.hvpaiva.abstractfactory;

import lombok.extern.java.Log;

/**
 * Classe principal da aplicação.
 */
@Log
public class App {

	private Prato prato;
	private Decoracao decoracao;
	private Musica musica;

	/**
	 * Cria os objetos do restaurante.
	 *
	 * @param factory A fabrica de tal restaurante
	 */
	void criarRestaurante(RestauranteFactory factory) {
		prato = factory.criarPrato();
		decoracao = factory.criarDecoracao();
		musica = factory.criarMusica();
	}

	/**
	 * Método getter.
	 *
	 * @return Retorna o Prato
	 */
	Prato getPrato() {
		return prato;
	}

	/**
	 * Método getter.
	 *
	 * @return Retorna a Decoracao
	 */
	Decoracao getDecoracao() {
		return decoracao;
	}

	/**
	 * Método getter.
	 *
	 * @return Retorna a música
	 */
	Musica getMusica() {
		return musica;
	}

	/**
	 * Método MAIN.
	 *
	 * @param args Os argumentos de inicialização
	 */
	public static void main(String[] args) {

		App app = new App();

		log.info("Restaurante Italiano");
		app.criarRestaurante(RestauranteFactoryMaker.makeFactory(RestauranteType.ITALIANO));
		log.info(app.getPrato().descricao());
		log.info(app.getDecoracao().descricao());
		log.info(app.getMusica().descricao());

		log.info("Restaurante Mexicano");
		app.criarRestaurante(RestauranteFactoryMaker.makeFactory(RestauranteType.MEXICANO));
		log.info(app.getPrato().descricao());
		log.info(app.getDecoracao().descricao());
		log.info(app.getMusica().descricao());
	}
}
