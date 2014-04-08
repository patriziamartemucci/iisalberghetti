import java.util.Calendar;
import java.util.Date;


public class TestContoCorrente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContoCorrenteArray c=new ContoCorrenteArray();
		ContoCorrenteArray c2=new ContoCorrenteArray();
		
		/* adding 1 day to the actual date */
		
		Date eventDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(eventDate);
		
		Calendar calendar2=Calendar.getInstance();
		calendar2.setTime(eventDate);
		calendar2.add(Calendar.MONTH, 1);
		Date pastDate = calendar2.getTime();

		Calendar calendar3=Calendar.getInstance();
		calendar3.setTime(eventDate);
		calendar3.add(Calendar.DATE,5);
		Date pastDate2 = calendar3.getTime();
		
		System.out.println("Data d1: "+eventDate);
		System.out.println("Data d2: "+pastDate);
		System.out.println("Data d3: "+pastDate2);
		
		c.versa(1000, calendar);
		c.versa(1000,calendar2);
		c.preleva(200,calendar2);
		System.out.println("\nnumero ContoCorrente: "+c.getNumeroConto());
		System.out.println("\nvalore ContoCorrente: "+c.getSaldo());
		System.out.println("\nLista movimenti conto n. "+c.getNumeroConto());
		c.listaMovimenti();
		Date di = calendar.getTime();
		Date df=calendar3.getTime();
		System.out.println("\n\nCancella le operazioni eseguite " +
				"nelle date\n da\t"+di+"\n a\t"+df);
		c.cancellaOperazioni(calendar,calendar3);
		System.out.println("\nLista movimenti del conto n. "+c.getNumeroConto()+" dopo la cancellazione  ");
		c.listaMovimenti();
		
		c2.versa(150,calendar3);
		System.out.println("\nLista movimenti conto n. "+c2.getNumeroConto());
		c2.listaMovimenti();
		
	}

}
