package it.alberghetti.geometria;


public class Quadrilatero //implements Cloneable
{
	protected int a;
	protected int b;
	protected int c;
	protected int d;
	
	public Quadrilatero(){
		this(0,0,0,0);
		System.out.println("Classe Quadrilatero: costruttore senza parametri");
	}
	
	public Quadrilatero(int x, int y,int z,int k){
		System.out.println("Classe Quadrilatero: costruttore con 4 parametri");
		this.a=x;
		this.b=y;
		this.c=z;
		this.d=k;
	}
	
	public void setLato(int i,int x){
		System.out.println("Classe Quadrilatero: metodo setLato");
		switch(i){
			case 1: this.a=x; break;
			case 2: this.b=x; break;
			case 3: this.c=x; break;
			case 4: this.d=x; break;
		}
	}
	
	public int getLato(int i){
		System.out.println("Classe Quadrilatero: metodo getLato");
		switch (i){
		case 1: return a;
		case 2: return b;
		case 3: return c;
		case 4: return d;
		default: return -1;
		}
	}
	
	public int perimetro(){
		System.out.println("Classe Quadrilatero: metodo perimetro");
		return a+b+c+d;
	}
	
	public double area(){
		System.out.println("Classe Quadrilatero: metodo area");
		int sp=this.perimetro()/2;
		return Math.sqrt((sp-a)*(sp-b)*(sp-c)*(sp-d));
	}
	
	public String toString(){
		System.out.println("Classe Quadrilatero: metodo toString");
		return "Quadrilatero["+a+","+b+","+c+","+d+"]";
	}
	
	public Object clone() throws CloneNotSupportedException{
		System.out.println("Classe Quadrilatero: metodo clone");
		try{
			return (Quadrilatero)super.clone();
		}
		catch(CloneNotSupportedException e){
			throw e;
		}
		
	}
	
	public boolean equals(Object o){
		System.out.println("Classe Quadrilatero: metodo equals");
		Quadrilatero q;
		if(o instanceof Quadrilatero){
			q=(Quadrilatero)o;
			if(q.a==this.a && q.b==this.b && q.c== this.c && q.d== this.d)return true;
			else return false;
		}
		else return false;
	}
}
