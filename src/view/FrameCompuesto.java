package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.MyButton;
import modelo.PanelBotonera;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

public class FrameCompuesto extends JFrame {

	private JPanel contentPane;
	private PanelBotonera panel;
	private final JLabel lblEstado = new JLabel("Turno del Jugador 2");

	



	/**
	 * Create the frame.
	 */
	public FrameCompuesto() {
		setTitle("3 en Raya");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[271px]", "[155px][13px][][][][]"));
		
		panel = new PanelBotonera();
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setVgap(1);
		fl_panel.setHgap(1);
		contentPane.add(panel, "cell 0 0 1 5,grow");
		panel.getBoton(1,1).setText("X");
		contentPane.add(lblEstado, "cell 0 5,grow");
	}

	protected PanelBotonera getPanel() {
		return panel;
	}

	public MyButton getBoton(int i, int j) {
		return panel.getBoton(i, j);
	}
	
	public JLabel getLblEstado() {
		return lblEstado;
	}
}
