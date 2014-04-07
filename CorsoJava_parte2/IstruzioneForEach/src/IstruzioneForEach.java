import java.util.ArrayList;


public class IstruzioneForEach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//L'istruzione for-each serve per scandire array od oggetti che implementano l'interfaccia Iterable
		int arr[]={1,2,3};
		System.out.println("\nArray originale:");
		for(int el:arr){
			System.out.print(el+" ");
		}
		//l'aggiornamenot degli elementi dell'array non è possibile con l'istruzione for-each
		for(int el:arr){
			el=el*2;
		}
		System.out.println("\n\nArray dopo il for-each (che non aggiorna nulla):");
		for(int el:arr){
			System.out.print(el+" ");
		}
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("Pippo");
		list.add("Paperino");
		list.add("Pluto");
		System.out.println("\n\nArrayList scandito");
		for(String el:list){
			System.out.println(el);
		}
	}

}
