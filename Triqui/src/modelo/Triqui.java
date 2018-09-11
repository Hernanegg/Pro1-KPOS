package modelo;

import javax.swing.JOptionPane;

/**
 * @author Hernan Gordillo, Santiago Lopez, Santiago 
 *Escta clase contiene los metodos que modifican la casilla o otros propios del triqui
 *en esta se declara la matriz de casillas y sus metodos para modificar
 */

/**
 * @author hernan
 *
 */
public class Triqui {

	/**
	 * EL numero de Filas que tiee la matriz
	 */
	public final static int FILAS = 5;
	/**
	 * El numero de Columas que tiene la matriz
	 */
	public final static int COLUMNAS = 5;

	/**
	 * Se declara la matriz tablero de tipo Casilla
	 */
	private Casilla[][] tablero;
	
	/**
	 * EL turno en el que esta la partida
	 * Falso si es el jugador 1 y verdadero si es el jugador 2
	 */
	private boolean turno;
	
	/**
	 *  las fichas que tiene el jugador 1
	 */
	private int jugadas1;
	
	/**
	 *  las fichas que tiene el jugador 2
	 */
	private int jugadas2;
	
	/**
	 * da el turno del jugador si es 1 o 2
	 */
	private int turnoJugador;


	/**
	 * inicializa los atributos y la matriz de Casillas con 5 filas y 5 columnas
	 */
	public Triqui ()
	{
		turno = false; // faslso equivale a juagdor 1 y verdadero a jugador 2
		tablero = new Casilla[FILAS][COLUMNAS];
		inicializarTablero();
		jugadas1=0;
		jugadas2=0;
		turnoJugador=1;
	}

	
	/**
	 * Da el turno  
	 * @return EL turno en el que esta la partida
	 */
	public boolean darTurno()
	{
		return turno;
	}

	/**
	 * inicializa la matriz casillas con el tablero de la vista 
	 */
	public void inicializarTablero()
	{
		for (int i = 0; i < FILAS; i++)
		{
			for (int j = 0; j < COLUMNAS; j++) 
			{
				tablero[i][j] = new Casilla();
			}
		}
	}

	/**
	 * Da las fichas que tiene el jugador 1
	 * @return las fichas que tiene el jugador 1
	 */
	public int darjugadas1(){
		return  jugadas1;
	}
	
	/**
	 * cambia las fichas en juego del jugador 1
	 * @param pJugadas
	 */
	public void cambiarJugadas1(int pJugadas)
	{
		jugadas1 = pJugadas;
	}

	/**
	 * Da las fichas que tiene el jugador 2
	 * @return las fichas que tiene el jugador 2
	 */
	public int darJugadas2(){
		return  jugadas2;
	}
	
	/**
	 * Cambia las fichas en juego por el parametro
	 * @param pJugadas
	 */
	public void cambiarJugadas2(int pJugadas)
	{
		jugadas2 = pJugadas;
	}

	/**
	 * Actualiza la casilla asignada por el parametro
	 * @param px. la fila de la casilla
	 * @param py. la columna de la casilla
	 * @return seActualizo;  verdadero si actualizo falso si no
	 */
	public boolean acualizarCasilla (int px, int py)
	{
		boolean seActualizo = false;
		Casilla cas = tablero[px][py];

		if(cas.darColor() == Casilla.VACIA)
		{
			if (turnoJugador ==1)// faslso equivale a juagdor 1 y verdadero a jugador 2
			{
				cas.cambiarColor(Casilla.JUGADOR_1);
				jugadas1++;
				turno = true;
				turnoJugador=2;
			}
			else 
			{
				cas.cambiarColor(Casilla.JUGADOR_2);
				turno = false;
				jugadas2++;
				turnoJugador=1;
			}
			seActualizo = true;
		}
		else if(cas.darColor() == Casilla.JUGADOR_1) 
		{
			if (turnoJugador == 1)
			{
			JOptionPane.showMessageDialog(null, "Esta Casilla Ya Esta Ocupada Por Una Ficha Tuya ");
			}
			else if(turnoJugador ==2)
			{
				JOptionPane.showMessageDialog(null, "Esta Casilla Ya Esta Ocupada Por Una Ficha Del Contrario ");
			}
		}
		else if (cas.darColor() == Casilla.JUGADOR_2)
		{
			if (turnoJugador == 2)
			{
			JOptionPane.showMessageDialog(null, "Esta Casilla Ya Esta Ocupada Por Una Ficha Tuya ");
			}
			else if(turnoJugador ==1)
			{
				JOptionPane.showMessageDialog(null, "Esta Casilla Ya Esta Ocupada Por Una Ficha Del Contrario ");
			}
		}

		return seActualizo;
	}


	/**
	 * Da el turno de quien le toca actualmente
	 * @return el Turno del jugador Actua
	 */
	public int jugadorActual(){
		int jA=0;
		if(turnoJugador==1){
			jA=2;
		} else jA=1;
		return jA;
	}
	
	/**
	 * Retorna no gano si el tablero esta lleno y no a ganndo nadie
	 * @return rta. Si gano true de lo contrario False
	 */
	public boolean noGano(){
		boolean rta=false;
		if((jugadas1+jugadas2)==25){
		rta=true;
		}
		return rta;
	}
	
	
	/**Cambia el turno en el que esta la partida por el parametro entero que resibe
	 * @param pTurno, el turno entero
	 */
	public void cambiarTurnoJugador(int pTurno){
		turnoJugador=pTurno;
	}

	/**
	 * Retorna el turno en el que esta la partida
	 * @return turnoJugador
	 */
	public int darTurnoJugador(){
		return turnoJugador;
	}

