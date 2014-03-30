import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ScriviFileBase64 {

	public static void main(String args[]) throws Exception{
		/*
		 *
		 //decodifica un file di testo
		GestioneFile fr=new GestioneFile("allegato.txt");
		GestioneFile fw=new GestioneFile("allegato2.txt");
		decodificaFileTesto(fr,fw);
		*/
	
		 //decodifica un file binario
		/*
		GestioneFile fr=new GestioneFile("allegato.txt");
		File fout=new File("allegato2.gif");
		decodificaFileBinario(fr,fout);
		
		*/
		
		//codifica un file di testo
		/*
		GestioneFile fr=new GestioneFile("allegato2.txt");
		GestioneFile fw=new GestioneFile("allegato1.txt");
		codificaFileTesto(fr,fw);
		*/
		
		File fin=new File("allegato2.gif");
		File fout=new File("allegato3Stream.gif");
		FileInputStream fis=new FileInputStream(fin);
		FileOutputStream fouts=new FileOutputStream(fout);
		
		//codifica un file di binario
		/*
				
		int lenFile=(int) fin.length();
		GestioneFile fw=new GestioneFile("allegato3.txt");
		codificaFileBinario(fis,fw,lenFile);
		*/
		leggiScriviFileBinario(fis,fouts);
		System.out.println("Finito!");
	}
	
	public static void decodificaFileBinario(GestioneFile fr,File pOut) throws IOException {
	 	if (!pOut.exists()) {
	 		pOut.createNewFile();
	 	}
	 	FileOutputStream fos = new FileOutputStream(pOut);
	 	String letto=fr.leggiFile();
		byte[] decodificato=new BASE64Decoder().decodeBuffer(letto);
		fos.write(decodificato, 0, decodificato.length);
		fos.close();
    }
	
	public static void decodificaFileTesto(GestioneFile fr,GestioneFile fw) throws IOException {
		
		String letto=fr.leggiFile();
		byte[] decodificato=new BASE64Decoder().decodeBuffer(letto);
		String scritto=new String(decodificato,"UTF8");
		System.out.println(scritto);
		fw.salvaFile(scritto,false);
    }
	
	public static void codificaFileTesto(GestioneFile fr, GestioneFile fw) throws UnsupportedEncodingException{
		String letto=fr.leggiFile();
		String codificato=new BASE64Encoder().encode(letto.getBytes("UTF8"));
		System.out.println(codificato);
		fw.salvaFile(codificato,false);
	}
	
	public static void codificaFileBinario(InputStream pIn, GestioneFile fw,int lenFile) throws IOException{
		DataInputStream dis = new DataInputStream(pIn);
        byte []bytes = new byte[lenFile];
      
        dis.read(bytes);
        String codificato=new BASE64Encoder().encode(bytes);
    	//System.out.println(codificato);
        fw.salvaFile(codificato, true);
       
        dis.close();
	}
	public static void leggiScriviFileBinario(InputStream pIn, OutputStream out) throws IOException{
		DataInputStream dis = new DataInputStream(pIn);
		DataOutputStream dout=new DataOutputStream(out);
        byte []bytes = new byte[1024];
        int ret;
       do{ 
    	   ret=dis.read(bytes);
    	   //for(int i=0;i<bytes.length;i++) System.out.print(bytes[i]+" ");
    	   //System.out.println();
    	   System.out.println("ret vale "+ret);
    	   if(ret!=-1)
    		   dout.write(bytes,0,ret);
       }while(ret!=-1);
    	
       
        dis.close();
	}
}
