package it.alberghetti.esempioInterfacce2;
public class PortaSeriale implements Porta{
	public boolean apri() {
		System.out.println("Sono nel metodo apri() di PortaSeriale");
		return true;
	}

	public boolean chiudi() {
		System.out.println("Sono nel metodo chiudi() di PortaSeriale");
		return true;
	}

	public byte[] leggi() {
		System.out.println("Sono nel metodo leggi() di PortaSeriale");
		byte input[]={0,1,0,1,1,1,1,1};
		return input;
	}

	public void scrivi(byte[] b) {
		System.out.println("Sono nel metodo scrivi() di PortaSeriale." +
				"\nDati da inviare:\n");
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+"\t");
		}
		System.out.println("\nDati inviati!");
	}
}
