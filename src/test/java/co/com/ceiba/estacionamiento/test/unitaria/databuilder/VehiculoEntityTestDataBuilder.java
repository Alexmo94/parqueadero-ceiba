package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.TipoEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.UsuarioEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.VehiculoEntity;

public class VehiculoEntityTestDataBuilder {
	private static final long VEHICULO_ID = 1;
	private static final TipoEntity TIPO_ID = new TipoEntityTestDataBuilder().build();
	private static final long VEHICULO_CILINDRAJE = 650;
	private static final UsuarioEntity USER_ID =  new UsuarioEntityTestDataBuilder().build();
	private static final String VEHICULO_PLACA = "FSG83D";

	private long vehiculoId;
	private TipoEntity tipoId;
	private long vehiculoCilindraje;
	private UsuarioEntity userId;
	private String vehiculoPlaca;

	public VehiculoEntityTestDataBuilder() {
		this.vehiculoId = VEHICULO_ID;
		this.tipoId = TIPO_ID;
		this.vehiculoCilindraje = VEHICULO_CILINDRAJE;
		this.userId = USER_ID;
		this.vehiculoPlaca = VEHICULO_PLACA;
	}
	public VehiculoEntityTestDataBuilder conVehiculoId(long vehiculoId) {
		this.vehiculoId = vehiculoId;
		return this;
	}

	public VehiculoEntityTestDataBuilder conTipoId(TipoEntity tipoId) {
		this.tipoId = tipoId;
		return this;
	}

	public VehiculoEntityTestDataBuilder conCinlindraje(long vehiculoCilindraje) {
		this.vehiculoCilindraje = vehiculoCilindraje;
		return this;
	}

	public VehiculoEntityTestDataBuilder conUsuario(UsuarioEntity userId) {
		this.userId = userId;
		return this;
	}
	
	public VehiculoEntityTestDataBuilder conPlaca(String vehiculoPlaca) {
		this.vehiculoPlaca = vehiculoPlaca;
		return this;
	}

	public VehiculoEntity build() {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setVehiculoId(this.vehiculoId);
		vehiculoEntity.setTipoId(this.tipoId);
		vehiculoEntity.setVehiculoCilindraje(this.vehiculoCilindraje);
		vehiculoEntity.setUserId(this.userId);
		vehiculoEntity.setVehiculoPlaca(this.vehiculoPlaca);
		return vehiculoEntity;
	}
}