	/**
	 * Verifica si existe un ganador ya sea jugador 1 o jugador 2 
	 * Y hace uso de los metodos de las diagonales para verificar 
	 * @return respu; boolean, falso si no a ganado nadie y verdadero si hay ganador
	 */
	public boolean verificarPartida()
	{
		boolean respu = false;
		if(validarDiagoJugador1() == true || validarDiagoJugador2() == true || validarFilasJugador1()==true || validarFilasJugador2()==true || validarColumnasJugador1()==true|| validarColumnasJugador2()==true)
		{
			respu =true;
		} 

		return respu;
	}


	/**
	 * Valida si el jugador 1 es ganador con la diagonal de izquierda a derecha o de derecha a izquierda; 
	 * @return res; boolean Verdadero si el jugador 1 gano con esa diagonal, falso si no
	 */
	public boolean validarDiagoJugador1()
	{
		boolean res = false;

		if (res == false)
		{
			int cont =0;
			for (int i = 0; i < FILAS; i++)
			{
				if(tablero[i][i].darColor() == Casilla.JUGADOR_1)
				{
					cont++;
				}
			}
			if (cont == FILAS)
			{
				res = true;
			}
		}

		if (res == false)
		{
			int cont =0;
			int j = FILAS-1;
			for (int i = 0; i < FILAS; i++ )
			{				
				if(tablero[i][j].darColor() == Casilla.JUGADOR_1)
				{
					cont++;
				}
				j--;
			}
			if (cont++ == FILAS)
			{
				res = true;
			}
		}
		return res;
	}


	/**
	 * valida si el jugador 2 gana con la diagonal de izquierda a derecha o la diagonal de derecha a izquierda
	 * @return res; verdadero si gana y falso si no
	 */
	public boolean validarDiagoJugador2()
	{
		boolean res = false;

		if (res == false)
		{
			int cont =0;
			for (int i = 0; i < FILAS; i++)
			{
				if(tablero[i][i].darColor() == Casilla.JUGADOR_2)
				{
					cont++;
				}
			}
			if (cont == FILAS)
			{
				res = true;
			}
		}

		if (res == false)
		{
			int cont =0;
			int j = FILAS-1;
			for (int i = 0; i < FILAS; i++ )
			{				
				if(tablero[i][j].darColor() == Casilla.JUGADOR_2)
				{
					cont++;
				}
				j--;
			}
			if (cont == FILAS)
			{
				res = true;
			}
		}
		return res;
	}


	/**
	 * Valida si el jugador 1 gana con alfuna fila completa 
	 * @return res; verdadero si gana de lo contrafio falso
	 */
	public boolean validarFilasJugador1()
	{
		boolean res = false;
		for (int i = 0; i < FILAS && res == false; i++)
		{
			int cont = 0;
			for (int j = 0; j < COLUMNAS; j++)
			{
				if (tablero[i][j].darColor() == Casilla.JUGADOR_1)
				{
					cont++;
				}
			}
			if(cont ==FILAS)
			{
				res = true;
			}
		}
		return res;
	}


	/**
	 * Valida si el jugador 2 gana con alguna fila completa 
	 * @return res; verdadero si gano de lo contrario falso
	 */
	public boolean validarFilasJugador2()
	{
		boolean res = false;
		for (int i = 0; i < FILAS && res == false; i++)
		{
			int cont = 0;
			for (int j = 0; j < COLUMNAS; j++)
			{
				if (tablero[i][j].darColor() == Casilla.JUGADOR_2)
				{
					cont++;
				}
			}
			if(cont ==FILAS)
			{
				res = true;
			}
		}
		return res;
	}


	/**
	 * valida si el jugador 1 gana con alguna columna completa 
	 * @return res; verdadero si gana de lo contrario falso
	 */
	public boolean validarColumnasJugador1()
	{
		boolean res = false;

		for (int i = 0; i < COLUMNAS && res == false; i++)
		{
			int cont =0;
			for (int j = 0; j < FILAS; j++)
			{
				if(tablero[j][i].darColor() == Casilla.JUGADOR_1)
				{
					cont++;
				}
			}
			if(cont ==COLUMNAS)
			{
				res = true;
			}
		}
		return res;
	}


	/**
	 * valida si el jugador 2 gana con alguna columna completa 
	 * @return res; verdadero si gana de lo contrario falso
	 */
	public boolean validarColumnasJugador2()
	{
		boolean res = false;

		for (int i = 0; i < COLUMNAS && res == false; i++)
		{
			int cont =0;
			for (int j = 0; j < FILAS; j++)
			{
				if(tablero[j][i].darColor() == Casilla.JUGADOR_2)
				{
					cont++;
				}
			}
			if(cont ==COLUMNAS)
			{
				res = true;
			}
		}
		return res;
	}


	/**
	 * inicializa de nuevo los valores del tablero(matriz de casillas)
	 * el turno =0, jugadas que lleva el jugador 1 =0 y las jugadas que lleva el jugador 2  = 0; 
	 */
	public void reiniciarPartida()
	{
		inicializarTablero();
		turno = false;
		jugadas1=0;
		jugadas2=0;
	}

	/**
	 * Este metodo da toda la matriz de casillas tablero
	 * @return tablero
	 */
	public Casilla[][] darmatriz()
	{
		return tablero;
	}


	/**
	 * Modfica el turno boolean Falso si es el Jugador 1 y verdadero si es el dos
	 * @param turno2; boolean 
	 */
	public void modificarTurno(boolean turno2) 
	{
		turno = turno2;
	}


}
