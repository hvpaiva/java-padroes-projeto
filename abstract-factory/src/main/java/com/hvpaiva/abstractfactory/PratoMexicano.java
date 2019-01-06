package com.hvpaiva.abstractfactory;

/**
 * Implementação do Prato Mexicano.
 */
public class PratoMexicano implements Prato {

	static final String DESCRICAO = "Este é um prato mexicano!";

	@Override
	public String descricao() {
		return DESCRICAO;
	}
}
