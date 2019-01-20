package com.hvpaiva.factorymethod;

/**
 * Implementação do Pizzaiolo que contrói pizzas veganas.
 */
public class VeganPizzaiolo implements Pizzaiolo {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pizza criarPizza() {
		return new VeganPizza();
	}
}
