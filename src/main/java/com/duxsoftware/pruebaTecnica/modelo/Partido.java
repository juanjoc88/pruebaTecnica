package com.duxsoftware.pruebaTecnica.modelo;

import java.util.Arrays;
import java.util.List;

public class Partido {
    
	private String nombreTorneo;
    private String jugador1;
    private String jugador2;
    private double probabilidad1;
    private double probabilidad2;
    private int sets;
    private int puntos[][];
    private boolean jugador1Saque = true;
    private List<String> registro;

    public String getNombreTorneo() {
		return nombreTorneo;
	}

	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}

	public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }
    
    public double getProbabilidad1() {
        return probabilidad1;
    }

    public void setProbabilidad1(double probabilidad1) {
        this.probabilidad1 = probabilidad1/100;
        this.probabilidad2 = (100 - probabilidad1) /100;
    }

    public double getProbabilidad2() {
        return probabilidad2;
    }

    public void setProbabilidad2(double probabilidad2) {
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
        this.puntos = new int[2][this.sets];
    }

	public int[][] getPuntos() {
		return puntos;
	}
	

	public void setPuntos(int[][] puntos) {
		this.puntos = puntos;
	}

	public boolean isJugador1Saque() {
		return jugador1Saque;
	}

	public void setJugador1Saque(boolean jugador1Saque) {
		this.jugador1Saque = jugador1Saque;
	}
	

	public List<String> getRegistro() {
		return registro;
	}

	public void setRegistro(List<String> registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "Partido [nombreTorneo=" + nombreTorneo + ", jugador1=" + jugador1 + ", jugador2=" + jugador2
				+ ", probabilidad1=" + probabilidad1 + ", probabilidad2=" + probabilidad2 + ", sets=" + sets
				+ ", puntos=" + Arrays.toString(puntos) + ", jugador1Saque=" + jugador1Saque + ", registro=" + registro
				+ "]";
	}



}
