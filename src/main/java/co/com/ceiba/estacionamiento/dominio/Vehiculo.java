package co.com.ceiba.estacionamiento.dominio;

import lombok.Data;

@Data
public class Vehiculo {
	
	private Long vehiculoId;
	private Long tipoId;
	private Long vehiculoCilindraje;
	private Long userId;
}
