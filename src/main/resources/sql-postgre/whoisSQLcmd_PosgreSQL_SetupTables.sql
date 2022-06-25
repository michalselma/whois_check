CREATE TABLE ianaTLDlist (
    Domain VARCHAR(20) PRIMARY KEY NOT NULL,
    WhoisServerAddr VARCHAR(200),
	TLDType VARCHAR (20),
	AvailablePattern VARCHAR(100),
	AvailablePatternAlternate VARCHAR(100),
	NotAvailablePattern VARCHAR(100),
	NotAvailablePatternAlternate VARCHAR(100),
	ExpiryDatePattern VARCHAR(100),
    UpdatedUTC TIMESTAMP );


INSERT INTO ianaTLDlist (Domain, TLDType, AvailablePattern, AvailablePatternAlternate, NotAvailablePattern, NotAvailablePatternAlternate, ExpiryDatePattern, UpdatedUTC) 
	VALUES ('.com', 'generic', 'No match for', null, 'Registrar:', null, 'Registry Expiry Date:',CURRENT_TIMESTAMP);
INSERT INTO ianaTLDlist (Domain, TLDType, AvailablePattern, AvailablePatternAlternate, NotAvailablePattern, NotAvailablePatternAlternate, ExpiryDatePattern, UpdatedUTC) 
	VALUES ('.net', 'generic', 'No match for', null, 'Registrar:', null, 'Registry Expiry Date:', CURRENT_TIMESTAMP);
INSERT INTO ianaTLDlist (Domain, TLDType, AvailablePattern, AvailablePatternAlternate, NotAvailablePattern, NotAvailablePatternAlternate, ExpiryDatePattern, UpdatedUTC) 
	VALUES ('.org', 'generic', 'NOT FOUND', null, 'Registrar:', 'Name is reserved by Registry_Policy', 'Registry Expiry Date:', CURRENT_TIMESTAMP);
INSERT INTO ianaTLDlist (Domain, TLDType, AvailablePattern, AvailablePatternAlternate, NotAvailablePattern, NotAvailablePatternAlternate, ExpiryDatePattern, UpdatedUTC) 
	VALUES ('.eu', 'country-code', 'Status: AVAILABLE', null, 'Registrant:', 'Status: NOT AVAILABLE', null, CURRENT_TIMESTAMP);


CREATE TABLE tbl_2char_letters_com (
    Domain VARCHAR(20) PRIMARY KEY NOT NULL, Name VARCHAR(2), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );
CREATE TABLE tbl_2char_numbers_com (
    Domain VARCHAR(20) PRIMARY KEY NOT NULL, Name VARCHAR(2), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );
CREATE TABLE tbl_3char_letters_com (
    Domain VARCHAR(20) PRIMARY KEY NOT NULL, Name VARCHAR(3), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );
CREATE TABLE tbl_3char_numbers_com (
    Domain VARCHAR(20) PRIMARY KEY NOT NULL, Name VARCHAR(3), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );
CREATE TABLE tbl_4char_letters_com (
    Domain VARCHAR(20) PRIMARY KEY NOT NULL, Name VARCHAR(4), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );
CREATE TABLE tbl_4char_numbers_com (
    Domain VARCHAR(20) PRIMARY KEY NOT NULL, Name VARCHAR(4), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );


CREATE TABLE tbl_dictionary_english_com (
    Domain VARCHAR(120) PRIMARY KEY NOT NULL, Name VARCHAR(100), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );
CREATE TABLE tbl_dictionary_english_dash_com (
    Domain VARCHAR(120) PRIMARY KEY NOT NULL, Name VARCHAR(100), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );
CREATE TABLE tbl_dictionary_english_numbers_com (
    Domain VARCHAR(120) PRIMARY KEY NOT NULL, Name VARCHAR(100), TLD VARCHAR(20),
	Available VARCHAR(1), DomainExpiryDate TIMESTAMP, UpdatedUTC TIMESTAMP );