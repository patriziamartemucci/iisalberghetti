import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;


public class EsempioStringhe {

	public static void main(String[] args) throws UnsupportedEncodingException {
			String s="patrizia";
			String s2=new String("patrizia");
			String s3="patrizia";
			
			String s4=s;
			if(s!=s3){
				System.out.println("s diverso da s3");
			}
			else{
				System.out.println("s diverso da s3");
			}
			
			if(s.equals(s2)){
				System.out.println("le stringhe sono uguali");
			}
			int len=s3.length();
			for(int i=0;i<s3.length();i++){
				char c=s3.charAt(i);
				System.out.println("c vale "+c);
				
			}
			s3=s3.concat(" martemucci"); // equivale a +
			if(s3.startsWith("p")) {
				System.out.println("Vero. Inizia con p");
			}
			else System.out.println("Falso. Non inizia con p");
			
			int pos=s3.indexOf('a');
			System.out.println("a è in posizione "+pos);
			pos=s3.indexOf("tri");
			System.out.println("tri è in posizione "+pos);
			pos=s3.indexOf("tri",5);
			System.out.println("tri a partire dalla posizione 5 è in posizione "+pos);
			
			byte b[]= s3.getBytes("UTF8");
			String s5=new String(b);
			System.out.println("s5 vale "+s5);
			
			
			
			
			String frase="Oggi c'� il sole, domani chiss�!Forse...";
			StringTokenizer st=new StringTokenizer(frase," ,;!");
			while(st.hasMoreElements()){
				String sottos=st.nextToken();
				System.out.println(sottos);
			}
			
			
	}

}
