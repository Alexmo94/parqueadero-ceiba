package co.com.ceiba.estacionamiento.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioVehiculo;
import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/vehiculo")
@Api(tags = "vehiculo")
public class ControladorVehiculo {
	
	private final ServicioVehiculo servicio;
	
	public ControladorVehiculo(final ServicioVehiculo servicio) {
		this.servicio = servicio;
	}

	@PostMapping
	public ResponseEntity<Usuario> guardarVehiculo(@RequestBody Vehiculo vehiculo) {
		servicio.guardarVehiculo(vehiculo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{vehiculoPlaca}")
	public ResponseEntity<Vehiculo> get(@PathVariable("vehiculoPlaca") String vehiculoPlaca) {
		return new ResponseEntity<>(servicio.consultarPorPlaca(vehiculoPlaca), HttpStatus.OK);
	}
	
}
