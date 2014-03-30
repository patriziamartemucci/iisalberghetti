//Esempio di parametri al main: quando avvio il programma posso inserire dei parametri
//java ProvaParametri parametro1 parametro2
//il seguente esempio stampa la lista dei parametri passati al main
public class ProvaParametri{
	public static void main(String args[]){
		System.out.println("n. parametri: "+args.length);
		for(int i=0;i<args.length;i++){
			System.out.println("args["+i+"]: "+args[i]);
		}
	}
}