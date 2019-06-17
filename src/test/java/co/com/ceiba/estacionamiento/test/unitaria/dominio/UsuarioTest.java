package co.com.ceiba.estacionamiento.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.UsuarioTestDataBuilder;

public class UsuarioTest {

	private static final long CEDULA_USUARIO = 52074603L;
	private static final String NOMBRE_USUARIO = "Daniela";
	private static final String APELLIDO_USUARIO = "Zambrano";
	private static final String GENERO_USUARIO = "F";
	private static final String FECHA_NACIMIENTO_USUARIO = "17/06/1996";

	private SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

	private Usuario usuario;

	@Before
	public void setUp() throws ParseException {
		// arrage
		UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conUserId(CEDULA_USUARIO)
				.conUserNombre(NOMBRE_USUARIO).conUserApellido(APELLIDO_USUARIO)
				.conUserFechaNacimiento(formato.parse(FECHA_NACIMIENTO_USUARIO)).conUserSexo(GENERO_USUARIO);
		// act
		usuario = usuarioTestDataBuilder.build();
	}

	@Test
	public void buildUsuario() throws ParseException{
		//assert
		assertNotNull(usuario);
		assertEquals(usuario.getUserId(), CEDULA_USUARIO);
		assertEquals(usuario.getUserNombre(),NOMBRE_USUARIO);
		assertEquals(usuario.getUserApellido(), APELLIDO_USUARIO);
		assertEquals(usuario.getUserFechaNacimiento(), formato.parse(FECHA_NACIMIENTO_USUARIO));
		assertEquals(usuario.getUserSexo(), GENERO_USUARIO);
	}
}
