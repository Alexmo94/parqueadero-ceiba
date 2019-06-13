package co.com.ceiba.estacionamiento.dominio.excepcion;

public class VehiculoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1755102158730351946L;
	
	public VehiculoNotFoundException(String message) {
		super(message);
	}
	
}
