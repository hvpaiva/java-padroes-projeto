package com.hvpaiva.singleton;

class InitializingOnDemandHolderIdiomTest extends SingletonTest<InitializingOnDemandHolderIdiom> {

	InitializingOnDemandHolderIdiomTest() {
		super(InitializingOnDemandHolderIdiom::getInstance);
	}

}
