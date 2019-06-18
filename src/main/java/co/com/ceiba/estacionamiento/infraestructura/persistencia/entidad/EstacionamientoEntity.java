package co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "estacionamiento")
public class EstacionamientoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long parkingId;

	@ManyToOne
	@JoinColumn(name = "vehiculo_id", nullable = false)
	private VehiculoEntity vehiculoId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "parking_fecha_entrada", nullable = false)
	private Date parkingFechaEntrada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "parking_fecha_salida", nullable = true)
	private Date parkingFechaSalida;

	@Column(name = "parking_total", nullable = true)
	private long parkingTotal;

}
