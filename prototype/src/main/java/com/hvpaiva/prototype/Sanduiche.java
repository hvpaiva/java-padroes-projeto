package com.hvpaiva.prototype;

/**
 * O sanduíche.
 */
class Sanduiche implements Lanche {

	private String nome;

	/**
	 * Construtor padrão.
	 *
	 * @param nome O nome do sanduíche.
	 */
	Sanduiche(String nome) {
		this.nome = nome;
	}

	/**
	 * Construtor.
	 * Recebe um sanduíche pronto, no qual buscará o nome.
	 *
	 * @param sanduiche O sanduíche
	 */
	Sanduiche(Sanduiche sanduiche) {
		this.nome = sanduiche.nome;
	}

	@Override
	public Lanche copy() throws CloneNotSupportedException {
		return new Sanduiche(this);
	}

	@Override
	public String toString() {
		return "Sanduíche " + nome;
	}
}
