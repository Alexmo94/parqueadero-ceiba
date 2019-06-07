package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.repositorio.EstacionamientoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.EstacionamientoRepositorioJPA;

@Repository
@Transactional
public class EstacionamientoRepositorioImpl implements EstacionamientoRepositorio{

	@Autowired
	private EstacionamientoRepositorioJPA repository;
	
	public EstacionamientoRepositorioImpl (EstacionamientoRepositorioJPA repository) {
		this.repository = repository;
	}
	
	// TODO: Consultas Con respecto a Estacionamiento
}
