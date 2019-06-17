package co.com.ceiba.estacionamiento.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Registro;
import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.dominio.excepcion.EstacionamientoNotFoundException;
import co.com.ceiba.estacionamiento.dominio.excepcion.TipoNotFoundException;
import co.com.ceiba.estacionamiento.test.unitaria.dominio.databuilder.RegistroTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.dominio.databuilder.TipoTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.dominio.databuilder.VehiculoTestDataBuilder;

public class RegistroTest {

	private static final String ERROR_VEHICULO_INCOMPATIPLE = "Tipo de Vehiculo Incompatible";
	private static final String ERROR_ACCESO_DENEGADO_VEHICULO = "Acceso denegado: Los Vehiculos con placas que inicial con "
			+ "'A' Solo pueden ingresar los Domingos y Lunes";
	private static final String ERROR_CAPACIDAD_MAXIMA = "Acceso denegado: El estacionamiento está en su máxima capacidad";
	private static final String PLACA_VEHICULO_CON_LETRA_A = "AJE74A";
	private static final String PLACA_VEHICULO = "VJE746";
	private static final int CAPACIDAD_MAXIMA_CARROS = 20;
	private static final int CAPACIDAD_MAXIMA_MOTOS = 10;
	private static final long TIPO_CARRO = 2;
	private static final long TIPO_MOTO = 1;
	private static final String PARKING_FECHA_ENTRADA = "14/06/2019 07:00";
	private static final String PARKING_FECHA_SALIDA = "15/06/2019 11:00";

	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm");

	private Registro registro;

	@Before
	public void setUp() {
		// arrage
		RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder();

		// act
		registro = registroTestDataBuilder.build();
	}

	@Test
	public void registroBuild() {
		// act
		assertNotNull(registro);
	}

