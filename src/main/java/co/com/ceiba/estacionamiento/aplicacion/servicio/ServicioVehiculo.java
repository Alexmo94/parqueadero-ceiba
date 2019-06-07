package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.repositorio.VehiculoRepositorio;

@Service
public class ServicioVehiculo {

	private VehiculoRepositorio repository;
	
	public ServicioVehiculo(VehiculoRepositorio repository) {
		this.repository = repository;
	}
	
}
