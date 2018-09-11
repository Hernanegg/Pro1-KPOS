package modelo;

import java.io.File;
import java.util.ArrayList;

public abstract class Persistencia {

	protected String pri15[];
	protected String ruta;
	
	public Persistencia()
	{
		pri15 = new String[16];
		ruta = "C:\\Users\\hernan\\Desktop\\programas\\Ejercicio1\\data\\Archivo.TXT";
		
		pri15[0] ="cero";
		pri15[1] = "uno";
		pri15[2] ="dos";
		pri15[3] ="tres";
		pri15[4] ="cuatro";
		pri15[5] ="cinco";
		pri15[6] ="seis";
		pri15[7] ="siete";
		pri15[8] ="ocho";
		pri15[9] ="nueve";
		pri15[10] ="diez";
		pri15[11] ="Once";
		pri15[12] ="Doce";
		pri15[13] ="Trese";
		pri15[14] ="Catorce";
		pri15[15] ="Quince";
	}
	
	public abstract void esArchivo(ArrayList<String> aEscri, File archivo);
	public abstract ArrayList<String> lectura(File archivo);
	
	

}
