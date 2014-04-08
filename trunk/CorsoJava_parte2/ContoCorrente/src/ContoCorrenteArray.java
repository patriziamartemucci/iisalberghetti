

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ContoCorrenteArray {
	protected final static int stepIncrement = 10;
	private static int ultimoNumeroConto = 0;
	private int numeroConto;
	protected int saldo;
	protected OperazioneBanca[] operazioni;
	protected int indexInOperazioni;

	ContoCorrenteArray() {
		numeroConto = ultimoNumeroConto;
		ultimoNumeroConto++;//in modo che il prossimo conto avra' un valore diverso
		saldo = 0;
		operazioni = new OperazioneBanca[stepIncrement];
		indexInOperazioni = -1;
	}

	ContoCorrenteArray(int valore, Calendar data) {
		this();
		versa(valore, data);
	}

	public void versa(int valore, Calendar data) {
		saldo = saldo + valore;
		OperazioneBanca ob = new OperazioneBanca(valore, data, TipoOperazione.VERSAMENTO);
		addOperazione(ob);
	}

	protected void addOperazione(OperazioneBanca ob) {
		indexInOperazioni++;
		if(indexInOperazioni == operazioni.length) {
			OperazioneBanca[] newOperazioni = new OperazioneBanca[operazioni.length + stepIncrement];
			for(int i= 0; i < operazioni.length; i++) {
				newOperazioni[i] = operazioni[i];
			}
			operazioni = newOperazioni;
		}
		operazioni[indexInOperazioni] = ob;
	}

	public void preleva(int valore, Calendar data) {
		if(valore <= saldo) {
			saldo = saldo - valore;
			OperazioneBanca ob = new OperazioneBanca(valore, data, TipoOperazione.PRELIEVO);
			addOperazione(ob);
		}
		else {
			System.out.println("Prelievo non permesso. Il saldo del conto e' " + saldo + ".");
		}
	}

	public void listaMovimenti() {
		System.out.println("Saldo: " + saldo);
		System.out.println("Lista operazioni:");
		for(int i = 0; i <= indexInOperazioni; i++) {
			System.out.println("\t" + operazioni[i].toString());
		}
	}

	public void cancellaOperazioni(Calendar startDate, Calendar endDate) {
		Calendar obData;
		OperazioneBanca[] daTenere = new OperazioneBanca[operazioni.length];
		int index = -1;
		
		for(int i = 0; i <=indexInOperazioni; i++) {
			obData = operazioni[i].getData();
			if(obData.before(startDate) || obData.after(endDate)) {
				index++;
				daTenere[index] = operazioni[i];
			}
		}
		operazioni = daTenere;
		indexInOperazioni = index;
	}

	public int getNumeroConto() {
		return numeroConto;
	}

	public int getSaldo() {
		return saldo;
	}
}
