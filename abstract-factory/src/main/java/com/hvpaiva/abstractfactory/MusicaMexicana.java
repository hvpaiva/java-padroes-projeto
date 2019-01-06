package com.hvpaiva.abstractfactory;

/**
 * Implementação da Música Mexicana.
 */
public class MusicaMexicana implements Musica {

	static final String DESCRICAO = "Esta é uma música mexicana!";

	@Override
	public String descricao() {
		return DESCRICAO;
	}

}
