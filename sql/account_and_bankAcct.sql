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

INSERT INTO sc_account(username, clientId, funds) VALUES ('Aryan', 'ABC123', 100000);
INSERT INTO sc_bankaccount(clientId, account_number, bank_name, balance) values('ABC123', '608502111', 'XYZ bank', 1050000.0);

COMMIT;