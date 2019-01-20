package com.hvpaiva.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class PedidoTest {

	@Test
	public void testFactory() throws CloneNotSupportedException {
		final Lanche lanche = mock(Lanche.class);
		final Bebida bebida = mock(Bebida.class);

		when(lanche.copy()).thenThrow(CloneNotSupportedException.class);
		when(bebida.copy()).thenThrow(CloneNotSupportedException.class);

		final PedidoFactory factory = new Pedido(lanche, bebida);
		assertNull(factory.criarLanche());
		assertNull(factory.criarBebida());

		verify(lanche).copy();
		verify(bebida).copy();
		verifyNoMoreInteractions(lanche, bebida);
	}
}
