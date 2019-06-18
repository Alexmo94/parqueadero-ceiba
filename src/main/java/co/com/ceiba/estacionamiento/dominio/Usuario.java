package co.com.ceiba.estacionamiento.dominio;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Usuario {

	private long userId;
	private String userNombre;
	private String userApellido;
	private Date userFechaNacimiento;
	private String userSexo;
	
}
