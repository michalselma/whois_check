package whoischeck;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import auxiliary.db.*;

public class DomainList {

		public void checkDomainListArray(int charsAmount, String charsType, String tldName, Connection con, int numberOfDomains) throws IOException{
			System.out.println("*** Calling [domainList][checkDomainListArray]");
			String tld = "."+tldName;
			String SqlTableName = "";
			if (charsAmount==0) {
				SqlTableName = "tbl_"+charsType+"_"+tldName; // Jezeli charsAmount jest 0 to wez nazwe tabeli z charsType
			}
			else {
				SqlTableName = "tbl_"+charsAmount+"char_"+charsType+"_"+tldName;
			}
			PostgreSqlDB DB = new PostgreSqlDB();
//			String query = "SELECT name, tld FROM "+table+" WHERE updatedutc < NOW() - INTERVAL '90 DAY' OR available IS NULL ORDER BY name, tld";
			
			String queryDomainsToCheck = "SELECT domain FROM "+SqlTableName+" WHERE available IS NULL AND tld = '"+tld+"' LIMIT "+numberOfDomains+";";
			//System.out.println(TimeStamp.currentUtcTimeDate()+" [domainList][CheckDomainListArray] SQL queryDomainsToCheck: "+queryDomainsToCheck);	
			ArrayList<String> queryDomainsToCheckResultArray = DB.selectDataFromDbOneColumnOnly(queryDomainsToCheck,con);		// tu dostajemy tld i name
			
			String queryWhoisSrvName = "SELECT WhoisServerAddr FROM ianaTLDList WHERE Domain = '"+tld+"'";			
			ArrayList<String> queryWhoisSrvNameResultArray = DB.selectDataFromDbOneColumnOnly(queryWhoisSrvName,con);
			String WhoisSrvName = queryWhoisSrvNameResultArray.get(0); // zakladamy ze SELECT zwroci tylko jedna wartosc
			
			// tu zaczynami checki
			GetWhoIsServerDataArray checkResultArray = new GetWhoIsServerDataArray();
			ArrayList<ArrayList<String>> checkResultArrayOutput;
			checkResultArrayOutput = checkResultArray.getAndAnalyseWhoIsData(queryDomainsToCheckResultArray,WhoisSrvName, con); // czy tutaj powinno by� array of arrays ?
			
			if (checkResultArrayOutput.size()>0) {
				int arrayRows = checkResultArrayOutput.size();
				int arrayMaxRowIndex = arrayRows-1;
				for (int x=0; x<=arrayMaxRowIndex; x++) {
					String name_tld = checkResultArrayOutput.get(x).get(0);
					//System.out.println(checkResultArrayOutput.get(x).get(0));
					//System.out.println(checkResultArrayOutput.get(x).get(1));
					//System.out.println(checkResultArrayOutput.get(x).get(2));
				
					
					// System.out.println(TimeStamp.currentUtcTimeDate()+" [domainList][Check] Checking "+name_tld);		
					if (checkResultArrayOutput.get(x).get(1)!="ERROR"&&checkResultArrayOutput.get(x).get(2)=="EMPTY") {
						try {
							PreparedStatement stmt = con.prepareStatement("UPDATE "+SqlTableName+" SET available = ?, updatedutc = CURRENT_TIMESTAMP WHERE domain = ?");
							// execute the java prepared statement
							stmt.setString(1, checkResultArrayOutput.get(x).get(1));
							stmt.setString(2, name_tld);
							stmt.executeUpdate();
							//System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [domainList][checkDomainListArray] Updated '"+name_tld+"' set available: '"+checkResultArrayOutput.get(x).get(1)+"'");
						}
						catch (SQLException e) {
							System.out.println("Sql exception :" + e.getMessage());
							e.printStackTrace();
						}
					}
				
					if (checkResultArrayOutput.get(x).get(1)!="ERROR"&&checkResultArrayOutput.get(x).get(2)!="EMPTY") {
						try {
							PreparedStatement stmt = con.prepareStatement("UPDATE "+SqlTableName+" SET available = ?, DomainExpiryDate = ?, updatedutc = CURRENT_TIMESTAMP WHERE domain = ?");
							// execute the java prepared statement
							stmt.setString(1, checkResultArrayOutput.get(x).get(1));
							//stmt.setString(2, result[1]);
							
							stmt.setTimestamp(2, Timestamp.valueOf(checkResultArrayOutput.get(x).get(2)));
							stmt.setString(3, name_tld);
							stmt.executeUpdate();
							//System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [domainList][checkDomainListArray] Updated '"+name_tld+"', set available: '"+checkResultArrayOutput.get(x).get(1)+"' AND set domainexpirydate: '"+Timestamp.valueOf(checkResultArrayOutput.get(x).get(2))+"'");
						}
						catch (SQLException e) {
							System.out.println("Sql exception :" + e.getMessage());
							e.printStackTrace();
						}
					}
				}
			}
		}
}
		

