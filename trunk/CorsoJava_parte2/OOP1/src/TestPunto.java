import it.alberghetti.geometriaPiano2D.Punto;
public class TestPunto {

	public static void main(String[] args) {
		Punto p=new Punto();
		Punto p2=new Punto(4,6);
		Punto p3=new Punto(4,6);
		Punto p4=p3;
		System.out.println("Metodo toString()");
		System.out.println("p: "+p);
		System.out.println("p2: "+p2);
		System.out.println("p3: "+p3);
		System.out.println("p4: "+p4);
		System.out.println("p2 uguale p3? "+(p2.equals(p3)));
		System.out.println("p3 uguale p4? "+(p3.equals(p4)));
		
		System.out.println("\n\nMetodo hashCode()");
		System.out.println("p: "+p.hashCode());
		System.out.println("p2: "+p2.hashCode());
		System.out.println("p3: "+p3.hashCode());
		System.out.println("p4: "+p4.hashCode());
		String s="ciao";
		String s2=new String("ciao");
		System.out.println(s.hashCode()+" "+s2.hashCode());

	}

}
