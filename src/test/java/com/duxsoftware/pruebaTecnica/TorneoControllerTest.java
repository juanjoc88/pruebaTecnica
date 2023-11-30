package com.duxsoftware.pruebaTecnica;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.duxsoftware.pruebaTecnica.controller.TorneoController;
import com.duxsoftware.pruebaTecnica.modelo.Partido;
import com.duxsoftware.pruebaTecnica.service.TorneoService;

public class TorneoControllerTest {
	
	@Test
	public void testJugarPartido() {
		Partido partido = new Partido();
		partido.setNombreTorneo("Torneo de Prueba");
		partido.setJugador1("Player 1");
		partido.setJugador2("Player 2");
		partido.setProbabilidad1(51);
		partido.setSets(5);
		Partido resultado = new Partido();
		TorneoService torneoS =  new TorneoService();
		resultado = torneoS.jugarPartido(partido);
		assertEquals(partido.getJugador1(), resultado.getJugador1());
		assertEquals(partido.getJugador2(), resultado.getJugador2());
		assertEquals(partido.getNombreTorneo(), resultado.getNombreTorneo());
		assertEquals((1 - partido.getProbabilidad1() ), resultado.getProbabilidad2());
		assertEquals(partido.getSets(), resultado.getSets());
		assertEquals(partido.getPuntos()[0].length, resultado.getSets());
		assertNotNull(resultado.getRegistro());
	}
	
	@Test
	public void testJugarGame() {
		TorneoService torneoS =  new TorneoService();
		Partido partido = new Partido();
		partido.setNombreTorneo("Torneo de Prueba");
		partido.setJugador1("Player 1");
		partido.setJugador2("Player 2");
		partido.setProbabilidad1(51);
		partido.setSets(5);
		torneoS.jugarPartido(partido);
		String resultadoGanador = torneoS.jugarGame(3);
		assertNotNull(resultadoGanador);
	
	}
	
	
	@Test
	public void testCrearPartido() {
		TorneoController torneoC =  new TorneoController();
		String resultado = torneoC.inicio();
		assertNotNull(resultado);
	
	}

}
