import java.io.*;


public class Giorni {
	public static void main(String args[]) throws Exception{

		BufferedReader br=new 
			BufferedReader(new InputStreamReader(System.in));
		
		int mm,aa,gg;
	//controllo sull'input del mese: 
	//se il mese è minore di 1 o maggiore di 12 (input non valido)
	//l'input viene ripetuto
	do{
		System.out.println("Inserisci  mm ");
		mm=Integer.parseInt(br.readLine());
	}while(mm<1 || mm>12);
	
	
		System.out.println("Inserisci gg ");
		gg=Integer.parseInt(br.readLine());


		System.out.println("Inserisci aa ");
		aa=Integer.parseInt(br.readLine());
	
		int ng=0;
		//switch con break
		switch(mm){
		case 1: ng=ng+gg; break;
		case 2: ng=31+gg; break;
		case 3: ng=31+28+gg; break;
		case 4: ng=31+28+31+gg; break;
		case 5: ng=31+28+31+30+gg; break;
		case 6: ng=31+28+31+30+31+gg; break;
		case 7: ng=31+28+31+30+31+30+gg; break;
		case 8: ng=31+28+31+30+31+30+31+gg;  break;
		case 9: ng=31+28+31+30+31+30+31+31+gg; break;
		case 10: ng=31+28+31+30+31+30+31+31+30+gg; break;
		case 11: ng=31+28+31+30+31+30+31+31+30+31+gg;;break;
		case 12:  ng=31+28+31+30+31+30+31+31+30+31+30+gg; break;
		}
		
		if(mm>2 &&(aa%4==0 && aa%100!=0 || aa%400==0)){
			ng++;
		}
		System.out.println("Giorni: "+ng);
		//switch senza break
		ng=0;
		switch(mm){
		case 12:ng=ng+30;
		case 11:ng=ng+31;
		case 10:ng=ng+30;
		case 9:ng=ng+31;
		case 8:ng=ng+31;
		case 7:ng=ng+30;
		case 6:ng=ng+31;
		case 5:ng=ng+30;
		case 4:ng=ng+31;
		case 3:ng=ng+28;
		case 2:ng=ng+31;
		case 1:ng=ng+gg;
		}
		if(mm>2 &&(aa%4==0 && aa%100!=0 || aa%400==0)){
			ng++;
		}
		System.out.println("Giorni: "+ng);
	
	}
}
