package com.hvpaiva.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RestauranteFactoryMakerTest {

	@Test
	void deveDarErroAoCriarUmTipoInexistente() {
		assertThrows(IllegalArgumentException.class, () -> RestauranteFactoryMaker.makeFactory(RestauranteType.UNKNOWN));
	}
}
