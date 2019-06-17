package co.com.ceiba.estacionamiento.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	private static final long VEHICULO_ID = 1L;
	private static final String VEHICULO_PLACA = "AGS12A";
	private static final long VEHICULO_CILINDRAJE = 200L;
	private static final long TIPO_ID = 1L;
	private static final long USER_ID = 52074603L;

	private Vehiculo vehiculo;

	@Before
	public void setUp() {
		// arrage
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
				.conCinlindraje(VEHICULO_CILINDRAJE).conTipoId(TIPO_ID).conUsuario(USER_ID).conVehiculoId(VEHICULO_ID)
				.conPlaca(VEHICULO_PLACA);
		// act
		vehiculo = vehiculoTestDataBuilder.build();
	}

	@Test
	public void buildvehiculo() throws ParseException {
		// assert
		assertNotNull(vehiculo);
		assertEquals(vehiculo.getUserId(), USER_ID);
		assertEquals(vehiculo.getVehiculoId(), VEHICULO_ID);
		assertEquals(vehiculo.getVehiculoCilindraje(), VEHICULO_CILINDRAJE);
		assertEquals(vehiculo.getTipoId(), TIPO_ID);
		assertEquals(vehiculo.getVehiculoPlaca(), VEHICULO_PLACA);
	}
}
