package co.com.ceiba.estacionamiento.dominio.excepcion;

public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1755102158730351946L;

	public UsuarioNotFoundException(String message) {
		super(message);
	}
}
