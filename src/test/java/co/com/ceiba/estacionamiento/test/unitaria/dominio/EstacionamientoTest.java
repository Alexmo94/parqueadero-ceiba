package co.com.ceiba.estacionamiento.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.EstacionamientoTestDataBuilder;

public class EstacionamientoTest {

	private static final long PARKING_ID = 1L;
	private static final String PARKING_FECHA_ENTRADA = "14/06/2019 07:00";
	private static final String PARKING_FECHA_SALIDA = "15/06/2019 11:00";
	private static final long PARKING_VALOR_TOTAL = 1L;
	private static final long VEHICULO_ID = 1L;

	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm");

	@Test
	public void estacionamientoBuild() throws ParseException {
		EstacionamientoTestDataBuilder estacionamientoTestDataBuilder = new EstacionamientoTestDataBuilder();

		Estacionamiento estacionamiento = estacionamientoTestDataBuilder.conParkingId(PARKING_ID)
				.conParkingFechaEntrada(formato.parse(PARKING_FECHA_ENTRADA))
				.conParkingFechaSalida(formato.parse(PARKING_FECHA_SALIDA)).conParkingTotal(PARKING_VALOR_TOTAL)
				.conVehiculoId(VEHICULO_ID).build();
		
		assertNotNull(estacionamiento);
		assertEquals(estacionamiento.getParkingFechaEntrada(), formato.parse(PARKING_FECHA_ENTRADA));
		assertEquals(estacionamiento.getParkingFechaSalida(), formato.parse(PARKING_FECHA_SALIDA));
		assertEquals(estacionamiento.getParkingId(), PARKING_ID);
		assertEquals(estacionamiento.getParkingTotal(), PARKING_ID);
		assertEquals(estacionamiento.getVehiculoId(), VEHICULO_ID);

	}

}
