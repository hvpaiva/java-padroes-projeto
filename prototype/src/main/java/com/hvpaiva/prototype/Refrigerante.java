package com.hvpaiva.prototype;

/**
 * O refrigerante.
 */
class Refrigerante implements Bebida {

	private String nome;

	/**
	 * Construtor padrão.
	 *
	 * @param nome O nome do refrigerante
	 */
	Refrigerante(String nome) {
		this.nome = nome;
	}

	/**
	 * Construtor.
	 *
	 * @param refrigerante O refrigerante.
	 */
	Refrigerante(Refrigerante refrigerante) {
		this.nome = refrigerante.nome;
	}

	@Override
	public String toString() {
		return "Refrigerante " + nome;
	}

	@Override
	public Bebida copy() throws CloneNotSupportedException {
		return new Refrigerante(this);
	}
}
