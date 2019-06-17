package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.dominio.repositorio.VehiculoRepositorio;

@Service
public class ServicioVehiculo {

	private final VehiculoRepositorio repository;
	
	public ServicioVehiculo(final VehiculoRepositorio repository) {
		this.repository = repository;
	}

	public Vehiculo guardarVehiculo(Vehiculo vehiculo) {		
		return repository.guardarVehiculo(vehiculo);
	}
	
	public Vehiculo consultarPorPlaca(String vehiculoPlaca) {
		return repository.consultarVehiculoPorPlaca(vehiculoPlaca);		
	}
}
