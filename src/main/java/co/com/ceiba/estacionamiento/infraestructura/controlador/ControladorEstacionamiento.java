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
	
	@PostMapping
	public ResponseEntity<Estacionamiento> ingresarVehiculoEstacionamiento(@RequestBody Vehiculo vehiculo) {
		servicioEstacionamiento.registrarEntrada(vehiculo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PatchMapping("/{vehiculoPlaca}")
	public ResponseEntity<Estacionamiento> extraerVehiculoEstacionamiento(@PathVariable String vehiculoPlaca) {
		servicioEstacionamiento.registrarSalida(vehiculoPlaca);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
