package com.hvpaiva.factorymethod;

/**
 * Implementação da pizzza normal.
 */
public class NormalPizza implements Pizza {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String tipoPizza() {
		return "Pizza normal!";
	}
}
