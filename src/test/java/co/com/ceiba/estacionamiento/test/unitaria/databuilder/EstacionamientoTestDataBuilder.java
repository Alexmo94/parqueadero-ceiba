package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;

public class EstacionamientoTestDataBuilder {

	private static final long PARKING_ID = 1;
	private static final long VEHICULO_ID = 1;
	private static final String PARKING_FECHA_ENTRADA = "10/06/2019 07:00:00";
	private static final String PARKING_FECHA_SALIDA = "10/06/2019 20:00:00";
	private static final long PARKING_TOTAL = 600;

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioTestDataBuilder.class);

	private Long parkingId;
	private Long vehiculoId;
	private Date parkingFechaEntrada;
	private Date parkingFechaSalida;
	private Long parkingTotal;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");

	public EstacionamientoTestDataBuilder() {
		try {
			this.parkingId = PARKING_ID;
			this.vehiculoId = VEHICULO_ID;
			this.parkingFechaEntrada = formato.parse(PARKING_FECHA_ENTRADA);
			this.parkingFechaSalida = formato.parse(PARKING_FECHA_SALIDA);
			this.parkingTotal = PARKING_TOTAL;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public EstacionamientoTestDataBuilder conParkingId(Long parkingId) {
		this.parkingId = parkingId;
		return this;
	}

	public EstacionamientoTestDataBuilder conVehiculoId(Long vehiculoId) {
		this.vehiculoId = vehiculoId;
		return this;
	}

	public EstacionamientoTestDataBuilder conParkingFechaEntrada(Date parkingFechaEntrada) {
		this.parkingFechaEntrada = parkingFechaEntrada;
		return this;
	}

	public EstacionamientoTestDataBuilder conParkingFechaSalida(Date parkingFechaSalida) {
		this.parkingFechaSalida = parkingFechaSalida;
		return this;
	}

	public EstacionamientoTestDataBuilder conParkingTotal(Long parkingTotal) {
		this.parkingTotal = parkingTotal;
		return this;
	}

	public Estacionamiento build() {
		Estacionamiento estacionamiento = new Estacionamiento();
		estacionamiento.setParkingId(this.parkingId);
		estacionamiento.setVehiculoId(this.vehiculoId);
		estacionamiento.setParkingFechaEntrada(this.parkingFechaEntrada);
		estacionamiento.setParkingFechaSalida(this.parkingFechaSalida);
		estacionamiento.setParkingTotal(this.parkingTotal);
		return estacionamiento;
	}

}
