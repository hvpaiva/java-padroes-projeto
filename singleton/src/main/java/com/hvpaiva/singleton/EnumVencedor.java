package com.hvpaiva.singleton;

/**
 * Implementação Singleton baseado em Enum. Effective Java 2nd Edition (Joshua Bloch) p. 18
 *
 * Esta implementação é thread-safe, no entanto, ao adicionar qualquer outro método
 * segurança por threads é de responsabilidade do desenvolvedor.
 */
enum EnumVencedor {
	INSTANCE;

	@Override
	public String toString() {
		return getDeclaringClass().getCanonicalName() + "@" + hashCode();
	}
}
