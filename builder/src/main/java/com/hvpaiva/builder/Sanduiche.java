package com.hvpaiva.builder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Representa o Sanduiche.
 */
public final class Sanduiche {

	private final Tamanho tamanho;
	private final CarneTipo carne;
	private final PaoTipo pao;
	private final QueijoTipo queijo;
	private final List<Extras> extras;
	private final List<Salada> salada;
	private final List<Molho> molho;

	/**
	 * Contrutor padrão de sanduíche.
	 *
	 * @param builder O builder de sanduíche
	 */
	Sanduiche(Builder builder) {
		this.tamanho = builder.tamanho;
		this.carne = builder.carne;
		this.pao = builder.pao;
		this.queijo = builder.queijo;
		this.extras = builder.extras;
		this.salada = builder.salada;
		this.molho = builder.molho;
	}

	/**
	 * O Builder de sanduíche.
	 * Ofere métodos necessários para a
	 * construção passo-a-passo de um sanduíche.
	 */
	public static class Builder {

		private final Tamanho tamanho;
		private final CarneTipo carne;
		private final PaoTipo pao;
		private QueijoTipo queijo;
		private List<Extras> extras;
		private List<Salada> salada;
		private List<Molho> molho;

		/**
		 * Construtor padrão do builder de Sanduíche.
		 * Assume o que é indispensável para se ter um sanduíche.
		 *
		 * @param tamanho O tamanho do sanduíche
		 * @param carne O tipo de carne
		 * @param pao O tipo do pão
		 */
		public Builder(Tamanho tamanho, CarneTipo carne, PaoTipo pao) {
			if (tamanho == null || carne == null || pao == null)
				throw new IllegalArgumentException("É necessário definir o tamanho, a carne e o pão!");

			this.tamanho = tamanho;
			this.carne = carne;
			this.pao = pao;
		}

		/**
		 * Adiciona o queijo ao sanduíche em construção.
		 *
		 * @param queijo O tipo de queijo
		 * @return O builder de sanduíche com queijo
		 */
		public Builder comQueijo(QueijoTipo queijo) {
			this.queijo = queijo;
			return this;
		}

		/**
		 * Adiciona os extras ao sanduíche em construção.
		 *
		 * @param extras Os extras do sanduíche
		 * @return O builder de sanduíche com os extras
		 */
		public Builder comExtras(List<Extras> extras) {
			this.extras = extras;
			return this;
		}

		/**
		 * Adiciona os tipos de salada ao
		 * sanduíche em construção.
		 *
		 * @param salada Os tipos de salada do sanduíche
		 * @return O builder de sanduíche com os
		 * tipos de salada
		 */
		public Builder comSalada(List<Salada> salada) {
			this.salada = salada;
			return this;
		}

		/**
		 * Adiciona os tipos de molho ao
		 * sanduíche em construção.
		 *
		 * @param molho Os tipos de molho do sanduíche
		 * @return O builder de sanduíche com os
		 * tipos de molho
		 */
		public Builder comMolho(List<Molho> molho) {
			this.molho = molho;
			return this;
		}

		/**
		 * Método builder.
		 * Constrói o sanduíche com as propriedades
		 * definidas no builder.
		 *
		 * @return O sanduíche
		 */
		public Sanduiche build() {
			return new Sanduiche(this);
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb
				.append("Este é um sanduíche tamanho ")
				.append(tamanho.name().toLowerCase().replace("_", " "))
				.append(", com carne de ")
				.append(carne.name().toLowerCase().replace("_", " "))
				.append(" e pão ")
				.append(pao.name().toLowerCase().replace("_", " "))
				.append("; \n");

		if (queijo != null)
			sb.append("Com queijo ").append(queijo.name().toLowerCase());

		if (extras != null && !extras.isEmpty()) {
			sb.append("; Extras: ");

			String ext = StringUtils.join(
					extras
							.stream()
							.map(e -> e.name().toLowerCase().replace("_", " "))
							.toArray(),
					", ");
			sb.append(ext);
		}

		if (salada != null && !salada.isEmpty()) {
			sb.append("; Salada: ");

			String saladas = StringUtils.join(
					salada
							.stream()
							.map(e -> e.name().toLowerCase().replace("_", " "))
							.toArray(),
					", ");
			sb.append(saladas);
		}

		if (molho != null && !molho.isEmpty()) {
			sb.append("; Molho: ");

			String molhos = StringUtils.join(
					molho
							.stream()
							.map(e -> e.name().toLowerCase().replace("_", " "))
							.toArray(),
					", ");
			sb.append(molhos);
		}

		sb.append(".");

		return sb.toString();
	}
}
