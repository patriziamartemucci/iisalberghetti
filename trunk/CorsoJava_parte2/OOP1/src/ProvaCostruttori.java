
public class ProvaCostruttori {
	float x;
	float y;
	
	//overloading del costruttore
	public ProvaCostruttori(int x,int y){
		System.out.println("Costruttore (int,int)");
		this.x=x;
		this.y=y;
	}
	
	public ProvaCostruttori(float x,int y){
		System.out.println("Costruttore (float,int)");
		this.x=x;
		this.y=y;
	}
	
	public ProvaCostruttori(int x,float y){
		System.out.println("Costruttore (int,float)");
		this.x=x;
		this.y=y;
	}
	
	public ProvaCostruttori(float x,float y){
		System.out.println("Costruttore (float,float)");
		this.x=x;
		this.y=y;
	}
	
	public String toString(){
		return "\nStato dell'oggetto:\nx: "+x+"\ny: "+y;
	}
	
	//overloading
	public void scala(int x){
		this.x=this.x+x;
		this.y=this.y+x;
	}
	
	public boolean scala(int x,int y){
		this.x=this.x+x;
		this.y=this.y+y;
		if(x>0) return true;
		else return false;
	}
}
