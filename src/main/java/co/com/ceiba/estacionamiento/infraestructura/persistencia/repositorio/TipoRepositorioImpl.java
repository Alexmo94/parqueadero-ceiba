package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.excepcion.TipoNotFoundException;
import co.com.ceiba.estacionamiento.dominio.repositorio.TipoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.TipoMapeo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.TipoRepositorioJPA;

@Repository
@Transactional
public class TipoRepositorioImpl implements TipoRepositorio {

	public static final String TIPO_NO_ENCONTRADO = "El vehiculo no se encuentra registrado";

	@Autowired
	private TipoRepositorioJPA repository;

	public TipoRepositorioImpl(TipoRepositorioJPA repository) {
		this.repository = repository;
	}

	@Override
	public Tipo consultById(long id) {
		return TipoMapeo.convertirEntityADominio(
				repository.findById(id).orElseThrow(() -> new TipoNotFoundException(TIPO_NO_ENCONTRADO)));

	}

	@Override
	public Tipo guardarTipo(Tipo tipo) {
		return TipoMapeo.convertirEntityADominio(repository.save(TipoMapeo.convertirDominioAEntity(tipo)));
	}

}
