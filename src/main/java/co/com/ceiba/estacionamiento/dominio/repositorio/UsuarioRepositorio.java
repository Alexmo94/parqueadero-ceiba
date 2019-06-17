package co.com.ceiba.estacionamiento.dominio.repositorio;

import co.com.ceiba.estacionamiento.dominio.Usuario;

public interface UsuarioRepositorio{

	Usuario crearUsuario(Usuario usuario);

	Usuario consultarUsuarioPorId(Long userId);

}
