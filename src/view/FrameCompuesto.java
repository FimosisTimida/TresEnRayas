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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{307, 0};
		gbl_contentPane.rowHeights = new int[]{245, 13, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new PanelBotonera();
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setVgap(1);
		fl_panel.setHgap(1);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.getBoton(1,1).setText("X");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.fill = GridBagConstraints.BOTH;
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 1;
		contentPane.add(lblEstado, gbc_lblEstado);
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
