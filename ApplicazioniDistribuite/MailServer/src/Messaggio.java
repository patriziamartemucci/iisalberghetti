/**
 * @(#)Messaggio.java
 *
 *
 * @author 
 * @version 1.00 2007/4/10
 */

import java.io.Serializable;
// ho serializzoto la classe perchè volevo salvare l'oggetto. Non ci sono riuscita :-(
public class Messaggio implements Serializable{

   String from;
   String to;
   String subject;
   String body;
   
   public String toString(){
   	return from+","+to+","+subject+","+body;
   } 
    
}