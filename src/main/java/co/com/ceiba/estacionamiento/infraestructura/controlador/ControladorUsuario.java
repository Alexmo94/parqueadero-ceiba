package co.com.ceiba.estacionamiento.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioUsuario;
import co.com.ceiba.estacionamiento.dominio.Usuario;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/usuario")
@Api(tags = "usuario")
public class ControladorUsuario {

	private final ServicioUsuario servicio;

	public ControladorUsuario(final ServicioUsuario servicio) {
		this.servicio = servicio;
	}

	@PostMapping
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
		servicio.crearUsuario(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Usuario> consultarUsuario(@PathVariable("userId") Long userId) {
		return new ResponseEntity<>(servicio.consultarUsuarioPorId(userId), HttpStatus.OK);
	}

}
