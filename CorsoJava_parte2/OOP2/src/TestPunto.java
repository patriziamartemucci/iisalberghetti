import it.alberghetti.geometriaPiano2D.Punto;
public class TestPunto {

	
	public static void main(String[] args) {

		Punto p=new Punto();
		Punto p2=new Punto(4,6);
		Punto p3=new Punto(4,6);
		Punto p4=p3;
		System.out.println("Metodo toString()");
		System.out.println("p: "+p.toString());//chiamata esplicita
		System.out.println("p2: "+p2);//chiamata implicita
		System.out.println("p3: "+p3);
		System.out.println("p4: "+p4);
		System.out.println("p2 uguale p3? "+(p2.equals(p3)));
		System.out.println("p3 uguale p4? "+(p3.equals(p4)));
		System.out.println("p2==p3? "+(p2==p3));
		System.out.println("p3==p4? "+(p3==p4));

		Punto copia=(Punto)p2.clone();
		System.out.println("Punto p2: "+p2);
		System.out.println("Punto clone di p2: "+copia);
		System.out.println("p2 e' uguale a copia? "+p2.equals(copia));
		System.out.println("p2==copia? "+(p2==copia));
		
		System.out.println("\n\np2.x: "+p2.getX()+
				"   p2.y: "+p2.getY());
		
		Punto p5=p2.simmetrico();
		System.out.println("p5.x: "+p5.getX()+
				"   p5.y: "+p5.getY());
		
		
		System.out.println("\n\nMetodo hashCode()");
		System.out.println("p: "+p.hashCode());
		System.out.println("p2: "+p2.hashCode());
		System.out.println("p3: "+p3.hashCode());
		System.out.println("p4: "+p4.hashCode());
		

		double x=Punto.PIGRECO*4;
		
		String s="ciao";
		String s2=new String("ciao");
		System.out.println(s.hashCode()+" "+s2.hashCode());
		
	}

}
