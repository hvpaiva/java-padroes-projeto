package com.hvpaiva.builder;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe com main.
 */
@Log
public final class App {

	/**
	 * Método main.
	 *
	 * @param args Os argumentos de inicialização
	 */
	public static void main(String[] args) {

		Sanduiche sandubaSemSalada = new Sanduiche.Builder(
				Tamanho.TRINTA_CENTIMETROS,
				CarneTipo.FRANGO,
				PaoTipo.QUATRO_QUEIJOS
		)
				.comQueijo(QueijoTipo.MUSSARELA)
				.build();

		log.info(sandubaSemSalada.toString());

		List<Extras> extras = new ArrayList<>();
		extras.add(Extras.CREAM_CHEESE);
		extras.add(Extras.BACON);

		List<Salada> saladas = new ArrayList<>();
		saladas.add(Salada.ALFACE);
		saladas.add(Salada.TOMATE);
		saladas.add(Salada.CEBOLA_ROXA);

		Sanduiche sandubaSimples = new Sanduiche.Builder(
				Tamanho.QUINZE_CENTIMETROS,
				CarneTipo.BOI,
				PaoTipo.TRADICIONAL
		)
				.comQueijo(QueijoTipo.PRATO)
				.comExtras(extras)
				.comSalada(saladas)
				.build();

		log.info(sandubaSimples.toString());
	}

	/**
	 * Para evitar instanciaçã.
	 */
	private App() {
	}
}
