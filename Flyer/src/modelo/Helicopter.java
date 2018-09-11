package modelo;

public class Helicopter extends Airplane {

	public Helicopter()
	{
		super.color = "gris";
		super.marca = "AgustaWestland";
		super.tipoDeV= "Helicoptero";
	}
	public String takeOff() {
		return "Despega en un helipuerto";
	}

	public String land() {
		return "Aterriza en un helipuerto o en un lugar plano";
	}

	public String fly() {
		return "Puede meantenerse quieto en el aire";
	}

	public String funcionamiento() {
		return "Sirven para transportar pocas personas y/o suminisros, tambien para vijilancias";
	}

	public String conducir() {
		return "Se conduce pon una palanca";
	}

	public String frenar() {
		return "Frena de forma moderada para evitar accidentes";
	}



}
