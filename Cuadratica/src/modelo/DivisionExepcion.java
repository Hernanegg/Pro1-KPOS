package modelo;

public class DivisionExepcion extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DivisionExepcion ()
	{
		super("No se pueden hacer diviciones en 0");
	}

}
