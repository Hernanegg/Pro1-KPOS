package controlador;

import modelo.Bird;
import modelo.Helicopter;
import modelo.SeaPlane;
import modelo.Superman;
import vista.Ventanas;

public class Controlador {

	Superman s = new Superman();
	Bird b = new Bird();
	Helicopter h = new Helicopter();
	SeaPlane aM = new SeaPlane();
	Ventanas v = new Ventanas();
	
	public Controlador ()
	{
		v.mostaraHeli(h.takeOff(), h.land(), h.land(),h.funcionamiento(), h.conducir(), h.frenar());
		v.mostarSeaPlane(aM.takeOff(), aM.land(), aM.fly(), aM.funcionamiento(), aM.conducir(), aM.frenar());
		v.mostarBird(b.takeOff(),b.land(), b.fly(), b.eat(), b.layEggs(), b.buildNest());
		v.mostarSman(s.takeOff(), s.land(), s.fly(), s.eat(),s.leerMentes(), s.acciones());
	}
	
}
