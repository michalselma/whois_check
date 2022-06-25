Free DNS domain whois search and check

Functionality:
- Build 2, 3 and 4 letters, numbers, chars dictionary and use predefined english dictionary
- Data stoage: PostgreSQL, MS SQL or SQLite (SQLite not yet implemented)
- Configurabel Top Level Domains (TLD) to be checked
- Configurabel TLD Response patterns to identify free/taken domain
- Parse whois response from TLD to gain the following information:
* available, taken
* Expiry Date 
* Last cheked Date

Usage:
- Execute setup sables scripts on your SQL DB (resources/SQL)
- Make sure you included auxiliary.jar refereced library
- Review Main.java and compile per your needs (eg. generate dictionaries or standard checks execution)

AUTHOR:
Michal Selma <michal@selma.cc>



