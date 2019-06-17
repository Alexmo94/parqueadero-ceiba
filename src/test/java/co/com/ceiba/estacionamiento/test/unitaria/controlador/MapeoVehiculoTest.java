package co.com.ceiba.estacionamiento.test.unitaria.controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.VehiculoEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.VehiculoMapeo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.VehiculoEntityTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.VehiculoTestDataBuilder;

public class MapeoVehiculoTest {

	Vehiculo vehiculo;
	VehiculoEntity vehiculoEntity;

	VehiculoTestDataBuilder vehiculoTestDataBuilder;
	VehiculoEntityTestDataBuilder vehiculoEntityTestDataBuilder;

	@Before
	public void setUp() {
		vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoEntityTestDataBuilder = new VehiculoEntityTestDataBuilder();
	}

	@Test
	public void convertirDominioAEntidadTest() {
		vehiculo = vehiculoTestDataBuilder.build();
		vehiculoEntity = VehiculoMapeo.convertirDominioAEntity(vehiculo);
		assertEquals(vehiculo.getVehiculoId(), vehiculoEntity.getVehiculoId());
		assertEquals(vehiculo.getTipoId(), vehiculoEntity.getTipoId().getTipoId());
		assertEquals(vehiculo.getUserId(), vehiculoEntity.getUserId().getUserId());
		assertEquals(vehiculo.getVehiculoCilindraje(), vehiculoEntity.getVehiculoCilindraje());
		assertEquals(vehiculo.getVehiculoPlaca(), vehiculoEntity.getVehiculoPlaca());
	}

	@Test
	public void convertirEntidadADominioTest() {
		vehiculoEntity = vehiculoEntityTestDataBuilder.build();
		vehiculo = VehiculoMapeo.convertirEntityADominio(vehiculoEntity);
		assertEquals(vehiculoEntity.getVehiculoId(), vehiculo.getVehiculoId());
		assertEquals(vehiculoEntity.getTipoId().getTipoId(), vehiculo.getTipoId());
		assertEquals(vehiculoEntity.getUserId().getUserId(), vehiculo.getUserId());
		assertEquals(vehiculoEntity.getVehiculoCilindraje(), vehiculo.getVehiculoCilindraje());
		assertEquals(vehiculoEntity.getVehiculoPlaca(), vehiculo.getVehiculoPlaca());
	}

}
