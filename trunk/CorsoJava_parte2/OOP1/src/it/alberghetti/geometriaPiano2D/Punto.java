package it.alberghetti.geometriaPiano2D;

public class Punto {

	private double x;
	private double y;
	
	public Punto(double a){
		x=a;y=a;
	}
	public Punto(){
		x=0;y=0;
	}
	
	public Punto(double a,double b){
		x=a;y=b;
	}
	public void setX(double a){
		x=a;
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
		d=Math.sqrt((x)*(x)+(y)*(y));
		return d;
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
