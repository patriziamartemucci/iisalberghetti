
class CustomExceptDemo {
  public static void main(String args[]) {

    // Qui, numer contiene dei valori strani.
    int numer[] = { 4, 8, 15, 32, 64, 127, 256, 512 };
    int denom[] = { 2, 0, 4, 4, 0, 8 };
    for(int i=0; i<numer.length; i++) {
      try {
        if((numer[i]%2) != 0)
          throw new 
            NonIntResultException(numer[i], denom[i]);

        System.out.println(numer[i] + " / " +
                           denom[i] + " = " +
                           numer[i]/denom[i]);
      }
      catch (ArithmeticException exc) {
        // cattura l'eccezione 
        System.out.println("Non può dividere per Zero!");
      }
      catch (ArrayIndexOutOfBoundsException exc) {
        // cattura l'eccezione 
        System.out.println("Nessun elemento corrispondente trovato.");
      }
      catch (NonIntResultException exc) {
        System.out.println(exc);
      }
    }
  }
}
