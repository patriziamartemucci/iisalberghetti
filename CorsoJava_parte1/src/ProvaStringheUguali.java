
public class ProvaStringheUguali {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="ciao";
		String s2="ciao";
		String s3=new String(s1);
		
		System.out.println("s1: "+s1+"\ns2: "+s2.toString()+"\ns3: "+s3.toString());
		Object o=new Object();
		o=s3;
		System.out.println(
				"\nriferimento s3: "+o.getClass());
		if(s1==s2)
			System.out.println("s1 e s2 sono uguali");
		else
			System.out.println("s1 e s2 sono diverse");
		if(s1==s3)
			System.out.println("s1 e s3 sono uguali");
		else
			System.out.println("s1 e s3 sono diverse");
	}

}
