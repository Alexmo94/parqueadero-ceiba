package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.EstacionamientoEntity;

public interface EstacionamientoRepositorioJPA extends JpaRepository<EstacionamientoEntity, Long>{

	int countByVehiculoIdTipoIdTipoIdAndParkingTotal(long tipoId, long parkingTotal);
	
	Optional<EstacionamientoEntity> findByVehiculoIdVehiculoPlaca(String vehiculoPlaca);
	
}
