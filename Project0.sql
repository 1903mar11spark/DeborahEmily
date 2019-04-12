--User for partner
CREATE USER Project0
IDENTIFIED BY EmilyB
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to Project0;
GRANT resource to Project0;
GRANT create session TO Project0;
GRANT create table TO Project0;
GRANT create view TO Project0;
conn Project0/EmilyB
--
DROP TABLE BANK_USER CASCADE CONSTRAINTS;
DROP TABLE ACCOUNTS CASCADE CONSTRAINTS;
DROP TABLE TRANSACTION_HISTORY CASCADE CONSTRAINTS;
DROP SEQUENCE SQ_USER_PK;
DROP SEQUENCE SQ_ACCOUNT_PK;
DROP SEQUENCE SQ_TRANSACTION_PK;
REVOKE ALL ON BEAR FROM PUBLIC;
REVOKE ALL ON BEAR_BEEHIVE FROM PUBLIC;
REVOKE ALL ON BEAR_TYPE FROM PUBLIC;
REVOKE ALL ON BEEHIVE FROM PUBLIC;
REVOKE ALL ON CAVE FROM PUBLIC;
CREATE TABLE BANK_USER (--ADD TO MORE COLUNMS SUPER_LOGIN!!!
    USER_ID INTEGER PRIMARY KEY, --ADDING PK TO THIS COLUMN
    USERNAME VARCHAR2(100) NOT NULL,
    USERPASSWORD INTEGER NOT NULL
);
/
CREATE TABLE ACCOUNTS(
    ACCOUNT_ID INTEGER PRIMARY KEY,
    USER_ID INTEGER,
    ACCOUNTS_TYPE VARCHAR2(100),
    ACCOUNT_BALANCE NUMBER 
);
/
CREATE TABLE TRANSACTION_HISTORY(
    TRANSACTION_ID INTEGER PRIMARY KEY,
    ACCOUNT_ID INTEGER,
    --CURRENT_BALANCE NUMBER(5,2) NOT NULL, COMEBACK
    WITHDRAW NUMBER(8,2) ,
    DEPOSIT NUMBER(8,2) 
    );
/
ALTER TABLE ACCOUNTS
ADD CONSTRAINT FK_USER_ID 
FOREIGN KEY (USER_ID) REFERENCES BANK_USER(USER_ID)ON DELETE CASCADE;
/
ALTER TABLE ACCOUNTS
MODIFY ACCOUNT_BALANCE DEFAULT 0; 
/
ALTER TABLE ACCOUNTS
MODIFY ACCOUNTS_TYPE DEFAULT 'CHECKING';
/
ALTER TABLE TRANSACTION_HISTORY
ADD CONSTRAINT FK_ACCOUNT_ID
FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNTS(ACCOUNT_ID)ON DELETE CASCADE;
/
ALTER TABLE TRANSACTION_HISTORY
MODIFY WITHDRAW DEFAULT 0;
/
ALTER TABLE TRANSACTION_HISTORY
MODIFY DEPOSIT DEFAULT 0;
/
ALTER TABLE BANK_USER
ADD CONSTRAINT CHECK_PASSWORD
CHECK (LENGTH(USERPASSWORD) >= 4);
/
ALTER TABLE ACCOUNTS
ADD CONSTRAINT CHECK_ACCOUNT_TYPE
CHECK (ACCOUNTS_TYPE IN ('SAVINGS', 'CHECKING'));
/
--STORED PROCE FOR USER ID/BANK ACCOUNT ID
CREATE SEQUENCE SQ_USER_PK
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_ACCOUNT_PK
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_TRANSACTION_PK
START WITH 1
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER TR_INSERT_USER
BEFORE INSERT ON BANK_USER
FOR EACH ROW 
BEGIN 
    SELECT SQ_USER_PK.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TR_INSERT_ACCOUNT
BEFORE INSERT ON ACCOUNTS 
FOR EACH ROW 
BEGIN 
    SELECT SQ_ACCOUNT_PK.NEXTVAL INTO :NEW.ACCOUNT_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TR_INSERT_TRANSACTION
BEFORE INSERT ON TRANSACTION_HISTORY
FOR EACH ROW 
BEGIN 
    SELECT SQ_TRANSACTION_PK.NEXTVAL INTO :NEW.TRANSACTION_ID FROM DUAL;
