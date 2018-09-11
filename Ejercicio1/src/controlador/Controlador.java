package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Conversion;

public class Controlador {
	
	private ArrayList<String> paraG ;
	private Conversion conversion;
	public Controlador()
	{
		paraG = new ArrayList<>();
       conversion = new Conversion();
		pedirNum();
		conversion.esArchivo(paraG);

	}
	
	
	}
	


}
