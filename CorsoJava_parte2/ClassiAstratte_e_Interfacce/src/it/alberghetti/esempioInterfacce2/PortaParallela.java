package it.alberghetti.esempioInterfacce2;
public class PortaParallela implements Porta{

	public boolean apri() {
		System.out.println("Sono nel metodo apri() di PortaParallela");
		return true;
	}

	public boolean chiudi() {
		System.out.println("Sono nel metodo chiudi() di PortaParallela");
		return true;
	}

	public byte[] leggi() {
		System.out.println("Sono nel metodo leggi() di PortaParallela");
		byte input[]={1,2,1,1};
		return input;
	}

	public void scrivi(byte[] b) {
		System.out.println("Sono nel metodo scrivi() di PortaParallela." +
				"\nDati da inviare:");
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+"\t");
		}
		System.out.println("\nDati inviati!");
	}
}
