package com.hvpaiva.abstractfactory;

/**
 * Implementação da Factory de Restaurante Italiano.
 *
 * Retorna ao criar os objetos de Restaurante,
 * os objetos da mesma família, ou seja, os objetos da
 * família "Italiana".
 */
public class RestauranteItalianoFactory implements RestauranteFactory {

	@Override
	public Prato criarPrato() {
		return new PratoItaliano();
	}

	@Override
	public Decoracao criarDecoracao() {
		return new DecoracaoItaliana();
	}

	@Override
	public Musica criarMusica() {
		return new MusicaItaliana();
	}
}
