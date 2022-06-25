package whoischeck;

public class Main {
    public static void main(String[] args) {

//		PostgreSQL test = new PostgreSQL();
//		test.openConnection();
//		test.displayDbProperties();
//		test.closeConnection();

//		*** Update WhoisServer address for each TLD domain. ianaTldList table need to exist.
//		PostgreSQL DB = new PostgreSQL();
//		DB.openConnection();
//		TLDListManagement execute = new TLDListManagement();
//		execute.ianaTldListUpdate(DB.con);
//		DB.closeConnection();

//		*** Generate directory list. domains_2char table needs to exist.
//		Dictionary execute = new Dictionary();
//		execute.createDictionaryForTldAndInsertIntoDB(4, "letters", "com");
//		execute.createDictionaryForTldAndInsertIntoDB(4, "numbers", "com");
//		execute.createDictionaryForTldAndInsertIntoDB(4, "letters", "net");
//		execute.createDictionaryForTldAndInsertIntoDB(4, "numbers", "net");
/*        try {
            PostgreSqlDB DB = new PostgreSqlDB();
            int repeat = 4000;
            for (int x=0;x<repeat;x++) {
                DB.openConnection();
                DomainList execute = new DomainList();
//			execute.checkDomainListArray(4, "letters", "com", DB.con, 50);
//			execute.checkDomainListArray(4, "letters", "net", DB.con, 50);
//			execute.checkDomainListArray(4, "numbers", "com", DB.con, 50);
//			execute.checkDomainListArray(4, "numbers", "net", DB.con, 50);
//			execute.checkDomainListArray(3, "letters", "com", DB.con, 50);
//			execute.checkDomainListArray(3, "letters", "net", DB.con, 50);
//			execute.checkDomainListArray(3, "numbers", "com", DB.con, 50);
//			execute.checkDomainListArray(3, "numbers", "net", DB.con, 50);
//			execute.checkDomainListArray(2, "letters", "com", DB.con, 50);
//			execute.checkDomainListArray(2, "letters", "net", DB.con, 50);
//			execute.checkDomainListArray(2, "numbers", "com", DB.con, 50);
//			execute.checkDomainListArray(2, "numbers", "net", DB.con, 50);
                execute.checkDomainListArray(0, "dictionary_english", "com", DB.con, 40);
                execute.checkDomainListArray(0, "dictionary_english_dash", "com", DB.con, 40);
//			execute.checkDomainListArray(0, "dictionary_english_numbers", "com", DB.con, 40);
                DB.closeConnection();
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */

//		PostgreSQL DB = new PostgreSQL();
//		DB.openConnection();
//		getWhoisServerData data = new getWhoisServerData();
//		String whoisRawData = data.getWhoIsData("037.org","whois.pir.org");
//		System.out.println(whoisRawData);
//		String[] return2;
//		return2	= data.getAndAnalyseWhoIsData("037",".org", DB.con);
//		DB.closeConnection();

//		PostgreSQL DB = new PostgreSQL();
//		DB.openConnection();
//		getWhoisServerData data = new getWhoisServerData();
//		String whoisRawData = data.getWhoIsData("04a.eu","whois.eu");
//		System.out.println(whoisRawData);
//		String[] return2;
//		return2	= data.getAndAnalyseWhoIsData("04a",".eu", DB.con);
//		DB.closeConnection();
    }
}
