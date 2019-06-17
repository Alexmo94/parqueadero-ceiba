package co.com.ceiba.estacionamiento.test.unitaria.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioVehiculo;
import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.controlador.ControladorVehiculo;
import co.com.ceiba.estacionamiento.test.unitaria.dominio.databuilder.VehiculoTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ControladorVehiculo.class)
public class ControladorEstacionamientoTest {

	private static final long VEHICULO_ID = 1;

	private Vehiculo vehiculo;
	private ObjectWriter objectWriter;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehiculoRepositorio vehiculoRepositorio;

	@MockBean
	private ServicioVehiculo serviciovehiculo;

	@Before
	public void setUp() throws Exception {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conVehiculoId(VEHICULO_ID)
				.conCinlindraje(0).conPlaca(null).conTipoId(0).conUsuario(0);
		vehiculo = vehiculoTestDataBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void guardarEntradaEstacionamientoTest() throws Exception {
		String vehiculoJson = objectWriter.writeValueAsString(vehiculo);

		mockMvc.perform(
				post("/api/estacionamiento/entrada").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson))
				.andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void guardarSalidaEstacionamientoTest() throws Exception {
		String vehiculoJson = objectWriter.writeValueAsString(vehiculo);

		mockMvc.perform(patch("/api/estacionamiento/" + vehiculo.getVehiculoPlaca())
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson)).andDo(print())
				.andExpect(status().isCreated());
	}
}
