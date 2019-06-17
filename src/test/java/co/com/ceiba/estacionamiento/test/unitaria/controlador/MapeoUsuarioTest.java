package co.com.ceiba.estacionamiento.test.unitaria.controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.UsuarioEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.UsuarioMapeo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.UsuarioEntityTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.UsuarioTestDataBuilder;

public class MapeoUsuarioTest {

	Usuario usuario;
	UsuarioEntity usuarioEntity;

	UsuarioTestDataBuilder usuarioTestDataBuilder;
	UsuarioEntityTestDataBuilder usuarioEntityTestDataBuilder;

	@Before
	public void setUp() {
		usuarioTestDataBuilder = new UsuarioTestDataBuilder();
		usuarioEntityTestDataBuilder = new UsuarioEntityTestDataBuilder();
	}

	@Test
	public void convertirDominioAEntidadTest() {
		usuario = usuarioTestDataBuilder.build();
		usuarioEntity = UsuarioMapeo.convertirDominioAEntity(usuario);
		assertEquals(usuario.getUserId(), usuarioEntity.getUserId());
		assertEquals(usuario.getUserNombre(), usuarioEntity.getUserNombre());
		assertEquals(usuario.getUserApellido(), usuarioEntity.getUserApellido());
		assertEquals(usuario.getUserFechaNacimiento(), usuarioEntity.getUserFechaNacimiento());
		assertEquals(usuario.getUserSexo(), usuarioEntity.getUserSexo());
	}
	
	@Test
	public void convertirEntidadADominioTest() {
		usuarioEntity = usuarioEntityTestDataBuilder.build();
		usuario = UsuarioMapeo.convertirEntityADominio(usuarioEntity);
		assertEquals(usuarioEntity.getUserId(), usuario.getUserId());
		assertEquals(usuarioEntity.getUserNombre(), usuario.getUserNombre());
		assertEquals(usuarioEntity.getUserApellido(), usuario.getUserApellido());
		assertEquals(usuarioEntity.getUserFechaNacimiento(), usuario.getUserFechaNacimiento());
		assertEquals(usuarioEntity.getUserSexo(), usuario.getUserSexo());
	}

}
