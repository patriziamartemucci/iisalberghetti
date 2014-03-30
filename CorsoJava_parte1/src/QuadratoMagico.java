class QuadratoMagico{
	public static void main(String args[]){
		final int N=7;
		int mat[][]=new int[N][N];
		int i,j,k;
		int ii,jj;
		int iprec,jprec;
		
		mat[0][N/2]=1;
		k=2;
		i=0;
		j=N/2;
		while(k<=N*N){
			iprec=i;
			jprec=j;
			i--;j--;
			if (i<0) i=N-1;
			if(j<0) j=N-1;
			if(mat[i][j]==0){
				mat[i][j]=k;
			}
			else{
				mat[iprec+1][jprec]=k;
				i=iprec+1;
				j=jprec;
			}
			k++;
		}

		System.out.println("Quadrato magico "+N+"x"+N);
		for(ii=0;ii<N;ii++){
			for(jj=0;jj<N;jj++){
				System.out.print(mat[ii][jj]+"\t");
			}
			System.out.println();
		}
	}
}