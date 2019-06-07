package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.repositorio.TipoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.TipoRepositorioJPA;

@Repository
@Transactional
public class TipoRepositorioImpl implements TipoRepositorio {

	@Autowired
	private TipoRepositorioJPA repository;

	public TipoRepositorioImpl(TipoRepositorioJPA repository) {
		this.repository = repository;
	}

	//TODO: Consultas con respecto al tipo
	
}
