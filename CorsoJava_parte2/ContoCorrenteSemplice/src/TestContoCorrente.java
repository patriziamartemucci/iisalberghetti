
public class TestContoCorrente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContoCorrente c1=new ContoCorrente();
		ContoCorrente c2=new ContoCorrente(500);
		
		System.out.println("c1: "+c1+"\nc2: "+c2);
		c1.versa(1000);
		int k=c2.preleva(300);
		if(k>0){
			System.out.println("Prelievo riuscito. Saldo: "+c2.saldo());
		}
		else{
			System.out.println("Prelievo non riuscito. Saldo: "+c2.saldo());
		}
		k=c2.preleva(300);
		if(k>0){
			System.out.println("Prelievo riuscito. Saldo: "+c2.saldo());
		}
		else{
			System.out.println("Prelievo non riuscito. Saldo: "+c2.saldo());
		}
	}

}
