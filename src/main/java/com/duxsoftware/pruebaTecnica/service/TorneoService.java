package com.duxsoftware.pruebaTecnica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.duxsoftware.pruebaTecnica.modelo.Partido;

@Service
public class TorneoService {
	
	public Partido p; 
	private int puntos[][];
	private List<String> registro = new ArrayList<>();

	public Partido jugarPartido(Partido partido){
	    List<String> registro = new ArrayList<>();
		this.p = partido;
        this.puntos = new int[2][p.getSets()];
        int setJugador1 = 0;
        int setJugador2 = 0;
        int ns = 0;
        while(ns < p.getSets()){
            String ganadorGame = jugarGame(ns);
            if(ganadorGame.equals(p.getJugador1())){
                setJugador1++;
                this.registro.add("El jugador " + p.getJugador1() + " ganó el SET");
            }else{
                setJugador2++;
                this.registro.add("El jugador " + p.getJugador2() + " ganó el SET");
            }
            ns++;
        }
        if(setJugador1 > setJugador2){
            this.registro.add("El ganador del torneo es el jugador " + p.getJugador1());
        }else{
            this.registro.add("El ganador del torneo es el jugador " + p.getJugador2());
        }
        this.p.setRegistro(this.registro);
        return this.p;
    }
    
    public String jugarGame(int numeroSet){

        int gameJugador1 = 0;
        int gameJugador2 = 0;
       
        Random random = new Random();
        while(((gameJugador1 < 6 && gameJugador2 < 6) || Math.abs(gameJugador1 - gameJugador2) < 2) && (gameJugador1 < 7 && gameJugador2 < 7)){
            int puntajeJugador1 = 0;
            int puntajeJugador2 = 0;
            if(p.isJugador1Saque()){
            	this.registro.add("El jugador " + p.getJugador1() + " tiene el saque");
            }else {
            	this.registro.add("El jugador " + p.getJugador2() + " tiene el saque");
            }
            while((puntajeJugador1 < 4 && puntajeJugador2 < 4) || Math.abs(puntajeJugador1 - puntajeJugador2) < 2){
                if(p.isJugador1Saque()){
                    if(random.nextDouble() <= p.getProbabilidad1()){
                        puntajeJugador1++;
                        this.registro.add("Punto para el jugador " + p.getJugador1());
                    }else{
                        puntajeJugador2++;
                        this.registro.add("Punto para el jugador " + p.getJugador2());
                    }
                }else{
                    if(random.nextDouble() <= p.getProbabilidad2()){
                        puntajeJugador2++;
                        this.registro.add("Punto para el jugador " + p.getJugador2());
                    }else{
                        puntajeJugador1++;
                        this.registro.add("Punto para el jugador " + p.getJugador1());
                    }
                }
            }
            if (puntajeJugador1 > puntajeJugador2) {
                gameJugador1++;
                this.registro.add("El jugador " + p.getJugador1() + " ganó el GAME");
            }else{
                gameJugador2++;
                this.registro.add("El jugador " + p.getJugador2() + " ganó el GAME");
                }
            p.setJugador1Saque(!p.isJugador1Saque());
        }
        this.puntos[0][numeroSet] = gameJugador1;
        this.puntos[1][numeroSet] = gameJugador2;
        this.p.setPuntos(puntos);
        String resultadoParcial = "Resultado del " + numeroSet+1 + "° SET: \n"
        							+ p.getJugador1() + "\t" +gameJugador1 + "\n"
        							+ p.getJugador2() + "\t" +gameJugador2;
        this.registro.add(resultadoParcial);
        if(gameJugador1 >= 6){
            return p.getJugador1();
        }else{
            return p.getJugador2();
        }
    }
    
}
