package com.hvpaiva.prototype;

/**
 * A pizza.
 */
class Pizza implements Lanche {

	private String nome;

	/**
	 * Construtor padrão.
	 *
	 * @param nome O nome da pizza
	 */
	Pizza(String nome) {
		this.nome = nome;
	}

	/**
	 * Construtor.
	 * Recebe uma pizza pronta, no qual buscará o nome.
	 *
	 * @param pizza A pizza
	 */
	Pizza(Pizza pizza) {
		this.nome = pizza.nome;
	}

	@Override
	public Lanche copy() throws CloneNotSupportedException {
		return new Pizza(this);
	}

	@Override
	public String toString() {
		return "Pizza " + nome;
	}
}
