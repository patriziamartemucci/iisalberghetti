
public class TestFrazione {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frazione f1=new Frazione();
		f1.setNumDen(1,3);
		Frazione f2=new Frazione(-2,5);
		Frazione f3=new Frazione(-2,-4);
		Frazione f4=new Frazione(2,-7);
		System.out.println("f1: "+f1);
		System.out.println("f2: "+f2);
		System.out.println("f3: "+f3);
		System.out.println("f4: "+f4);
		
		Frazione f1Reciproca=f1.reciproca();
		Frazione f2Opposta=f2.opposta();
		
		System.out.println("Reciproca di f1: "+f1Reciproca);
		System.out.println("Opposta di f2: "+f2Opposta);
		
		Frazione somma=f3.somma(f4);

		if(f4.getDen()<0 || f4.getNum()<0)
			System.out.println("\nSomma (f3 + f4) --> "+f3+f4+"="+somma);
		else
			System.out.println("\nSomma (f3 + f4) --> "+f3+"+"+f4+"="+somma);
		
		Frazione f4Opposta=f4.opposta();
		Frazione sottrazione=f3.somma(f4.opposta());

		if(f4.getDen()<0 || f4.getNum()<0)
			System.out.println("\nSottrazione (f3 - f4) --> "+f3+"+"+f4Opposta+"="+sottrazione);
		else
			System.out.println("\nSottrazione (f3 - f4) --> "+f3+"-"+f4Opposta+"="+sottrazione);
		
		Frazione divisione=f1.prodotto(f2.reciproca());
		System.out.println("\n\nDivisione: f1 diviso f2 --> ("+f1+")/("+f2+")= "+divisione);
		
		Frazione prodotto=f1.prodotto(f2);
		System.out.println("\n\nProdotto: f1 * f2 --> ("+f1+")*("+f2+")= "+prodotto);
		
		Frazione f5=new Frazione(f2.getNum(),f2.getDen());
		System.out.println("\n\nf2 e' uguale a f5? "+f2.equals(f5));
		System.out.println("f1 e' uguale a f5? "+f1.equals(f5));
	}

}
