package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.TipoEntity;

public interface TipoRepositorioJPA extends JpaRepository<TipoEntity, Long> {
	
	

}
