package it.alberghetti.esempioInterfacce;

public interface Movable {
	public final static int PDF=1;
	boolean start();
	boolean stop();
	boolean turn(int degrees);
	double fuelRemaining();
	boolean changeSpeed(double kmperhour);
}
