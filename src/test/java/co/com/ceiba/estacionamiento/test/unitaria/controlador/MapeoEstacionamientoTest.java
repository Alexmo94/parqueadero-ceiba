package co.com.ceiba.estacionamiento.test.unitaria.controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.EstacionamientoEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.EstacionamientoMapeo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.EstacionamientoEntityTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.EstacionamientoTestDataBuilder;

public class MapeoEstacionamientoTest {

	Estacionamiento estacionamiento;
	EstacionamientoEntity estacionamientoEntity;

	EstacionamientoTestDataBuilder estacionamientoTestDataBuilder;
	EstacionamientoEntityTestDataBuilder estacionamientoEntityTestDataBuilder;

	@Before
	public void setUp() {
		estacionamientoTestDataBuilder = new EstacionamientoTestDataBuilder();
		estacionamientoEntityTestDataBuilder = new EstacionamientoEntityTestDataBuilder();
	}

	@Test
	public void convertirDominioAEntidadTest() {
		estacionamiento = estacionamientoTestDataBuilder.build();
		estacionamientoEntity = EstacionamientoMapeo.convertirDominioAEntity(estacionamiento);
		assertEquals(estacionamiento.getParkingId(), estacionamientoEntity.getParkingId());
		assertEquals(estacionamiento.getVehiculoId(), estacionamientoEntity.getVehiculoId().getVehiculoId());
		assertEquals(estacionamiento.getParkingFechaEntrada(), estacionamientoEntity.getParkingFechaEntrada());
		assertEquals(estacionamiento.getParkingFechaSalida(), estacionamientoEntity.getParkingFechaSalida());
		assertEquals(estacionamiento.getParkingTotal(), estacionamientoEntity.getParkingTotal());
	}

	@Test
	public void convertirEntidadADominioTest() {
		estacionamientoEntity = estacionamientoEntityTestDataBuilder.build();
		estacionamiento = EstacionamientoMapeo.convertirEntityADominio(estacionamientoEntity);
		assertEquals(estacionamientoEntity.getParkingId(), estacionamiento.getParkingId());
		assertEquals(estacionamientoEntity.getVehiculoId().getVehiculoId(), estacionamiento.getVehiculoId());
		assertEquals(estacionamientoEntity.getParkingFechaEntrada(), estacionamiento.getParkingFechaEntrada());
		assertEquals(estacionamientoEntity.getParkingFechaSalida(), estacionamiento.getParkingFechaSalida());
		assertEquals(estacionamientoEntity.getParkingTotal(), estacionamiento.getParkingTotal());
	}

}
