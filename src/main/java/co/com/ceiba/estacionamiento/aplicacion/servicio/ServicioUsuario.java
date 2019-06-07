package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.dominio.repositorio.UsuarioRepositorio;

@Service
public class ServicioUsuario {

	private UsuarioRepositorio repository;
	
	public ServicioUsuario(UsuarioRepositorio repository) {
		this.repository = repository;
	}
	
	public Usuario guardar(Usuario usuario) {	
		return repository.guardar(usuario);
	}
	
}
