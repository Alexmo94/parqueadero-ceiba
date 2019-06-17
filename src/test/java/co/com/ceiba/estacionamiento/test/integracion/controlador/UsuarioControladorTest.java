package co.com.ceiba.estacionamiento.test.integracion.controlador;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.estacionamiento.Application;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = Application.class)
@AutoConfigureMockMvc
public class UsuarioControladorTest {

	@Autowired
	private WebApplicationContext contexto;
	private MockMvc mvc;
	
	@Before
	public void setUp () {
		mvc = MockMvcBuilders.webAppContextSetup(contexto).build();
	}
	
	@Test
	public void crearUsuario () {
		
	}
	
	
}
