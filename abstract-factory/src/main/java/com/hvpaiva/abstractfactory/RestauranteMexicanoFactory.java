package com.hvpaiva.abstractfactory;

/**
 * Implementação da Factory de Restaurante Mexicano.
 *
 * Retorna ao criar os objetos de Restaurante,
 * os objetos da mesma família, ou seja, os objetos da
 * família "Mexicana".
 */
public class RestauranteMexicanoFactory implements RestauranteFactory {

	@Override
	public Prato criarPrato() {
		return new PratoMexicano();
	}

	@Override
	public Decoracao criarDecoracao() {
		return new DecoracaoMexicana();
	}

	@Override
	public Musica criarMusica() {
		return new MusicaMexicana();
	}
}
