package co.com.ceiba.estacionamiento.test.integracion;

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
import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.TipoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class TipoControladorIntegrationTest {

	public static final long TIPO_ID = 3;
	public static final long TIPO_ID_MOTO = 1;
	public static final String TIPO_DESC = "Bicicleta";
	public static final long TIPO_PRECIO_DIA = 2000;
	public static final long TIPO_PRECIO_HORA = 200;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	private Tipo tipo;
	private ObjectWriter objectWriter;

	@Before
	public void setUp() throws ParseException {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		TipoTestDataBuilder tipoTestDataBuilder = new TipoTestDataBuilder().conTipoId(TIPO_ID).conTipoDesc(TIPO_DESC)
				.conTipoValorHora(TIPO_PRECIO_HORA).conTipoValorDia(TIPO_PRECIO_DIA).conTipoTarifaExtra(0);
		tipo = tipoTestDataBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void guardartipo() throws Exception {
		String tipoJson = objectWriter.writeValueAsString(tipo);
		mockMvc.perform(post("/api/tipo").contentType(MediaType.APPLICATION_JSON_UTF8).content(tipoJson)).andDo(print())
				.andExpect(status().isCreated());
	}

	/*@Test
	public void consultarTipo() throws Exception {
		mockMvc.perform(get("/api/tipo/" + TIPO_ID_MOTO).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}*/

}
