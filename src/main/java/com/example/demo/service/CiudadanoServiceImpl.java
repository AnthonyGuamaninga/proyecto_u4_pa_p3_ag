package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.ICiudadanoRepo;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public List<Ciudadano> consultarTodos() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepo.buscarTodos();
	}

	@Override
	public Estudiante convertir(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		Estudiante estudiante = new Estudiante();
		
		String nombreComp = ciudadano.getNombre()+" "+ciudadano.getApellido();
		estudiante.setNombreCompleto(nombreComp);
		
		// Obtengo fecha
		Integer dia = ciudadano.getFechaNacimiento().getDayOfMonth();
		Integer mes = ciudadano.getFechaNacimiento().getMonthValue();
		Integer anio = ciudadano.getFechaNacimiento().getYear();
		
		Integer diaActual = LocalDateTime.now().getDayOfMonth();
		Integer mesActual = LocalDateTime.now().getMonthValue();
		Integer anioActual = LocalDateTime.now().getYear();
		//Calculo edad
		Integer edad;
		if (mes > mesActual && dia > diaActual) {
			edad = anioActual - anio;
		}else {
			edad = (anioActual - anio)-1;
		}
		estudiante.setEdad(edad);
		this.estudianteRepository.insertar(estudiante);
		return estudiante;
		
	}
	
}
