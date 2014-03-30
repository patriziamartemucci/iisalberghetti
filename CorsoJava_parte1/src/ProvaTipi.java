
public class ProvaTipi {
	public static final void main(String[] args){
		int x,y,z;
		x=7; y=3;
		z=x++ + y;
		System.out.println("\n\nz vale "+z+"\nx vale "+x+"\ny vale "+y);
		z=x + --y;
		System.out.println("\n\nz vale "+z+"\nx vale "+x+"\ny vale "+y);
		z = x--*(2+y);
		System.out.println("\n\nz vale "+z+"\nx vale "+x+"\ny vale "+y);
		
		z=x*y/4*(x/y)+x*(y%4*x);
		System.out.println("\n\nz vale "+z+"\nx vale "+x+"\ny vale "+y);
		byte a=4,b=5;
		int c;
		c=a%--b;
		System.out.println("\n\na vale "+a+"\nb vale "+b+"\nc vale "+c);
		
		
		//operatori bit a bit
		int xb=Integer.MAX_VALUE;
		System.out.print(xb+" in binario: ");
		int bit=1;
		String s="";
		for(int i=0;i<32;i++){
			int p=xb & bit;
			//System.out.print(p);
			xb=(xb>>1);
			s=p+s;
		}
		System.out.println(s);
		
		xb=Integer.MAX_VALUE;
		byte yb=(byte)(~xb);
		byte ris=(byte)(xb | yb);
		
		int riss=(xb<<2);
		System.out.print(xb+" << 2 vale "+riss+ " che in bianrio fa ");
		bit=1;
		s="";
		for(int i=0;i<32;i++){
			int p=riss & bit;
			//System.out.print(p);
			riss=riss>>1;
			s=p+s;
		}
		System.out.println(s);
		
		xb=-8;
		System.out.print(xb+" in binario: ");
		bit=1;
		s="";
		for(int i=0;i<32;i++){
			int p=xb & bit;
			//System.out.print(p);
			xb=(xb>>1);
			s=p+s;
		}
		System.out.println(s);
		xb=-8;
		riss=(xb>>2);
		System.out.print(xb+" >> 2 vale "+riss+ " che in binario fa ");
		bit=1;
		s="";
		for(int i=0;i<32;i++){
			int p=riss & bit;
			//System.out.print(p);
			riss=riss>>1;
			s=p+s;
		}
		System.out.println(s);
		xb=8;
		System.out.print(xb+" in binario: ");
		bit=1;
		s="";
		for(int i=0;i<32;i++){
			int p=xb & bit;
			//System.out.print(p);
			xb=(xb>>1);
			s=p+s;
		}
		System.out.println(s);
		
		
		xb=8;
		riss=(xb>>2);
		System.out.print(xb+" >> 2 vale "+riss+ " che in binario fa ");
		bit=1;
		s="";
		for(int i=0;i<32;i++){
			int p=riss & bit;
			//System.out.print(p);
			riss=riss>>1;
			s=p+s;
		}
		System.out.println(s);
		
		
		xb=-8;
		riss=(xb>>>2);
		System.out.print(xb+" >>> 2 vale "+riss+ " che in binario fa ");
		bit=1;
		s="";
		for(int i=0;i<32;i++){
			int p=riss & bit;
			//System.out.print(p);
			riss=riss>>1;
			s=p+s;
		}
		System.out.println(s);
	
		xb=8;
		riss=(xb>>>2);
		System.out.print(xb+" >>> 2 vale "+riss+ " che in binario fa ");
		bit=1;
		s="";
		for(int i=0;i<32;i++){
			int p=riss & bit;
			//System.out.print(p);
			riss=riss>>1;
			s=p+s;
		}
		System.out.println(s);
	/*
	 * 

	--------------------------------------------------------------------------------
	
	2147483647 (MAX_VALUE int) in binario:		01111111111111111111111111111111
	
	--------------------------------------------------------------------------------
	
	2147483647 << 2 vale -4 che in bianrio fa 	11111111111111111111111111111100	
	
	--------------------------------------------------------------------------------
	
	-8 in binario:					11111111111111111111111111111000
	
	--------------------------------------------------------------------------------
	
	-8 >> 2 vale -2 che in binario fa		11111111111111111111111111111110
	
	--------------------------------------------------------------------------------
	
	8 in binario: 					00000000000000000000000000001000
	
	--------------------------------------------------------------------------------
	
	8 >> 2 vale 2 che in binario fa 		00000000000000000000000000000010
	
	--------------------------------------------------------------------------------
	
	-8 >>> 2 vale 1073741822 che in binario fa 	00111111111111111111111111111110
	
	--------------------------------------------------------------------------------
	
	8 >>> 2 vale 2 che in binario fa 		00000000000000000000000000000010
	
	--------------------------------------------------------------------------------	

 */
	}

}
