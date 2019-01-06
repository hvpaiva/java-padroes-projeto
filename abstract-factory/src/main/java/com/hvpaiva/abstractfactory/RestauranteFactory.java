package com.hvpaiva.abstractfactory;

/**
 * Interface da Fábrica de Restaurante.
 *
 * Responsável pelo contrato de criação dos objetos
 * de restaurante: Prato, Decoracao e Musica.
 */
public interface RestauranteFactory {

	/**
	 * Cria um prato para o restaurante.
	 *
	 * @return O Prato
	 */
	Prato criarPrato();

	/**
	 * Cria uma decoração para o restaurante.
	 *
	 * @return A Decoracao
	 */
	Decoracao criarDecoracao();

	/**
	 * Cria uma musica para o restaurante.
	 *
	 * @return A Musica
	 */
	Musica criarMusica();

}
