package co.com.ceiba.estacionamiento.test.unitaria.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;

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

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioUsuario;
import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.dominio.excepcion.UsuarioNotFoundException;
import co.com.ceiba.estacionamiento.dominio.repositorio.UsuarioRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.controlador.ControladorUsuario;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.UsuarioTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ControladorUsuario.class)
public class ControladorUsuarioTest {

	private static final long USER_ID = 1022398602;
	private static final String USER_NOMBRE = "Haroll";
	private static final String USER_APELLIDO = "Mora";
	private static final String USER_GENERO = "M";
	private static final String FECHA_NACIMIENTO = "20/11/1994";

	private final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

	private Usuario usuario;
	private ObjectWriter objectWriter;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsuarioRepositorio usuarioRepositorio;

	@MockBean
	private ServicioUsuario servicioUsuario;

	@Before
	public void setUp() {
		try {
			UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conUserApellido(USER_APELLIDO)
					.conUserNombre(USER_NOMBRE).conUserId(USER_ID).conUserSexo(USER_GENERO)
					.conUserFechaNacimiento(formato.parse(FECHA_NACIMIENTO));
			usuario = usuarioTestDataBuilder.build();
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
		} catch (Exception e) {
			throw new UsuarioNotFoundException(e.getMessage());
		}
	}

	@Test
	public void guardarUsuarioTest() throws Exception {
		String usuarioJson = objectWriter.writeValueAsString(usuario);

		mockMvc.perform(post("/api/usuario").contentType(MediaType.APPLICATION_JSON_UTF8).content(usuarioJson))
				.andDo(print()).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void consultarUsuarioTest() throws Exception {
		mockMvc.perform(get("/api/usuario/" + USER_ID).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is2xxSuccessful());
	}

}
