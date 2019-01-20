package com.hvpaiva.factorymethod;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * O Factory Method é um padrão de design de criação que usa métodos de fábrica
 * para lidar com o problema de criar objetos sem especificar a classe exata de
 * objeto que será criada. Isso é feito criando objetos chamando um método de
 * fábrica especificado em uma interface e implementado por classes filhas ou
 * implementado em uma classe base e, opcionalmente, substituído por classes
 * derivadas - em vez de chamar um construtor.
 *
 * Neste exemplo de Factory Method, temos uma interface ({@link Pizzaiolo})
 * com um método para criação de objetos ({@link Pizzaiolo # criarPizza ()}).
 * As subclasses concretas ({@link VeganPizzaiolo}, {@link NormalPizzaiolo})
 * sobrescrevem o método para produzir objetos de sua preferência.
 *
 */
@Log
public final class Pizzaria {

	private final Pizzaiolo pizzaiolo;

	/**
	 * Cria uma instância de <code>Pizzaria</code> que usará o <code>Pizzaiolo</code>
	 * para fabricar as pizzas. A <code>Pizzaria</code> não sabe qual implementação
	 * concreta do {@link Pizzaiolo} está usando. A decisão de qual implementação do
	 * pizzaiolo usar pode depender da configuração ou do tipo de pedido.
	 *
	 * @param pizzaiolo uma implementação não nula de pizzaiolo
	 */
	private Pizzaria(Pizzaiolo pizzaiolo) {
		this.pizzaiolo = pizzaiolo;
	}

	/**
	 * Método que confecciona a pizza.
	 */
	private void confeccionarPizza() {
		Pizza pizza;

		pizza = pizzaiolo.criarPizza();
		log.info(pizza.tipoPizza());
	}

	/**
	 * Programa.
	 *
	 * @param args Os argumentos
	 */
	public static void main(String[] args) {

		// Pizza vegana
		log.info("Pizza Vegana:");
		Pizzaria pizzaria = new Pizzaria(new VeganPizzaiolo());
		pizzaria.confeccionarPizza();

		// Pizza normal
		log.info("Pizza Normal:");
		Pizzaria pizzaria2 = new Pizzaria(new NormalPizzaiolo());
		pizzaria2.confeccionarPizza();

	}
}
