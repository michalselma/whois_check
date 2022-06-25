package whoischeck;

import java.io.IOException;
import auxiliary.*;
//import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.whois.*;

public class GetWhoIsServerDataArray {

    public ArrayList<String> getWhoIsData(ArrayList<String> TLDdomain, String WhoisSrvName) {
        System.out.println("*** Calling [whoischeck.GetWhoIsServerDataArray][getWhoIsData()]");
        //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray][getWhoIsData()] Variable type: ArrayList<String> , name: TLDdomain, value: "+TLDdomain);
        //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray][getWhoIsData()] Variable type: String , name: WhoisSrvName , value: "+WhoisSrvName);
        ArrayList<String> whoisData = new ArrayList<String>() ;
        int arraySize = TLDdomain.size();
        int arrayMaxIndex = arraySize-1;
        WhoisClient whois = new WhoisClient();
//		whois.connect(WhoisSrvName);
//		System.out.println("whois.isConnected(): "+whois.isConnected());
//		System.out.println("whois.isAvailable(): "+whois.isAvailable());
//		System.out.println("whois.getDefaultPort(): "+whois.getDefaultPort());
//		System.out.println("whois.getDefaultTimeout(): "+whois.getDefaultTimeout());

////		System.out.println("whois.getSendBufferSize(): "+whois.getSendBufferSize());
////		System.out.println("whois.getReceiveBufferSize(): "+whois.getReceiveBufferSize());
//		System.out.println("whois.getSoTimeout(): "+whois.getSoTimeout());

//		System.out.println("whois.getTcpNoDelay(): "+whois.getTcpNoDelay());
//		whois.setTcpNoDelay(true);
//		System.out.println("whois.getKeepAlive(): "+whois.getKeepAlive());
//		whois.setKeepAlive(true);
//		System.out.println("whois.getSoLinger(): "+whois.getSoLinger());
//		whois.setSoLinger(true,1000);
//		System.out.println("whois.getLocalPort(): "+whois.getLocalPort());
//		System.out.println("whois.getLocalAddress(): "+whois.getLocalAddress());
//		System.out.println("whois.getRemotePort(): "+whois.getRemotePort());
////		System.out.println("whois.verifyRemote(): "+whois.verifyRemote());
//		System.out.println("whois.getConnectTimeout(): "+whois.getConnectTimeout());

//		System.out.println("whois.getServerSocketFactory(): "+whois.getServerSocketFactory());
////		System.out.println("whois.getCommandSupport(): "+whois.getCommandSupport());
//		System.out.println("whois.getProxy(): "+whois.getProxy());
//		System.out.println("whois.getCharsetName(): "+whois.getCharsetName());
//		System.out.println("whois.getCharset(): "+whois.getCharset());
//		System.out.println("whois Connect done");


        //System.out.println("data added: "+whoisData.get(x));

        for (int x=0; x<=arrayMaxIndex; x++) {
            try {
                String checkdomain = TLDdomain.get(x);
                //System.out.println("checkdomain: "+checkdomain);
                whois.connect(WhoisSrvName);
                whois.setDefaultTimeout(2000);
                whois.setSoTimeout(2000);
                whois.setConnectTimeout(2000);
                whoisData.add(x, whois.query(checkdomain));
                whois.disconnect();
            }

            catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
//		    	e.printStackTrace();
                whoisData.add(x, "WHOISSRVERROR");
            }
        }
        //whois.disconnect();
        return whoisData;
    }

    public String filterWhoisData(String whoisData, String pattern, String filteringType) {
        //System.out.println("*** Calling [GetWhoisServerData][filterWhoisData]");
        //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray][filterWhoisData()] Variable type: String , name: whoisData, value:");
        //System.out.println(whoisData);
        //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray][filterWhoisData()] Variable type: String , name: pattern , value: "+pattern);
        //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray][filterWhoisData()] Variable type: String , name: filteringType , value: "+filteringType);
        String filterResult = null;
        try {
            // **Call Pattern and Matcher class/methods to substring dns server name**
            // **Define Pattern for Search**
            Pattern searchPattern = Pattern.compile(pattern+".*");
            // **And search Output Query String**
            Matcher searchResult = searchPattern.matcher(whoisData);
            if (searchResult.find()==true){
                //System.out.println("[whoischeck.GetWhoIsServerDataArray.filterWhoisData] Pattern Found. Analysing Pattern Type and/or filtering.");
                // **Remove whitespace from found Pattern Line in the string and remove "whois:" substring**
                if (filteringType.equals("ShowValue")) {
                    //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray.filterWhoisData] Pattern Type: ShowValue");
                    filterResult = searchResult.group().replace(pattern,""); // **remove pattern substring to get pure data**
                    filterResult = filterResult.replaceAll("Z",""); // **Remove Z at the end of dattime
                    filterResult = filterResult.replaceAll("\\s+",""); // **Remove whitespace
                    filterResult = filterResult.replaceAll("T"," "); // **Replace T with space
                }
                else if (filteringType.equals("ShowPattern")) {
                    //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray][filterWhoisData] Pattern Type: ShowPattern");
                    //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [whoischeck.GetWhoIsServerDataArray][filterWhoisData] Found: "+searchResult.group()); // **Shows found Pattern Line**
                    filterResult = searchResult.group();
                    filterResult = filterResult.substring(0, pattern.length()); // remove all after define pattern
                }
                else {
                    System.out.println("[GetWhoisServerData][filterWhoisData] Pattern Type unknown");
                    filterResult = "ERROR";
                }
            }
            else {
                //System.out.println("[getWhoisServerData.filterWhoisData] Pattern Not Found: "+pattern);
                filterResult = "ERROR";
            }
        }
        catch (Exception e) {
            System.err.println("IOException: " + e.getMessage());
//	    	e.printStackTrace();
            System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [GetWhoisServerData][filterWhoisData] Filtering Error");
            filterResult = "ERROR";
        }
        //System.out.println(filterResult);
        return filterResult;
    }

    public ArrayList<String> DBSelectTLDWhoIsFilteringPatternData(String WhoisSrvName,Connection con){
        //System.out.println("*** Calling [whoischeck.GetWhoIsServerDataArray][DBSelectTLDWhoIsSrvAndPattern] (String Domain: '"+Domain+"', Connection con: '"+con+"')");
        //System.out.println("[whoischeck.GetWhoIsServerDataArray][DBSelectTLDWhoIsSrvAndPattern] Select query on domain: " +Domain);
        ArrayList<String> values = new ArrayList<String>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT AvailablePattern, AvailablePatternAlternate, NotAvailablePattern, NotAvailablePatternAlternate, ExpiryDatePattern FROM ianaTLDList WHERE WhoisServerAddr = ?");
            stmt.setString(1, WhoisSrvName);
            ResultSet rs = stmt.executeQuery();
            if(con!=null){
                // Ilo   kolumn bedzie wielkoscia macierzy
                int numCols = rs.getMetaData().getColumnCount();
                //System.out.println("[getWhoisServerData.DBSelectTLDWhoIsSrvAndPattern] Ilosc kolumn SQL: " +numCols);
                while(rs.next()) { //troche be sensu bo zawsze bedzie tylko jedna linia (jeden wiersz) zwracane przez SQL SELECT
                    String strng = null;
                    for (int i = 1; i <= numCols; i++) {
                        strng = rs.getString(i);
                        values.add(strng);
                    }
                }
                rs.close();
                stmt.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Sql exception :" + e.getMessage());
            e.printStackTrace();
        }
        finally {
        }
        return values;
    }


    public ArrayList<ArrayList<String>> getAndAnalyseWhoIsData(ArrayList<String> Name_TLD, String WhoisSrvName, Connection con) throws IOException {
        //System.out.println("*** Calling [getWhoisServerData][getAndAnalyseWhoIsData] (String Name: '"+Name+"', String TLD: '"+TLD+"', Connection con: '"+con+"')");

        ArrayList<ArrayList<String>> returnData = new ArrayList<ArrayList<String>>();

        // getting whois Server filtering patterns
        ArrayList<String> whoisSqlFilteringPatternData = DBSelectTLDWhoIsFilteringPatternData(WhoisSrvName,con);
        //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] AvailablePattern: "+SQLArrayValues.get(0).get(0));
        //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] NotAvailablePattern: "+SQLArrayValues.get(0).get(1));
        //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] ExpiryDatePattern: "+SQLArrayValues.get(0).get(2));

        // getting whois data from whois Server
        ArrayList<String> whoisRawData = null;
        GetWhoIsServerDataArray whoisData = new GetWhoIsServerDataArray();
        whoisRawData = whoisData.getWhoIsData(Name_TLD, WhoisSrvName);
        int arraySize = Name_TLD.size(); //
        int arrayMaxIndex = arraySize-1;
        String pattern = "";
        String ExpiryDate = null;
        String whoisFilteredData = null;
        String whoisRawDataForEachTLD = null;
        //int x=0;
        // Rozpoczynay analiz  element w Name_TLD i wype niania macierzy returnData
        for (int x=0; x<=arrayMaxIndex; x++) { // dla kazdego wiersza tego co bedziemy zwracali z tej metody
            String NameTld = Name_TLD.get(x);
            //System.out.println(NameTld);
            returnData.add(new ArrayList<String>());
            returnData.get(x).add(NameTld); // na pozycje [x,0] gdzie x to zwracany z tej metody wiersz a 1 to index kolumny wrzuc wartosc z wejsciowej macierzy z pozycji Name_TLD[x] - taki troche piwocik :-)
            returnData.get(x).add("ERROR"); // na pozycje [x,1], gdzie x to zwracany z tej metody wiersz a 1 to index kolumny wrzuc domyslnie "ERROR"
            returnData.get(x).add("EMPTY"); // na pozycje [x,2], gdzie x to zwracany z tej metody wiersz a 2 to index kolumny wrzuc domyslnie "EMPTY"
            //System.out.println(returnData.get(x).get(0));
            //System.out.println(returnData.get(x).get(1));
            //System.out.println(returnData.get(x).get(2));
            whoisRawDataForEachTLD = whoisRawData.get(x);
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] --------------- START OF RAW DATA ---------------");
            //System.out.println(whoisRawDataForEachTLD);
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] ---------------- END OF RAW DATA ----------------");
            //check for AVAIALABLE pattern
            pattern = whoisSqlFilteringPatternData.get(0);
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Checking pattern: " +pattern);
            whoisFilteredData = whoisData.filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowPattern");
            if (whoisFilteredData.equals(pattern)) {
                //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Match found for AVAIALABLE: " +pattern);
                returnData.get(x).set(1,"Y");
            }
            //check for NOT AVAILABLE pattern
            pattern = whoisSqlFilteringPatternData.get(2);
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Checking pattern: " +pattern);
            whoisFilteredData = whoisData.filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowPattern");
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Found: " +whoisFilteredData);
            if (whoisFilteredData.equals(pattern)) {
                //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Match found for NOT AVAIALABLE: " +pattern);
                returnData.get(x).set(1,"N");
            }
            //check for EXPIRYDATE pattern
            pattern = whoisSqlFilteringPatternData.get(4);
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Checking pattern: " +pattern);
            whoisFilteredData = whoisData.filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowPattern");
            if (whoisFilteredData.equals(pattern)) {
                //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Match found for EXPIRYDATE: " +pattern);
                ExpiryDate = filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowValue");
                //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] EXPIRYDATE value returned: " +ExpiryDate);
                returnData.get(x).set(2,ExpiryDate);
            }
            // Check for alternate available
            pattern = whoisSqlFilteringPatternData.get(1);
            //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [getWhoisServerData.getAndAnalyseWhoIsData] Checking alternate pattern: " +pattern);
            //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [getWhoisServerData.getAndAnalyseWhoIsData] Raw data: "+whoisRawDataForEachTLD);
            whoisFilteredData = whoisData.filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowPattern");
            //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [getWhoisServerData.getAndAnalyseWhoIsData] TLD : "+NameTld);
            //System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [getWhoisServerData.getAndAnalyseWhoIsData] Filtered data: "+whoisFilteredData);
            if (whoisFilteredData.equals(pattern)) {
                //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Match found for ALTERNATE AVAIALABLE: " +pattern);
                returnData.get(x).set(1,"Y");
            }
            // Check for alternate not available
            pattern = whoisSqlFilteringPatternData.get(3);
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Checking alternate pattern: " +pattern);
            whoisFilteredData = whoisData.filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowPattern");
            if (whoisFilteredData.equals(pattern)) {
                //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Match found for ALTERNATE NOT AVAIALABLE: " +pattern);
                returnData.get(x).set(1,"N");
            }
            // Check for whois connection limit exceeded
            pattern = "WHOIS LIMIT EXCEEDED";
            whoisFilteredData = whoisData.filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowPattern");
            if (whoisFilteredData.equals(pattern)) {
                System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [getWhoisServerData.getAndAnalyseWhoIsData] WHOIS LIMIT EXCEEDED.");
                returnData.get(x).set(1,"ERROR");
            }
            pattern = "WHOISSRVERROR";
            whoisFilteredData = whoisData.filterWhoisData(whoisRawDataForEachTLD, pattern, "ShowPattern");
            if (whoisFilteredData.equals(pattern)) {
                System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [GetWhoisServerData.getAndAnalyseWhoIsData] WHOIS SERVER CHECK ERROR.");
                returnData.get(x).set(1,"ERROR");
            }
            //System.out.println("[getWhoisServerData.getAndAnalyseWhoIsData] Available: " +available);
            System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [GetWhoisServerData.getAndAnalyseWhoIsData] Returning '" +returnData.get(x).get(1)+"' '"+returnData.get(x).get(2)+"' value for '"+returnData.get(x).get(0)+"'");
        }

        return returnData;
    }


}
