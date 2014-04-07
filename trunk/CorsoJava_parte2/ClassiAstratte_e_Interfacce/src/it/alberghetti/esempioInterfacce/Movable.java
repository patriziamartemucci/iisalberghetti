package it.alberghetti.esempioInterfacce;

public interface Movable {
	boolean start();
	boolean stop();
	boolean turn(int degrees);
	double fuelRemaining();
	boolean changeSpeed(double kmperhour);
}
