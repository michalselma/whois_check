USE master ;  
GO  
CREATE DATABASE whois
ON   
( NAME = whois,  
    FILENAME = 'C:\_Dev\DB\whois.mdf',  
    SIZE = 8MB,  
    MAXSIZE = UNLIMITED,  
    FILEGROWTH = 64MB )  
LOG ON  
( NAME = whois_log,  
    FILENAME = 'C:\_Dev\DB\whois_log.ldf',  
    SIZE = 8MB,  
    MAXSIZE = UNLIMITED,  
    FILEGROWTH = 64MB ) ;  
GO


CREATE TABLE whois.dbo.ianaTLDlist (
    Domain NVARCHAR(20) PRIMARY KEY NOT NULL,
    WhoisServerAddr NVARCHAR(200),
	TLDType NVARCHAR (20),
	AvailablePattern NVARCHAR(100),
	NotAvailablePattern NVARCHAR(100),
	ExpiryDatePattern NVARCHAR(100),
    UpdatedUTC DATETIME );

INSERT INTO whois.dbo.ianaTLDlist (Domain, TLDType, AvailablePattern, NotAvailablePattern, ExpiryDatePattern, UpdatedUTC) VALUES ('.com', 'generic', 'No match for', 'Registrar:', 'Registry Expiry Date:',GETUTCDATE());
INSERT INTO whois.dbo.ianaTLDlist (Domain, TLDType, AvailablePattern, NotAvailablePattern, ExpiryDatePattern, UpdatedUTC) VALUES ('.net', 'generic', 'No match for', 'Registrar:', 'Registry Expiry Date:', GETUTCDATE());
INSERT INTO whois.dbo.ianaTLDlist (Domain, TLDType, AvailablePattern, NotAvailablePattern, ExpiryDatePattern, UpdatedUTC) VALUES ('.org', 'generic', 'NOT FOUND', 'Registrar:', 'Registry Expiry Date:', GETUTCDATE());
INSERT INTO whois.dbo.ianaTLDlist (Domain, TLDType, AvailablePattern, NotAvailablePattern, ExpiryDatePattern, UpdatedUTC) VALUES ('.eu', 'country-code', 'Status: AVAILABLE', 'Registrant:', null, GETUTCDATE());

SELECT * FROM whois.dbo.ianaTLDlist;

CREATE TABLE whois.dbo.domains_2char (
    Domain NCHAR(20) PRIMARY KEY NOT NULL,
    Name NCHAR(2),
	TLD NCHAR(20),
	Available NCHAR(1),
	DomainExpiryDate DATETIME,
    UpdatedUTC DATETIME );

SELECT * FROM whois.dbo.domains_2char;