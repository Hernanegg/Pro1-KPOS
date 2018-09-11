package modelo;

public class Casilla {

	//Atributos
	

	public static final int VACIA = 0;
	public static final int JUGADOR_1 =1;
	public static final int JUGADOR_2 =2;
	/**
	 * El Color que ocupa la Casilla
	 */
	private int color;

	//Metodos

	/**
	 * inicializa la informacion del equipo
	 */
	public Casilla ()
	{
		color = VACIA;
	}

	/**
	 * retorna el color del equipo
	 * @return color equipo
	 */
	public int darColor()
	{
		return color;
	}

	/**
	 * Camia el color de la casilla
	 * @param pColor a cambiar
	 */
	public void cambiarColor(int pColor)
	{
		color = pColor;
	}



}
