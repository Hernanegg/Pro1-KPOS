package modelo;

public class RaizExepcion extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RaizExepcion ()
	{
		super("No existen raises cuadradas negativas");
	}

}
