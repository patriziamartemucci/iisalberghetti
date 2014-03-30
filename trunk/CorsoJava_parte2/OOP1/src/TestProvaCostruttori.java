
public class TestProvaCostruttori {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// non posso richiamare il costruttore senza parametri, 
		// perch� non dichiarato nella classe ProvaCostruttori
		// e NON EREDITATO dalla classe Object (come tutti i costruttori)
		
		//ProvaCostruttori a1=new ProvaCostruttori();

		ProvaCostruttori a=new ProvaCostruttori(3,5);
		System.out.println("Oggetto a: "+a);
		
		ProvaCostruttori b=new ProvaCostruttori(((float)3),(int)5);
		System.out.println("Oggetto b: "+b);
		
		ProvaCostruttori c=new ProvaCostruttori((float)3,(float)5);
		System.out.println("Oggetto c: "+c);
		
		ProvaCostruttori d=new ProvaCostruttori(5,3.0F);
		System.out.println("Oggetto d: "+d);
		
		a.scala(4);
		System.out.println("Oggetto a dopo la chiamata a scala(int): "+a);
		if(a.scala(3,4)){
			System.out.println("OK");
		}
		else System.out.println("NO");
		System.out.println("Oggetto a dopo la chiamata a boolean scala(int,int): "+a);
	}

}
