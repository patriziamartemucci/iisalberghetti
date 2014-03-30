import java.util.*;
public class Vettori {

	

	public static void main(String[] args) {
		int i;
		int vet[];
		vet=new int[10];
		for(i=0;i<10;i++){
			vet[i]=(int)(Math.random()*100);
			System.out.print(vet[i]+" ");
		}
		System.out.println();
		
		System.out.println("Dimensione del vettore1: "+vet.length);
		int vet2[]=vet;
		int vet3[]=(int[])vet.clone();
		System.out.println("Vettore 2");
		for(i=0;i<10;i++){
			System.out.print(vet2[i]+" ");
		}
		System.out.println();
		System.out.println("Vettore 3");
		for(i=0;i<vet3.length;i++){
			System.out.print(vet3[i]+" ");
		}
		System.out.println();
		vet[2]=-15;
		System.out.println("vet[2]: "+vet[2]+
				"    vet2[2]: "+vet2[2]+"   vet3[2]: "+vet3[2]);
		Vector<String> v = new Vector<String>(3);
		v.add("ciao");
		v.add("IMOLUG");
		v.add("di Imola e");
		v.add("Faenza");
		v.add(2,"Linux Users Group");//inserisce l'elemento in posizione 2
		//v.add("Linux Users Group");
		System.out.println("\n\nClasse Vector <String>: ");
		for(i=0;i<v.size();i++){
			System.out.println(v.elementAt(i));
		}
		Vector vec = new Vector();
		vec.add(10);
		vec.add(36);
		vec.add(70);
		//vec.add("ciao");
		vec.set(1,-24);//per settare il valore -24 in posizione 1
		vec.remove(0);//per rimuovere l'elemento in posizione 0
		System.out.println("\n\nClasse Vector : ");
		for(i=0;i<vec.size();i++){
			int x=(int)vec.get(i);//cast esplicito a int, perchè get restituisce un Object
			System.out.println(vec.elementAt(i));
			vec.get(i);
			//System.out.println(vec.get(i));
		}
		
		
		int vet4[]={1,2,3,4,5};
		int vet5[]=new int[10];
		System.out.println("\n\nVettore con numeri ordinati (da 1 a 10)");
		for(i=0;i<10;i++){
			vet5[i]=i+1;
			System.out.print(vet5[i]+" ");
		}
		
		//Disordina il vettore 5
	}

}
