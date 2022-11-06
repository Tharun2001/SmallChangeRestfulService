drop table sc_securities;
drop table sc_stock_securities;

CREATE TABLE sc_securities (
    s_id NUMBER(6,0) PRIMARY KEY,
    s_name  VARCHAR2(200) NOT NULL,
    s_code VARCHAR2(200) NOT NULL UNIQUE,
    s_ltp DECIMAL(10,2) NOT NULL,
    s_asset_class VARCHAR2(200)
);

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

COMMIT;