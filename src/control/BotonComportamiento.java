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
	
	public BotonComportamiento(JLabel jLabel) {
		super();
		this.gest =new GestionDatos();;
		lblestado = jLabel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton boton = (MyButton) e.getSource();
		
		
		boolean jugadaHecha= false;
		boolean tableroLleno= gest.isTableroFull();
		
		if(!comprobarResultado()) {
				if(isFree(boton) ) {
					
					hacerTurno(boton);
					
					if(comprobarResultado()) {
						msgEnhorabuenaLblEstado(playerNumber());
					}else {
						gest.incrementarNumeroJugada();
						updateLblEstadoNextPlayer(playerNumber());
					}
					
				}else if(tableroLleno){
					//Seleccionar una casilla tuya
					// Coger casilla vecina rival
					
				}else {
					msgNotEmptyLblEstado(playerNumber());
				}
		
		}
		
	}



	private boolean comprobarResultado() {
		return gest.getTablero().comprobarTresEnRaya();
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
		gest.getTablero().setValorPosicion(boton.getCoordenada(), playerNumber);
		
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
	
	private void msgEnhorabuenaLblEstado(int playerNumber) {
		lblestado.setText("Ganador!! Jugador "+playerNumber+ ". Enhorbuena pantera");
		
	}
}
