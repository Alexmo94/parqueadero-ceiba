package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.dominio.repositorio.UsuarioRepositorio;

@Service
public class ServicioUsuario {

	private final UsuarioRepositorio repository;
	
	public ServicioUsuario(final UsuarioRepositorio repository) {
		this.repository = repository;
	}
	
	public Usuario guardar(Usuario usuario) {	
		return repository.guardar(usuario);
	}
	
	public Usuario consultarUsuarioPorId(Long userId) {	
		return repository.consultarUsuarioPorId(userId);
	}
	
}
