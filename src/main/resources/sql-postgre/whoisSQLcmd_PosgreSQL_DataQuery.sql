SELECT * FROM ianaTLDlist;

/***** NOT CHECKED YET *****/
SELECT * FROM tbl_2char_letters_com where available is null
UNION ALL
SELECT * FROM tbl_2char_numbers_com where available is null
UNION ALL
SELECT * FROM tbl_2char_letters_net where available is null
UNION ALL
SELECT * FROM tbl_2char_numbers_net where available is null
UNION ALL
SELECT * FROM tbl_3char_letters_com where available is null
UNION ALL
SELECT * FROM tbl_3char_numbers_com where available is null
UNION ALL
SELECT * FROM tbl_3char_letters_net where available is null
UNION ALL
SELECT * FROM tbl_3char_numbers_net where available is null
UNION ALL
SELECT * FROM tbl_4char_letters_com where available is null
UNION ALL
SELECT * FROM tbl_4char_numbers_com where available is null
UNION ALL
SELECT * FROM tbl_4char_letters_net where available is null
UNION ALL
SELECT * FROM tbl_4char_numbers_net where available is null;


/***** .COM AVAILABLE *****/
SELECT * FROM tbl_2char_letters_com where available <> 'N'
UNION ALL
SELECT * FROM tbl_2char_numbers_com where available <> 'N'
UNION ALL
SELECT * FROM tbl_3char_letters_com where available <> 'N'
UNION ALL
SELECT * FROM tbl_3char_numbers_com where available <> 'N'
UNION ALL
SELECT * FROM tbl_4char_letters_com where available <> 'N'
UNION ALL
SELECT * FROM tbl_4char_numbers_com where available <> 'N';


/***** .NET AVAILABLE *****/
SELECT * FROM tbl_2char_letters_net where available <> 'N'
UNION ALL
SELECT * FROM tbl_2char_numbers_net where available <> 'N'
UNION ALL
SELECT * FROM tbl_3char_letters_net where available <> 'N'
UNION ALL
SELECT * FROM tbl_3char_numbers_net where available <> 'N'
UNION ALL
SELECT * FROM tbl_4char_letters_net where available <> 'N'
UNION ALL
SELECT * FROM tbl_4char_numbers_net where available <> 'N';


/***** DICTIONARY AVAILABLE *****/
SELECT * FROM tbl_dictionary_english_com  where available = 'Y'
UNION ALL
SELECT * FROM tbl_dictionary_english_dash_com  where available = 'Y'
UNION ALL
SELECT * FROM tbl_dictionary_english_numbers_com  where available = 'Y'


SELECT * FROM tbl_dictionary_english_com  where available is null;

SELECT * FROM tbl_dictionary_english_com  where domain like 'able%';

SELECT domain, length(name) AS "Length of a Name" 
FROM tbl_dictionary_english_com 
WHERE length(name)<8
AND available = 'Y';



SELECT name, tld FROM domains_2char WHERE updatedutc < NOW() - INTERVAL '1 DAY' OR available IS NULL OR available = '' ORDER BY name, tld 

SELECT * FROM tbl_dictionary_english_com  where domain like '%test%' and available <> 'N'
