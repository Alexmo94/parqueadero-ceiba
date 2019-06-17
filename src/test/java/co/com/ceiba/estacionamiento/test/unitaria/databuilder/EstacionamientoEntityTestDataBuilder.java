package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.EstacionamientoEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.VehiculoEntity;

public class EstacionamientoEntityTestDataBuilder {

	private static final long PARKING_ID = 1;
	private static final VehiculoEntity VEHICULO_ID = new VehiculoEntityTestDataBuilder().build();
	private static final String PARKING_FECHA_ENTRADA = "10/06/2019 07:00:00";
	private static final String PARKING_FECHA_SALIDA = "10/06/2019 20:00:00";
	private static final long PARKING_TOTAL = 600;

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioTestDataBuilder.class);

	private Long parkingId;
	private VehiculoEntity vehiculoId;
	private Date parkingFechaEntrada;
	private Date parkingFechaSalida;
	private Long parkingTotal;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");

	public EstacionamientoEntityTestDataBuilder() {
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

	public EstacionamientoEntityTestDataBuilder conParkingId(Long parkingId) {
		this.parkingId = parkingId;
		return this;
	}

	public EstacionamientoEntityTestDataBuilder conVehiculoId(VehiculoEntity vehiculoId) {
		this.vehiculoId = vehiculoId;
		return this;
	}

	public EstacionamientoEntityTestDataBuilder conParkingFechaEntrada(Date parkingFechaEntrada) {
		this.parkingFechaEntrada = parkingFechaEntrada;
		return this;
	}

	public EstacionamientoEntityTestDataBuilder conParkingFechaSalida(Date parkingFechaSalida) {
		this.parkingFechaSalida = parkingFechaSalida;
		return this;
	}

	public EstacionamientoEntityTestDataBuilder conParkingTotal(Long parkingTotal) {
		this.parkingTotal = parkingTotal;
		return this;
	}

	public EstacionamientoEntity build() {
		EstacionamientoEntity estacionamiento = new EstacionamientoEntity();
		estacionamiento.setParkingId(this.parkingId);
		estacionamiento.setVehiculoId(this.vehiculoId);
		estacionamiento.setParkingFechaEntrada(this.parkingFechaEntrada);
		estacionamiento.setParkingFechaSalida(this.parkingFechaSalida);
		estacionamiento.setParkingTotal(this.parkingTotal);
		return estacionamiento;
	}

}
