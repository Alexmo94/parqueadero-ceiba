package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final long VEHICULO_ID = 1;
	private static final long TIPO_ID = 1;
	private static final long VEHICULO_CILINDRAJE = 650;
	private static final long USER_ID = 1022398602;
	private static final String VEHICULO_PLACA = "FSG83D";

	private long vehiculoId;
	private long tipoId;
	private long vehiculoCilindraje;
	private long userId;
	private String vehiculoPlaca;

	public VehiculoTestDataBuilder() {
		this.vehiculoId = VEHICULO_ID;
		this.tipoId = TIPO_ID;
		this.vehiculoCilindraje = VEHICULO_CILINDRAJE;
		this.userId = USER_ID;
		this.vehiculoPlaca = VEHICULO_PLACA;
	}
	public VehiculoTestDataBuilder conVehiculoId(long vehiculoId) {
		this.vehiculoId = vehiculoId;
		return this;
	}

	public VehiculoTestDataBuilder conTipoId(long tipoId) {
		this.tipoId = tipoId;
		return this;
	}

	public VehiculoTestDataBuilder conCinlindraje(long vehiculoCilindraje) {
		this.vehiculoCilindraje = vehiculoCilindraje;
		return this;
	}

	public VehiculoTestDataBuilder conUsuario(long userId) {
		this.userId = userId;
		return this;
	}
	
	public VehiculoTestDataBuilder conPlaca(String vehiculoPlaca) {
		this.vehiculoPlaca = vehiculoPlaca;
		return this;
	}

	public Vehiculo build() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setVehiculoId(this.vehiculoId);
		vehiculo.setTipoId(this.tipoId);
		vehiculo.setVehiculoCilindraje(this.vehiculoCilindraje);
		vehiculo.setUserId(this.userId);
		vehiculo.setVehiculoPlaca(this.vehiculoPlaca);
		return vehiculo;
	}

}
