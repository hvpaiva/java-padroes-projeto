package com.hvpaiva.abstractfactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractFactoryTest {

	private App app;

	private RestauranteFactory italianoFactory;
	private RestauranteFactory mexicanoFactory;

	@BeforeEach
	void setUp() {
		italianoFactory = RestauranteFactoryMaker.makeFactory(RestauranteType.ITALIANO);
		mexicanoFactory = RestauranteFactoryMaker.makeFactory(RestauranteType.MEXICANO);
		app = new App();
	}

	@AfterEach
	void cleanUp() {
		app = null;
	}

	@Test
	void deveRetornarUmPratoItaliano() {
		app.criarRestaurante(italianoFactory);
		final Prato prato = app.getPrato();

		assertTrue(prato instanceof PratoItaliano);
		assertEquals(PratoItaliano.DESCRICAO, prato.descricao());
	}

	@Test
	void deveRetornarUmPratoMexicano() {
		app.criarRestaurante(mexicanoFactory);
		final Prato prato = app.getPrato();

		assertTrue(prato instanceof PratoMexicano);
		assertEquals(PratoMexicano.DESCRICAO, prato.descricao());
	}

	@Test
	void deveRetornarUmaDecoracaoItaliana() {
		app.criarRestaurante(italianoFactory);
		final Decoracao decoracao = app.getDecoracao();

		assertTrue(decoracao instanceof DecoracaoItaliana);
		assertEquals(DecoracaoItaliana.DESCRICAO, decoracao.descricao());
	}

	@Test
	void deveRetornarUmaDecoracaoMexicana() {
		app.criarRestaurante(mexicanoFactory);
		final Decoracao decoracao = app.getDecoracao();

		assertTrue(decoracao instanceof DecoracaoMexicana);
		assertEquals(DecoracaoMexicana.DESCRICAO, decoracao.descricao());
	}

	@Test
	void deveRetornarUmaMusicaItaliana() {
		app.criarRestaurante(italianoFactory);
		final Musica musica = app.getMusica();

		assertTrue(musica instanceof MusicaItaliana);
		assertEquals(MusicaItaliana.DESCRICAO, musica.descricao());
	}

	@Test
	void deveRetornarUmaMusicaMexicana() {
		app.criarRestaurante(mexicanoFactory);
		final Musica musica = app.getMusica();

		assertTrue(musica instanceof MusicaMexicana);
		assertEquals(MusicaMexicana.DESCRICAO, musica.descricao());
	}

}
