class FrequenzaVocali{
	public static void main(String args[]){
		
		
		
		String frase="Oggi e' una bella giornata",fraseMaiuscolo;
		char vetVocali[]={'A','E','I','O','U'};
		
		
		int freqVocali[]=new int[5];

		float freqVocaliRel[]=new float[5];
	
		int contaNonCaratteri=0;
		char c;
	
    	
    
        System.out.println("Testo\n"+frase);
        
      
		
		fraseMaiuscolo=frase.toUpperCase();
		System.out.println("Frase in maiuscolo \n"+fraseMaiuscolo);
		
		for(int i=0;i<fraseMaiuscolo.length();i++){
			c=fraseMaiuscolo.charAt(i);
			switch (c){
				case 'A':freqVocali[0]++; break;
				case 'E':freqVocali[1]++; break;
				case 'I':freqVocali[2]++; break;
				case 'O':freqVocali[3]++; break;
				case 'U':freqVocali[4]++; break;
				default: 
					if(c>='A' && c<='Z')contaNonCaratteri++;																																																											
			}
		}
		

		System.out.println("\n\n\nFrequenze relative delle vocali:");
		for(int i=0;i<5;i++){
			System.out.print(vetVocali[i]+" ");
			float x=freqVocali[i]/(float)(frase.length()-contaNonCaratteri);
			x=x*100F;//percentuale
			x=((int)(x*100))/100F;//approssima a due cifre decimali
			System.out.println(x+"\t");
			freqVocaliRel[i]=x;
		}
		System.out.println();	
	
	}
}