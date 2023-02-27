package modelo;

import javax.swing.JButton;

import boceto.Coordenada;

public class MyButton extends JButton {
	private Coordenada coordenada;

	public MyButton(Coordenada coordenada) {
		super("");
		this.coordenada = coordenada;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	
}
