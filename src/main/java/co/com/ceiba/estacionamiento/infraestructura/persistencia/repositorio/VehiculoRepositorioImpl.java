package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.VehiculoRepositorioJPA;

@Repository
@Transactional
public class VehiculoRepositorioImpl implements VehiculoRepositorio{

	@Autowired
	private VehiculoRepositorioJPA repository;
	
	public VehiculoRepositorioImpl (VehiculoRepositorioJPA repository) {
		this.repository = repository;
	}
	
	// TODO: Consultas Con respecto a Vehiculo
}
