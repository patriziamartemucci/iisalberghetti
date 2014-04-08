
public class Frazione {
	private int num;
	private int den;
	
	public Frazione(){}//costruttore di default
	
	public Frazione(int n, int d){
		num=n;
		den=d;
	}
	
	public void setNum(int n){
		num=n;
	}
	public void setDen(int d){
		den=d;
	}
	public void setNumDen(int n, int d){
		num=n;
		den=d;
	}
	public int getNum(){
		return num;
	}
	public int getDen(){
		return den;
	}
	public String toString(){
		String s="";
		if(num<0 && den<0)
			s=(-num)+"/"+(-den);
		else if(num>0 && den<0)
				s="-"+num+"/"+(-den);
		else s=num+"/"+den;
		return s;
		
	}
	public boolean equals(Object o){
		if(o instanceof Frazione){
			Frazione f=(Frazione)o;
			if(f.num==this.num && f.den==this.den) return true;
			else return false;
		}
		else return false;
	}
	//calcolo MCD
	private int MCD(int a,int b){
		if(b==0)return a;
		else return MCD(b,a%b);
	}
	
	//calcolo mcm
	private int mcm(int a, int b){
		int sa =a,sb = b;
		while(sa!=sb){
			if(sa<sb) sa=sa+a;
			else sb=sb+b;
		}
		
		return sa;
	}
	
	public void semplifica(){
		int a,b;
		if(num<0)a=-num; else a=num;
		if(den<0) b=-den; else b=-den;
		int mcd=MCD(a,b);
		num=num/mcd;
		den=den/mcd;
	}
	
	public Frazione reciproca(){
		Frazione f=new Frazione();
		f.num=den;
		f.den=num;
		return f;
	}
	
	public Frazione opposta(){
		Frazione f=new Frazione(-1,1);
		f=f.prodotto(this);
		return f;
	}
	public Frazione prodotto(Frazione fb){
		Frazione fa=new Frazione();
		fa.num=this.num*fb.num;
		fa.den=this.den*fb.den;
		fa.semplifica();
		return fa;
	}
	public Frazione somma(Frazione fa){
		Frazione fb=new Frazione();
		int a,b;
		if(den<0) a=-den; else a=den;
		if(fa.den<0) b=-fa.den; else b=fa.den;
		int minimoComuneMultiplo=mcm(a,b);
		fb.num=minimoComuneMultiplo/den*num+minimoComuneMultiplo/fa.den*fa.num;
		fb.den=minimoComuneMultiplo;
		fb.semplifica();
		return fb;
	}
	
	
	
}
