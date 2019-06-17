package co.com.ceiba.estacionamiento.dominio;

import lombok.Data;

@Data
public class Ticket {

	private Usuario usuario;
	private Estacionamiento estacionamiento;
	private Vehiculo vehiculo;
}
