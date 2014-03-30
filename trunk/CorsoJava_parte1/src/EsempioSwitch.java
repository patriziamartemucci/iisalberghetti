
public class EsempioSwitch {
	public static void main(String args[]){
		char op='-';
		int op1=1,op2=10,ris = 0;
		switch(op){
		case '+':ris=op1+op2;
			//break;
		case '-':ris=op1-op2;
			//break;
		case '/':ris=op1/op2;
			//break;
		case '*':ris=op1*op2;
			//break;
		default:System.out.println("op non corrisponde a nessun operatore");
		}
		System.out.println("ris vale "+ris);
	}
}
