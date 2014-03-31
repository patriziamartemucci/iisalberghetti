
public class TestNumeroComplesso {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumeroComplesso c1,c2,c3;
		c1=null;
		c2=null;
		c3=null;
		
		c1=new NumeroComplesso(1,-2);
		c2=new NumeroComplesso(1,1);
		c3=c1.somma(c2);
		System.out.println("somma: "+c3);
		c3=c1.somma(c2.opposto());
		System.out.println("sottrazione: "+c3);
		c3=c1.rapporto(c2);
		System.out.println("rapporto: "+c3);
		c3=c1.prodotto(c2.reciproco());
		System.out.println("rapporto: "+c3);
		c3=c1.prodotto(c2);
		System.out.println("prodotto: "+c3);
		c3=c1.quadrato();
		System.out.println("somma: "+c3);
		c3=c1.coniugato();
		System.out.println("coniugato: "+c3);
		System.out.println("modulo: "+c3.modulo());
		
		NumeroComplesso c4=c1;
		NumeroComplesso c5=c1.clone();
		
		boolean b=c4==c1;//l'operatore == confronta il contenuto delle variabili 
						//c1 e c4 nello stack (confronta i riferimenti)
		System.out.println("c1 e' uguale a c4? "+b);
		
		b=c5==c1;//l'operatore == confronta il contenuto delle variabili 
			//c1 e c5 nello stack (confronta i riferimenti)
		System.out.println("c1 e' uguale a c5? "+b);
		
		b=c1.equals(c5);//equals confronta il contenuto degli oggetti nell'heap, 
						//confronta il valore degli attributi degli oggetti riferiti da c1 e c5
		System.out.println("L'oggetto riferito da c1 e' uguale all'oggetto riferito da c5? "+b);
	}

}
