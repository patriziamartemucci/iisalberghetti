import it.alberghetti.geometriaPiano2D.PuntoNonValidoInRettangolo;
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
		
		
		//Rettangolo
		Rettangolo r1=new Rettangolo();
		System.out.println("r1 "+r1);
		Rettangolo r2=new Rettangolo(p3,3,4);
		System.out.println("r2 "+r2);
		System.out.println("area di r2 "+r2.area());
		System.out.println("perimetro  di r2 "+r2.perimetro());
		
		Rettangolo r3=new Rettangolo(new Punto(10,2),3,4);
		Rettangolo r4=(Rettangolo)r3.clone();
		System.out.println("Rettangolo r3 "+
				r3+"\nRettangolo r4 clone di r3 "+r4);
	
		if(r4!=null){
			System.out.println("r3 e' uguale a r4? "+r3.equals(r4));
			System.out.println("r3 == r4? "+(r3==r4));
		}
		System.out.println("\n\nRichiamo il metodo setPointLeftUp");
		try{
			r1.setPointLeftUp(new Punto(10,0));
		}
		catch(PuntoNonValidoInRettangolo e){
			System.out.println("Eccezione PuntoNonValidoInRettangolo: "+e);
		}
		catch(Exception e){
			System.out.println("Altra eccezione: "+e.getMessage());
		}
		System.out.println("\n\nRichiamo il metodo setPointRightDown");
		try{
			r1.setPointRightDown(new Punto(0,10));
		
		}
		catch(PuntoNonValidoInRettangolo e){
			System.out.println("Eccezione PuntoNonValidoInRettangolo: "+e);
		}
		catch(Exception e){
			System.out.println("Altra eccezione: "+e.getMessage());
		}
		Punto pc=r2.getPointLeftUp();
		System.out.println("P3 vale "+p3+"\npc (clone di p3) vale "+pc);
		
		
	}
	

}
