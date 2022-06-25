package whoischeck;

import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.whois.WhoisClient;

import auxiliary.db.*;



public class TLDListManagement {

	public String getWhoIsSrvNameForTLDFromIANA(String TLDdomain) {

		String IANAwhoisServer = "whois.iana.org";
		String registerWhoIsServer = null;
		
	    try {
	    	// **Call org.apache.commons.net.whois class**
			WhoisClient whois = new WhoisClient();
	    	
			// **Call whois methods to connect, query, disconnect**
			//whois.connect(WhoisClient.DEFAULT_HOST);
	    	whois.connect(IANAwhoisServer);
	    	String whoisQueryResult = whois.query(TLDdomain);
	    	// System.out.println(whoisQueryResult);
	    	whois.disconnect();
	    	// **Call Pattern and Matcher class/methods to substring dns server name**
	    	// **Define Pattern for Search**
			Pattern registerWhoIsSearchWholeLine = Pattern.compile("whois.*");
			// **And search Output Query String**
	    	Matcher registerWhoIsResult = registerWhoIsSearchWholeLine.matcher(whoisQueryResult);
		    // System.out.println(registerWhoIsResult.find()); // **Only True/False if found**
	    	if (registerWhoIsResult.find()==true){
			    //System.out.println(registerWhoIsResult.group()); // **Shows found Pattern**
	    		// **Remove whitespace from found Pattern Line in the string and remove "whois:" substring**
	    		registerWhoIsServer = registerWhoIsResult.group().replaceAll("\\s+","");
	    		registerWhoIsServer = registerWhoIsServer.replace("whois:",""); // **remove "whois:" substring**
		    	}
	    	else {
	    		registerWhoIsServer = "";
	    		}
	    	}
	    catch (SocketException e) {
	    	System.err.println("Error Socket exception: " + e.getMessage());
	    	e.printStackTrace();
	    	registerWhoIsServer = "Error Socket exception: " + e.getMessage();
	    	} 
	    catch (IOException e) {
	    	System.err.println("Error I/O exception: " + e.getMessage());
	    	e.printStackTrace();
	    	registerWhoIsServer = "Error I/O exception: " + e.getMessage();
	    	}
	    return registerWhoIsServer;
	}
	
	
	
	public void DBUpdateWhoIsSrvNameForTLD(String Domain, String WhoisServerAddr,Connection con) {
		try {
			System.out.println("[TLDListManagement][DBUpdateWhoIsSrvNameForTLD]");
			PreparedStatement stmt = con.prepareStatement("UPDATE ianaTLDList SET WhoisServerAddr = ? , UpdatedUTC = CURRENT_TIMESTAMP WHERE Domain = ?");
		    if (WhoisServerAddr == "null" || WhoisServerAddr.matches("\\s*")) {
		    	stmt.setNull(1, Types.VARCHAR);
		      } 
		      else {
		    	stmt.setString(1, WhoisServerAddr);
		      }
			stmt.setString(2, Domain);
	        // execute the java prepared statement
			stmt.executeUpdate();
			System.out.println("Updated "+Domain+" set "+WhoisServerAddr);
			}
		catch (SQLException e) {
        	System.out.println("Sql exception :" + e.getMessage());
            e.printStackTrace();
        	}		
		}

	
	
	public void ianaTLDlistUpdate(Connection con){
		System.out.println("[ianaTLDlistUpdate]");
		PostgreSqlDB DB = new PostgreSqlDB();
		String query = "SELECT Domain FROM ianaTLDList";
		ArrayList<ArrayList<String>> queryResultArray = DB.selectDataFromDb(query,con);
		int arrayColumns = queryResultArray.get(0).size(); // **wystarczy ze sprawdzimy ile kolumn ma pierwszy wiersz bedziemy miec ilosc kolumn dla calej macierzy
		int arrayRows = queryResultArray.size();
		int arrayMaxColumnIndex = arrayColumns-1;
		int arrayMaxRowIndex = arrayRows-1;
		String tldName;
		String serverAddr;
		DB.openConnection();  //returns Connection type , variable con
		for (int x=0; x<=arrayMaxRowIndex; x++) {
			tldName = queryResultArray.get(x).get(0);
			serverAddr = getWhoIsSrvNameForTLDFromIANA(tldName);
			if (serverAddr=="") {
				serverAddr="null";
				}
			System.out.print(tldName + ": ");
			System.out.println(serverAddr);
			DBUpdateWhoIsSrvNameForTLD(tldName, serverAddr, DB.con);
			}
		DB.closeConnection();
		}
	}