package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.dominio.excepcion.VehiculoNotFoundException;
import co.com.ceiba.estacionamiento.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.VehiculoMapeo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.VehiculoRepositorioJPA;

@Repository
@Transactional
public class VehiculoRepositorioImpl implements VehiculoRepositorio {

	public static final String VEHICULO_NO_ENCONTRADO = "El vehiculo no se encuentra registrado";

	private final VehiculoRepositorioJPA repository;

	public VehiculoRepositorioImpl(final VehiculoRepositorioJPA repository) {
		this.repository = repository;
	}

	@Override
	public Vehiculo guardar(Vehiculo vehiculo) {
		return VehiculoMapeo.convertirEntityADominio(repository.save(VehiculoMapeo.convertirDominioAEntity(vehiculo)));
	}

	@Override
	public Vehiculo consultById(Long vehiculoId) {

		try {
			return VehiculoMapeo.convertirEntityADominio(repository.getOne(vehiculoId));
		} catch (EntityNotFoundException e) {
			throw new VehiculoNotFoundException(VEHICULO_NO_ENCONTRADO);
			//TODO: Log Exception
		}
	}

	@Override
	public Vehiculo consultarVehiculoPorPlaca(String vehiculoPlaca) {
		return VehiculoMapeo.convertirEntityADominio(this.repository.findByVehiculoPlaca(vehiculoPlaca)
				.orElseThrow(() -> new VehiculoNotFoundException(VEHICULO_NO_ENCONTRADO)));
	}

}
