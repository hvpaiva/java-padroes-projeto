package com.hvpaiva.prototype;

/**
 * A factory concreta de pedido.
 */
class Pedido implements PedidoFactory {

	private Lanche lanche;
	private Bebida bebida;

	/**
	 * Construtor de pedido.
	 *
	 * @param lanche O lanche
	 * @param bebida A bebida
	 */
	Pedido(Lanche lanche, Bebida bebida) {
		this.lanche = lanche;
		this.bebida = bebida;
	}

	@Override
	public Lanche criarLanche() {
		try {

			return lanche.copy();

		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public Bebida criarBebida() {
		try {

			return bebida.copy();

		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
