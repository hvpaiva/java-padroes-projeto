import com.hvpaiva.factorymethod.NormalPizzaiolo;
import com.hvpaiva.factorymethod.Pizza;
import com.hvpaiva.factorymethod.Pizzaiolo;
import com.hvpaiva.factorymethod.VeganPizzaiolo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryMethodTest {

	@Test
	void testPizzaioloVegano() {
		Pizzaiolo pizzaiolo = new VeganPizzaiolo();
		Pizza pizza = pizzaiolo.criarPizza();

		assertEquals("Pizza vegana!", pizza.tipoPizza());
	}

	@Test
	void testPizzaioloNormal() {
		Pizzaiolo pizzaiolo = new NormalPizzaiolo();
		Pizza pizza = pizzaiolo.criarPizza();

		assertEquals("Pizza normal!", pizza.tipoPizza());
	}
}
