package co.com.ceiba.estacionamiento.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.aplicacion.servicio.ServicioUsuario;
import co.com.ceiba.estacionamiento.dominio.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/usuario")
@Api(tags = "usuario")
public class ControladorUsuario {
	
	private ServicioUsuario servicio;
	
	public ControladorUsuario(ServicioUsuario servicio) {
		this.servicio = servicio;
	}

	@PostMapping
	@ApiOperation(value = "Registrar Usuario", notes = "Registra un nuevo usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario registrado correctamente"),
			@ApiResponse(code = 404, message = "Solicitud Invalida") })
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		servicio.guardar(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}


