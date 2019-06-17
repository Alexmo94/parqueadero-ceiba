package co.com.ceiba.estacionamiento.dominio.repositorio;

import co.com.ceiba.estacionamiento.dominio.Tipo;

public interface TipoRepositorio {

	Tipo guardarTipo(Tipo tipo);

	Tipo consultById(long id);

}
