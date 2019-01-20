package com.hvpaiva.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitializingOnDemandHolderIdiomTest extends SingletonTest<InitializingOnDemandHolderIdiom> {

	InitializingOnDemandHolderIdiomTest() {
		super(InitializingOnDemandHolderIdiom::getInstance);
	}

	@Test
	void testDescription() {
		InitializingOnDemandHolderIdiom instance = InitializingOnDemandHolderIdiom.getInstance();
		assertEquals("Initializing On Demand Holder Idiom", instance.getDescription());
	}

}
