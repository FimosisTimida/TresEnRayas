package control;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import boceto.Coordenada;
import modelo.MyButton;

public class BotonComportamiento implements ActionListener {


	private GestionDatos gest;
	private JLabel lblestado;
	Coordenada xyAux;
	
	public BotonComportamiento(JLabel jLabel) {
		super();
		this.gest =new GestionDatos();;
		lblestado = jLabel;
		xyAux=null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton boton = (MyButton) e.getSource();
		
		
		boolean jugadaHecha= false;
		//boolean tableroLleno= gest.isTableroFull(); esto seria si se rellenase la mesa
		boolean tableroLleno = gest.getNumerojugada()>6;//Se lleno al menos 1 vez
		
		if(!comprobarGanador()) {
				if(isFree(boton) && !tableroLleno) {
					
					hacerTurno(boton);
					
					if(comprobarGanador()) {
						msgEnhorabuenaLblEstado(playerNumber());
					}else {
						gest.incrementarNumeroJugada();
						updateLblEstadoNextPlayer(playerNumber());
					}
					
				}else if(tableroLleno){
					if(casillaOwner(boton.getCoordenada()) && xyAux == null) {
						limpiarBoton(boton);
						ocuparPosicionEnTablero(boton, 0);
						// Coordenadas para ver si son vecinos a la casilla elegida
						xyAux = boton.getCoordenada();
						
					}else if(xyAux!= null) {
						if( eligioLibreVecina(boton)) {
						
							hacerTurno(boton);
							xyAux=null;
							
							if(comprobarGanador()) {
								msgEnhorabuenaLblEstado(playerNumber());
							}else {
								gest.incrementarNumeroJugada();
								updateLblEstadoNextPlayer(playerNumber());
							}
						}else {
							msgErrorVecinoLblEstado(playerNumber());
						}
					}else {
						msgErrorOwnerLblEstado(playerNumber());
					}
					
				}else {
					msgNotEmptyLblEstado(playerNumber());
				}
		
		}
		
	}
	

	private boolean eligioLibreVecina(MyButton boton) {
		return isVecina(boton.getCoordenada()) && !casillaOwner(boton.getCoordenada());
	}

	private boolean isBloqueada() {
		return gest.getTablero().comprobarBloqueada(xyAux);
	}
	
	private boolean isVecina(Coordenada coordenada) {
		return gest.getTablero().comprobarVecina(coordenada,xyAux);
	}

	private boolean casillaOwner(Coordenada coordenada) {
		
		return gest.getTablero().comprobarPropiedad(coordenada, gest.verTurno());
	}

	private boolean comprobarGanador() {
		return gest.comprobarTresEnRaya();
	}

	private void hacerTurno(MyButton boton) {
		posiciona(boton, playerNumber() );
		ocuparPosicionEnTablero(boton, playerNumber());	
	}

	private int playerNumber() {
		return gest.verTurno();
	}

	private boolean isFree(MyButton boton) {
		return gest.getTablero().mirarCasillaLibre(boton.getCoordenada());
	}

	private void ocuparPosicionEnTablero(MyButton boton, int playerNumber) {
		gest.setValorPosicion(boton.getCoordenada(), playerNumber);
		
	}
	
	private boolean turnoJugador1() {
		return gest.verTurno()==1;
	}
	
	private void posiciona(MyButton boton, int playerNumber) {
		if(playerNumber==1) {
			boton.setForeground(new Color(255, 105, 180));
			boton.setText("X");
		}else {
			boton.setForeground(SystemColor.textHighlight);
			boton.setText("O");
		}
	}
	
	private void updateLblEstadoNextPlayer(int playerNumber) {
		lblestado.setText("Turno del Jugador "+playerNumber);
	
	}
	
	private void msgNotEmptyLblEstado(int playerNumber) {
//		lblestado.setText("Esa casilla no esta libre");
		lblestado.setText("Esa casilla no esta libre. Turno del Jugador "+playerNumber);
		
	}
	
	private void limpiarBoton(MyButton boton) {
		boton.setText("");
		
	}
	
	private void msgEnhorabuenaLblEstado(int playerNumber) {
		lblestado.setText("Ganador!! Jugador "+playerNumber+ ". Enhorbuena pantera");
		
	}
	
	private void msgErrorOwnerLblEstado(int playerNumber) {
		
		lblestado.setText("Error, elige una casilla a mover Jugador "+playerNumber);
	}
	
	private void msgErrorVecinoLblEstado(int playerNumber) {
		lblestado.setText("Error. No es casilla vecina Jugador "+playerNumber);
		
	}
}
