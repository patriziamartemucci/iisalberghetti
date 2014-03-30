import java.io.*;
class FrequenzaLettere{
	public static void main(String args[]){
		
		final String NOME_FILE_1="testo1.txt";
		final String NOME_FILE_2="testo2.txt";
    
    	
    	FileReader fr=null;
    	FileWriter fw=null;
    	BufferedReader br=null;
    	
		
		String frase="",fraseMaiuscolo;
		char vetLettere[]={'A','B','C','D','E','F','G','H','I','J','K','L','M',
			'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		
		int freqLettere[]=new int[26];
		int freqLettere2[]=new int[26];
	
		
		float freqLettereRel[]=new float[26];
		float freqLettere2Rel[]=new float[26];
		double distanza;

		int contaSpazi=0;
		
		String linea;
    	
    	
    	//apri il file in lettura (testo1)
    	try{
    		fr=new FileReader(NOME_FILE_1);
    		br=new BufferedReader(fr);
    	}
        catch(IOException e){
        	System.out.println("Errore nell'apertura del file "+NOME_FILE_1);
        	System.exit(1);
        }
        
        //leggi il testo dal file
        
        try{
        	int c;
        	do{
        		c=br.read();//leggi un carattere alla volta
        		if(c!=-1)
        			frase=frase+(char)c;//concatena alla stringa
        	}while(c!=-1);	
    	}
        catch(IOException e){
        	System.out.println("Errore nella lettura del file "+NOME_FILE_1);
        	System.exit(1);
        }
        //stampa il contenuto del file
        System.out.println("Testo\n"+frase);
        
        try{
        	//chiude il file
    		fr.close();
        }
        catch(IOException e){
        	System.out.println("Errore nella chiusura del file "+NOME_FILE_1);
        	System.exit(1);
        }
	
		
		
		fraseMaiuscolo=frase.toUpperCase();
		System.out.println("Frase in maiuscolo \n"+fraseMaiuscolo);
		
		for(int i=0;i<fraseMaiuscolo.length();i++){
			if(fraseMaiuscolo.charAt(i)==' ') contaSpazi++;
			else
			switch (fraseMaiuscolo.charAt(i)){
				case 'A':freqLettere[0]++; break;
				case 'B':freqLettere[1]++; break;
				case 'C':freqLettere[2]++; break;
				case 'D':freqLettere[3]++; break;
				case 'E':freqLettere[4]++; break;
				case 'F':freqLettere[5]++; break;
				case 'G':freqLettere[6]++; break;
				case 'H':freqLettere[7]++; break;
				case 'I':freqLettere[8]++; break;
				case 'J':freqLettere[9]++; break;
				case 'K':freqLettere[10]++; break;
				case 'L':freqLettere[11]++; break;
				case 'M':freqLettere[12]++; break;
				case 'N':freqLettere[13]++; break;
				case 'O':freqLettere[14]++; break;
				case 'P':freqLettere[15]++; break;
				case 'Q':freqLettere[16]++; break;
				case 'R':freqLettere[17]++; break;
				case 'S':freqLettere[18]++; break;
				case 'T':freqLettere[19]++; break;
				case 'U':freqLettere[20]++; break;
				case 'V':freqLettere[21]++; break;
				case 'W':freqLettere[22]++; break;
				case 'X':freqLettere[23]++; break;
				case 'Y':freqLettere[24]++; break;
				case 'Z':freqLettere[25]++; break;																																																											
			}
		}
		

		System.out.println("\n\n\nFrequenze relative delle lettere:");
		for(int i=0;i<26;i++){
			System.out.print(vetLettere[i]+" ");
			float x=freqLettere[i]/(float)(frase.length()-contaSpazi);
			x=x*100F;//percentuale
			//x=((int)(x*100))/100F;//approssima a due cifre decimali
			System.out.println(x+"\t");
			freqLettereRel[i]=x;
		}
		System.out.println();
		
		
		
		
		
		//secondo testo
			//apri il file in lettura (testo2)
    	try{
    		fr=new FileReader(NOME_FILE_2);
    		br=new BufferedReader(fr);
    	}
        catch(IOException e){
        	System.out.println("Errore nell'apertura del file "+NOME_FILE_2);
        	System.exit(1);
        }
        
        //leggi il testo dal file
        frase="";
        try{
        	int c;
        	do{
        		c=br.read();//leggi un carattere alla volta
        		if(c!=-1)
        			frase=frase+(char)c;//concatena alla stringa
        	}while(c!=-1);	
    	}
        catch(IOException e){
        	System.out.println("Errore nella lettura del file "+NOME_FILE_2);
        	System.exit(1);
        }
        //stampa il contenuto del file
        System.out.println("Testo\n"+frase);
        
        try{
        	//chiude il file
    		fr.close();
        }
        catch(IOException e){
        	System.out.println("Errore nella chiusura del file "+NOME_FILE_1);
        	System.exit(1);
        }
	
		
		contaSpazi=0;
		
		fraseMaiuscolo="";
		fraseMaiuscolo=frase.toUpperCase();
		System.out.println("Frase in maiuscolo \n"+fraseMaiuscolo);
		
		for(int i=0;i<fraseMaiuscolo.length();i++){
			if(fraseMaiuscolo.charAt(i)==' ') contaSpazi++;
			else
			switch (fraseMaiuscolo.charAt(i)){
				case 'A':freqLettere2[0]++; break;
				case 'B':freqLettere2[1]++; break;
				case 'C':freqLettere2[2]++; break;
				case 'D':freqLettere2[3]++; break;
				case 'E':freqLettere2[4]++; break;
				case 'F':freqLettere2[5]++; break;
				case 'G':freqLettere2[6]++; break;
				case 'H':freqLettere2[7]++; break;
				case 'I':freqLettere2[8]++; break;
				case 'J':freqLettere2[9]++; break;
				case 'K':freqLettere2[10]++; break;
				case 'L':freqLettere2[11]++; break;
				case 'M':freqLettere2[12]++; break;
				case 'N':freqLettere2[13]++; break;
				case 'O':freqLettere2[14]++; break;
				case 'P':freqLettere2[15]++; break;
				case 'Q':freqLettere2[16]++; break;
				case 'R':freqLettere2[17]++; break;
				case 'S':freqLettere2[18]++; break;
				case 'T':freqLettere2[19]++; break;
				case 'U':freqLettere2[20]++; break;
				case 'V':freqLettere2[21]++; break;
				case 'W':freqLettere2[22]++; break;
				case 'X':freqLettere2[23]++; break;
				case 'Y':freqLettere2[24]++; break;
				case 'Z':freqLettere2[25]++; break;																																																											
			}
		}
		

		System.out.println("\n\n\nFrequenze relative delle lettere:");
		for(int i=0;i<26;i++){
			System.out.print(vetLettere[i]+" ");
			float x=freqLettere2[i]/(float)(frase.length()-contaSpazi);
			//x=((int)(x*100))/100F;//approssima a due cifre decimali
			//percentuale
			x=x*100F;
			System.out.println(x+"\t");
			freqLettere2Rel[i]=x;
		}
		System.out.println();
		
		double s=0;
		for(int i=0;i<26;i++){
			s=s+(freqLettere2Rel[i]-freqLettereRel[i])*(freqLettere2Rel[i]-freqLettereRel[i]);
		}
		distanza=Math.sqrt(s);
		System.out.println("Distanza tra testo1.txt e testo2.txt --> "+distanza);
	}
}