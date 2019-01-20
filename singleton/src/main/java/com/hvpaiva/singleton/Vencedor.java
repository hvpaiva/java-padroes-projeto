package com.hvpaiva.singleton;

/**
 * Singleton class.
 * Eagerly initialized static instance garante segurança de thread.
 */
final class Vencedor {

	/**
	 * Construtor privado para evitar instanciação.
	 */
	private Vencedor() { }

	/**
	 * Instancia estática da classe.
	 */
	private static final Vencedor INSTANCE = new Vencedor();

	/**
	 * @return A instância da classe.
	 */
	public static Vencedor getInstance() {
		return INSTANCE;
	}
}
