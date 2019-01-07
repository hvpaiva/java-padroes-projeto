package com.hvpaiva.builder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SanduicheTest {

	@Test
	void testeTamanhoFaltando() {
		assertThrows(IllegalArgumentException.class, () -> new Sanduiche.Builder(null, CarneTipo.BOI, PaoTipo.TRADICIONAL));
	}

	@Test
	void testeCarneFaltando() {
		assertThrows(IllegalArgumentException.class, () -> new Sanduiche.Builder(Tamanho.QUINZE_CENTIMETROS, null, PaoTipo.TRADICIONAL));
	}

	@Test
	void testePaoFaltando() {
		assertThrows(IllegalArgumentException.class, () -> new Sanduiche.Builder(Tamanho.QUINZE_CENTIMETROS, CarneTipo.FRANGO, null));
	}

	void testeBuild() {

		final List<Extras> extras = new ArrayList<>();
		extras.add(Extras.BACON);

		final List<Salada> saladas = new ArrayList<>();
		saladas.add(Salada.ALFACE);
		saladas.add(Salada.CEBOLA);

		final List<Molho> molhos = new ArrayList<>();
		molhos.add(Molho.BARBECUE);
		molhos.add(Molho.KATCHUP);
		molhos.add(Molho.MAIONESE);
		molhos.add(Molho.MOSTARDA);

		final Sanduiche sanduiche = new Sanduiche.Builder(Tamanho.QUINZE_CENTIMETROS, CarneTipo.BOI, PaoTipo.ITALIANO)
				.comExtras(extras)
				.comQueijo(QueijoTipo.PRATO)
				.comSalada(saladas)
				.comMolho(molhos)
				.build();

		assertNotNull(sanduiche);
		assertNotNull(sanduiche.toString());
		assertEquals(Tamanho.QUINZE_CENTIMETROS, sanduiche.getTamanho());

	}
}
