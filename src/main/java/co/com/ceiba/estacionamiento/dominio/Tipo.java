package co.com.ceiba.estacionamiento.dominio;

import lombok.Data;

@Data
public class Tipo {
	
	private long tipoId;
	private String tipoDesc;
	private long tipoValorHora;
	private long tipoValorDia;
	private long tipoTarifaExtra;
	
}
