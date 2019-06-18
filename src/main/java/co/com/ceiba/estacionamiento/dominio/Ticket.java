package co.com.ceiba.estacionamiento.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ticket {

	private Usuario usuario;
	private Estacionamiento estacionamiento;
	private Vehiculo vehiculo;
}
