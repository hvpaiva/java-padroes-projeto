package com.hvpaiva.abstractfactory;

/**
 * Implementação da Decoração Mexicana.
 */
public class DecoracaoMexicana implements Decoracao {

	static final String DESCRICAO = "Esta é uma decoração mexicana!";

	@Override
	public String descricao() {
		return DESCRICAO;
	}

}
