package co.com.ceiba.estacionamiento.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioEstacionamiento;
import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.dominio.Ticket;
import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/estacionamiento")
@Api(tags = "estacionamiento")
public class ControladorEstacionamiento {

	private final ServicioEstacionamiento servicioEstacionamiento;

	public ControladorEstacionamiento(final ServicioEstacionamiento servicioEstacionamiento) {
		this.servicioEstacionamiento = servicioEstacionamiento;
	}

	@PostMapping("/entrada")
	public ResponseEntity<Estacionamiento> ingresarVehiculoEstacionamiento(@RequestBody Vehiculo vehiculo) {
		return new ResponseEntity<>(servicioEstacionamiento.registrarEntrada(vehiculo), HttpStatus.CREATED);
	}

	@PatchMapping("/salida/{vehiculoPlaca}")
	public ResponseEntity<Ticket> extraerVehiculoEstacionamiento(@PathVariable("vehiculoPlaca") String vehiculoPlaca) {
		return new ResponseEntity<>(servicioEstacionamiento.registrarSalida(vehiculoPlaca), HttpStatus.CREATED);
	}
}
