// E' necessario includere nel progetto il jar
// postgresql-9.1-903.jdbc4.jar

//

// I certificati devono essere in 
// serverTrustStore.jks il certificato root.ctr
// postgresql.p12 il certificato client per la connessione al DB 
// (il suo CN deve contenere lo username dell'utente autorizzato ad accedere al DB)


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class PostgreSQLCertConnTester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		
		final String userId = "martemucci.patrizia@alberghetti.it";
		
		//Set the properties
		System.setProperty(CertAuthFactory.CONFIG_KEYSTORE_PATH, "./postgresql.p12");
		System.setProperty(CertAuthFactory.CONFIG_KEYSTORE_PWD, args[0]);
		System.setProperty(CertAuthFactory.CONFIG_TRUSTSTORE_PATH, "./serverTrustStore.jks");
		System.setProperty(CertAuthFactory.CONFIG_TRUSTSTORE_PWD, args[1]);
		
		final String connUrl = "jdbc:postgresql://127.0.0.1:5432/TestDB?ssl=true&sslfactory=CertAuthFactory";
		final String query = "SELECT * FROM \"Tabella_email\"";
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user",userId);

		Connection conn = DriverManager.getConnection(connUrl,props);
		
		
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.execute();
		ResultSet rs = stmt.getResultSet();
		System.out.println("Query eseguita  ");
		while(rs.next()){
			System.out.println("Reading row #" + rs.getRow());
		}
		
		 Statement stmt2 = conn.createStatement();
		 System.out.println("Create statement");
 		ResultSet risSQL=stmt2.executeQuery(query);
 		System.out.println("Query eseguita  ");
 		int ultimoID=0;
 		while(risSQL.next()){
 			
 			System.out.println("\nCampo 1 (ID): "+risSQL.getString("ID") +"\nCampo 2 (Cognome): "+risSQL.getString("Cognome")
 					+"\nCampo 3 (Nome): "+risSQL.getString("Nome")
 					+"\nCampo 4 (email): "+risSQL.getString("email"));
 			ultimoID=Integer.parseInt(risSQL.getString("ID"));
 			
 		}
 		/*
 		 
 		 //insert
 		int id=ultimoID+1;
		System.out.println("\n\n\nnuovo ID: "+id);
		StringBuffer sql = new StringBuffer();
		StringBuffer values = new StringBuffer();
		sql.append( "INSERT INTO \"Tabella_email\" (\"ID\",\"Cognome\") VALUES (?,?)" );
		String cognome="Martemucci";
		PreparedStatement stmt1 = null;
		stmt1 = conn.prepareStatement( sql.toString(), Statement.RETURN_GENERATED_KEYS);
		stmt1.setInt( 1,id);
		stmt1.setString(2,cognome);
		int rows = stmt1.executeUpdate();
		
 		if(rows==0) System.out.println("Query non eseguita  ");
 		else  System.out.println("Query eseguita  ");
 		*/
 		conn.close();
	}
	
}
