package com.hvpaiva.abstractfactory;

/**
 * Implementação da Música Italina.
 */
public class MusicaItaliana implements Musica {

	static final String DESCRICAO = "Esta é uma música italiana!";

	@Override
	public String descricao() {
		return DESCRICAO;
	}
}
