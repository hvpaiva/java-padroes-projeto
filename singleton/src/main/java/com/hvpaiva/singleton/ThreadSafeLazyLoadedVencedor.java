package com.hvpaiva.singleton;

/**
 * Classe Singleton Thread-safe. A instância é inicializada lentamente e,
 * portanto, precisa de um mecanismo de sincronização.
 *
 * Nota: se criado por reflexão, então um singleton não será criado,
 * mas múltiplas opções no mesmo classloader
 */
final class ThreadSafeLazyLoadedVencedor {
	private static ThreadSafeLazyLoadedVencedor instance;

	/**
	 * Construtor padrão privado.
	 */
	private ThreadSafeLazyLoadedVencedor() {
	}

	/**
	 * A instância será criada apenas quando chamada pela primeira vez. Lazy-loading.
	 *
	 * @return A instância
	 */
	public static synchronized ThreadSafeLazyLoadedVencedor getInstance() {
		if (instance == null) {
			instance = new ThreadSafeLazyLoadedVencedor();
		}

		return instance;
	}
}
