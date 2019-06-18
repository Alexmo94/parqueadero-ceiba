package co.com.ceiba.estacionamiento.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tipo {
	
	private long tipoId;
	private String tipoDesc;
	private long tipoValorHora;
	private long tipoValorDia;
	private long tipoTarifaExtra;
	
}
