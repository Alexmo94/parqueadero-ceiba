package co.com.ceiba.estacionamiento.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioTipo;
import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.dominio.Usuario;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/tipo")
@Api(tags = "tipo")
public class ControladorTipo {
	
	private ServicioTipo servicio;
	
	public ControladorTipo(ServicioTipo servicio) {
		this.servicio = servicio;
	}

	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Tipo tipo) {
		servicio.guardar(tipo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}


