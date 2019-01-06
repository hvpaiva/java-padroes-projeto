package com.hvpaiva.abstractfactory;

/**
 * Implementação do Prato Italiano.
 */
public class PratoItaliano implements Prato {

	static final String DESCRICAO = "Este é um prato italiano!";

	@Override
	public String descricao() {
		return DESCRICAO;
	}
}
