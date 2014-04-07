package it.alberghetti.geometriaPiano2D;

public class PuntoNonValidoInRettangolo extends Exception{
	int i;
	
	public PuntoNonValidoInRettangolo(int x){
		this.i=x;
		System.out.println("\nCostruttore di PuntoNonValidoInRettangolo.\nParametro  "+i+
				"\n0: eccezione creata da setPointRightDown"+
				"\n1: eccezione creata da setPointLeftUp");
	}
	public String toString(){
		if(i==0)
			return "Punto in basso a destra non valido";
		else 
			return "Punto in alto a sinistra non valido";
	}
	
}
