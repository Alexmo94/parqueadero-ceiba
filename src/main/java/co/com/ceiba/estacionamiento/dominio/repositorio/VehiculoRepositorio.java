package co.com.ceiba.estacionamiento.dominio.repositorio;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;

public interface VehiculoRepositorio {

	Vehiculo guardarVehiculo(Vehiculo vehiculo);

	Vehiculo consultarVehiculoPorPlaca(String vehiculo);

	Vehiculo consultById(Long id);
}
