package co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	private long userId;
	
	@Column(name = "user_nombre", nullable = false)
	private String userNombre;
	
	@Column(name = "user_apellidos", nullable = false)
	private String userApellido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_fecha_nacimiento", nullable = false)
	private Date userFechaNacimiento;
	
	@Column(name = "user_sexo", nullable = false)
	private String userSexo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userId")
	private Set<VehiculoEntity> vehiculos;

}
