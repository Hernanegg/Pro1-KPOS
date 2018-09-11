package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Casilla;
import modelo.Triqui;

public class PanelTablero extends JPanel
{
	/**
	 * Es la matriz de Botones 
	 */
	private JButton[][] matrizBotones;
	
	/**
	 *es un Objeto de la clase Ventana 
	 */
	private Ventana principal;
	
	/**
	 * Es una constante de tipo string la cual almacna el rumbo de donde se guarda la 
	 * imagen like
	 */
	private static final String LIKE="./data/like.png";
	
	/**
	 *  se crea una imagen like de tipo ImagenIcon con rumbo de la constante like
	 */
	ImageIcon like=new ImageIcon(LIKE);
	
	/**
	 *Es una constante de tipo string la cual almacna el rumbo de donde se guarda la 
	 * imagen like 
	 */
	private static final String DISLIKE="./data/dislike.png";
	
	/**
	 *Se crea una imagen de tipo dislike la cual contiene el rumbo de donde se encuenta 
	 *la imagen dislike
	 */
	ImageIcon dislike=new ImageIcon(DISLIKE);
	
	/**
	 *Es una constante de tipo String la cual almacena el rumbo de la imagn en blanco 
	 */
	private static final String BLAN="./data/b.png";
	
	/**
	 *Se crea una imagen de tipo ImagenIcon almacenada el la constante BLAN 
	 */
	ImageIcon imgB=new ImageIcon(BLAN);
	
	/**
	 * En este metodo se crea la matriz de botones con 5 filas y cinco columnas 
	 * @param pVentana
	 */
	public PanelTablero (Ventana pVentana)  
	{
		principal = pVentana;
		setLayout(new GridLayout(Triqui.FILAS, Triqui.COLUMNAS));
		setBorder(new TitledBorder("Tablero"));
		
		matrizBotones = new JButton[Triqui.FILAS][Triqui.COLUMNAS];
		inicializarBotones();
		cargarGrilla();
	}

	/**
	 *Este metodo Inicializa los valores de la matris en Blanco
	 */
	public void inicializarBotones()
	{
		for (int i = 0; i < Triqui.FILAS; i++)
		{
			for (int j = 0; j < Triqui.COLUMNAS; j++)
			{
				matrizBotones[i][j] = new JButton("");
				matrizBotones[i][j].setActionCommand(i + "," + j);
				matrizBotones[i][j].addActionListener(principal);
				
			}

		}
	}

	/**
	 *Ese metodo agrega los botones a la matriz 
	 */
	public void cargarGrilla()
	{
		for (int i = 0; i < Triqui.FILAS; i++) 
		{
			for (int j = 0; j < Triqui.COLUMNAS; j++) 
			{
				add(matrizBotones[i][j]);
			}
		}
		validate ();
	}
	
	/**
	 * Este metodo hace que todo el tablero quede en banco sin importar turno o jugadas
	 */
	public void tableroBlanco(){
		for (int i = 0; i < Triqui.FILAS; i++)
		{
			for (int j = 0; j < Triqui.COLUMNAS; j++)
			{
				matrizBotones[i][j].setIcon(imgB);;
			}
			}
	}

	/**
	 * Este metodo actualiza la matriz asignandole el like o el dislike 
	 * dependiendo la casilla que se de en el parametro y el turno en el que este 
	 * @param matriz
	 */
	public void actualizar(Casilla[][] matriz)
	{
		for (int i = 0; i < Triqui.FILAS; i++)
		{
			for (int j = 0; j < Triqui.COLUMNAS; j++)
			{
				if(matriz[i][j].darColor() == Casilla.JUGADOR_1)
				{
					matrizBotones[i][j].setIcon(like);
				}
				else if(matriz[i][j].darColor() == Casilla.JUGADOR_2)
				{
					matrizBotones[i][j].setIcon(dislike);
				}
				else 
				{
					matrizBotones[i][j].setBackground(Color.WHITE);
				}
			}

		}
		
	}

	/**
	 * Este metodo inavilita el tablero para que no se pueda seleccionar ningun boton
	 */
	public void inavilitarTablero ()
	{
		for (int i = 0; i < Triqui.FILAS; i++)
		{
		for (int j = 0; j < Triqui.COLUMNAS; j++) 
		{
			matrizBotones[i][j].setEnabled(false);
		}	
		}
	}
	
	/**
	 * Habilita el tablero para que se puedan seleccionar sus botones y se pueda jugar la partida
	 */
	public void habilitarTablero ()
	{
		for (int i = 0; i < Triqui.FILAS; i++)
		{
		for (int j = 0; j < Triqui.COLUMNAS; j++) 
		{
			matrizBotones[i][j].setEnabled(true);
		}	
		}
	}



}
