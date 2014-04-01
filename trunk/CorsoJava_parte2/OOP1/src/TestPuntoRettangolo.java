import it.alberghetti.geometriaPiano2D.Rettangolo;
import it.alberghetti.geometriaPiano2D.Punto;

public class TestPuntoRettangolo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto p1=new Punto();
		Punto p2=new Punto(3);
		Punto p3=new Punto(3,5);
		System.out.println("Distanza di p3 dall'orogine: "+p3.distanza());
		System.out.println("Distanza di p3 dall'orogine: "+p3.distanza(new Punto()));
		System.out.println("Distanza di p3 da p2: "+p3.distanza(p2));
		//boolean b=p3.equals(p1);//p3  uguale a p1?
		Punto p4=p3.simmetrico();
		System.out.println("p4 "+p4.toString());
		System.out.println("p4 "+p4);
		p4.trasla(3, 4);
		System.out.println("p4 traslato"+p4);
		
		//Rettangolo
		Rettangolo r1=new Rettangolo();
		System.out.println("r1 "+r1);
		Rettangolo r2=new Rettangolo(p3,3,4);
		System.out.println("r2 "+r2);
		System.out.println("area di r2 "+r2.area());
		System.out.println("perimetro  di r2 "+r2.perimetro());
		
		Rettangolo r3=new Rettangolo(new Punto(10,2),3,4);
	}

}
