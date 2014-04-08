
public class TestAutomobile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Automobile a1=new Automobile(30);
		Automobile a2=new Automobile();
		a1.accendi();
		a2.accendi();
		
		System.out.println("\na1: "+a1+"\na2: "+a2);
		a1.gira(-30);
		a1.accelera(10);
		a1.accelera(30);
		a2.accelera(50);
		System.out.println("\na1: "+a1+"\na2: "+a2);
		a2.gira(90);
		a1.spegni();
		System.out.println("\na1: "+a1+"\na2: "+a2);
		a2.accendi();//non ha effetto, e' gia' accesa
		System.out.println("\na1: "+a1+"\na2: "+a2);
	}
}
