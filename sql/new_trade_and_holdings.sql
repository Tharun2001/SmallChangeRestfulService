--------------------------------------------------------
--  File created - Wednesday-October-12-2022   
--------------------------------------------------------
DROP TABLE "SCOTT"."SC_TRADE";
DROP TABLE "SCOTT"."SC_HOLDING";
--------------------------------------------------------
--  DDL for Table SC_TRADE
--------------------------------------------------------

  CREATE TABLE "SCOTT"."SC_TRADE" 
   (	"TRADE_ID" NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"CLIENTID" VARCHAR2(255 BYTE), 
	"TRADE_TYPE" CHAR(1 BYTE), 
	"S_ID" NUMBER(6,0), 
	"QUANTITY" NUMBER(10,2), 
	"PRICE" NUMBER(10,2),
	"TRADE_TIME" TIMESTAMP(0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSAUX" ;
--------------------------------------------------------
--  DDL for Table SC_HOLDING
--------------------------------------------------------

  CREATE TABLE "SCOTT"."SC_HOLDING" 
   (	"HOLDING_ID" NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"S_ID" NUMBER, 
	"QTY" NUMBER(10,2), 
	"INVESTED_AMOUNT" NUMBER(10,2), 
	"CLIENTID" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "SYSAUX" ;
REM INSERTING into SCOTT.SC_TRADE
SET DEFINE OFF;
REM INSERTING into SCOTT.SC_HOLDING
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SC_TRADE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SC_TRADE_PK" ON "SCOTT"."SC_TRADE" ("TRADE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSAUX" ;
--------------------------------------------------------
--  DDL for Index SC_HOLDING_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SC_HOLDING_PK" ON "SCOTT"."SC_HOLDING" ("HOLDING_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSAUX" ;
--------------------------------------------------------
--  Constraints for Table SC_TRADE
--------------------------------------------------------

  ALTER TABLE "SCOTT"."SC_TRADE" MODIFY ("TRADE_ID" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_TRADE" MODIFY ("CLIENTID" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_TRADE" MODIFY ("TRADE_TYPE" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_TRADE" MODIFY ("S_ID" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_TRADE" MODIFY ("QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_TRADE" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_TRADE" MODIFY ("TRADE_TIME" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_TRADE" ADD CONSTRAINT "SC_TRADE_PK" PRIMARY KEY ("TRADE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSAUX"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SC_HOLDING
--------------------------------------------------------

  ALTER TABLE "SCOTT"."SC_HOLDING" MODIFY ("HOLDING_ID" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_HOLDING" MODIFY ("S_ID" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_HOLDING" MODIFY ("QTY" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_HOLDING" MODIFY ("INVESTED_AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SC_HOLDING" ADD CONSTRAINT "SC_HOLDING_PK" PRIMARY KEY ("HOLDING_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "SYSAUX"  ENABLE;
  
  
  INSERT INTO SC_TRADE(CLIENTID,trade_type,S_ID,QUANTITY,PRICE,TRADE_TIME) VALUES('HVL491','B',1,10,100, CURRENT_TIMESTAMP);
  
  INSERT INTO SC_HOLDING(CLIENTID, S_ID, QTY,INVESTED_AMOUNT) VALUES('HVL491',1,10,1000);
  Insert into SCOTT.SC_HOLDING (CLIENTID, S_ID, QTY,INVESTED_AMOUNT) values ('HVL491', 2, 10, 5000);

  COMMIT;