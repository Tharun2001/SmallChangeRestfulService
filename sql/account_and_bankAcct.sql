drop table sc_bankaccount;
drop table sc_account;

CREATE TABLE sc_account (
    username varchar(255),
    clientId varchar(255) NOT NULL PRIMARY KEY,
    funds decimal(30,2) NOT NULL
);

CREATE TABLE sc_bankaccount (
    clientId varchar(255),
    account_number varchar(255) NOT NULL,
    bank_name varchar(255) NOT NULL,
    balance decimal(30,2),
    PRIMARY KEY(account_number),
    FOREIGN KEY(clientId) REFERENCES sc_account(clientId)
); 

Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Aryan','ABC123',85324);
Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Tharun','PLC341',85324);
Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Akilesh','GHT623',85324);
Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Akshay','YTC123',85324);
Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Sandhya','FLM504',81910);
Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Ethan','HVL491',81910);

Insert into SCOTT.SC_BANKACCOUNT (CLIENTID,ACCOUNT_NUMBER,BANK_NAME,BALANCE) values ('ABC123','608502111','XYZ bank',1050000);
Insert into SCOTT.SC_BANKACCOUNT (CLIENTID,ACCOUNT_NUMBER,BANK_NAME,BALANCE) values ('PLC341','718502111','XYZ bank',1050000);
Insert into SCOTT.SC_BANKACCOUNT (CLIENTID,ACCOUNT_NUMBER,BANK_NAME,BALANCE) values ('GHT623','666555444','Yes bank',2400000);
Insert into SCOTT.SC_BANKACCOUNT (CLIENTID,ACCOUNT_NUMBER,BANK_NAME,BALANCE) values ('HVL491','1111222333','Yes bank',2400000);

COMMIT;