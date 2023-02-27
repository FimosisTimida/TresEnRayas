package control;

import boceto.Coordenada;

public class GestionDatos {
	private Tablero tablero=new Tablero();
	public int numerojugada = 2;
	/**
	 * Informa de quien es el turno actual
	 * 
	 * @return 1 o 0 dependiendo de quien sea el propietario del turno
	 */
	public int verTurno() {
		if (numerojugada % 2 == 0)
			return 2;
		return 1;

	}
	
	public void incrementarNumeroJugada() {
		numerojugada ++;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setValorPosicion(Coordenada coordenada, int i) {
		tablero.setValorPosicion(coordenada, i);
	}

	public boolean comprobarTresEnRaya() {
		return tablero.comprobarTresEnRaya();
	}
	
	/**
	 * Metodo que no sirve aqui, entendi mal el ennunciado 
	 * y ahora terminando el ejercicio lo entendi mejor
	 * no tiene que llenarse el tablero,
	 * si no que cada jugador oslo pone 3 fichas
	 * @return
	 */
	public boolean isTableroFull() {
		return numerojugada >= tablero.volTablero();
	}

	public int getNumerojugada() {
		return numerojugada;
	}
	
}
