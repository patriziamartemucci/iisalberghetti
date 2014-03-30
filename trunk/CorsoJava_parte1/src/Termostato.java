//simulazione di un termostato
import java.io.*;
public class Termostato {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new 
		BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Imposta temperatura termostato: ");
		double temp=Double.parseDouble(br.readLine());
		
		double t=20;//temperatura iniziali: temp. ambiente
	while(true){	//ciclo infinito
	//la temperatura cresce finchè non raggiunge la temperatura 
	// temp+4
		while(t<(temp+4)){
			t=t+1;//aumenta di un grado al secondo
			Thread.sleep(1000);//ritarda di 1 secondo
			System.out.println(t+" cresce");
		}
		//ora la temperatura scende fino a temp-4
		while(t>(temp-4)){
			t=t-2;//decresce di 2 gradi ogni secondo
			Thread.sleep(1000);//ritarda di 1 secondo
			System.out.println(t+" decresce");
		}
	}
	}
}
