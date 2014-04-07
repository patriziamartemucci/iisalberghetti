package it.alberghetti.geometria;

public class Trapezio extends Quadrilatero //implements Cloneable
{
	protected int altezza;
	
	public Trapezio(){
		super();
		altezza=0;
		System.out.println("Classe Trapezio: costruttore senza parametri");
	}
	
	public Trapezio(int x,int y,int z,int k,int h){
		super(x,y,z,k);
		altezza=h;
		System.out.println("Classe Trapezio: costruttore con 5 parametri");
	}
	
	public Trapezio(int x,int y,int z,int k){
		this(x,y,z,k,0);
		System.out.println("Classe Trapezio: costruttore con 4 parametri");
	}
	
	public int geth(){
		return altezza;
	}
	
	public void seth(int h){
		this.altezza=h;
	}
	
	public double area(){
		return (a+c)*altezza/2;
	}
	
	public String toString(){
		System.out.println("Classe Trapezio: metodo toString");
		return "Trapezio["+a+","+b+","+c+","+d+","+altezza+"]";
	}

	public Object clone()throws CloneNotSupportedException{
		System.out.println("Classe Trapezio: metodo clone");
		try{
			return (Trapezio)super.clone();
		}
		catch(CloneNotSupportedException e){
			throw e;
		}
	}
	
	public boolean equals(Object o){
		System.out.println("Classe Trapezio: metodo equals");
		Trapezio q;
		if(o instanceof Trapezio){
			q=(Trapezio)o;
			if(q.a==this.a && q.b==this.b && q.c== this.c && q.d== this.d && q.altezza==this.altezza)return true;
			else return false;
		}
		else return false;
	}
}
