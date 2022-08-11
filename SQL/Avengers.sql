
-- Let's get all employees job titles
select FIRST_NAME, LAST_NAME, JOB_TITLE
from EMPLOYEES e join JOBS j on e.JOB_ID=j.JOB_ID;

-- inner join
select FIRSTNAME,LASTNAME,ADDRESS
from CUSTOMERS c inner join ADDRESS a
on c.ADDRESS_ID=a.ADDRESS_ID;

select * from CUSTOMERS;
select * from ADDRESS;