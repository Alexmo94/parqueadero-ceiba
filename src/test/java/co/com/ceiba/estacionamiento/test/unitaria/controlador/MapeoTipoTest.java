package co.com.ceiba.estacionamiento.test.unitaria.controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.entidad.TipoEntity;
import co.com.ceiba.estacionamiento.infraestructura.persistencia.mapeo.TipoMapeo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.TipoEntityTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.TipoTestDataBuilder;

public class MapeoTipoTest {

	Tipo tipo;
	TipoEntity tipoEntity;

	TipoTestDataBuilder tipoTestDataBuilder;
	TipoEntityTestDataBuilder tipoEntityTestDataBuilder;

	@Before
	public void setUp() {
		tipoTestDataBuilder = new TipoTestDataBuilder();
		tipoEntityTestDataBuilder = new TipoEntityTestDataBuilder();
	}

	@Test
	public void convertirDominioAEntidadTest() {
		tipo = tipoTestDataBuilder.build();
		tipoEntity = TipoMapeo.convertirDominioAEntity(tipo);
		assertEquals(tipo.getTipoId(), tipoEntity.getTipoId());
		assertEquals(tipo.getTipoDesc(), tipoEntity.getTipoDesc());
		assertEquals(tipo.getTipoValorHora(), tipoEntity.getTipoValorHora());
		assertEquals(tipo.getTipoValorDia(), tipoEntity.getTipoValorDia());
		assertEquals(tipo.getTipoTarifaExtra(), tipoEntity.getTipoTarifaExtra());
	}
	
	@Test
	public void convertirEntidadADominioTest() {
		tipoEntity = tipoEntityTestDataBuilder.build();
		tipo = TipoMapeo.convertirEntityADominio(tipoEntity);
		assertEquals(tipoEntity.getTipoId(), tipo.getTipoId());
		assertEquals(tipoEntity.getTipoDesc(), tipo.getTipoDesc());
		assertEquals(tipoEntity.getTipoValorHora(), tipo.getTipoValorHora());
		assertEquals(tipoEntity.getTipoValorDia(), tipo.getTipoValorDia());
		assertEquals(tipoEntity.getTipoTarifaExtra(), tipo.getTipoTarifaExtra());
	}

}
