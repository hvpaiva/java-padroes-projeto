package com.hvpaiva.factorymethod;

/**
 * Implementação do pizzaiolo que constrói pizzas normais.
 */
public class NormalPizzaiolo implements Pizzaiolo {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pizza criarPizza() {
		return new NormalPizza();
	}
}
