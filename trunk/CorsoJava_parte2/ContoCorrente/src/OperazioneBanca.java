

import java.util.Calendar;

public class OperazioneBanca {
	private int valore;
	private Calendar data;
	//private String tipoOperazione;
	private TipoOperazione tipoOperazione;

	OperazioneBanca(int valore, Calendar data, TipoOperazione tipoOperazione) {
		this.valore = valore;
		this.data = data;
		this.tipoOperazione = tipoOperazione;
	}

	public int getValore() {
		return valore;
	}

	public Calendar getData() {
		return data;
	}

	public TipoOperazione getTipoOperazione() {
		return tipoOperazione;
	}

	public String toString() {
		return "In data " + data.getTime() + " e' stato eseguito un " + tipoOperazione + " di " + valore + " euro.";
	}
}

enum TipoOperazione {
	VERSAMENTO, PRELIEVO;
}