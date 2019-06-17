package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.ceiba.estacionamiento.dominio.Usuario;

public class UsuarioTestDataBuilder {

	private static final long USER_ID = 1022398602;
	private static final String USER_NOMBRE = "Haroll Alexander";
	private static final String USER_APELLIDO = "Mora Garzon";
	private static final String USER_FECHA_NACIMIENTO = "20/11/1994";
	private static final String USER_SEXO = "M";

	private Long userId;
	private String userNombre;
	private String userApellido;
	private Date userFechaNacimiento;
	private String userSexo;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioTestDataBuilder.class);

	public UsuarioTestDataBuilder() {
		try {
			this.userId = USER_ID;
			this.userNombre = USER_NOMBRE;
			this.userApellido = USER_APELLIDO;
			this.userFechaNacimiento = formato.parse(USER_FECHA_NACIMIENTO);
			this.userSexo = USER_SEXO;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public UsuarioTestDataBuilder conUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public UsuarioTestDataBuilder conUserNombre(String userNombre) {
		this.userNombre = userNombre;
		return this;
	}

	public UsuarioTestDataBuilder conUserApellido(String userApellido) {
		this.userApellido = userApellido;
		return this;
	}

	public UsuarioTestDataBuilder conUserFechaNacimiento(Date userFechaNacimiento) {
		this.userFechaNacimiento = userFechaNacimiento;
		return this;
	}

	public UsuarioTestDataBuilder conUserSexo(String userSexo) {
		this.userSexo = userSexo;
		return this;
	}

	public Usuario build() {
		Usuario usuario = new Usuario();
		usuario.setUserId(this.userId);
		usuario.setUserNombre(this.userNombre);
		usuario.setUserApellido(this.userApellido);
		usuario.setUserFechaNacimiento(this.userFechaNacimiento);
		usuario.setUserSexo(this.userSexo);
		return usuario;
	}

}
