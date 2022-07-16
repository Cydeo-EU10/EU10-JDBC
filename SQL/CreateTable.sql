-- create table tableName(columnName, Type, constraint)
create table address(
                        address_id Integer Primary Key,
                        address varchar(50) NOT NULL,
                        phone Integer Not Null);

insert into address(address_id,address,phone) values (5,'1913 Hanoi Way',28303384);
insert into address(address_id,address,phone) values (7,'692 Joliet Street',44847719);
insert into address(address_id,address,phone) values (8, '1566 Inegl Manor', '70581400');
insert into address(address_id,address,phone) values (10, '1795 Santiago', 86045262);
insert into address(address_id,address,phone) values (11, '900 Satiago', 1657120);

CREATE TABLE Customers(
                          Customer_id INTEGER Primary Key,
                          FirstName varchar(30) NOT NULL,
                          LastName varchar(30) Not Null,
                          Address_id INTEGER references address(address_id)
);

select * from customers;
INSERT INTO Customers (Customer_id, FirstNAme, LastName, Address_id)
VALUES(1, 'Mary', 'Smith', 5);
INSERT INTO Customers (Customer_id, FirstNAme, LastName, Address_id) values (2, 'Patricia', 'Johnson', NULL);
INSERT INTO Customers (Customer_id, FirstNAme, LastName, Address_id) values (3, 'Linda', 'Williams', 7);
INSERT INTO Customers (Customer_id, FirstNAme, LastName, Address_id) values (4, 'Barbara', 'Jones', 8);
INSERT INTO Customers (Customer_id, FirstNAme, LastName, Address_id)values (5, 'Elizabeth', 'Brown', NULL);