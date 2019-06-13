package co.com.ceiba.estacionamiento.dominio.repositorio;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;

public interface EstacionamientoRepositorio {

	Estacionamiento registrarEntrada(Estacionamiento estacionamiento);

	Estacionamiento registrarSalida(Estacionamiento estacionamiento);

	long contarEspaciosEstacionamiento(long tipoId, long parkingTotal);

	void validarVehiculoEstacionado(String vehiculoPlaca);

	Estacionamiento consultarPorVehiculoRegistradoYParkingTotal(String vehiculoPlaca);

}
