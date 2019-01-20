package com.hvpaiva.prototype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PrototypeTest<P extends Prototype> {

	static Collection<Object[]> dataProvider() {
		final Object[] sanduiche = new Object[2];
		sanduiche[0] = new Sanduiche("X-Tudo");
		sanduiche[1] = "Sanduíche X-Tudo";

		final Object[] pizza = new Object[2];
		pizza[0] = new Pizza("Quatro queijos");
		pizza[1] = "Pizza Quatro queijos";

		final Object[] suco = new Object[2];
		suco[0] = new Suco("Laranja");
		suco[1] = "Suco de Laranja";

		final Object[] refrigerante = new Object[2];
		refrigerante[0] = new Refrigerante("Coda-cola");
		refrigerante[1] = "Refrigerante Coda-cola";

		return Arrays.asList(
				sanduiche,
				pizza,
				suco,
				refrigerante
		);
	}

	@ParameterizedTest
	@MethodSource("dataProvider")
	void testPrototype(P testedPrototype, String expectedToString) throws CloneNotSupportedException {
		assertEquals(expectedToString, testedPrototype.toString());

		final Object clone = testedPrototype.copy();
		assertNotNull(clone);
		assertNotSame(clone, testedPrototype);
		assertSame(testedPrototype.getClass(), clone.getClass());
	}
}
