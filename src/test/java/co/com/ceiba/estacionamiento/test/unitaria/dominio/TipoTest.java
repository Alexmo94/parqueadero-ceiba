package co.com.ceiba.estacionamiento.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Tipo;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.TipoTestDataBuilder;

public class TipoTest {

	public static final long TIPO_ID = 2L;
	public static final String TIPO_DESC = "Carro";
	public static final long TIPO_PRECIO_DIA = 8000L;
	public static final long TIPO_PRECIO_HORA = 1000L;

	@Test
	public void setUp() {
		// arrage
		TipoTestDataBuilder tipoTestDataBuilder = new TipoTestDataBuilder();

		// act
		Tipo tipo = tipoTestDataBuilder.conTipoId(TIPO_ID).conTipoDesc(TIPO_DESC).conTipoValorDia(TIPO_PRECIO_DIA)
				.conTipoValorHora(TIPO_PRECIO_HORA).conTipoTarifaExtra(0).build();

		assertNotNull(tipo);
		assertEquals(tipo.getTipoId(), TIPO_ID);
		assertEquals(tipo.getTipoDesc(), TIPO_DESC);
		assertEquals(tipo.getTipoValorDia(), TIPO_PRECIO_DIA);
		assertEquals(tipo.getTipoValorHora(), TIPO_PRECIO_HORA);
		assertEquals(tipo.getTipoTarifaExtra(), 0);
	}

}
