package vista;

import javax.swing.JOptionPane;

public class Ventanas {
	
	public void mostaraHeli(String pTakeOff, String pLand, String pFly, String pFunci, String pConducir, String pFrena)
	{
		JOptionPane.showMessageDialog(null,"HELICOPTERO"+"\n"+pTakeOff+"\n"+pLand+"\n"+pFly+"\n"+pFunci+"\n"+pConducir+"\n"+pFrena);
	}
	
	public void mostarSeaPlane(String pTakeOff, String pLand, String pFly, String pFunci, String pConducir, String pFrena)
	{
		JOptionPane.showMessageDialog(null, "SEAPLANE"+"\n"+pTakeOff+"\n"+pLand+"\n"+pFly+"\n"+pFunci+"\n"+pConducir+"\n"+pFrena);
	}

	public void mostarSman(String pTakeOff, String pLand, String pFly,String pEa, String pLMentes, String pAcciones) {
		JOptionPane.showMessageDialog(null, "SUPERMAN"+"\n"+pTakeOff+"\n"+pLand+"\n"+pFly+"\n"+pEa+"\n"+pLMentes+"\n"+pAcciones);
	}
	
	public void mostarBird(String pTakeOff, String pLand, String pFly,String pEa, String pLayEggs, String pbuildNest) {
		JOptionPane.showMessageDialog(null, "BIRD"+pTakeOff+"\n"+pLand+"\n"+pFly+"\n"+pEa+"\n"+pLayEggs+"\n"+pbuildNest);
	}
}
