package vista;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Triqui;


public class PanelPartida extends JPanel 
{
	/**
	 * Es un panel De tipo Derecho
	 */
	private PanelDerecho panlDerecha;
	
	/**
	 *Es un lugar de texto que muestra el turno en el que esta 
	 */
	private JLabel turnoJuga;
	
	

	/**
	 * Se declara el espaco doonde van las fichas en juego del jugador 1
	 */
	private JLabel jugador1;
	
	/**
	 * Se declara el espaco doonde van las fichas en juego del jugador 2
	 */
	private JLabel jugador2;
	
	/**
	 * Es el turno del jugador que le toca 
	 */
	private int jugadorEnJuego;
	
	/**
	 *Son las fichas que tiene el jugador 1 en juego 
	 */
	private int jugadasJugador1;
	
	/**
	 * Son las fichas que tiene el jugador 2 en juego
	 */
	private int jugadasJugador2;
	

	/**
	 * Es el metodo constructor en el cual se inicializan los valores 
	 * y recibe como parametro un pDerecho de tipoPanelDerecho
	 * en este se crea el gridLayout de 3 filas por 1 columna 
	 * jugadore en juego =0; y las fichas en juego estan en 0;
	 * @param pDerecho
	 */
	public PanelPartida (PanelDerecho pDerecho)
	{
		panlDerecha = pDerecho;
		setLayout(new GridLayout(3, 1));
		setBorder(new TitledBorder("Partida"));
		
		jugadorEnJuego =1;
		jugadasJugador1 = 0;
		jugadasJugador2 = 0;
		turnoJuga = new JLabel("Turno: Jugador "+ jugadorEnJuego);
		jugador1 = new JLabel("Jugador1: "+jugadasJugador1); 
		jugador2 = new JLabel("Jugador2: "+jugadasJugador2); 
		
		add(turnoJuga);
		add(jugador1);
		add(jugador2);
	}
	
	/**
	 * Este metodo reinicia los valores de turno jugador y las fchas que los jugadores tiene en juego
	 */
	public void reiniciarPartida()
	{
		jugadorEnJuego =1;
		
		
		turnoJuga.setText("Turno: Jugador "+ jugadorEnJuego);
		jugador1.setText("Jugador1: "+jugadasJugador1);
		jugador2.setText("Jugador2: "+jugadasJugador2);
	}
	
	/**
	 *Este metodo actualiza los turnos y las jugadas de los jugadores  
	 */
	public void turnoJugador ()
	{
		String[] jugadas=panlDerecha.darJugadas().split(",");
		
		turnoJuga.setText("Turno: Jugador "+ panlDerecha.darTurnoJugador());
		
			jugador1.setText("Jugador1: "+jugadas[0]);
	
			jugador2.setText("Jugador2: "+jugadas[1]);
		}
	}
	
	
		
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

