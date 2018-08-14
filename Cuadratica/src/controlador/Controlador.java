package controlador;

import modelo.DivisionExepcion;
import modelo.Mundo;
import modelo.RaizExepcion;

public class Controlador {

	Mundo mundo;
	private String[] resultado;

	public Controlador (int pa, int pb, int pc) 
	{
		mundo = new Mundo(pa, pb, pc);
		try {
			System.out.println(mundo.hacerOperacion());
		} catch (RaizExepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DivisionExepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
