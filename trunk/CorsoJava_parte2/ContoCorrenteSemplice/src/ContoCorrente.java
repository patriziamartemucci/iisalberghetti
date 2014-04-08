
public class ContoCorrente {
	private static int numeroConti;
	
	private int numero;
	private int valore;
	
	static{
		numeroConti=0;
	}
	
	public ContoCorrente(){
		this(0);
	}
	
	public ContoCorrente(int val){
		numeroConti++;
		numero=numeroConti;
		versa(val);
	}
	
	public void versa(int v){
		valore=valore+v;
	}
	
	public int preleva(int p){
		if((valore-p)>=0){
			valore=valore-p;
			return p;
		}
		else return 0;
	}
	
	public int saldo(){
		return valore;
	}
	
	public int getNumConto(){
		return numero;
	}
	
	public String toString(){
		return "[ContoCorrente N. "+numero+"    -   Saldo: "+valore+"]";
	}
}
