select * from regions;

select FIRST_NAME, LAST_NAME, SALARY, JOB_ID from EMPLOYEES;

select * from address;
select * from customers;

-- left join
select * from CUSTOMERS c left outer join ADDRESS a
on c.ADDRESS_ID = a.ADDRESS_ID;
-- inner join or default join
select * from CUSTOMERS c  join ADDRESS a
        on c.ADDRESS_ID = a.ADDRESS_ID;

select a.ADDRESS from CUSTOMERS c  join ADDRESS a
                                on c.ADDRESS_ID = a.ADDRESS_ID
where FIRSTNAME = 'Mary' ;