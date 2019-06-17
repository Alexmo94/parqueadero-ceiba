package co.com.ceiba.estacionamiento.test.unitaria.databuilder;

import co.com.ceiba.estacionamiento.dominio.Estacionamiento;
import co.com.ceiba.estacionamiento.dominio.Ticket;
import co.com.ceiba.estacionamiento.dominio.Usuario;

public class TicketTestDataBuilder {

	private static final Usuario USUARIO_DEFAULT = new UsuarioTestDataBuilder().build();
	private static final Estacionamiento ESTACIONAMIENTO_DEFAULT = new EstacionamientoTestDataBuilder().build();

	private Usuario usuario;
	private Estacionamiento estacionamiento;

	public TicketTestDataBuilder() {
		this.usuario = USUARIO_DEFAULT;
		this.estacionamiento = ESTACIONAMIENTO_DEFAULT;
	}

	public TicketTestDataBuilder conUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}

	public TicketTestDataBuilder conEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
		return this;
	}

	public Ticket build() {
		Ticket ticket = new Ticket();
		ticket.setUsuario(this.usuario);
		ticket.setEstacionamiento(this.estacionamiento);
		return ticket;
	}

}
