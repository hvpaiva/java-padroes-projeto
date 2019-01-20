package com.hvpaiva.prototype;

import lombok.extern.java.Log;

/**
 * Neste exemplo, temos uma classe Factory {@link Pedido} produzindo ofjetos por
 * meio de clones de outros existentes. Os objetos protótipos da fábrica são dados
 * como parâmetros construtores.
 */
@Log
final class App {

	/**
	 * Construtor privado.
	 */
	private App() {
	}

	/**
	 * Main.
	 *
	 * @param args Argumentos do programa.
	 */
	public static void main(String[] args) {
		PedidoFactory pedido;

		Lanche lanche;
		Bebida bebida;

		// Criar objetos de lanche a partir do clone do pedido
		pedido = new Pedido(new Pizza("Calabreza"), new Suco("Laranja"));

		lanche = pedido.criarLanche();
		bebida = pedido.criarBebida();

		log.info(lanche.toString()); // Pizza Calabreza
		log.info(bebida.toString()); // Suco de Laranja

		// Criar objetos de lanche a partir do clone do pedido
		pedido = new Pedido(new Sanduiche("X-Bacon"), new Refrigerante("Fanta Laranja"));

		lanche = pedido.criarLanche();
		bebida = pedido.criarBebida();

		log.info(lanche.toString()); // Sanduíche X-Bacon
		log.info(bebida.toString()); // Refrigerante Fanta Laranja

	}

}
