package co.com.ceiba.estacionamiento.dominio;

import lombok.Data;

@Data
public class Vehiculo {

	private long vehiculoId;
	private long tipoId;
	private long vehiculoCilindraje;
	private String vehiculoPlaca;
	private long userId;
	
}
