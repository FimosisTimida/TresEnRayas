package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import boceto.Coordenada;
import control.BotonComportamiento;
import control.ParaFrameCompuesto;

public class PanelBotonera extends JPanel {

	private MyButton botonera[][]=new MyButton[3][3];
	
	public PanelBotonera() {
		crearBotones();
	
	}

	private void crearBotones() {
		//BotonComportamiento btnComportamiento = new BotonComportamiento();
		for (int i = 0; i < 3; i++) {
			for (int j= 0; j < 3; j++) {
				botonera[i][j] = new MyButton(new Coordenada(i, j));
				botonera[i][j].setForeground(new Color(255, 105, 180));
				botonera[i][j].setFont(new Font("Sitka Subheading", Font.BOLD, 46));
				//botonera[i][j] .addActionListener(btnComportamiento);
			this.add(botonera[i][j] );
			}
		}
		
	}

	public MyButton getBoton(int i, int j) {
		return botonera[i][j];
	}
	
	public int getLengthRow() {
		return botonera.length;
	}
	public int getLengthColum() {
		return botonera[0].length;
	}
	
}
