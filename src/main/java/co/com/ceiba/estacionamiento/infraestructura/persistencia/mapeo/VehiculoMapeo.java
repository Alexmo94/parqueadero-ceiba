package co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.TipoEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.UsuarioEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.VehiculoEntity;

public final class VehiculoMapeo {

	private VehiculoMapeo() {
	}

	public static Vehiculo convertirEntityADominio(VehiculoEntity entity) {
		Vehiculo dominio = new Vehiculo();
		dominio.setVehiculoId(entity.getVehiculoId());
		dominio.setTipoId(entity.getTipoId().getTipoId());
		dominio.setVehiculoCilindraje(entity.getVehiculoCilindraje());
		dominio.setVehiculoPlaca(entity.getVehiculoPlaca());
		dominio.setUserId(entity.getUserId().getUserId());
		return dominio;
	}

	public static VehiculoEntity convertirDominioAEntity(Vehiculo dominio) {
		VehiculoEntity entity = new VehiculoEntity();
		TipoEntity tipo = new TipoEntity();
		UsuarioEntity user = new UsuarioEntity();

		entity.setVehiculoId(dominio.getVehiculoId());

		tipo.setTipoId(dominio.getTipoId());
		entity.setTipoId(tipo);

		user.setUserId(dominio.getUserId());
		entity.setUserId(user);
		
		entity.setVehiculoPlaca(dominio.getVehiculoPlaca());
		entity.setVehiculoCilindraje(dominio.getVehiculoCilindraje());

		return entity;
	}

}
