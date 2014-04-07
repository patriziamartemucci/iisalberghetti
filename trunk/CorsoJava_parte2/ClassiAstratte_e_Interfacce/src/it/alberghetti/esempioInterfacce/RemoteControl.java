package it.alberghetti.esempioInterfacce;

public class RemoteControl {
	private Movable m;
	RemoteControl (Movable m){
		this.m=m;
	}
	
	//quando si preme il pulsante start
	boolean tastoStart(){
		System.out.println("Sono nel metodo tastoStart di RemoteControl. ");
		boolean okay=m.start();
		if(!okay){
			System.out.println("Il modellino non � partito!");
		}
		return okay;
	}
}
