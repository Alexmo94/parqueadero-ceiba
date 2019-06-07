package co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo;

import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.UsuarioEntity;

public final class UsuarioMapeo {

	private UsuarioMapeo() {
	}

	public static Usuario convertirEntityADominio(UsuarioEntity entity) {
		Usuario dominio = new Usuario();
		dominio.setUserId(entity.getUserId());
		dominio.setUserNombre(entity.getUserNombre());
		dominio.setUserApellido(entity.getUserApellido());
		dominio.setUserFechaNacimiento(entity.getUserFechaNacimiento());
		dominio.setUserSexo(entity.getUserSexo());
		return dominio;
	}
	
	public static UsuarioEntity convertirDominioAEntity(Usuario dominio) {
		UsuarioEntity entity = new UsuarioEntity();
		entity.setUserId(dominio.getUserId());
		entity.setUserNombre(dominio.getUserNombre());
		entity.setUserApellido(dominio.getUserApellido());
		entity.setUserFechaNacimiento(dominio.getUserFechaNacimiento());
		entity.setUserSexo(dominio.getUserSexo());
		return entity;
	}

}
