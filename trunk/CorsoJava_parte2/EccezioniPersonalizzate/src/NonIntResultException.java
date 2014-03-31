
public class NonIntResultException extends Exception{
	int n;
	int d;

	  public NonIntResultException(int i, int j) {
	    n = i;
	    d = j;
	  }

	  public String toString() {
	    return "NonIntResultException: Il risultato di " + n + " / " + d +
	           " non è intero.";
	  }
	

}
