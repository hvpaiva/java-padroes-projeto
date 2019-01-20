package com.hvpaiva.singleton;

class VencedorTest extends SingletonTest<Vencedor> {

	VencedorTest() {
		super(Vencedor::getInstance);
	}
}