END;
/
INSERT ALL
    INTO BANK_USER (USERNAME, USERPASSWORD) VALUES ('hgranger', '111111')
    INTO BANK_USER (USERNAME, USERPASSWORD) VALUES ('hpotter', '222222')
    INTO BANK_USER (USERNAME, USERPASSWORD) VALUES ('rweasley', '333333')
    INTO BANK_USER (USERNAME, USERPASSWORD) VALUES ('dmalfoy', '444444')
SELECT * FROM DUAL;
INSERT ALL
    INTO ACCOUNTS (USER_ID, ACCOUNTS_TYPE, ACCOUNT_BALANCE) VALUES (1,'SAVINGS', 30.00)
    INTO ACCOUNTS (USER_ID, ACCOUNTS_TYPE, ACCOUNT_BALANCE) VALUES (1,'CHECKING', 39.00)
    INTO ACCOUNTS (USER_ID, ACCOUNTS_TYPE, ACCOUNT_BALANCE) VALUES (3,'CHECKING', 20.00)
    INTO ACCOUNTS (USER_ID, ACCOUNTS_TYPE, ACCOUNT_BALANCE) VALUES (2,'SAVINGS', 10.00)
SELECT * FROM DUAL;
UPDATE ACCOUNTS SET ACCOUNT_BALANCE= 500.00 WHERE USER_ID = 66;
INSERT INTO BANK_USER (USERNAME,USERPASSWORD) VALUES ('nlongbottom', 555555);
INSERT INTO ACCOUNTS (USER_ID) VALUES (5);
INSERT INTO TRANSACTION_HISTORY (ACCOUNT_ID, DEPOSIT) VALUES (9,100);
CREATE OR REPLACE PROCEDURE WITHDRAW_SP (ACCOUNTID IN NUMBER, WITHDRAW IN NUMBER)
IS
  CURRENT_BALANCE NUMBER;
BEGIN
    SELECT ACCOUNT_BALANCE
        INTO CURRENT_BALANCE
        FROM ACCOUNTS
        WHERE ACCOUNT_ID = ACCOUNTID;
  
    UPDATE ACCOUNTS
        SET ACCOUNT_BALANCE = CURRENT_BALANCE - WITHDRAW
        WHERE ACCOUNT_ID = ACCOUNTID;
    
    INSERT INTO TRANSACTION_HISTORY (ACCOUNT_ID, WITHDRAW)
    VALUES (ACCOUNTID, WITHDRAW);
 
END;
/
CREATE OR REPLACE TRIGGER TR_TRANSACTION
BEFORE INSERT ON TRANSACTION_HISTORY
FOR EACH ROW 
BEGIN 
    SELECT SQ_TRANSACTION_PK.NEXTVAL INTO :NEW.TRANSACTION_ID FROM DUAL;
END;
/
CREATE OR REPLACE PROCEDURE DEPOSIT_SP(ACCOUNTID IN NUMBER, DEPOSIT IN NUMBER)
IS
  CURRENT_BALANCE NUMBER;
BEGIN
  SELECT ACCOUNT_BALANCE
    INTO CURRENT_BALANCE
    FROM ACCOUNTS
    WHERE ACCOUNT_ID = ACCOUNTID;
      UPDATE ACCOUNTS
      SET ACCOUNT_BALANCE = CURRENT_BALANCE + DEPOSIT
      WHERE ACCOUNT_ID = ACCOUNTID;
     INSERT INTO TRANSACTION_HISTORY (ACCOUNT_ID, DEPOSIT)
     VALUES (ACCOUNTID, DEPOSIT);
END;
/
CREATE OR REPLACE PROCEDURE CHANGE_PASSWORD(USER_NAME IN VARCHAR2, NEW_PASSWORD IN NUMBER)
IS
    PASS NUMBER;
BEGIN
    SELECT USERPASSWORD
    INTO PASS
    FROM BANK_USER
    WHERE USERNAME = USER_NAME;
    
    UPDATE BANK_USER 
    SET USERPASSWORD = NEW_PASSWORD
    WHERE USERNAME = USER_NAME;
END;
BEGIN
CHANGE_PASSWORD('nlongbottom', 999999);
END;
DELETE BANK_USER WHERE USERNAME = 'nlongbottom
INSERT INTO BANK_USER VALUES (5, 'nlongbottom', 555555)

SELECT ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID = 22;
