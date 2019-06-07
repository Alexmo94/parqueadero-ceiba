package co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo;

import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.TipoEntity;

public class TipoMapeo {

	private TipoMapeo() {
	}

	public final Tipo convertirEntityADominio(TipoEntity entity) {
		Tipo dominio = new Tipo();
		dominio.setTipoId(entity.getTipoId());
		dominio.setTipoDesc(entity.getTipoDesc());
		dominio.setTipoValorHora(entity.getTipoValorHora());
		dominio.setTipoValorDia(entity.getTipoValorDia());
		dominio.setTipoTarifaExtra(entity.getTipoTarifaExtra());
		return dominio;
	}

	public final TipoEntity convertirEntityADominio(Tipo dominio) {
		TipoEntity entity = new TipoEntity();
		entity.setTipoId(dominio.getTipoId());
		entity.setTipoDesc(dominio.getTipoDesc());
		entity.setTipoValorHora(dominio.getTipoValorHora());
		entity.setTipoValorDia(dominio.getTipoValorDia());
		entity.setTipoTarifaExtra(dominio.getTipoTarifaExtra());
		return entity;
	}

}
