package co.com.ceiba.estacionamiento.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.UsuarioTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class UsuarioControladorIntegrationTest {

	private static final long USER_ID = 1022398602;
	private static final long USER_ID_OPCIONAL = 1234851;
	private static final String USER_NOMBRE = "Haroll Alexander";
	private static final String USER_APELLIDO = "Mora Garzon";
	private static final String USER_FECHA_NACIMIENTO = "20/11/1994";
	private static final String USER_SEXO = "M";

	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	private Usuario usuario;
	private ObjectWriter objectWriter;

	@Before
	public void setUp() throws ParseException {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conUserId(USER_ID)
				.conUserNombre(USER_NOMBRE).conUserApellido(USER_APELLIDO)
				.conUserFechaNacimiento(formato.parse(USER_FECHA_NACIMIENTO)).conUserSexo(USER_SEXO);
		usuario = usuarioTestDataBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void guardarUsuario() throws Exception {
		String usuarioJson = objectWriter.writeValueAsString(usuario);
		mockMvc.perform(post("/api/usuario").contentType(MediaType.APPLICATION_JSON_UTF8).content(usuarioJson))
				.andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void consultarUsuario() throws Exception {
		mockMvc.perform(get("/api/usuario/"+ USER_ID_OPCIONAL).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	/*@Test
	public void consultarUsuarioError() throws Exception {
		mockMvc.perform(get("/api/usuario/"+ USER_ID_NO_EXISTE).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isInternalServerError());
	}*/	
		
}
