package it.alberghetti.esempioInterfacce;

public abstract class Machine implements Movable {
	//essendo una classe astratta posso implementare solo alcuni metodi e 
	//demandare l'implementazione degli altri ad una classe derivata
	
	@Override
	public boolean start() {
		//fai ci� che serve per far partire la macchina
		//e restituisci true in caso di successo
		System.out.println("Sono nel metodo start di Machine (Classe Astratta). Ho implementato solo il metodo start");
		return true;
	}
}
