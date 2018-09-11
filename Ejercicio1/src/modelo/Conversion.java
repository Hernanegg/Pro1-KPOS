package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Conversion extends Persistencia {

	public Conversion()
	{


	}

	public String convertir(int pNum)
	{
		String resul = " "; 
		if(pNum<100)
		{
			if(pNum <16)
			{
				resul= super.pri15[pNum]+" Euros";
			}
			else if(pNum >15 && pNum <20)
			{
				pNum = pNum -10;
				resul = super.pri15[pNum]+" Euros";
			}
			else if(pNum>19 && pNum <30)
			{
				pNum= pNum-20;
				if (pNum == 0)
				{
					resul="Veinte Euros";
				}
				else 
				{
					resul ="Veinti"+super.pri15[pNum]+" Euros";
				}
			}
			else if(pNum >29 && pNum<40)
			{
				pNum= pNum-30;
				if (pNum == 0)
				{
					resul="Treinta Euros";
				}
				else 
				{
					resul="Treinta y "+super.pri15[pNum]+" Euros";
				}
			}
			else if(pNum >39 && pNum<50)
			{
				pNum= pNum-40;
				if (pNum == 0)
				{
					resul = "Cuarenta Euros";
				}
				else 
				{
					resul = "Cuarenta y "+super.pri15[pNum]+" Euros";
				}
			}
			else if(pNum >49 && pNum<60)
			{
				pNum= pNum-50;
				if (pNum == 0)
				{
					resul ="Cincuenta Euros";
				}
				else 
				{
					resul = "Cincuenta y "+super.pri15[pNum]+" Euros";
				}
			}
			else if(pNum >59 && pNum<70)
			{
				pNum= pNum-60;
				if (pNum == 0)
				{
					System.out.println("Sesenta Euros");
				}
				else 
				{
					resul ="Sesenta y "+super.pri15[pNum]+" Euros";
				}
			}
			else if(pNum >69 && pNum<80)
			{
				pNum= pNum-70;
				if (pNum == 0)
				{
					resul ="Setenta Euros";
				}
				else 
				{
					resul ="Setenta y "+super.pri15[pNum]+" Euros";
				}
			}
			else if(pNum >79 && pNum<90)
			{
				pNum= pNum-80;
				if (pNum == 0)
				{
					resul ="Ochenta Euros";
				}
				else 
				{
					resul = "Ochenta y "+super.pri15[pNum]+" Euros";
				}
			}
			else if(pNum >89 && pNum<100)
			{
				pNum= pNum-90;
				if (pNum == 0)
				{
					resul="Noventa Euros";
				}
				else 
				{
					resul ="Noventa y "+super.pri15[pNum]+" Euros";
				}
			}
		}
		else 
		{
			resul ="Error";
		}

		return resul;
	}


	public void esArchivo(ArrayList<String> aEscri, File archivo) {
		try {
			FileWriter escribe = new FileWriter(archivo);
			PrintWriter escritor = new PrintWriter(escribe);
			for (int i = 0; i < aEscri.size(); i++) {
				escritor.println(aEscri.get(i));
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
		
	}
	
	public ArrayList<String> lectura(File archivo)
	{
		ArrayList<String> valores = new ArrayList<>();
		try {
			FileReader lee = new FileReader(archivo);
			BufferedReader lector =  new BufferedReader(lee);
			String linea = lector.readLine();
			while(linea!= null)
			{
				linea = lector.readLine();
			}
			lee.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return valores;
	}











}
