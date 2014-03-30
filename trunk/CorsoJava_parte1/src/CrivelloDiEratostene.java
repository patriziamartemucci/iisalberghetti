
public class CrivelloDiEratostene {

	public static void main(String[] args) {
		int n;
		n=1000;
		int vet[]=new int[n];
		int i,j;
		for(i=0;i<vet.length;i++){
			vet[i]=i;
		}
		vet[0]=0;
		vet[1]=0;
		
		for(i=2;i<(int)(Math.sqrt(n));i++){
			if(vet[i]!=0){
				for(j=i+i;j<vet.length;j=j+i){
					vet[j]=0;
				}
			}
		}
		System.out.println("Numeri primi da 2 a "+n);
		for(i=0;i<vet.length;i++){
			if(vet[i]!=0)
				System.out.print(vet[i]+" ");
		}

	}

}
