package com.hvpaiva.abstractfactory;

/**
 * Classe utilitária responsável por lidar com qual
 * Factory o Cliente precisará.
 *
 * Dado o tipo de Restaurante, retornará a factory responsável pelo tipo.
 */
final class RestauranteFactoryMaker {

	/**
	 * Cria a factory responsável pra dado tipo de restaurante.
	 *
	 * @param type O tipo de restaurante
	 * @return O Factory correto daquele restaurante
	 */
	static RestauranteFactory makeFactory(RestauranteType type) {
		switch (type) {
			case ITALIANO:
				return new RestauranteItalianoFactory();
			case MEXICANO:
				return new RestauranteMexicanoFactory();
			default:
				throw new IllegalArgumentException("Tipo de restaurante não suportado!");
		}
	}

	/**
	 * Para prevenir instanciação.
	 */
	private RestauranteFactoryMaker() {
		throw new UnsupportedOperationException("Não se deve instanciar classes utilitárias!");
	}
}
