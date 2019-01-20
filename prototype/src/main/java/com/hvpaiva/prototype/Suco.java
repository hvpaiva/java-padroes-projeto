package com.hvpaiva.prototype;

/**
 * O suco.
 */
class Suco implements Bebida {

	private String sabor;

	/**
	 * Construtor padrão.
	 *
	 * @param sabor O sabor do suco
	 */
	Suco(String sabor) {
		this.sabor = sabor;
	}

	/**
	 * Construtor.
	 *
	 * @param suco O objeto suco
	 */
	Suco(Suco suco) {
		this.sabor = suco.sabor;
	}

	@Override
	public Bebida copy() throws CloneNotSupportedException {
		return new Suco(this);
	}

	@Override
	public String toString() {
		return "Suco de " + sabor;
	}
}
