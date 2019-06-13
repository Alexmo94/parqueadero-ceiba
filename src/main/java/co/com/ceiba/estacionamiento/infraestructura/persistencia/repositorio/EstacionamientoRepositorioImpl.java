package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.dominio.excepcion.EstacionamientoNotFoundException;
import co.com.ceiba.estacionamiento.dominio.repositorio.EstacionamientoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.EstacionamientoMapeo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.EstacionamientoRepositorioJPA;

@Repository
@Transactional
public class EstacionamientoRepositorioImpl implements EstacionamientoRepositorio {

	private final EstacionamientoRepositorioJPA repository;

	public EstacionamientoRepositorioImpl(final EstacionamientoRepositorioJPA repository) {
		this.repository = repository;
	}

	@Override
	public Estacionamiento registrarEntrada(Estacionamiento estacionamiento) {
		return EstacionamientoMapeo.convertirEntityADominio(
				repository.save(EstacionamientoMapeo.convertirDominioAEntity(estacionamiento)));
	}

	@Override
	public Estacionamiento registrarSalida(Estacionamiento estacionamiento) {
		return EstacionamientoMapeo.convertirEntityADominio(
				repository.save(EstacionamientoMapeo.convertirDominioAEntity(estacionamiento)));
	}

	@Override
	public long contarEspaciosEstacionamiento(long tipoId, long parkingTotal) {
		return repository.countByVehiculoIdTipoIdTipoIdAndParkingTotal(tipoId, parkingTotal);
	}

	@Override
	public void validarVehiculoEstacionado(String vehiculoPlaca) {
		if (repository.findByVehiculoIdVehiculoPlaca(vehiculoPlaca).isPresent())
			throw new EstacionamientoNotFoundException("El Vehiculo ya se encuentra estacionado");
	}

	@Override
	public Estacionamiento consultarPorVehiculoRegistradoYParkingTotal(String vehiculoPlaca) {
		return EstacionamientoMapeo.convertirEntityADominio(repository.findByVehiculoIdVehiculoPlaca(vehiculoPlaca)
				.orElseThrow(() -> new EstacionamientoNotFoundException("El vehiculo no se entruentra estacionado")));
	}
}
