package com.hvpaiva.singleton;

import lombok.extern.java.Log;

/**
 * Aplicação para demonstração.
 */
@Log
final class App {

	/**
	 * Para evitar instanciação.
	 */
	private App() { }

	/**
	 * Entrada do Programa.
	 *
	 * @param args command line argumentos
	 */
	public static void main(String[] args) {

		// eagerly initialized singleton
		Vencedor vencedor = Vencedor.getInstance();
		Vencedor vencedor2 = Vencedor.getInstance();
		log.info("vencedor= " + vencedor);
		log.info("vencedor2= " + vencedor2);

		// lazily initialized singleton
		ThreadSafeLazyLoadedVencedor threadSafeVencedor1 = ThreadSafeLazyLoadedVencedor.getInstance();
		ThreadSafeLazyLoadedVencedor threadSafeVencedor2 = ThreadSafeLazyLoadedVencedor.getInstance();
		log.info("threadSafeVencedor1= " + threadSafeVencedor1);
		log.info("threadSafeVencedor2= " + threadSafeVencedor2);

		// enum singleton
		EnumVencedor enumVencedor = EnumVencedor.INSTANCE;
		EnumVencedor enumVencedor2 = EnumVencedor.INSTANCE;
		log.info("enumVencedor= " + enumVencedor);
		log.info("enumVencedor2= " + enumVencedor2);

		// double checked locking
		ThreadSafeDoubleCheckLocking dcl = ThreadSafeDoubleCheckLocking.getInstance();
		ThreadSafeDoubleCheckLocking dcl2 = ThreadSafeDoubleCheckLocking.getInstance();
		log.info("dcl= " + dcl);
		log.info("dcl2= " + dcl2);

		// demand holder idiom
		InitializingOnDemandHolderIdiom demandHolderIdiom = InitializingOnDemandHolderIdiom.getInstance();
		InitializingOnDemandHolderIdiom demandHolderIdiom2 = InitializingOnDemandHolderIdiom.getInstance();
		log.info("demandHolderIdiom= " + demandHolderIdiom);
		log.info("demandHolderIdiom2= " + demandHolderIdiom2);

	}
}
