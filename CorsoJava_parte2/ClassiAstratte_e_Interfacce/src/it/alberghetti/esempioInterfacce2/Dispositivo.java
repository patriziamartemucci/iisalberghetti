package it.alberghetti.esempioInterfacce2;
public abstract class Dispositivo implements Porta{
	public Dispositivo(){}
	public boolean apri(){
		System.out.println("Metodo apri della classe Dispositivo");
		return true;
	}
}
