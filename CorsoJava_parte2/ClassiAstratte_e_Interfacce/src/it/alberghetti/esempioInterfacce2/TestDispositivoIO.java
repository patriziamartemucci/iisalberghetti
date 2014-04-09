package it.alberghetti.esempioInterfacce2;
public class TestDispositivoIO {
	public static void main(String args[]){
		PortaParallela pp=new PortaParallela();
		PortaSeriale ps=new PortaSeriale();	
		Porta p2=pp;
		//Porta p3=new Porta();
		DispositivoIO dp=new DispositivoIO(p2);
		DispositivoIO ds=new DispositivoIO(ps);
		//Dispositivo d=new Dispositivo();
		
		byte b[]={1,2,3,4,5,6,7,8};
		dp.inizializza();
		dp.inviaDati(b);
		byte bp[]=dp.leggiDati();
		System.out.println("Dati letti:");
		for(int i=0;i<bp.length;i++){
			System.out.print(bp[i]+"\t");
		}
		System.out.println();
		dp.finalizza();
		
		byte bs[];
		ds.inizializza();
		bs=ds.leggiDati();
		System.out.println("Dati letti:");
		for(int i=0;i<bs.length;i++){
			System.out.print(bs[i]+"\t");
		}
		System.out.println();
		ds.finalizza();
		
	}
}
