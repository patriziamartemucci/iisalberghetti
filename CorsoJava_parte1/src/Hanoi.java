
public class Hanoi {
	public static void spostaDisco(int n, char da, char a){
		System.out.println("Sposta il disco "+n+" da "+da+" a "+a);
	}
	
	public static void torre(int n,char da,char a,char attraverso){
			if(n>0){
				torre(n-1,da,attraverso,a);
				spostaDisco(n,da,a);
				torre(n-1,attraverso,a,da);		
			}
		
	}
	
	public static void main(String[] args) {
		int n=3;
		System.out.println("Sposta "+n+" dischi dalla torre A alla torre B attraverso la torre C.\n" +
				"I dischi sono numerati da 1 a "+n+" (dal più piccolo al più grande).\n");
		torre(n,'A','C','B');
	}
}
