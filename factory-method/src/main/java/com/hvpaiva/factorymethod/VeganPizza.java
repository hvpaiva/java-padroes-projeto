package com.hvpaiva.factorymethod;

/**
 * Implementação da pizza vegana.
 */
public class VeganPizza implements Pizza {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String tipoPizza() {
		return "Pizza vegana!";
	}
}
