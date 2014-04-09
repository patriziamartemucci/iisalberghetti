package it.alberghetti.esempioInterfacce2;
public class DispositivoIO {
	Porta p;
	public DispositivoIO(Porta p){
		this.p=p;
	}
	public boolean inizializza(){
		return p.apri();
	}
	public boolean finalizza(){
		return p.chiudi();
	}
	public void inviaDati(byte b[]){
		p.scrivi(b);
	}
	public byte [] leggiDati(){
		byte b[]=p.leggi();
		return b;
	}
}
