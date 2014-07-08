//E' necessario includere nel progetto il jar
// postgresql-9.1-903.jdbc4.jar

//

// I certificati devono essere in 
//serverTrustStore.jks il certificato root.ctr
//postgresql.p12 il certificato client per la connessione al DB (il suo CN deve contenere lo username dell'utente autorizzato ad accedere al DB)

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccessoSSL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        Connection conn = null;
      
        try {
            //conn = DriverManager.getConnection(url, props);
        	
        	ResourceManager.setPassword(args[0],args[1]);
        	//args[0]: password truststore
        	//args[1]: password p12
        	conn=ResourceManager.getConnection();
        	String query = "SELECT * FROM \"Tabella_email\"";
            //System.out.println("Catalog: " + conn.getCatalog());
            //System.out.println("schema: " + conn.getMetaData().getUserName());
            
            Statement stmt = conn.createStatement();
    		System.out.println("Create statement");
    		ResultSet risSQL=stmt.executeQuery(query);
    		System.out.println("Query eseguita  ");
    		while(risSQL.next()){
    			
    			System.out.println("\nCampo 1 (ID): "+risSQL.getString("ID") +"\nCampo 2 (Cognome): "+risSQL.getString("Cognome")
    					+"\nCampo 3 (Nome): "+risSQL.getString("Nome")
    					+"\nCampo 4 (email): "+risSQL.getString("email"));
    					
    			
    		}
    	
    		conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccessoSSL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
