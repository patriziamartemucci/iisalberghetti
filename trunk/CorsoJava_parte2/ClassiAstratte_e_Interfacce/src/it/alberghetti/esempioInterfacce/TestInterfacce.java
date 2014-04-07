package it.alberghetti.esempioInterfacce;

public class TestInterfacce {
	public static void main(String args[]){
		Planes plane=new Planes();
		Ships ship=new Ships();
		RemoteControl shipRemote=new RemoteControl(ship);
		RemoteControl planeRemote=new RemoteControl(plane);
		System.out.println("Ho creato un oggetto telecomando per l'aereo");
		System.out.println("Premo il tasto start del telecomando per l'aereo");
		planeRemote.tastoStart();
		System.out.println("\n\nHo creato un oggetto telecomando per la nave");
		System.out.println("Premo il tasto start del telecomando per la nave");
		shipRemote.tastoStart();
		
		// non posso creare un'istanza di tipo Machine (è una classe astratta)
		Machine m;
		//m=new Machine();//cannot instantiate the type Machine
		//posso dichiarare una variabile di tipo Movable (che è un'interfaccia)
		Movable m2;
		//posso assegnare a m2 un oggetto di tipo Planes (si tratta di un upcasting, perchè Planes implementa Movable)
		System.out.println("\n\nDichiaro una variabile di tipo Movable e le assegno il valore di plane facendo un upcasting implicito");
		m2=plane;
		m2.start();
		//m=m2;// ERRORE: cannot convert from Movable to Machine
		
		// non posso creare un'istanza di tipo Movable (è un'interfaccia)
		//m2=new Movable();//cannot instantiate the type Movable

		//istanzio MacchininaGiocattolo, posso farlo perchè è una classe concreta che estende la classe astratta Machine
		System.out.println("\n\nCreo una istanza della classe MacchininaGiocattolo, la faccio partire e la fermo.");
		MacchininaGiocattolo mg=new MacchininaGiocattolo();
		mg.start();
		mg.stop();
		System.out.println("\nMacchininaGiocattolo è una classe concreta derivata dalla classe astratta Machine.\n" +
				"Machine è una classe atratta che implementa Movable. Dell'interfaccia Movable implementa solo il metodo start");
		m=mg;
		m.fuelRemaining();
	}
}
