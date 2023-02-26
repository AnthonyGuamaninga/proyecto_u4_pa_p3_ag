package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Supplier
		LOG.info("\n1. SUPPLIER");
		// Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "Anthony 2";
		LOG.info("Supplier Lambda: " + supplier2.getNombre());

		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Lambda: " + supplier3.getNombre());

		IPersonaSupplier<Persona> supplier4 = () -> {
			Persona per = new Persona();
			per.setNombre("Anthony");
			per.setApellido("Guamaninga");
			return per;
		};

		LOG.info("Supplier Lambda: " + supplier4.getNombre());

		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier Lambda: " + supplier5.getNombre()); // Clase que permite imprimir

		// 2. Consumer
		LOG.info("\n2. CONSUMER");

		// Clase
		IPersonaConsumer<String, Integer> consumer = new PersonaConsumerImpl();
		consumer.accept("procesa este dato", Integer.valueOf(10));

		// Lambda
		IPersonaConsumer<String, Integer> consumer2 = (cadena, numero) -> {
			LOG.info("mensaje a: " + cadena);
			LOG.info("mensaje b: " + cadena);
			LOG.info("mensaje c: " + numero);
		};
		consumer2.accept("procesa este dato 2", Integer.valueOf(15));

		IPersonaConsumer<Integer, Integer> consumer3 = (valor1, valor2) -> {
			Integer valor3 = valor1.intValue() + valor2.intValue();
			LOG.info("Valor 3: " + valor3);
		};
		consumer3.accept(Integer.valueOf(5), Integer.valueOf(10));

		// 3. Predicate
		LOG.info("\n3. PREDICATE");
		// Lambdas
		IPersonaPredicate<String> predicate1= cadena -> cadena.contains("Z");
		LOG.info("Predicate: "+predicate1.evaluar("Anthony"));
		
		IPersonaPredicate<Integer> predicate2= numero -> {
			if(numero.intValue()>10) {
				return true;
			}else {
				return false;
			}
		};
		LOG.info("Predicate2: "+predicate2.evaluar(11));
		
		// 4. Function
		LOG.info("\n4. Function");
		IPersonaFunction<String , Integer> function = numero -> "Valor: " + numero.toString();
		LOG.info(function.aplicar(10));
		
		IPersonaFunction<Ciudadano , Persona> function2 = per -> {
			Ciudadano ciu = new Ciudadano();
			ciu.setNombreCompleto(per.getNombre()+" "+per.getApellido());
			ciu.setCiudad("Quito");
			return ciu;
		};
		Persona persona = new Persona();
		persona.setApellido("Yaguache");
		persona.setNombre("Alfred");
		Ciudadano ciudadanoConvertido = function2.aplicar(persona);
		LOG.info("Ciudadano convertido: "+ciudadanoConvertido);
		
		// 5. UnaryOperator
		// Lambdas
		LOG.info("\n5. UnaryOperator");
		IPersonaUnaryOperator<String> unaryOperator = cadena -> {
			String cadenaFinal =cadena.concat("-sufijo");
			return cadenaFinal;
		};
		LOG.info("UnaryOperator: "+unaryOperator.aplicar("Daniel"));
	}

}
