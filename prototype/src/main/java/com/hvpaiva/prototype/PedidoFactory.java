package com.hvpaiva.prototype;

/**
 * Interface de fábrica de Pedido.
 */
public interface PedidoFactory {

	/**
	 * @return Cria um objeto Lanche
	 */
	Lanche criarLanche();

	/**
	 * @return Cria um objeto Bebida
	 */
	Bebida criarBebida();

}
