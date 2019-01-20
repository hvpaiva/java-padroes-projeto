package com.hvpaiva.prototype;

/**
 * Classe abstrata de prototype.
 *
 * @param <P> O objeto clonado
 */
interface Prototype<P> extends Cloneable {

	/**
	 * Método clone.
	 *
	 * @return Retorna um objeto que é o clone do
	 * objeto clonado.
	 * @throws CloneNotSupportedException caso o clone não seja possível
	 */
	P copy() throws CloneNotSupportedException;
}
