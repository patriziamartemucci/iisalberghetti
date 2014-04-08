package it.alberghetti.esempioInterfacce;

public class MacchininaGiocattolo extends Machine{
	// questa classe deriva da Machine, che � una classe astratta.
	// Machine ha implementato solo il metodo start, gli altri saranno implementati qui
	@Override
	public void foo(){
		System.out.println("Metodo foo");
	}
	public boolean stop() {
		System.out.println("Sono nel metodo stop di MacchininaGiocattolo");
		return true;
	}

	@Override
	public boolean turn(int degrees) {
		return true;
	}

	@Override
	public double fuelRemaining() {
		System.out.println("\nSono nel metodo fuelRemaining di MacchininaGioattolo");
		return 1;
	}

	@Override
	public boolean changeSpeed(double kmperhour) {
		return true;
	}

}
