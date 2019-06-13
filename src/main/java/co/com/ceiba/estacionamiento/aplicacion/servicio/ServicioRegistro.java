package co.com.ceiba.estacionamiento.aplicacion.servicio;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.dominio.Registro;
import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.Vehiculo;

@Service
public class ServicioRegistro {
	
	private final Registro registro;
	
	public ServicioRegistro(final Registro registro) {
		this.registro = registro;
	}
	
	public Estacionamiento validarRegistro (Vehiculo vehiculo) {
		return registro.validarRegistro(vehiculo);
	}
	
	public void validarEspacioEstacionamiento(long contadorEspacioEstacionamiento, long tipoId) {
		registro.validarEspacioEstacionamiento(contadorEspacioEstacionamiento, tipoId);
	}
	
	public Estacionamiento validarSalidaEstacionamiento(Vehiculo vehiculo, Tipo tipo, Estacionamiento estacionamiento) {
		return registro.validarSalidaEstacionamiento(vehiculo, tipo, estacionamiento);
	}

}
