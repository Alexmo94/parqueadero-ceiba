package co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.EstacionamientoEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.VehiculoEntity;

public final class EstacionamientoMapeo {

	private EstacionamientoMapeo() {
	}

	public static Estacionamiento convertirEntityADominio(EstacionamientoEntity entity) {
		Estacionamiento dominio = new Estacionamiento();
		dominio.setParkingId(entity.getParkingId());
		dominio.setVehiculoId(entity.getVehiculoId().getVehiculoId());
		dominio.setParkingFechaEntrada(entity.getParkingFechaEntrada());
		dominio.setParkingFechaSalida(entity.getParkingFechaSalida());
		dominio.setParkingTotal(entity.getParkingTotal());
		return dominio;
	}

	public static EstacionamientoEntity convertirDominioAEntity(Estacionamiento dominio) {
		EstacionamientoEntity entity = new EstacionamientoEntity();
		VehiculoEntity vehiculo = new VehiculoEntity();
		entity.setParkingId(dominio.getParkingId());
		vehiculo.setVehiculoId(dominio.getVehiculoId());
		entity.setVehiculoId(vehiculo);
		entity.setParkingFechaEntrada(dominio.getParkingFechaEntrada());
		entity.setParkingFechaSalida(dominio.getParkingFechaSalida());
		entity.setParkingTotal(dominio.getParkingTotal());
		return entity;
	}

}
