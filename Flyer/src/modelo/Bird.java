package modelo;

public class Bird extends Animal implements Flyer {

	public String takeOff() {
		return "Despegan de cualquier lugar";
	}

	public String land() {
		return "Aterrizan donde puedan";
	}

	public String fly() {
		return "Vuela con las alas y las corrientes de aire";
	}
	
	public String buildNest()
	{
		return "Construyen sus nidos en la parte de arriba de los arboles";
	}
	
	public String layEggs()
	{
		return "Pone huevos en los nidos";
	}

	public String eat() {
		return "El pajaro como lombrises";
	}
	

	
}
