package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.repositorio.TipoRepositorio;

@Service
public class ServicioTipo {

	private final  TipoRepositorio repository;

	public ServicioTipo(final TipoRepositorio repository) {
		this.repository = repository;
	}
	
	public Tipo guardarTipo(Tipo usuario) {	
		return repository.guardarTipo(usuario);
	}

}
