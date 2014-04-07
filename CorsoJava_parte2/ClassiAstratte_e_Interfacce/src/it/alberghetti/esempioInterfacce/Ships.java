package it.alberghetti.esempioInterfacce;

public class Ships implements Movable {

	@Override
	public boolean start() {
		//fai ci� che serve per far partire la nave l'aereo
				//e restituisci true in caso di successo
		System.out.println("Sono nel metodo start di Ships");
		return true;
	}

	@Override
	public boolean stop() {
		//fai ci� che serve per far fermare la nave
		//e restituisci true in caso di successo
		return true;
	}

	@Override
	public boolean turn(int degrees) {
		// fai ci� che serve per far virare la nave
		//e restituisci true in caso di successo
		return true;
	}

	@Override
	public double fuelRemaining() {
		//restituisci la quantit� di carburante
		return 1;
	}

	@Override
	public boolean changeSpeed(double kmperhour) {
		//accelera in km/h (decelera se negativa)
		return true;
	}

}
