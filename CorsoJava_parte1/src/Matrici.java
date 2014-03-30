
public class Matrici {

	public static void main(String[] args) {
		int mat[][]=new int[3][4];//matricie di 3 righ e 4 colonne
		
		int mat2[][]=new int[3][];
		for(int i=0;i<mat2.length;i++){
			mat2[i]=new int[(int)(Math.random()*3+1)];
			System.out.println("dimensione riga "+i+": "+mat2[i].length);
		}
	
		//riempi la mat con valori casuali
		System.out.println("\n\n\nMatrice 1");
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				mat[i][j]=(int)(Math.random()*10);
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		


	}

}
