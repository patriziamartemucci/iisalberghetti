
public class Automobile {
	public static final int LIMITE=130;
	
	private int velocita;
	private boolean accesa;
	private int direzione;
	
	
	public Automobile(){}
	
	public Automobile( int d){
		velocita=0;
		accesa=false;
		direzione=d;
	}
	
	public int getVelocita(){
		return velocita;
	}
	
	public boolean getAccesa(){
		return accesa;
	}
	public int getDirezione(){
		return direzione;
	}
	
	public String toString(){
		return "Automobile [velocita: "+velocita+", accesa: "+accesa+", direzione: "+direzione+"]";
	}
	public void accendi(){
		if(!accesa){
			accesa=true;
		}
	}
	
	public void gira(int gradi){
		direzione=direzione+gradi;
	}
	public void spegni(){
		if(accesa){
			accesa=false;
			velocita=0;
		}
	}
	
	public void accelera(int v){
		if(accesa && v>0){
			if((velocita+v)<=LIMITE)
				velocita=velocita+v;
			else velocita=LIMITE;
		}
		if(accesa && v<=0){
			if((velocita+v)>=0)
				velocita=velocita+v;
			else{
				velocita=0;
			}
		}
	}
}
