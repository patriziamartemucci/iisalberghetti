import it.alberghetti.geometria.*;

public class Collaudo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//istanze di Quadrilatero
		System.out.println("\n\nCrea oggetto Quadrilatero q1");
		Quadrilatero q1=new Quadrilatero();
		System.out.println("\n\nCrea oggetto Quadrilatero q2");
		Quadrilatero q2=new Quadrilatero(1,2,3,4);
		if(q1.equals(q2)){
			System.out.println("q1 e q2 sono uguali");
		}
		else{
			System.out.println("q1 e q2 sono diversi");
		}
		System.out.println("\n\nOggetto Quadrilatero q2: "+q2);
		System.out.println("area di q2: "+q2.area());
		Quadrilatero q3 = null;
		try {
			q3 = (Quadrilatero)q2.clone();
		} catch (CloneNotSupportedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Quadrilatero q3 clone di q2 "+q3);
		
		//istanze di Rettangolo
		System.out.println("\n\nCrea oggetto Rettangolo r1");
		Rettangolo r1=new Rettangolo();
		System.out.println("\n\nCrea oggetto Rettangolo r2");
		Rettangolo r2=new Rettangolo(2,3);
		System.out.println("\n\nCrea oggetto Rettangolo r3");
		Rettangolo r3=new Rettangolo(1,2,3);
		Rettangolo rclone = null;
		try {
			rclone = (Rettangolo)r3.clone();
		} catch (CloneNotSupportedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Oggetto r3: "+r3+"\nOggetto rclone copia di r3: "+rclone);
		
		
		//istanze di Quadrato
		System.out.println("\n\nCrea oggetto Quadrato p1");
		Quadrato p1=new Quadrato();
		System.out.println("\n\nCrea oggetto Quadrato p2");
		Quadrato p2=new Quadrato(2);
		System.out.println("\n\nCrea oggetto Quadrato p3");
		Quadrato p3=new Quadrato(1,2);
		Quadrato quadCopia = null;
		try {
			quadCopia = (Quadrato) p3.clone();
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Oggetto p3: "+p3+"\nOggetto quadCopia clone di p3: "+quadCopia);
		//istanze di Trapezio
		System.out.println("\n\nCrea oggetto Trapezio t1");
		Trapezio t1=new Trapezio();
		System.out.println("\n\nCrea oggetto Trapezio t2");
		Trapezio t2=new Trapezio(1,2,3,4);
		System.out.println("\n\nCrea oggetto Trapezio t3");
		Trapezio t3=new Trapezio(1,2,3,4,5);
		try{
			Trapezio tCopia=(Trapezio)t3.clone();
			System.out.println("Oggetto t3: "+t3+"\nOggetto tCopia clone di t3: "+tCopia);
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		
		//istanze di Object
		System.out.println("\n\nCrea oggetto Object o1");
		Object o1=new Object();
		System.out.println("Object o1: "+o1+"\n\n");
		System.out.println("Rettangolo r1: "+r1+"\n\n");
		System.out.println("Quadrilatero q1: "+q1+"\n\n");
		System.out.println("Quadrato p1: "+p1+"\n\n");
		System.out.println("Trapezio t1: "+t1+"\n\n");
		Object o2,o3,o4;
		
		System.out.println("\n\n\n-------------------------------------------------------");
		System.out.println("UPCAST");
		System.out.println("\n-------------------------------------------------------");
		o1=(Object)r2;
		System.out.println("Object o1 dopo upcast da Rettangolo r2 : "+o1);
		System.out.println("\n********************************************");
		Quadrilatero q5=(Quadrilatero)r2;
		System.out.println("Quadrilatero q5 dopo upcast da Rettangolo r2 : "+q5);
		System.out.println("Area di q5: "+q5.area());
		System.out.println("\n********************************************");
		o1=(Object)p2;
		System.out.println("Object o1 dopo upcast da Quadrato p2 : "+o1);
		System.out.println("\n********************************************");
		o1=(Object)q2;
		System.out.println("Object o1 dopo upcast da Quadrilatero q2 : "+o1);
		
		o2=q2;
		o3=r2;
		o4=p2;
		Object o5=t2;
		
		Rettangolo rr3;
		Quadrato pp3;
		//Downcasting
		System.out.println("\n\n\n-------------------------------------------------------");
		System.out.println("DOWNCAST");
		System.out.println("\n-------------------------------------------------------");
		Quadrilatero qq2=(Quadrilatero)o2;
		System.out.println("Quadrilatero qq2 dopo downcast da Object o2 (che contiene un riferimento a Quadrilatero): "+qq2);
		//rr3=(Rettangolo)o2;
		//System.out.println("Rettangolo rr3 dopo downcast da Object o2 (che contiene un riferimento a Quadrilatero): "+rr3);
		System.out.println("\n********************************************");		
		rr3=(Rettangolo)o3;
		System.out.println("Rettangolo rr3 dopo downcast da Object o3 (che contiene un riferimento a Rettangolo): "+rr3);
		//pp3=(Quadrato)o3;
		//System.out.println("Quadrato pp3 dopo downcast da Object o3 (che contiene un riferimento a Rettangolo): "+pp3);
		System.out.println("\n********************************************");	
		pp3=(Quadrato)o4;
		System.out.println("Quadrato pp3 dopo downcast da Object o4 (che contiene un riferimento a Quadrato): "+pp3);
		
		//System.out.println("\n********************************************");	
		//pp3=(Quadrato)o2;
		//System.out.println("Quadrato pp3 dopo downcast da Object o2 (che contiene un riferimento a Quadrilatero): "+pp3);
	
		//System.out.println("\n********************************************");	
		//Quadrato pp4=(Quadrato)r2;
		//System.out.println("Quadrato pp4 dopo downcast da Rettangolo r2 (che contiene un riferimento a Rettangolo): "+pp4);
		
		//UPCAST
		System.out.println("\n********************************************\nUPCAST\n");	
		Rettangolo r_up=(Rettangolo)pp3;

		System.out.println("Rettangolo r_up dopo upcast da pp3 (che contiene un riferimento a Quadrato): "+r_up);
		System.out.println("Perimetro: "+r_up.perimetro());
		System.out.println("Area: "+r_up.area());
		
		Quadrilatero qq6=rr3;
		System.out.println("\n\nQuadrilatero qq6 dopo upcast da rr3 (che contiene un riferimento a Rettangolo): "+qq6);
		System.out.println("Perimetro: "+qq6.perimetro());
		System.out.println("Area: "+qq6.area());
		
		
	}

}
