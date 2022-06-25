package whoischeck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliary.*;
import auxiliary.db.*;

public class Dictionary {

	
	public static ArrayList<String> generteTwoCharLetters() {
		System.out.println("*** Calling [Dictionary][generteTwoCharLetters()]");
		String[] chars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int charsamount = chars.length;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteTwoCharLetters()] Amount of individual chars used by generator: " + charsamount);
		ArrayList<String> combinationsArray = new ArrayList<String>();
		String combination = null;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteTwoCharLetters()] Two numbers dictonary creation");
		   for (int a=0;a<charsamount;a++) {
			   for (int b=0;b<charsamount;b++) {
				   combination = chars[a]+chars[b];
				   combinationsArray.add(combination);
				   System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteTwoCharLetters()] Generated combination: " +combination);
				   System.out.print(".");
			   }
		   }
		System.out.println();   
		return combinationsArray;
	}

	
	public static ArrayList<String> generteTwoCharNumbers() {
		System.out.println("*** Calling [Dictionary][generteTwoCharNumbers()]");
		String[] chars = {"0","1","2","3","4","5","6","7","8","9"};
		int charsamount = chars.length;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteTwoCharNumbers()] Amount of individual chars used by generator: " + charsamount);
		ArrayList<String> combinationsArray = new ArrayList<String>();
		String combination = null;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteTwoCharNumbers()] Two numbers dictonary creation");
		   for (int a=0;a<charsamount;a++) {
			   for (int b=0;b<charsamount;b++) {
				   combination = chars[a]+chars[b];
				   combinationsArray.add(combination);
				   System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteTwoCharNumbers()] Generated combination: " +combination);
				   System.out.print(".");
			   }
		   }   
		return combinationsArray;
	}
	
	
	public static ArrayList<String> generteThreeCharLetters() {
		System.out.println("*** Calling [Dictionary][generteThreeCharLetters()]");
		String[] chars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int charsamount = chars.length;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteThreeCharLetters()] Amount of individual chars used by generator: " + charsamount);
		ArrayList<String> combinationsArray = new ArrayList<String>();
		String combination = null;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteThreeCharLetters()] Three numbers dictonary creation");
		   for (int a=0;a<charsamount;a++) {
			   for (int b=0;b<charsamount;b++) {
				   for (int c=0;c<charsamount;c++) {
					   combination = chars[a]+chars[b]+chars[c];
					   combinationsArray.add(combination);
					   System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteThreeCharLetters()] Generated combination: " +combination);
				   }
			   }
		   }  
		return combinationsArray;
	}


	public static ArrayList<String> generteThreeCharNumbers() {
		System.out.println("*** Calling [Dictionary][generteThreeCharNumbers()]");
		String[] chars = {"0","1","2","3","4","5","6","7","8","9"};
		int charsamount = chars.length;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteThreeCharNumbers()] Amount of individual chars used by generator: " + charsamount);
		ArrayList<String> combinationsArray = new ArrayList<String>();
		String combination = null;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteThreeCharNumbers()] Three numbers dictonary creation");
		   for (int a=0;a<charsamount;a++) {
			   for (int b=0;b<charsamount;b++) {
				   for (int c=0;c<charsamount;c++) {
					   combination = chars[a]+chars[b]+chars[c];
					   combinationsArray.add(combination);
					   System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteThreeCharNumbers()] Generated combination: " +combination);
				   }
			   }
		   }  
		return combinationsArray;
	}	
	
	
	public static ArrayList<String> generteFourCharLetters() {
		System.out.println("*** Calling [Dictionary][generteFourCharLetters()]");
		String[] chars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int charsamount = chars.length;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteFourCharLetters()] Amount of individual chars used by generator: " + charsamount);
		ArrayList<String> combinationsArray = new ArrayList<String>();
		String combination = null;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteFourCharLetters()] Four numbers dictonary creation");
		   for (int a=0;a<charsamount;a++) {
			   for (int b=0;b<charsamount;b++) {
				   for (int c=0;c<charsamount;c++) {
					   for (int d=0;d<charsamount;d++) {
					   combination = chars[a]+chars[b]+chars[c]+chars[d];
					   combinationsArray.add(combination);
					   System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteFourCharLetters()] Generated combination: " +combination);
					   }
				   }
			   }
		   }  
		return combinationsArray;
	}


	public static ArrayList<String> generteFourCharNumbers() {
		System.out.println("*** Calling [Dictionary][generteFourCharNumbers()]");
		String[] chars = {"0","1","2","3","4","5","6","7","8","9"};
		int charsamount = chars.length;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteFourCharNumbers()] Amount of individual chars used by generator: " + charsamount);
		ArrayList<String> combinationsArray = new ArrayList<String>();
		String combination = null;
		System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteFourCharNumbers()] Four numbers dictonary creation");
		   for (int a=0;a<charsamount;a++) {
			   for (int b=0;b<charsamount;b++) {
				   for (int c=0;c<charsamount;c++) {
					   for (int d=0;d<charsamount;d++) {
					   combination = chars[a]+chars[b]+chars[c]+chars[d];
					   combinationsArray.add(combination);
					   System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][generteFourCharNumbers()] Generated combination: " +combination);
					   }
				   }
			   }
		   }  
		return combinationsArray;
	}	
	
	
	public void dbInsertDomainName(String domain, String name, String tld, String table, Connection con) {
		System.out.println("*** Calling [Dictionary][dbInsertDomainName()]");
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO " +table+ "(Domain, Name, TLD, UpdatedUTC) VALUES (?, ?, ?, CURRENT_TIMESTAMP)");
			stmt.setString(1, domain);
			stmt.setString(2, name);
			stmt.setString(3, tld);
			// Execute the java prepared statement
			stmt.executeUpdate();
			System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][dbInsertDomainName()] DB insert done into: '"+table+"' for: '"+domain+"'");
			}
		catch (SQLException e) {
        	System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][dbInsertDomainName()] SQL exception :" + e.getMessage());
            //e.printStackTrace();
        	}		
		}
	
	
	public void createDictionaryForTldAndInsertIntoDB(int charsAmount, String charsType, String tldName) {
		System.out.println("*** Calling [Dictionary][createDictionaryForTldAndInsertIntoDB()]");
		try {
			ArrayList<String> itemsList = null; 
			if (charsAmount==2&&charsType=="letters") {
			itemsList = Dictionary.generteTwoCharLetters();
			}
			if (charsAmount==3&&charsType=="letters") {
			itemsList = Dictionary.generteThreeCharLetters();
			}
			if (charsAmount==4&&charsType=="letters") {
			itemsList = Dictionary.generteFourCharLetters();
			}			
			if (charsAmount==2&&charsType=="numbers") {
			itemsList = Dictionary.generteTwoCharNumbers();
			}
			if (charsAmount==3&&charsType=="numbers") {
			itemsList = Dictionary.generteThreeCharNumbers();
			}
			if (charsAmount==4&&charsType=="numbers") {
			itemsList = Dictionary.generteFourCharNumbers();
			}
			PostgreSqlDB DB = new PostgreSqlDB();
			DB.openConnection();
			for (int a=0;a<itemsList.size();a++) {
				String tableName = "tbl_"+charsAmount+"char_"+charsType+"_"+tldName;
				dbInsertDomainName(itemsList.get(a)+"."+tldName, itemsList.get(a), "."+tldName, tableName, DB.con);
				System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][createDictionaryForTldAndInsertIntoDB()] Domain generated and insert into DB: '"+itemsList.get(a)+"."+tldName+"'");
			}
			DB.closeConnection();
		}
		catch (Exception e) {
        	System.out.println(DefinedTimeStamp.currentUtcTimeDate()+" [Dictionary][createDictionaryForTldAndInsertIntoDB()] Exception: " + e.getMessage());
            e.printStackTrace();
		}
	}
	
}
