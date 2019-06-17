package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.TipoEntity;

public class TipoEntityTestDataBuilder {
	
	private static final long TIPO_ID  = 1L;
	private static final String TIPO_DESC = "Moto";
	private static final long TIPO_VALOR_HORA = 500;
	private static final long TIPO_VALOR_DIA = 4000;
	private static final long TIPO_TARIFA_EXTRA = 2000;

	private long tipoId;
	private String tipoDesc;
	private long tipoValorHora;
	private long tipoValorDia;
	private long tipoTarifaExtra;
	
	public TipoEntityTestDataBuilder() {
		this.tipoId = TIPO_ID;
		this.tipoDesc = TIPO_DESC;
		this.tipoValorDia = TIPO_VALOR_DIA;
		this.tipoValorHora = TIPO_VALOR_HORA;
		this.tipoTarifaExtra = TIPO_TARIFA_EXTRA;
	}
	
	public TipoEntityTestDataBuilder conTipoId(long tipoId) {
		this.tipoId = tipoId;
		return this;
	}
	
	public TipoEntityTestDataBuilder conTipoDesc(String tipoDesc) {
		this.tipoDesc = tipoDesc;
		return this;
	}
	
	public TipoEntityTestDataBuilder conTipoValorHora(long tipoValorHora) {
		this.tipoValorHora = tipoValorHora;
		return this;
	}
	
	public TipoEntityTestDataBuilder conTipoValorDia(long tipoValorDia) {
		this.tipoValorDia = tipoValorDia;
		return this;
	}
	
	public TipoEntityTestDataBuilder conTipoTarifaExtra(long tipoTarifaExtra) {
		this.tipoTarifaExtra = tipoTarifaExtra;
		return this;
	}
	
	public TipoEntity build() {
		TipoEntity tipoEntity = new TipoEntity();
		tipoEntity.setTipoId(this.tipoId);
		tipoEntity.setTipoDesc(this.tipoDesc);
		tipoEntity.setTipoValorDia(this.tipoValorDia);
		tipoEntity.setTipoValorHora(this.tipoValorHora);
		tipoEntity.setTipoTarifaExtra(this.tipoTarifaExtra);
		
		return tipoEntity;
	}

}
