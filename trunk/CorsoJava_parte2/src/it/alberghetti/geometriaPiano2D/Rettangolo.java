package it.alberghetti.geometriaPiano2D;

/**
 * UL ------------ UR
 * |                |
 * |                |
 * DL ------------ DR
 * 
 * Il rettangolo e' definito dai punti LU e RD.
 *
 */
public class Rettangolo {
	private Punto pointLeftUp;//punto a sinistra in alto
	private Punto pointRightDown;//punto a destra in basso

	public Rettangolo() {
		// crea un rettangolo di base 2 e altezza 1
		pointLeftUp = new Punto(0, 1);
		pointRightDown = new Punto(2, 0);
	}
	
	
	// costruttore con 3 parametri: punto UL, base e altezza del rettangolo
	public Rettangolo(Punto top, double base, double altezza) {
		this.pointLeftUp = top;
		pointRightDown = new Punto();
		double pointRightDownX = this.pointLeftUp.getX() + base;
		double pointRightDownY = this.pointLeftUp.getY() - altezza;
		this.pointRightDown.setXY(pointRightDownX, pointRightDownY);
	}

	public void setPointLeftUp(Punto t) {
		if (t.getX() < pointRightDown.getX() && t.getY() > pointRightDown.getY())
			pointLeftUp = t;
	}

	public void setPointRightDown(Punto b) {
		if (b.getX() > pointLeftUp.getX() && b.getY() < pointLeftUp.getY())
			pointRightDown = b;
	}
	
	public Punto getPointLeftUp() {
		return pointLeftUp;
	}

	public Punto getPointRightDown() {
		return pointRightDown;
	}

	/**
	 * UL(ulX, ulY)     UR(urX, urY)
	 * -----------------------------
	 * |                           |
	 * |                           |
	 * -----------------------------
	 * DL(dlX, dlY)     DR(drX, drY)
	 *
	 */

/*
	public String toString() {
		String s = "Rettangolo. UL = " + pointLeftUp.toString() + ". DR = " + pointRightDown.toString();
		return s;
	}
*/
	protected double calcolaBase() {
		Punto topB = new Punto(pointLeftUp.getX(), pointRightDown.getY());
		double base = pointRightDown.distanza(topB);
		//double base = pointRightDown.getX() - pointLeftUp.getX();
		return base;
	}

	protected double calcolaAltezza() {
		Punto topB = new Punto(pointLeftUp.getX(), pointRightDown.getY());
		double altezza = pointLeftUp.distanza(topB);
		//double altezza = pointLeftUp.getY() - pointRightDown.getY();
		return altezza;
	}

	public double area() {
		double a;
		a = calcolaBase() * calcolaAltezza();
		return a;
	}

	public double perimetro() {
		double p;
		p = (calcolaBase() + calcolaAltezza()) * 2;
		return p;
	}
}
