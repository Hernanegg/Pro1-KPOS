package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.Casilla;
import modelo.Triqui;
import vista.PanelDerecho;
import vista.PanelPartida;
import vista.Ventana;

public class Controlador {

	/**
	 *Es un objeto de tipo Triqui llamado modelo
	 */
	private Triqui modelo;
	
	/**
	 * Es un objeto de tipoVentana llamado vista
	 */
	private Ventana vista;
	

	/**
	 *Se crean los dos atributos modelo y vista  
	 */
	public Controlador ()
	{
		modelo = new Triqui();
		vista = new Ventana(this);
		vista.actualizarPanel(modelo.darmatriz());
	}
	
	/**
	 * debuelve los valores predeterminados del modelo y de la vista 
	 */
	public void reiniciar()
	{
		modelo.reiniciarPartida();
		vista.actualizarPanel(modelo.darmatriz());
		vista.crearPanel();
	}
	
	
	
	/**
	 * actualiza una de las casillas del tablero dependiendo del turno para poder asignarle el color 
	 * y resibe una fila y una columna como parametro para indicar la casilla a actualizar
	 * @param fila, de tipo entero
	 * @param columna, de tipo entero
	 */
	public void actualizarUnaCasilla(int fila, int columna)
	{

		 modelo.acualizarCasilla(fila, columna); 
		 vista.actualizarPanel(modelo.darmatriz());
		 boolean rest = modelo.verificarPartida();
		 vista.actualizarTurnos();
		 if (rest == true)
		 {
			vista.notificarQueHayGanador(); 
		 }
		 else if(modelo.noGano() == true)
		 {
			 vista.noHayGana();
		 }
		 
		
		 
		 
		  
	}
	
	/**
	 * debuelve el turno en el cual se encuentra la partida
	 * @return el turno jugador
	 */
	public int darTurnoJugador(){
		return modelo.darTurnoJugador();
	}
	

	/**
	 * Es el metodo main el cual crea un nuevo constructor,
	 * y es el que corre la aplicacion
	 * @param args de tipoString
	 */
	public static void main(String[] args) {

		Controlador control = new Controlador(); 


	}

	/**
	 * Este metodo crea un archivo de txt en la carpeta partida que se encuentra dentro de data
	 * y guarda el turno en el que se encuentra la partida, las casillas que se encuentran en blanco con 0,
	 * las que se encuentran ocupadas como jugador 1 como =1, y las de jgador dos como 2,
	 * tambien guarda los fichas que lleva cada parida 
	 */
	public void guardarPartida() 
	{
		String nombre=JOptionPane.showInputDialog("ingrse el nombre de la partida");
		File fichero = new File("./data/partida/"+nombre+".txt");
		FileWriter archivo;
		BufferedWriter impresora;
	try {
		fichero.createNewFile();
		archivo = new FileWriter(fichero);
		impresora = new BufferedWriter(archivo);
		String turnoJuego = null;
		if(modelo.darTurno() == false)
		{
			turnoJuego = "1";
		}
		else 
		{
			turnoJuego = "2";
		}
		
		
		String turno="turno="+ modelo.darTurnoJugador();
		impresora.write(turno);
		impresora.newLine();
		String jugadas1 = "jugado1=" + modelo.darjugadas1();
		impresora.write(jugadas1);
		impresora.newLine();
		String jugadas2 = "jugado2=" + modelo.darJugadas2();
		impresora.write(jugadas2);
		
		for (int i = 0; i < Triqui.FILAS; i++)
		{
			for (int j = 0; j < Triqui.COLUMNAS; j++)
			{
				int estado=modelo.darmatriz()[i][j].darColor();
				impresora.newLine();
				impresora.write(i+","+j+"="+estado);
			}
		}
		
		impresora.close();
		archivo.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	/**Este metodo retorna las jugadas de los dos jugadores separadas por una coma 
	 * @return jugadas de tipo int
	 */
	public String darJugadas(){
		String jugadas="";
		jugadas=modelo.darjugadas1()+","+modelo.darJugadas2();
	return jugadas;
	}
	
	/**
	 * este metodo retorna el jugador actual 
	 * @return el jugador actual que lleva en la partida 
	 */
	public int darJugadorActual(){
		return modelo.jugadorActual();
	}
	
	/**
	 * En caso de que el tablero se llene y no halla ganador retorna el metodo noGano que envia 
	 * un mensaje informando que no hay ganador
	 * @return noGano
	 */
	public boolean noGano(){
		return modelo.noGano();
	}
	
	/**
	 *Este metodo lansa un panel de selccion donde el usuario podia escoger la partida a cargar 
	 *con alluda de un archivo de propiedades donde se encuentran todos los dats para poder retornar la partida 
	 */
	public void cargarPartida()
	{
		File archiSelec;
		JFileChooser ventana = new JFileChooser("./data/partida");
		   int returnVal = ventana.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		      archiSelec = ventana.getSelectedFile();
		      try {
				FileInputStream  lector = new  FileInputStream(archiSelec);
				 Properties archivo= new Properties(System.getProperties());
			      archivo.load(lector);
			      
			      modelo.cambiarTurnoJugador(Integer.parseInt(archivo.getProperty("turno")));
			      modelo.cambiarJugadas1(Integer.parseInt(archivo.getProperty( "jugado1")));
			      modelo.cambiarJugadas2(Integer.parseInt(archivo.getProperty("jugado2")));
			      for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						
						int pColor=Integer.parseInt(archivo.getProperty(i+","+j));
						modelo.darmatriz()[i][j].cambiarColor(pColor);	
					}
				}
			      
			      vista.actualizarPanel(modelo.darmatriz());
			      vista.actualizarTurnos();
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		     
		      
		 
		    }else
		    {
		    	JOptionPane.showConfirmDialog(null, "No escogio ningun archivo");
		    }
		    
		    
		
	}


}
