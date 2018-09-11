package vista;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlador.Controlador;
import modelo.Casilla;


	public class Ventana extends JFrame implements ActionListener
	{

		/**
		 * Es un objeto de tipo tablero
		 */
		private PanelTablero tablero;
		
		/**
		 *Es un objeto de tipo PanelDerecho 
		 */
		private PanelDerecho panelDerecha;
		
		/**
		 *Es un objeto de tipo Controlador 
		 */
		private Controlador control;


		/**
		 * Se crea la ventana inicial la cual posee panel tablero y panel derecho 
		 * la ventana tiene dimenciones de 600 por 500 y tiene como parametro pControlador que es de tipo Controlador 
		 * @param pControlador
		 */
		public Ventana (Controlador pControlador)
		{
			control = pControlador;

			setTitle("Triqui");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(600, 500);
			setResizable(false);
			setLayout(new BorderLayout());
			tablero = new PanelTablero(this);
			panelDerecha = new PanelDerecho(this);

			add(tablero, BorderLayout.CENTER );
			add(panelDerecha, BorderLayout.EAST);
			setVisible(true);
		}
	
	/**
	 * En este metodo se habilia el tablero y se actualiza con las caillas en blanco
	 * @param matriz
	 */
	public void actualizarPanel (Casilla[][] matriz)
	{
		tablero.actualizar(matriz);
		tablero.habilitarTablero();
		
	}
		
	/**
	 * da las jugadas que llevan las dos jugadores 
	 * @return jugadas
	 */
	public String darjugadas(){
		
		return control.darJugadas();
		
	}
	
	/**
	 *notifica que existe el ganador deacuerdo al turno actual que hay 
	 */
	public  void notificarQueHayGanador ()
	{
	JOptionPane.showMessageDialog(this, "EL JUGADOR "+control.darJugadorActual()+" GANÓ LA PARTIDA");
	
	tablero.inavilitarTablero();
	}
	
	/**
	 * Este metodo notifica que no hubo ganador y que le tablero ya esta totalmente lleno
	 */
	public void noHayGana ()
	{
		if(control.noGano()==true)
		{
			JOptionPane.showMessageDialog(this, "NO HUBO GANADOR");
			tablero.inavilitarTablero();
		}
	}
	
	/**
	 * Este metodo actualiza los turnos del panel partida
	 */
	public void actualizarTurnos()
	{
		panelDerecha.turnoP();
	}

	/* (Aciiones que ejecuta)
	 * Este es el metodo en el cual escuha la accion que se debe realizar al oprimir un boton
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand();


	    if (comando.equals(PanelDerecho.NUEVA_PARTIDA))
		{
			panelDerecha.nuevaPartida();
			control.reiniciar();
		}
		else if (comando.equals(PanelDerecho.GUARDAR))
		{
			control.guardarPartida();
			
		}
		else if (comando.equals(PanelDerecho.CARGAR))
		{
			crearPanel();
			control.cargarPartida();
		}
		else 
		{
			String [] posiciones = comando.split(",");
			int fila = Integer.parseInt(posiciones[0]);
			int columna = Integer.parseInt(posiciones[1]);
			control.actualizarUnaCasilla(fila, columna);
	
		}
					
		
		
	}
	
	/**
	 * Retorna el turno de jugador que le toca jugar
	 * @return turnoJugador
	 */
	public int darTurnoJugador(){
		return control.darTurnoJugador();
	}
	
	/**
	 * Se crea el uevo panel con todos sus botones en blanco 
	 */
	public void crearPanel(){
		tablero.tableroBlanco();
	}
	
	
	
	}
	


















