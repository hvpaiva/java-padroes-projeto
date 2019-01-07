package com.hvpaiva.builder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SanduicheTest {

	@Test
	void testeTamanhoFaltando() {
		assertThrows(NullPointerException.class, () -> new Sanduiche.Builder(null, CarneTipo.BOI, PaoTipo.TRADICIONAL));
	}

	@Test
	void testeCarneFaltando() {
		assertThrows(NullPointerException.class, () -> new Sanduiche.Builder(Tamanho.QUINZE_CENTIMETROS, null, PaoTipo.TRADICIONAL));
	}

	@Test
	void testePaoFaltando() {
		assertThrows(NullPointerException.class, () -> new Sanduiche.Builder(Tamanho.QUINZE_CENTIMETROS, CarneTipo.FRANGO, null));
	}

	@Test
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
		assertEquals(CarneTipo.BOI, sanduiche.getCarne());
		assertEquals(PaoTipo.ITALIANO, sanduiche.getPao());
		assertEquals(QueijoTipo.PRATO, sanduiche.getQueijo());
		assertEquals(extras, sanduiche.getExtras());
		assertEquals(saladas, sanduiche.getSalada());
		assertEquals(molhos, sanduiche.getMolho());

		final Sanduiche sandubaSimples = new Sanduiche.Builder(
				Tamanho.QUINZE_CENTIMETROS,
				CarneTipo.FRANGO,
				PaoTipo.TRADICIONAL)
				.build();

		assertNotNull(sandubaSimples);
		assertNotNull(sandubaSimples.toString());
		assertEquals(Tamanho.QUINZE_CENTIMETROS, sandubaSimples.getTamanho());
		assertEquals(CarneTipo.FRANGO, sandubaSimples.getCarne());
		assertEquals(PaoTipo.TRADICIONAL, sandubaSimples.getPao());
		assertNull(sandubaSimples.getQueijo());
		assertNull(sandubaSimples.getSalada());
		assertNull(sandubaSimples.getMolho());
		assertNull(sandubaSimples.getExtras());
	}

	@Test
	void testeInvalidBuild() {

		assertThrows(IllegalArgumentException.class, () -> new Sanduiche.Builder(
				Tamanho.QUINZE_CENTIMETROS,
				CarneTipo.FRANGO,
				PaoTipo.TRADICIONAL)
				.comSalada(Collections.emptyList())
				.comExtras(Collections.emptyList())
				.comMolho(Collections.emptyList())
				.build());

		assertThrows(NullPointerException.class, () -> new Sanduiche.Builder(
				Tamanho.QUINZE_CENTIMETROS,
				CarneTipo.FRANGO,
				PaoTipo.TRADICIONAL)
				.comQueijo(null)
				.build());
	}

}
