import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccessoConPassword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String url= "jdbc:postgresql://localhost:5432/TestDB";
        Properties props = new Properties();
        String username=args[0];
        String password=args[1];
        props.setProperty("user", username);
        props.setProperty("password", password);
        
        
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, props);
            String query = "SELECT * FROM \"Tabella_email\"";
            System.out.println("Catalog: " + conn.getCatalog());
            
            Statement stmt = conn.createStatement();
    		System.out.println("Create statement");
    		ResultSet risSQL=stmt.executeQuery(query);
    		System.out.println("Query eseguita  ");
    		int ultimoID = 0;
    		while(risSQL.next()){
    			System.out.println("\nCampo 1 (ID): "+risSQL.getString("ID") +"\nCampo 2 (Cognome): "+risSQL.getString("Cognome")
    					+"\nCampo 3 (Nome): "+risSQL.getString("Nome")
    					+"\nCampo 4 (email): "+risSQL.getString("email"));
    			ultimoID=Integer.parseInt(risSQL.getString("ID"));
    		}
    		
    		
    		
    		//query parametriche
    		/*
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
        } catch (SQLException ex) {
            Logger.getLogger(AccessoConPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
