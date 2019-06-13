package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.repositorio.TipoRepositorio;

@Service
public class ServicioTipo {

	private TipoRepositorio repository;

	public ServicioTipo(TipoRepositorio repository) {
		this.repository = repository;
	}
	
	public Tipo guardar(Tipo usuario) {	
		return repository.guardar(usuario);
	}

}
