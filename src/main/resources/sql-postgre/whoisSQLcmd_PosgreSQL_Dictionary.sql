select domain, length(domain) as domain_length
from public.tbl_dictionary_english_com
where length(domain) = (select max(length(domain)) from tbl_dictionary_english_com)

delete from public.tbl_dictionary_english_dash_and_numbers_com
where domain in (
select domain from public.tbl_dictionary_english_dash_com);

INSERT INTO tbl_dictionary_english_dash_com (domain, name, tld)
SELECT domain, name, tld
FROM tbl_dictionary_english_dash_and_numbers_com
WHERE domain like '%-%'

select * from tbl_dictionary_english_com
select * from tbl_dictionary_english_dash_com
select * from tbl_dictionary_english_numbers_com