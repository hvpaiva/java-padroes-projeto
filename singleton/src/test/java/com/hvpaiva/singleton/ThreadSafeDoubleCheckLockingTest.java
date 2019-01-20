package com.hvpaiva.singleton;

class ThreadSafeDoubleCheckLockingTest extends SingletonTest<ThreadSafeDoubleCheckLocking> {

	ThreadSafeDoubleCheckLockingTest() {
		super(ThreadSafeDoubleCheckLocking::getInstance);
	}

}
