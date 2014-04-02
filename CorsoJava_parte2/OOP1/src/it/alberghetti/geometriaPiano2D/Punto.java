package it.alberghetti.geometriaPiano2D;

public class Punto {

	public static int contaPunti;
	
	public static final double PIGRECO=3.14;
	private double x;
	private double y;
	
	static{
		contaPunti=0;
	}
	
	public static double doppio(double a){
		return a*2;
	}
	public Punto(double a){
		this(a,a);
		contaPunti++;
	}
	
	public Punto(){
		//this(0,0);
		contaPunti++;
	}
	
	public Punto(double a,double b){
		x=a;y=b;
		contaPunti++;
	}
	
	public void setX(double x){
		this.x=x;
	}
	public void setY(double b){
		y=b;;
	}
	public void setXY(double a,double b){
		x=a;y=b;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
    }
	
	public void trasla(double deltax,double deltay){
		x=x+deltax;
		y=y+deltay;
		
	}
	public double distanza(Punto p){
		double d;
		d=Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
		return d;
		}
	
	public double distanza(){
		double d;
		Punto p=new Punto();
		d=this.distanza(p);
		return d;
	}	
	
	public void finalize(){
		System.out.println("Fine di punto. L'oggetto sara eliminato");
		contaPunti--;
	}
	/*
	public String toString(){
		String s;
		s="("+x+","+y+")";
		return s;
	}
	*/
	public Punto simmetrico(){
		Punto p=new Punto();
		p.x=-x;
		p.y=-y;
		return p;
	}
	
}
