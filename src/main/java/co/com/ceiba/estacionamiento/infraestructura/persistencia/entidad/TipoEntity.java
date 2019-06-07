package co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tipo")
public class TipoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoId;
	
	@Column(name = "tipo_desc")
	private String tipoDesc;
	
	@Column(name = "tipo_valor_hora")
	private Long tipoValorHora;
	
	@Column(name = "tipo_valor_dia")
	private Long tipoValorDia;
	
	@Column(name = "tipo_tarifa_extra")
	private Long tipoTarifaExtra;
	
	@JsonIgnore
	@OneToMany(mappedBy ="tipoId")
	private Set<VehiculoEntity> vehiculos;

	
}
