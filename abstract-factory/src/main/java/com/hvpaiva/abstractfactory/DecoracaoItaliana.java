package com.hvpaiva.abstractfactory;

/**
 * Implementação da Decoração Italiana.
 */
public class DecoracaoItaliana implements Decoracao {

	static final String DESCRICAO = "Esta é uma decoração italiana!";

	@Override
	public String descricao() {
		return DESCRICAO;
	}

}
