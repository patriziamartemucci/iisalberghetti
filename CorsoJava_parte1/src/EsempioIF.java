
public class EsempioIF {
	public static void main(String args[]){
		int x;
		x=(int)(Math.random()*10);
		System.out.println("x vale "+x);
		if(x % 2==0){
			System.out.println(" e' pari");
		}
		else{
			System.out.println(" e' dispari");
		}
		
		int anno=2400;
		if(anno%4==0 && anno%100!=0 || anno%400==0){
			System.out.println("anno "+anno+" bisestile");
		}
		else{
			System.out.println("anno "+anno+" non bisestile");
		}
	}
}
