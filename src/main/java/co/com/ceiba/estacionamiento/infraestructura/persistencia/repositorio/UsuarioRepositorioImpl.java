package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.dominio.excepcion.UsuarioNotFoundException;
import co.com.ceiba.estacionamiento.dominio.repositorio.UsuarioRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.UsuarioMapeo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa.UsuarioRepositorioJPA;

@Repository
@Transactional
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

	public static final String USUARIO_NO_EXISTE = "El usuario consultado No Existe";

	private UsuarioRepositorioJPA repository;

	public UsuarioRepositorioImpl(UsuarioRepositorioJPA repository) {
		this.repository = repository;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return UsuarioMapeo.convertirEntityADominio(repository.save(UsuarioMapeo.convertirDominioAEntity(usuario)));
	}

	@Override
	public Usuario consultarUsuarioPorId(Long userId) {
		return UsuarioMapeo.convertirEntityADominio(
				repository.findById(userId).orElseThrow(() -> new UsuarioNotFoundException(USUARIO_NO_EXISTE)));
	}

}
