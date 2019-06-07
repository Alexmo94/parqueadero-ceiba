package co.com.ceiba.estacionamiento.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.UsuarioEntity;

public interface UsuarioRepositorioJPA extends JpaRepository<UsuarioEntity, Long>{

}
