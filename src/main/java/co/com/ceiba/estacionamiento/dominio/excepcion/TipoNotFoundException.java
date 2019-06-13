package co.com.ceiba.estacionamiento.dominio.excepcion;

public class TipoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1755102158730351946L;

	public TipoNotFoundException(String message) {
		super(message);
	}
}
