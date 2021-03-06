package com.hvpaiva.singleton;

/**
 * O Initialize-on-demand-holder idiom é uma maneira segura de criar um objeto
 * singleton lazy initialized em Java.
 *
 * A classe interna não é referenciada anteriormente (e, portanto, não é carregada
 * anteriormente pelo carregador de classes) do que o momento em que getInstance() é chamado.
 * Portanto, essa solução é segura para thread sem exigir construções de linguagem
 * especiais (ou seja, volátil ou sincronizado).
 */
final class InitializingOnDemandHolderIdiom {

	private static final String DESCRICAO = "Initializing On Demand Holder Idiom";

	/**
	 * Construtor privado para evitar instanciação.
	 */
	private InitializingOnDemandHolderIdiom() {
	}

	/**
	 * @return A instÂncia Singleton
	 */
	public static InitializingOnDemandHolderIdiom getInstance() {
		return HelperHolder.INSTANCE;
	}

	/**
	 * Método não estático qualquer do singleton.
	 * @return A descrição
	 */
	public String getDescription() {
		return DESCRICAO;
	}

	/**
	 * Provém a instância Singleton lazy-loaded.
	 */
	private static class HelperHolder {
		private static final InitializingOnDemandHolderIdiom INSTANCE = new InitializingOnDemandHolderIdiom();
	}

}
