package modelo;

public class Mundo {
	
	private int a;
	private int b;
	private int c;
	
	public Mundo(int pa, int pb, int pc)
	{
		this.a = pa;
		this.b= pb;
		this.c = pc;
	}
	
	public boolean validarRais() throws RaizExepcion
	{
		boolean exepcion = false; 
		int resultado = ((b*b)-4*a*c); 
		if(resultado<0)
		{
			exepcion = true;
			throw new RaizExepcion();
			
		}
		return exepcion;
	}

	public boolean validarDivicion() throws DivisionExepcion 
	{
		boolean exepcion = false;
		int resultado = 2*a;
		if(resultado ==0)
		{
			exepcion = false;
			throw new DivisionExepcion();
		}
		return exepcion;
	}
	
	public String hacerOperacion() throws RaizExepcion, DivisionExepcion
	{
		double numerador1=0;
		double numerador2=0;
		double denominador=0;
		if(validarRais() == false && validarDivicion() == false)
		{
			numerador1 = -b+Math.sqrt((b*b)-4*a*c);
			numerador2 = -b-Math.sqrt((b*b)-4*a*c);
			denominador = 2*a;
		}
		return "El resultado de x1="+numerador1/denominador+"\nEL resultado de x2="+numerador2/denominador;
	}


}
