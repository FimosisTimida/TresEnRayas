package control;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import modelo.MyButton;
import view.FrameCompuesto;

public class ParaFrameCompuesto extends FrameCompuesto{

	BotonComportamiento btnComportamiento;
	
	public ParaFrameCompuesto() {
		super();
		BotonComportamiento btnComportamiento = new BotonComportamiento(getLblEstado());
		// Establecemos layout Grid
		setLayoutGrid();// esto creo que no va aqui, pero como no tengo idea de layout, lo dejo aqui para no joder el frame
		
		// Añadimos los Listeners aqui, no me deja desde PanelBotonera
		// al menos no me deja lo que intento hacer, seguro habra un metodo mejor
		for (int i = 0; i < getPanel().getLengthRow(); i++) {
			for (int j = 0; j < getPanel().getLengthColum(); j++) {
				getBoton(i, j).addActionListener(btnComportamiento);
			}
		}
	}
	
	
	
	private void setLayoutGrid() {
		int filas =getPanel().getLengthRow();
		int columnas = getPanel().getLengthColum();
		
		getPanel().setLayout(new GridLayout(filas, columnas, 1, 1));
	}
	
	


}
