package com.hvpaiva.singleton;

/**
 * Double check locking.
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 *
 * Não funciona abaixo do Java 1.4.
 */
final class ThreadSafeDoubleCheckLocking {

	private static volatile ThreadSafeDoubleCheckLocking instance;

	/**
	 * Construtor privado para prevenir instanciação.
	 * Proteção contra instanciação via reflection
	 */
	private ThreadSafeDoubleCheckLocking() {
		if (instance != null) {
			throw new IllegalStateException("Already initialized.");
		}
	}

	/**
	 * Acessor publico.
	 *
	 * @return a instância da classe
	 */
	public static ThreadSafeDoubleCheckLocking getInstance() {
		ThreadSafeDoubleCheckLocking result = instance;

		if (result == null) {

			synchronized (ThreadSafeDoubleCheckLocking.class) {

				result = instance;

				if (result == null) {
					instance = new ThreadSafeDoubleCheckLocking();
					result = instance;
				}
			}
		}
		return result;
	}

}
