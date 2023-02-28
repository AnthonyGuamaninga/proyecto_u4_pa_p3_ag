package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU4PaP3AgApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU4PaP3AgApplication.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU4PaP3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		long tiempoInicio = System.currentTimeMillis();
		List<Estudiante> listaCompletaE =  this.procesarEstudiantesParalelo();
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal = (tiempoFinal- tiempoInicio);
		LOG.info("\nTiempo total de conversión: "+tiempoTotal+" milisegundos");
		//System.out.println("\nTiempo total de conversión: "+tiempoTotal+" milisegundos");
		
		System.out.println();
		//listaCompletaE.forEach(datoEstu -> System.out.println(datoEstu+"\t"+Thread.currentThread().getName()));
		listaCompletaE.forEach(datoEstu -> LOG.info(datoEstu+"\t"+Thread.currentThread().getName()));
		
	}
	
	public List<Estudiante> procesarEstudiantesParalelo() {
		List<Ciudadano> ciudadanos =  this.ciudadanoService.consultarTodos();
		ciudadanos.forEach(ciud -> LOG.info("Impresion: "+ciud));

		List<Estudiante> estudiantes = ciudadanos.parallelStream().map(conv -> this.ciudadanoService.convertir(conv))
				.collect(Collectors.toList());

		return estudiantes;
	}

}
