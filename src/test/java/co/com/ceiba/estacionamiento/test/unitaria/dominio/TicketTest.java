package co.com.ceiba.estacionamiento.test.unitaria.dominio;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.dominio.Ticket;
import co.com.ceiba.estacionamiento.dominio.Usuario;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.EstacionamientoTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.TicketTestDataBuilder;
import co.com.ceiba.estacionamiento.test.unitaria.databuilder.UsuarioTestDataBuilder;

public class TicketTest {

	private static final Usuario USUARIO = new UsuarioTestDataBuilder().build();
	private static final Estacionamiento ESTACIONAMIENTO = new EstacionamientoTestDataBuilder().build();

	@Test
	public void estacionamientoBuild() {
		TicketTestDataBuilder ticketTestDataBuilder = new TicketTestDataBuilder();

		Ticket ticket = ticketTestDataBuilder.conUsuario(USUARIO).conEstacionamiento(ESTACIONAMIENTO).build();

		assertNotNull(ticket);

	}

}
