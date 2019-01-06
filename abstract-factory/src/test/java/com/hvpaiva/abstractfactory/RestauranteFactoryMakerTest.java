package com.hvpaiva.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestauranteFactoryMakerTest {

	@Test
	void deveDarErroAoCriarUmTipoInexistente() {
		try {
			RestauranteFactoryMaker.makeFactory(com.hvpaiva.abstractfactory.RestauranteType.UNKNOWN);
		} catch (IllegalArgumentException e) {
			assertEquals("Tipo de restaurante não suportado!", e.getMessage());
		}

	}
}
