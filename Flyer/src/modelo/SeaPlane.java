package modelo;

public class SeaPlane extends Airplane{


	public SeaPlane()
	{
		super.color = "azul";
		super.marca ="McDonnell";
		super.tipoDeV = "Avion con aterrizaje acuatico";
	}
	public String takeOff() {
		return "Despega en aguas";
	}

	public String land() {
		return "Aterriza en el agua";
	}

	public String fly() {
		return "Vuela por los lugares mas remotos y a bajas alturas";
	}

	public String funcionamiento() {
		return "Sirve para llevar y traer cosas en lugares donde se puede aterrisar solo en agua";
	}

	public String conducir() {
		return "Conduce con un copiloto";
	}

	public String frenar() {
		return "Frena cuando esta sobre el agua";
	}

}
