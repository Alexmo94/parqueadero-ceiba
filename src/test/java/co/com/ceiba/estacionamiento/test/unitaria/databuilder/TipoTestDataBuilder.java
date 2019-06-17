package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import co.com.ceiba.estacionamiento.dominio.Tipo;

public class TipoTestDataBuilder {
	
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
	
	public TipoTestDataBuilder() {
		this.tipoId = TIPO_ID;
		this.tipoDesc = TIPO_DESC;
		this.tipoValorDia = TIPO_VALOR_DIA;
		this.tipoValorHora = TIPO_VALOR_HORA;
		this.tipoTarifaExtra = TIPO_TARIFA_EXTRA;
	}
	
	public TipoTestDataBuilder conTipoId(long tipoId) {
		this.tipoId = tipoId;
		return this;
	}
	
	public TipoTestDataBuilder conTipoDesc(String tipoDesc) {
		this.tipoDesc = tipoDesc;
		return this;
	}
	
	public TipoTestDataBuilder conTipoValorHora(long tipoValorHora) {
		this.tipoValorHora = tipoValorHora;
		return this;
	}
	
	public TipoTestDataBuilder conTipoValorDia(long tipoValorDia) {
		this.tipoValorDia = tipoValorDia;
		return this;
	}
	
	public TipoTestDataBuilder conTipoTarifaExtra(long tipoTarifaExtra) {
		this.tipoTarifaExtra = tipoTarifaExtra;
		return this;
	}
	
	public Tipo build() {
		Tipo tipo = new Tipo();
		tipo.setTipoId(this.tipoId);
		tipo.setTipoDesc(this.tipoDesc);
		tipo.setTipoValorDia(this.tipoValorDia);
		tipo.setTipoValorHora(this.tipoValorHora);
		tipo.setTipoTarifaExtra(this.tipoTarifaExtra);
		
		return tipo;
	}
}
