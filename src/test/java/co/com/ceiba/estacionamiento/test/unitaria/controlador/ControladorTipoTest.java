package co.com.ceiba.estacionamiento.test.unitaria.controlador;

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

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioTipo;
import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.excepcion.TipoNotFoundException;
import co.com.ceiba.estacionamiento.dominio.repositorio.TipoRepositorio;
import co.com.ceiba.estacionamiento.infraestructura.controlador.ControladorTipo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.TipoTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ControladorTipo.class)
public class ControladorTipoTest {

	private static final long TIPO_ID = 2;
	private static final String TIPO_DESC = "Carro";
	private static final long TIPO_VALOR_HORA = 1000;
	private static final long TIPO_VALOR_DIA = 8000;
	private static final long TIPO_TARIFA_EXTRA = 0;

	private Tipo tipo;
	private ObjectWriter objectWriter;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TipoRepositorio tipoRepositorio;

	@MockBean
	private ServicioTipo servicioTipo;

	@Before
	public void setUp() {
		try {
			TipoTestDataBuilder tipoTestDataBuilder = new TipoTestDataBuilder().conTipoId(TIPO_ID)
					.conTipoDesc(TIPO_DESC).conTipoValorHora(TIPO_VALOR_HORA).conTipoValorDia(TIPO_VALOR_DIA)
					.conTipoTarifaExtra(TIPO_TARIFA_EXTRA);
			tipo = tipoTestDataBuilder.build();
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
		} catch (Exception e) {
			throw new TipoNotFoundException(e.getMessage());
		}
	}

	@Test
	public void guardarTipoTest() throws Exception {
		String tipoJson = objectWriter.writeValueAsString(tipo);

		mockMvc.perform(post("/api/tipo").contentType(MediaType.APPLICATION_JSON_UTF8).content(tipoJson)).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

}
