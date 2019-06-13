package co.com.ceiba.estacionamiento.dominio.excepcion;

public class EstacionamientoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1755102158730351946L;

	public EstacionamientoNotFoundException(String message) {
		super(message);
	}
}
