package co.com.ceiba.estacionamiento.aplicacion.servicio;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.dominio.Ticket;
import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.dominio.repositorio.EstacionamientoRepositorio;
import co.com.ceiba.estacionamiento.dominio.repositorio.TipoRepositorio;
import co.com.ceiba.estacionamiento.dominio.repositorio.UsuarioRepositorio;
import co.com.ceiba.estacionamiento.dominio.repositorio.VehiculoRepositorio;

@Service
public class ServicioEstacionamiento {

	private static final long TOTAL_PARKING_CERO = 0;

	private final EstacionamientoRepositorio estacionamientoRepositorio;
	private final VehiculoRepositorio vehiculoRepositorio;
	private final ServicioRegistro servicioRegistro;
	private final TipoRepositorio tipoRepositorio;
	private final UsuarioRepositorio usuarioRepositorio;

	public ServicioEstacionamiento(final EstacionamientoRepositorio estacionamientoRepositorio,
			final VehiculoRepositorio vehiculoRepositorio, final ServicioRegistro servicioRegistro,
			final TipoRepositorio tipoRepositorio, final UsuarioRepositorio usuarioRepositorio) {
		this.estacionamientoRepositorio = estacionamientoRepositorio;
		this.vehiculoRepositorio = vehiculoRepositorio;
		this.servicioRegistro = servicioRegistro;
		this.tipoRepositorio = tipoRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public Estacionamiento registrarEntrada(Vehiculo vehiculo) {
		Calendar fechaIngreso = Calendar.getInstance();
		vehiculo = vehiculoRepositorio.consultById(vehiculo.getVehiculoId());
		estacionamientoRepositorio.validarVehiculoEstacionado(vehiculo.getVehiculoPlaca());
		long contadorEspacioVehiculos = estacionamientoRepositorio.contarEspaciosEstacionamiento(vehiculo.getTipoId(),
				TOTAL_PARKING_CERO);
		servicioRegistro.validarEspacioEstacionamiento(contadorEspacioVehiculos, vehiculo.getTipoId());
		return this.estacionamientoRepositorio.registrarEntrada(this.servicioRegistro.validarRegistro(vehiculo, fechaIngreso));
	}

	public Ticket registrarSalida(String vehiculoPlaca) {
		Vehiculo vehiculo = vehiculoRepositorio.consultarVehiculoPorPlaca(vehiculoPlaca);
		Tipo tipo = tipoRepositorio.consultById(vehiculo.getTipoId());
		Usuario usuario = usuarioRepositorio.consultarUsuarioPorId(vehiculo.getUserId());
		Estacionamiento estacionamiento = estacionamientoRepositorio
				.consultarPorVehiculoRegistradoYParkingTotal(vehiculoPlaca);
		return servicioRegistro.validarSalidaEstacionamiento(vehiculo, tipo, estacionamiento, usuario);
	}
}
