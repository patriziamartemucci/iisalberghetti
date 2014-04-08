public class Data implements Comparable{
	private int gg;
	private int mm;
	private int aa;
	
	public Data(){}
	
	public Data(int g,int m,int a){
		this.gg=g;
		this.mm=m;
		this.aa=a;	
	}
	
	public void set_gg(int g){
		gg=g;
	}
	public void set_mm(int m){
		mm=m;
	}
	public void set_aa(int a){
		aa=a;
	}
	public void setData(int g,int m,int a){
		this.gg=g;
		this.mm=m;
		this.aa=a;	
	}
	
	public int get_gg(){
		return gg;
	}
	public int get_mm(){
		return mm;
	}
	public int get_aa(){
		return aa;
	}
	
	public String toString(){
		return "Data: "+gg+"/"+mm+"/"+aa;
	}
	
	public boolean equals(Object o){
		if(o instanceof Data){
			Data d=(Data)o;
			if( d.gg==gg && d.mm==mm && d.aa==aa) return true;
			else return false;
		}
		else return false;
	}
	
	public void successivo(){
		boolean bisestile=(aa%4==0 && aa%100!=0)|(aa%400==0);
		if(mm==12 && gg==31) {//ultimo dell'anno
			gg=1;mm=1;aa++;
		}
		else
		if((mm==4 || mm==6 || mm==9 || mm==11) && gg==30){//ultimo di un mese di 30 gg
			mm++;gg=1;
		}
		else if(mm==2 && bisestile && gg==29){//ultimo di febbraio di un anno bisestile
			mm++;gg=1;
		}
		else if(mm==2 && !bisestile && gg==28){//ultimo di febbraio di un anno non bisestile
			mm++;gg=1;
		}
		else if(gg==31){//ultimo di un mese di 31 giorni
			mm++;gg=1;
		}
		else {//in tutti gli altri casi
			gg++;
		}
	}
	
	public void precedente(){
		boolean bisestile=(aa%4==0 && aa%100!=0)|(aa%400==0);
		if(mm==1 && gg==1) {//primo dell'anno
			gg=31;mm=12;aa--;
		}
		else
		if((mm==5 || mm==7 || mm==10 || mm==12) && gg==1){//primo di un mese che ne precede  uno di 30 gg
			mm--;gg=30;
		}
		else if(mm==3 && bisestile && gg==1){//primo di marzo di un anno bisestile
			mm--;gg=29;
		}
		else if(mm==3 && !bisestile && gg==1){//primo di marzo di un anno non bisestile
			mm--;gg=28;
		}
		else if(gg==1){//ultimo di un mese di 31 giorni
			mm--;gg=31;
		}
		else {//in tutti gli altri casi
			gg--;
		}
	}
	
	public int giorniTrascorsi(Data d2){
		Data d1=new Data(this.gg,this.mm,this.aa);
		Data datamaggiore=null;
		Data dataminore=null;
		
		int gt=0;
		int res=d1.compareTo(d2);
		if(res==1){
			datamaggiore=new Data(d1.gg,d1.mm,d1.aa);
			dataminore=new Data(d2.gg,d2.mm,d2.aa);
		}
		else if(res==-1){
			datamaggiore=new Data(d2.gg,d2.mm,d2.aa);
			dataminore=new Data(d1.gg,d1.mm,d1.aa);
		}
		else return gt; //le date sono uguali
		while(!datamaggiore.equals(dataminore)){
			gt++;
			datamaggiore.precedente();
		}
		return gt;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int res=0;
		Data d2=(Data)o;
		if(aa==d2.aa && mm==d2.mm && gg==d2.gg)return res;
		if(aa>d2.aa){
			//d1>d2
			res=1;
		}
		else if(aa<d2.aa){
			//d1 < d2
			res=-1;
		}
		else{
			if(mm>d2.mm){
				//d1>d2
				res=1;
			}
			else if(mm<d2.mm){
				//d1<d2
				res=-1;
			}
			else{
				if(gg>d2.gg){
					//d1>d2
					res=1;
				}
				else if(gg<d2.gg){
					//d1<d2
					res=-1;
				}
				//else d1=d2 --> res=0
			}
		}
		return res;
	}
}
