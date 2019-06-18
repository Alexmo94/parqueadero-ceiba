package co.com.ceiba.estacionamiento.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.com.ceiba.estacionamiento.Application;
import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.VehiculoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class VehiculoControladorIntegrationTest {

	public static final long VEHICULO_ID = 3;
	private static final long USER_ID = 1234851;
	public static final String VEHICULO_PLACA = "RQG72E";
	public static final String VEHICULO_PLACA_OPCIONAL = "RQR45A";
	public static final long TIPO_ID = 1;
	public static final long CILINDRAJE = 200;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	private Vehiculo vehiculo;
	private ObjectWriter objectWriter;

	@Before
	public void setUp() throws ParseException {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conCinlindraje(CILINDRAJE)
				.conPlaca(VEHICULO_PLACA).conTipoId(TIPO_ID).conUsuario(USER_ID);
		vehiculo = vehiculoTestDataBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void guardarvehiculo() throws Exception {
		String vehiculoJson = objectWriter.writeValueAsString(vehiculo);
		mockMvc.perform(post("/api/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson))
				.andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void consultarVehiculoPorPlaca() throws Exception {
		mockMvc.perform(get("/api/vehiculo/" + VEHICULO_PLACA_OPCIONAL).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print()).andExpect(status().isOk());
	}

}
