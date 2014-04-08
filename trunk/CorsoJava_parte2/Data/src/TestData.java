
public class TestData {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Data d1=new Data(31,12,2015);
		Data d2=new Data(1,1,2016);
		System.out.println("d1: "+d1);
		System.out.println("d2: "+d2);
		System.out.println("Giorni trascorsi: "+d1.giorniTrascorsi(d2));
		d1.successivo();
		System.out.println("d1: "+d1);
		d2.precedente();
		System.out.println("d2: "+d2);
	}
}
