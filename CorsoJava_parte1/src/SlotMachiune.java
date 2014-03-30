import java.io.*;
public class SlotMachiune {
	public static void main(String args[]) throws NumberFormatException, IOException{
		int x,y,z,i;
		float montepremi=110.56F;
		float puntata;
		float vincitamax;
		float vincitaMaxGestore;
		float vincitaMin;
		float vincitaMinGestore;
		float guadagnoGestore=0;
		
		BufferedReader br=new 
				BufferedReader(new InputStreamReader(System.in));
		
		do{
			System.out.print("\n\nMontepremi iniziale: ");
			System.out.printf("%.2f\n",montepremi);
			System.out.println("Inserisci la puntata (0 per spegnere la slot-machine, massimo valore accettato 10): ");
			do{
				puntata=Float.parseFloat(br.readLine());
				if(puntata<0||puntata>10){
					System.out.println("Valore non valido. Inserisci un numero compreso tra 0 e 10.");
				}
			}while(puntata<0 || puntata>10);
			if(puntata!=0){
				
				for(i=1;i<=puntata;i++){
					x=(int)(Math.random()*10);
					y=(int)(Math.random()*10);
					z=(int)(Math.random()*10);
					
					
					montepremi=montepremi+1;
					vincitamax=montepremi*0.8F;
					vincitaMaxGestore=montepremi*0.2F;
					vincitaMin=montepremi*0.1F;
					vincitaMinGestore=montepremi*0.02F;
					
					System.out.println(x +" "+y+" "+z);
				
					if(x==y && y==z){
						System.out.print("hai vinto ");
						System.out.printf("%.2f € !!!\n",vincitamax);
						System.out.print("Al gestore ");
						System.out.printf("%.2f €\n",vincitaMaxGestore);
						guadagnoGestore=guadagnoGestore+vincitaMaxGestore;
						montepremi=montepremi-vincitamax-vincitaMaxGestore;
					}
					else{
						if(x==y || x==z || y==z){
							System.out.print("hai vinto ");
							System.out.printf("%.2f € !!!\n",vincitaMin);
							System.out.print("Al gestore ");
							System.out.printf("%.2f €\n",vincitaMinGestore);
							guadagnoGestore=guadagnoGestore+vincitaMinGestore;
							montepremi=montepremi-vincitaMin-vincitaMinGestore;
						}
						else{
						System.out.println("Non hai vinto :( Ritenta!");
						}
					}
				}
			}
		}while(puntata!=0);
		System.out.print("\n\nGuadagno giornaliero del gestore: ");
		System.out.printf("%.2f €\n",guadagnoGestore);
	}
}
