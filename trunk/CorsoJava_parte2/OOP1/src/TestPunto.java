import it.alberghetti.geometriaPiano2D.Punto;
public class TestPunto {

	
	public static void main(String[] args) {
	
		System.out.println("Punto.contaPunti: "+Punto.contaPunti);
		Punto p=new Punto();
		Punto p2=new Punto(4,6);
		Punto p3=new Punto(4,6);
		Punto p4=p3;
		System.out.println("Metodo toString()");
		System.out.println("p: "+p.toString());
		System.out.println("p2: "+p2);
		System.out.println("p3: "+p3);
		System.out.println("p4: "+p4);
		//System.out.println("p2 uguale p3? "+(p2.equals(p3)));
		//System.out.println("p3 uguale p4? "+(p3.equals(p4)));
		double d=p2.distanza(p3);
		System.out.println("p2.x: "+p2.getX()+
				"   p2.y: "+p2.getY());
		d=p2.distanza();
		System.out.println("p2.contaPunti: "+p2.contaPunti);
		System.out.println("p.contaPunti: "+p.contaPunti);
		System.out.println("p3.contaPunti: "+p3.contaPunti);
		System.out.println("Punto.contaPunti: "+Punto.contaPunti);
		System.gc();
		p2.trasla(2,3);
		p2.doppio(4);
		Punto.doppio(5);
		System.out.println("p2.x: "+p2.getX()+
				"   p2.y: "+p2.getY());
		
		Punto p5=p2.simmetrico();
		System.out.println("p5.x: "+p5.getX()+
				"   p5.y: "+p5.getY());
		
		
		System.out.println("Punto.contaPunti: "+Punto.contaPunti);
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
