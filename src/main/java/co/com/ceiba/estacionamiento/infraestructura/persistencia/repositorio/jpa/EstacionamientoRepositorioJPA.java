package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.EstacionamientoEntity;

public interface EstacionamientoRepositorioJPA extends JpaRepository<EstacionamientoEntity, Long>{

}
