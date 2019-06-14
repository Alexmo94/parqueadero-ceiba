package co.com.ceiba.estacionamiento.dominio;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.base.Objects;

import co.com.ceiba.estacionamiento.dominio.excepcion.EstacionamientoNotFoundException;
import co.com.ceiba.estacionamiento.dominio.excepcion.TipoNotFoundException;

@Component
public class Registro {

	private static final long TIPO_CARRO = 2;
	private static final long TIPO_MOTO = 1;
	private static final String ERROR_VEHICULO_INCOMPATIPLE = "Tipo de Vehiculo Incompatible";
	private static final String ERROR_ACCESO_DENEGADO_VEHICULO = "Acceso denegado: Los Vehiculos con placas que inicial con "
			+ "'A' Solo pueden ingresar los Domingos y Lunes";
	private static final String ERROR_CAPACIDAD_MAXIMA = "Acceso denegado: El estacionamiento está en su máxima capacidad";

	private static final String LETRA_INICIAL_PLACA_A = "A";
	private static final int CAPACIDAD_MAXIMA_CARROS_ESTACIONAMIENTO = 20;
	private static final int CAPACIDAD_MAXIMA_MOTOS_ESTACIONAMIENTO = 10;
	private static final int CILINDRAJE_MOTO_MINIMO_TARIFA = 500;

	public Estacionamiento validarRegistro(Vehiculo vehiculo) {
		Estacionamiento estacionamiento;
		Calendar fechaIngreso;

		if (!(Objects.equal(vehiculo.getTipoId(), TIPO_CARRO) || Objects.equal(vehiculo.getTipoId(), TIPO_MOTO))) {
			throw new TipoNotFoundException(ERROR_VEHICULO_INCOMPATIPLE);
		}
		fechaIngreso = Calendar.getInstance();
		if (autorizarIngresoVehiculo(vehiculo, fechaIngreso) || !validarPlacaA(vehiculo.getVehiculoPlaca())) {
			estacionamiento = new Estacionamiento();
			estacionamiento.setVehiculoId(vehiculo.getVehiculoId());
			estacionamiento.setParkingFechaEntrada(fechaIngreso.getTime());
			return estacionamiento;
		}
		throw new EstacionamientoNotFoundException(ERROR_ACCESO_DENEGADO_VEHICULO);
	}

	public boolean validarPlacaA(String vehiculoPlaca) {
		return vehiculoPlaca.toUpperCase().startsWith(LETRA_INICIAL_PLACA_A);
	}

	public boolean autorizarIngresoVehiculo(Vehiculo vehiculo, Calendar fechaIngreso) {
		return (validarPlacaA(vehiculo.getVehiculoPlaca()) && validarIngresoDiaVehiculo(fechaIngreso));
	}

	public boolean validarIngresoDiaVehiculo(Calendar fechaIngreso) {
		return (Objects.equal(fechaIngreso.get(Calendar.DAY_OF_WEEK), Calendar.SUNDAY)
				|| Objects.equal(fechaIngreso.get(Calendar.DAY_OF_WEEK), Calendar.MONDAY) ? Boolean.TRUE
						: Boolean.FALSE);
	}

	public void validarEspacioEstacionamiento(long contadorEspacioEstacionamiento, long tipoId) {
		boolean estaOcupado = ((tipoId == TIPO_CARRO ? CAPACIDAD_MAXIMA_CARROS_ESTACIONAMIENTO
				: CAPACIDAD_MAXIMA_MOTOS_ESTACIONAMIENTO) <= contadorEspacioEstacionamiento);
		if (estaOcupado)
			throw new EstacionamientoNotFoundException(ERROR_CAPACIDAD_MAXIMA);
	}

	public Estacionamiento validarSalidaEstacionamiento(Vehiculo vehiculo, Tipo tipo, Estacionamiento estacionamiento) {
		Calendar fechaingreso;
		Calendar fechaSalida;
		fechaingreso = fechaSalida = Calendar.getInstance();
		fechaingreso.setTime(estacionamiento.getParkingFechaEntrada());
		estacionamiento.setParkingTotal(calcularTotalParking(fechaingreso, fechaSalida, tipo, vehiculo));
		estacionamiento.setParkingFechaSalida(fechaSalida.getTime());
		return estacionamiento;
	}

	public long calcularTotalParking(Calendar fechaIngreso, Calendar fechaSalida, Tipo tipo, Vehiculo vehiculo) {
		long precio = 0;
		long tiempoServicio = TimeUnit.MILLISECONDS
				.toHours(fechaSalida.getTimeInMillis() - fechaIngreso.getTimeInMillis());
		while (tiempoServicio >= 24) {
			precio += tipo.getTipoValorDia();
			tiempoServicio -= 24;
		}
		precio += (tiempoServicio >= 9 ? tipo.getTipoValorDia() : tipo.getTipoValorHora() * tiempoServicio)
				+ ((tipo.getTipoId() == TIPO_MOTO && vehiculo.getVehiculoCilindraje() >= CILINDRAJE_MOTO_MINIMO_TARIFA)
						? tipo.getTipoTarifaExtra()
						: 0);
		return precio;
	}

}
