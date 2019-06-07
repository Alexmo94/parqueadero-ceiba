package co.com.ceiba.estacionamiento.dominio;

import java.util.Date;

import lombok.Data;

@Data
public class Estacionamiento {

	private Long parkingId;	
	private Long vehiculoId;
	private Date parkingFechaEntrada;
	private Date parkingFechaSalida;
	private Long parkingTotal;
	
}
