package Vista;

import java.io.File;
import java.util.Scanner;
import java.util.jar.JarFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Interfas {
	
	private File archivo;
	
	public Interfas()
	{
		archivo = escojerArchivo();
	}
	
	public File escojerArchivo()
	{
		JFileChooser escojer = new JFileChooser();
		escojer.showOpenDialog(null);
		return escojer.getSelectedFile();
	}
	
	public File darArchivo()
	{
		return archivo;
	}

	public String pedirNum()
	{
		return JOptionPane.showInputDialog("Introdusca el numero");
	}
	
	public String soliOtroNum()
	{
		String respu = JOptionPane.showInputDialog("Desea Continuar (SI/NO)");
		if (respu.equalsIgnoreCase("si"))
		{
			return respu;
		}
		else
		{
		JOptionPane.showMessageDialog(null, "El programa se cerro porque no ingreso un numero dentro del rango o no es un numero");
		return "";
		}
	}
	
	
}
