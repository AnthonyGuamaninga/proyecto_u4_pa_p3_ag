package com.example.demo.funcional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Supplier
		// JAVA
		LOG.info("\n1. JAVA Supplier");
		Stream<String> lista = Stream.generate(() -> "Anthony").limit(10);
		lista.forEach(cadena-> LOG.info(cadena));
		
		// 2. Consumer
		// JAVA
		LOG.info("\n1. JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,56,78);
		listaNumeros.forEach(numero-> LOG.info("valor: "+numero));
		
		// 3. Predicate
		// JAVA
		LOG.info("\n3.JAVA PREDICATE");
		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> numero>=3);
		listaFiltrada.forEach(numero -> LOG.info("Valor: "+numero));
		
		// 4. Function
		// JAVA
		LOG.info("\n4. JAVA Function");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valorFinal= numeroLista +1;
			String cadena = "num: "+valorFinal.toString();
			return cadena;
		});
		listaCambiada.forEach(cadena-> LOG.info(cadena));
		
		// 5. UnaryOperator
		// JAVA
		LOG.info("\n5. JAVA UnaryOperator");
		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numeroLista -> {
			Integer valorFinal= numeroLista +5;
			return valorFinal;
		});
		listaCambiada2.forEach(numero-> LOG.info("valor entero: "+numero));
		
	}

}
