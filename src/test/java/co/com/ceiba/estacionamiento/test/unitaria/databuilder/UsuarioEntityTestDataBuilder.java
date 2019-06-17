package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.UsuarioEntity;

public class UsuarioEntityTestDataBuilder {
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
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioEntityTestDataBuilder.class);

	public UsuarioEntityTestDataBuilder() {
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

	public UsuarioEntityTestDataBuilder conUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public UsuarioEntityTestDataBuilder conUserNombre(String userNombre) {
		this.userNombre = userNombre;
		return this;
	}

	public UsuarioEntityTestDataBuilder conUserApellido(String userApellido) {
		this.userApellido = userApellido;
		return this;
	}

	public UsuarioEntityTestDataBuilder conUserFechaNacimiento(Date userFechaNacimiento) {
		this.userFechaNacimiento = userFechaNacimiento;
		return this;
	}

	public UsuarioEntityTestDataBuilder conUserSexo(String userSexo) {
		this.userSexo = userSexo;
		return this;
	}

	public UsuarioEntity build() {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setUserId(this.userId);
		usuarioEntity.setUserNombre(this.userNombre);
		usuarioEntity.setUserApellido(this.userApellido);
		usuarioEntity.setUserFechaNacimiento(this.userFechaNacimiento);
		usuarioEntity.setUserSexo(this.userSexo);
		return usuarioEntity;
	}
}
