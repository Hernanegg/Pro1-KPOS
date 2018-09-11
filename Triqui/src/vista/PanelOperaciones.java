package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOperaciones extends JPanel
{
	/**
	 * ES el boton de nueva Partda 
	 */
	private JButton btnNuevaP;
	
	/**
	 *Es el boton de Guardar la partida 
	 */
	private JButton btnGuardarP;
	
	/**
	 *Es el boton de cargar partida 
	 */
	private JButton btnCargarP;
	
	/**
	 *Es el atributo principal de clase Ventana 
	 */
	private Ventana principal;
	


	/**
	 * Se crea un gridlayout de tres filas y 1 columna en la que se introducen los 4 botones inicializados 
	 * los cuales van a ser escuhados por principal la cual es inicializada con el parametro
	 * @param pPrincipal
	 */ public PanelOperaciones (Ventana pPrincipal)
	{
		principal = pPrincipal;
		setLayout(new GridLayout(4,4,3,5));
		setBorder(new TitledBorder("Operaciones"));
		btnNuevaP = new JButton("Nueva Partida");
		btnNuevaP.setActionCommand(PanelDerecho.NUEVA_PARTIDA);
		btnNuevaP.addActionListener(principal);
		add(btnNuevaP);
		
		btnGuardarP = new JButton("Guardar Partida");
		btnGuardarP.setActionCommand(PanelDerecho.GUARDAR);
		btnGuardarP.addActionListener(principal);
		add(btnGuardarP);
		
		btnCargarP = new JButton("Cargar Partida");
		btnCargarP.setActionCommand(PanelDerecho.CARGAR);
		btnCargarP.addActionListener(principal);
		add(btnCargarP);
		
	}

}
