package com.hvpaiva.singleton;

class EnumVencedorTest extends SingletonTest<EnumVencedor> {

	EnumVencedorTest() {
		super(() -> EnumVencedor.INSTANCE);
	}
}
