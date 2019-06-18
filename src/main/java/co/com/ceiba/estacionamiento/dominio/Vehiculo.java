package co.com.ceiba.estacionamiento.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehiculo {

	private long vehiculoId;
	private long tipoId;
	private long vehiculoCilindraje;
	private String vehiculoPlaca;
	private long userId;
	
}
