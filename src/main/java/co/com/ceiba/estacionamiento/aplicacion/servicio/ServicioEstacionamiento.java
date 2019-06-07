package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.repositorio.EstacionamientoRepositorio;

@Service
public class ServicioEstacionamiento {

	private EstacionamientoRepositorio repository;
	
	public ServicioEstacionamiento() {
		
	}

	@Autowired
	public ServicioEstacionamiento(EstacionamientoRepositorio repository) {
		this.repository = repository;
	}

}
