package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.Controlador;
import modelo.Triqui;

public class PanelDerecho extends JPanel 
{
	
	/**
	 * Es una constante de tipo String la cual contiene Nueva partida
	 */
	public static final String NUEVA_PARTIDA = "Nueva Partida";
	
	/**
	 *Es una variable de tipo String la cual cotiene Guardar Partida
	 */
	public static final String GUARDAR = "Guardar Partida";
	
	/**
	 * Es ua variable de tipo String la cual contiene Cargar Partida
	 */
	public static final String CARGAR = "Cargar Partida";
	
	/**
	 * Es un panel llamado operaciones de tipo PanelOperaciones
	 */
	private PanelOperaciones operaciones;
	
	/**
	 *Es un panel llamado partida de tipo Partida 
	 */
	private PanelPartida partida;
	
	/**
	 *Es la ventana principal de tipo Ventana y nombreda principal 
	 */
	private Ventana principal;
	
	
	
	/**
	 * Es el metodo constructor en el cual se inicializa todos los atributos y se agregan los paneles operaciones 
	 * y artidas al panel derecho uno en el centro y el otro en la parte sur del panel 
	 * resibe como parametreo un objeto de Clase Ventana; y se le asigna de que puede ser visible 
	 * @param pPrincipal
	 */
	public PanelDerecho(Ventana pPrincipal)
	{
		principal = pPrincipal;
		setLayout(new BorderLayout());
		operaciones = new PanelOperaciones(principal);
		partida = new PanelPartida(this);
		add(partida, BorderLayout.CENTER);
		add(operaciones, BorderLayout.SOUTH );
		setVisible(true);

	}
	
	/**
	 *modeifica el turno de la clase partida.turnoJugador 
	 */
	public void turnoP()
	{
		partida.turnoJugador();
	}
	
	/**
	 * reinicia el panel de la partda con sus valores predeterminados
	 */
	public void nuevaPartida()
	{
		partida.reiniciarPartida();
	}
	
	
	/**
	 * Retorna el numero de jugadas que da el objeto principal
	 * @return
	 */
	public String darJugadas(){
		return principal.darjugadas();
	}
	
	/**
	 * retorna el tuno de la partida del objeto pricipal
	 * @return
	 */
	public int darTurnoJugador(){
		return principal.darTurnoJugador();
	}
	
		
		
	

	
	}


	


	
