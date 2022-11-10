Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Aryan','ABC123',85324);
Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Elend','FLM504',81910);
Insert into SCOTT.SC_ACCOUNT (USERNAME,CLIENTID,FUNDS) values ('Ethan','HVL491',76586.6);

Insert into SCOTT.SC_BANKACCOUNT (CLIENTID,ACCOUNT_NUMBER,BANK_NAME,BALANCE) values ('HVL491','1111222333','BUH bank',262114286);
Insert into SCOTT.SC_BANKACCOUNT (CLIENTID,ACCOUNT_NUMBER,BANK_NAME,BALANCE) values ('ABC123','608502111','XYZ bank',1050000);
Insert into SCOTT.SC_BANKACCOUNT (CLIENTID,ACCOUNT_NUMBER,BANK_NAME,BALANCE) values ('FLM504','666555444','Yes bank',2400000);





INSERT INTO SC_TRADE(CLIENTID,trade_type,S_ID,QUANTITY,PRICE,TRADE_TIME) VALUES('HVL491','B',1,10,100, CURRENT_TIMESTAMP);
  
INSERT INTO SC_HOLDING(CLIENTID, S_ID, QTY,INVESTED_AMOUNT) VALUES('HVL491',1,10,1000);
Insert into SCOTT.SC_HOLDING (CLIENTID, S_ID, QTY,INVESTED_AMOUNT) values ('HVL491', 2, 10, 5000);

  
  
  
  
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (1, 'Apple Inc', 'AAPL',154.29,'Main Index');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (2, 'Tesla Inc', 'TSLA',733.8,'Main Index');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (3, 'Amazon.com', 'AMZN',170,'Main Index');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (5, 'Microsoft', 'MSFT',300.88,'Main Index');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (6, 'Facebook', 'FB',386.71,'Main Index');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (7, 'Walmart Inc', 'WMT',145.70,'Main Index');

INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (4, 'Vinco Ventures', 'BBIG',7.70,'Small cap company stocks');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (8, 'Aterian', 'ATER',17.89,'Small cap company stocks');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (9, 'BHL Group', 'BHP',61.71,'Small cap company stocks');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (10, 'Sphere 3D Corp', 'ANY',6.71,'Small cap company stocks');

INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (11, 'Lucid Group Inc Shs', 'LCID',80.70,'International market stocks');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (12, 'Pfizer Inc', 'PFE',27.89,'International market stocks');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (13, 'Mastercard Inc', 'MA',31.71,'International market stocks');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (14, 'NVDIA Corp', 'NVDA',17.71,'International market stocks');

--INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (15, 'Vanguard 500', 'VFIAX',17.71,'MF');
--INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (16, 'Fidelity 500 Index fund', 'FXAIX',17.71,'MF');
--INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (17, 'SPDR S&P 500 ETF', 'SPY',17.71,'MF');
--INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (18, 'Fidelity Govt Cash Rsrvs', 'FDRXX',17.71,'MF');
--INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (19, 'American Funds gro', 'AGTHX',17.71,'MF');
--INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (20, 'Fidelity Contrafund', 'MVRXX',17.71,'MF');

INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (21, 'SPDR Bloomberg Barclays', 'VFIAXB',44.51,'Government bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (22, 'iShares US Treasury', 'USTAXB',57.12,'Government bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (23, 'PIMCO', 'MINT',32.97,'Government bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (24, 'ProShares', 'TBX',88.76,'Government bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (25, 'FlexShares', 'TDTT',56.51,'Government bonds');

INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (26, 'Schwab Corp', 'SCHI',38.71,'Corporate bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (27, 'Invesco', 'INV',72.90,'Corporate bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (28, 'Vanguard', 'VNG',87.41,'Corporate bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (29, 'iShares', 'IGSB',61.23,'Corporate bonds');
INSERT INTO sc_securities (s_id, s_name, s_code, s_ltp, s_asset_class) VALUES (30, 'BlackRock', 'BLRC',97.21,'Corporate bonds');
  
  
  
  
  

INSERT INTO sc_users (
    first_name, last_name, date_of_birth, email, phone_number, username, user_password) 
    VALUES ('Aryan', 'Sinha', TO_DATE('01/03/2000', 'DD/MM/YYYY'),  'aryan@smallchange.com', '+91-9999999999', 'Aryan', 'aryan'); 

INSERT INTO sc_users (
    first_name, last_name, date_of_birth, email, phone_number, username, user_password) 
    VALUES ('Tharun', 'Bhargav Annamalai', TO_DATE('01/04/2000', 'DD/MM/YYYY'),  'tharun@smallchange.com', '+91-9999999998', 'Tharun', 'tharun'); 

INSERT INTO sc_users (
    first_name, last_name, date_of_birth, email, phone_number, username, user_password) 
    VALUES ('Akilesh', 'N S', TO_DATE('01/05/2000', 'DD/MM/YYYY'),  'akilesh@smallchange.com', '+91-9999999997', 'Akilesh', 'akilesh'); 
    
INSERT INTO sc_users (
    first_name, last_name, date_of_birth, email, phone_number, username, user_password) 
    VALUES ('Akshay', 'V Nayak', TO_DATE('01/06/2000', 'DD/MM/YYYY'),  'Akshay@smallchange.com', '+91-9999999996', 'Akshay', 'akshay');
    
INSERT INTO sc_users (
    first_name, last_name, date_of_birth, email, phone_number, username, user_password) 
    VALUES ('Sandhya', 'Ramesh', TO_DATE('01/07/2000', 'DD/MM/YYYY'),  'Sandhya@smallchange.com', '+91-9999999995', 'Sandhya', 'sandhya');


INSERT INTO sc_preferences (username, purpose, risk_tolerance, income_category, length_of_investment) VALUES
('Aryan', 'Trading', 3, 'Middle', '3 Years');

INSERT INTO sc_preferences (username, purpose, risk_tolerance, income_category, length_of_investment) VALUES
('Tharun', 'College Tuition', 3, 'Upper', '1 Year');

INSERT INTO sc_preferences (username, purpose, risk_tolerance, income_category, length_of_investment) VALUES
('Akilesh', 'Trading', 3, 'Middle', '5 Years');

INSERT INTO sc_preferences (username, purpose, risk_tolerance, income_category, length_of_investment) VALUES
('Akshay', 'Trading', 3, 'Upper', '2 Years');

INSERT INTO sc_preferences (username, purpose, risk_tolerance, income_category, length_of_investment) VALUES
('Sandhya', 'Debt', 3, 'Middle', '7 Years');
  