	@Test
	public void autorizarIngresoVehiculovalidarPlacaADomingo() {
		Calendar fechaIngreso = Calendar.getInstance();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_CON_LETRA_A);
		fechaIngreso.set(2019, 5, 9, 7, 0);
		assertTrue(registro.autorizarIngresoVehiculo(vehiculoTestDataBuilder.build(), fechaIngreso));
	}

	@Test
	public void autorizarIngresoVehiculovalidarPlacaNormalDomingo() {
		Calendar fechaIngreso = Calendar.getInstance();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_VEHICULO);
		fechaIngreso.set(2019, 5, 9, 7, 0);
		assertFalse(registro.autorizarIngresoVehiculo(vehiculoTestDataBuilder.build(), fechaIngreso));
	}

	@Test
	public void autorizarIngresoVehiculovalidarPlacaALunes() {
		Calendar fechaIngreso = Calendar.getInstance();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_CON_LETRA_A);
		fechaIngreso.set(2019, 5, 10, 7, 0);
		assertTrue(registro.autorizarIngresoVehiculo(vehiculoTestDataBuilder.build(), fechaIngreso));
	}

	@Test
	public void autorizarIngresoVehiculovalidarPlacaNormalLunes() {
		Calendar fechaIngreso = Calendar.getInstance();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_VEHICULO);
		fechaIngreso.set(2019, 5, 10, 7, 0);
		assertFalse(registro.autorizarIngresoVehiculo(vehiculoTestDataBuilder.build(), fechaIngreso));
	}

	@Test
	public void autorizarIngresoVehiculovalidarPlacaADiaNormal() {
		Calendar fechaIngreso = Calendar.getInstance();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_CON_LETRA_A);
		fechaIngreso.set(2019, 5, 11, 7, 0);
		assertFalse(registro.autorizarIngresoVehiculo(vehiculoTestDataBuilder.build(), fechaIngreso));
	}

	@Test
	public void autorizarIngresoVehiculovalidarPlacaNormalDiaNormal() {
		Calendar fechaIngreso = Calendar.getInstance();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA_VEHICULO);
		fechaIngreso.set(2019, 5, 11, 7, 0);
		assertFalse(registro.autorizarIngresoVehiculo(vehiculoTestDataBuilder.build(), fechaIngreso));
	}

	@Test
	public void validarRegistroEstacionamientoConVehiculoTipoMoto() {

		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conTipoId(TIPO_MOTO);
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		assertNotNull(registro.validarRegistro(vehiculo));
	}

	@Test
	public void validarRegistroEstacionamientoConVehiculoTipoCarro() {

		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conTipoId(TIPO_CARRO);
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		assertNotNull(registro.validarRegistro(vehiculo));
	}

	@Test
	public void validarErrorTipoNoExistente() {

		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conTipoId(3);
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		try {
			registro.validarRegistro(vehiculo);
			fail();
		} catch (TipoNotFoundException e) {
			assertEquals(ERROR_VEHICULO_INCOMPATIPLE, e.getMessage());
		}
	}

	/*@Test
	public void validarErrorEstacionamientoAccesoDenegado() {

		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_CON_LETRA_A);
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		try {
			registro.validarRegistro(vehiculo);
			fail();
		} catch (EstacionamientoNotFoundException e) {
			assertEquals(ERROR_ACCESO_DENEGADO_VEHICULO, e.getMessage());
		}
	}*/

	@Test
	public void validarEspacioEstacionamientoCarrosExcepcion() {
		try {
			registro.validarEspacioEstacionamiento(CAPACIDAD_MAXIMA_CARROS, TIPO_CARRO);
			fail();
		} catch (EstacionamientoNotFoundException e) {
			assertEquals(e.getMessage(), ERROR_CAPACIDAD_MAXIMA);
		}
	}

	@Test
	public void validarEspacioEstacionamientoMotosExcepcion() {
		try {
			registro.validarEspacioEstacionamiento(CAPACIDAD_MAXIMA_MOTOS, TIPO_MOTO);
			fail();
		} catch (EstacionamientoNotFoundException e) {
			assertEquals(e.getMessage(), ERROR_CAPACIDAD_MAXIMA);
		}
	}
	
	@Test
	public void validarEspacioEstacionamientoMotosExitoso() {
		assertFalse(registro.validarEspacioEstacionamiento(1, TIPO_MOTO));
	}

	@Test
	public void calcularTipoSalidaEstacionamientoCarro() throws ParseException {
		Tipo tipo = new TipoTestDataBuilder().conTipoId(TIPO_CARRO).conTipoDesc("Carro").conTipoValorDia(8000)
				.conTipoValorHora(1000).conTipoTarifaExtra(0).build();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conCinlindraje(0).conPlaca(PLACA_VEHICULO).conTipoId(TIPO_CARRO).build();
		Calendar fechaIngreso = Calendar.getInstance();
		Calendar fechaSalida = Calendar.getInstance();
		fechaIngreso.setTime(formato.parse(PARKING_FECHA_ENTRADA));
		fechaSalida.setTime(formato.parse(PARKING_FECHA_SALIDA));

		long precioTotal = registro.calcularTotalParking(fechaIngreso, fechaSalida, tipo, vehiculo);

		assertEquals(precioTotal, 12000);

	}

	@Test
	public void calcularTipoSalidaEstacionamientoMotoBajoCilindraje() throws ParseException {
		Tipo tipo = new TipoTestDataBuilder().build();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conCinlindraje(200).build();
		Calendar fechaIngreso = Calendar.getInstance();
		Calendar fechaSalida = Calendar.getInstance();
		fechaIngreso.setTime(formato.parse(PARKING_FECHA_ENTRADA));
		fechaSalida.setTime(formato.parse(PARKING_FECHA_SALIDA));

		long precioTotal = registro.calcularTotalParking(fechaIngreso, fechaSalida, tipo, vehiculo);

		assertEquals(precioTotal, 6000);

	}
	
	@Test
	public void calcularTipoSalidaEstacionamientoMotoAltoCilindraje() throws ParseException {
		Tipo tipo = new TipoTestDataBuilder().build();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		Calendar fechaIngreso = Calendar.getInstance();
		Calendar fechaSalida = Calendar.getInstance();
		fechaIngreso.setTime(formato.parse(PARKING_FECHA_ENTRADA));
		fechaSalida.setTime(formato.parse(PARKING_FECHA_SALIDA));

		long precioTotal = registro.calcularTotalParking(fechaIngreso, fechaSalida, tipo, vehiculo);

		assertEquals(precioTotal, 8000);

	}
	
	@Test
	public void calcularTipoSalidaEstacionamientoMotoMasNueveHoras() throws ParseException {
		Tipo tipo = new TipoTestDataBuilder().build();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		Calendar fechaIngreso = Calendar.getInstance();
		Calendar fechaSalida = Calendar.getInstance();
		fechaIngreso.setTime(formato.parse(PARKING_FECHA_ENTRADA));
		fechaSalida.setTime(formato.parse("15/06/2019 18:00"));

		long precioTotal = registro.calcularTotalParking(fechaIngreso, fechaSalida, tipo, vehiculo);

		assertEquals(precioTotal, 10000);

	}
	
}
