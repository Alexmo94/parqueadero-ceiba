package co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "vehiculo")

public class VehiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vehiculoId;

	@ManyToOne
	@JoinColumn(name = "tipo_id", nullable = false)
	private TipoEntity tipoId;

	@Column(name = "vehiculo_cilindraje", nullable = true)
	private long vehiculoCilindraje;

	@Column(name = "vehiculo_placa", nullable = true)
	private String vehiculoPlaca;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UsuarioEntity userId;

	@JsonIgnore
	@OneToMany(mappedBy = "vehiculoId")
	private Set<EstacionamientoEntity> estacionamientos;

}
