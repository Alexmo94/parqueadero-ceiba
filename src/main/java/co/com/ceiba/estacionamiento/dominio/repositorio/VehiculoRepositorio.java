package co.com.ceiba.estacionamiento.dominio.repositorio;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;

public interface VehiculoRepositorio {

	Vehiculo guardar(Vehiculo vehiculo);

	Vehiculo consultarVehiculoPorPlaca(String vehiculo);

	Vehiculo consultById(Long id);
}
