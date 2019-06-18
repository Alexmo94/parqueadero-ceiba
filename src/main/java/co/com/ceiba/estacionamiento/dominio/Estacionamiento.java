package co.com.ceiba.estacionamiento.dominio;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Estacionamiento {

	private long parkingId;
	private long vehiculoId;
	private Date parkingFechaEntrada;
	private Date parkingFechaSalida;
	private long parkingTotal;

}
