package com.hvpaiva.singleton;

/**
 * Double check locking.
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 *
 * Não funciona abaixo do Java 1.4.
 */
final class ThreadSafeDoubleCheckLocking {

	private static ThreadSafeDoubleCheckLocking instance;

	/**
	 * Construtor privado para prevenir instanciação.
	 */
	private ThreadSafeDoubleCheckLocking() { }

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
