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

DROP TABLE BANK_USER;
DROP TABLE ACCOUNTS;
DROP TABLE TRANSACTION_HISTORY;
REVOKE ALL ON BEAR FROM PUBLIC;
REVOKE ALL ON BEAR_BEEHIVE FROM PUBLIC;
REVOKE ALL ON BEAR_TYPE FROM PUBLIC;
REVOKE ALL ON BEEHIVE FROM PUBLIC;
REVOKE ALL ON CAVE FROM PUBLIC;

CREATE TABLE BANK_USER (
    USER_ID INTEGER PRIMARY KEY, --ADDING PK TO THIS COLUMN
    USERNAME VARCHAR2(100) NOT NULL,
    USERPASSWORD INTEGER NOT NULL
);
/
CREATE TABLE ACCOUNTS(
    ACCOUNT_ID INTEGER PRIMARY KEY,
    USER_ID INTEGER,
    ACCOUNTS_TYPE VARCHAR2(100) NOT NULL,
    ACCOUNT_BALANCE NUMBER(8,2) 
);
/
CREATE TABLE TRANSACTION_HISTORY(
    TRANSACTION_ID INTEGER PRIMARY KEY,
    ACCOUNT_ID INTEGER,
    --CURRENT_BALANCE NUMBER(5,2) NOT NULL, COMEBACK
    WITHDRAW NUMBER(3,2) NULL,
    DEPOSIT NUMBER(3,2) NULL
    );
/

ALTER TABLE ACCOUNTS
ADD CONSTRAINT FK_USER_ID
FOREIGN KEY (USER_ID) REFERENCES BANK_USER(USER_ID);
/
ALTER TABLE TRANSACTION_HISTORY
ADD CONSTRAINT FK_ACCOUNT_ID
FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNTS(ACCOUNT_ID);
/

--TIGGERS, LATER
--UPDATE ACCOUNT BALANCE, 
--UPDATE USERNAME/PASSWORD
--STORED PROCE FOR USER ID/BANK ACCOUNT ID

CREATE SEQUENCE SQ_USER_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_ACCOUNT_PK
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

UPDATE ACCOUNTS SET ACCOUNT_BALANCE= 500.00 WHERE USER_ID = 1;

ALTER TABLE BANK_USER
ADD CONSTRAINT CHECK_PASSWORD
CHECK (LENGTH(USERPASSWORD) >= 4);
/

ALTER TABLE ACCOUNTS
ADD CONSTRAINT CHECK_ACCOUNT_TYPE
CHECK (ACCOUNTS_TYPE IN ('SAVINGS', 'CHECKING'));
/

CREATE OR REPLACE PROCEDURE WITHDRAW_SP(ACCOUNTID IN NUMBER, WITHDRAW IN NUMBER)
IS
  CURRENT_BALANCE NUMBER;
BEGIN
  SELECT ACCOUNT_BALANCE
    INTO CURRENT_BALANCE
    FROM ACCOUNTS
    WHERE ACCOUNT_ID = ACCOUNTID;
  IF CURRENT_BALANCE > WITHDRAW THEN
    UPDATE ACCOUNTS
      SET ACCOUNT_BALANCE = CURRENT_BALANCE - WITHDRAW
      WHERE ACCOUNT_ID = ACCOUNTID;
    UPDATE TRANSACTION_HISTORY
     SET WITHDRAW = WITHDRAW
     WHERE ACCOUNT_ID = ACCOUNTID;
  END IF; 
END;
/

DECLARE
BEGIN WITHDRAW_SP(1, 15);
END;

CREATE SEQUENCE SQ_TRANSACTION_PK
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGE
FOR EACH ROW R TR_ACCOUNTSTRANSACTION
AFTER UPDATE ON 
BEGIN 
    SELECT SQ_TRANSACTION_PK.NEXTVAL INTO :NEW.TRANSACTION_ID FROM DUAL;
END;
/

O
