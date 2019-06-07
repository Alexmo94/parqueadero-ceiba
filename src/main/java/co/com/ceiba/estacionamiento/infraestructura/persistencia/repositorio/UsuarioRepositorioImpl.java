package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.dominio.repositorio.UsuarioRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.UsuarioMapeo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.UsuarioRepositorioJPA;

@Repository
@Transactional
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

	@Autowired
	private UsuarioRepositorioJPA repository;

	public UsuarioRepositorioImpl(UsuarioRepositorioJPA repository) {
		this.repository = repository;
	}

	@Override
	public Usuario guardar (Usuario usuario) {
		return UsuarioMapeo.convertirEntityADominio(repository.save(UsuarioMapeo.convertirDominioAEntity(usuario))); 
	}

}
