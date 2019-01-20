package com.hvpaiva.singleton;

class ThreadSafeLazyLoadedVencedorTest extends SingletonTest<ThreadSafeLazyLoadedVencedor> {

	ThreadSafeLazyLoadedVencedorTest() {
		super(ThreadSafeLazyLoadedVencedor::getInstance);
	}

}
