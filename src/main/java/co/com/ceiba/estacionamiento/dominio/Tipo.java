package co.com.ceiba.estacionamiento.dominio;

import lombok.Data;

@Data
public class Tipo {
	
	private Long tipoId;
	private String tipoDesc;
	private Long tipoValorHora;
	private Long tipoValorDia;
	private Long tipoTarifaExtra;
	
}
