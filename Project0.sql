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

ALTER TABLE BANK_USER
ADD CONSTRAINT CHECK_PASSWORD
CHECK (LENGTH(USERPASSWORD) >= 4);
/

ALTER TABLE ACCOUNTS
ADD CONSTRAINT CHECK_ACCOUNT_TYPE
CHECK (ACCOUNTS_TYPE IN ('SAVINGS', 'CHECKING'));
/

CREATE OR REPLACE PROCEDURE SP_WITHDRAW
    (
    A_ACCOUNTID IN NUMBER,
    A_AMOUNT IN NUMBER,
    CUR_BAL OUT NUMBER
    )
IS
AA_EXISTS INTEGER;
AA_BALANCE NUMBER;
AA_CURRENT NUMBER;
BEGIN 
    SELECT COUNT(AA.ACCOUNT_ID)
    INTO AA_EXISTS
    FROM ACCOUNTS AA
    WHERE AA.ACCOUNT_ID = A_ACCOUNTID;
    
    SELECT ACCOUNT_BALANCE
    INTO AA_BALANCE
    FROM ACCOUNTS
    WHERE ACCOUNT_ID = A_ACCOUNTID;
    
    --IF ACCOUNT EXISTS THEN UPDATE ACCOUNT BALANCE 
    IF AA_EXISTS > 0 THEN
        UPDATE
            ACCOUNTS
        SET
            AA_CURRENT = AA_BALANCE + A_AMOUNT
        WHERE 
            ACCOUNT_ID = A_ACCOUNTID;
        --SET RETURN BALANCE
            CUR_BAL := AA_CURRENT;
        UPDATE
            TRANSACTION_HISTORY
        SET
            WITHDRAW = A_AMOUNT
        WHERE
            ACCOUNT_ID = A_ACCOUNTID;
    ELSE
        CUR_BAL := 0;
    END IF;
    COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
        CUR_BAL := 0;
        ROLLBACK;
END;
/
CREATE OR REPLACE PROCEDURE SP_DEPOSIT
    (
    A_ACCOUNTID IN NUMBER,
    A_AMOUNT IN NUMBER,
    CUR_BAL OUT NUMBER
    )
IS
AA_EXISTS INTEGER;
AA_BALANCE NUMBER;
BEGIN 
    SELECT COUNT(AA.ACCOUNT_ID)
    INTO AA_EXISTS
    FROM ACCOUNTS AA
    WHERE AA.ACCOUNT_ID = A_ACCOUNTID;
    
    --IF ACCOUNT EXISTS THEN UPDATE ACCOUNT BALANCE 
    IF AA_EXISTS > 0 THEN
        UPDATE
            ACCOUNTS
        SET
            AA_BALANCE = ACCOUNT_BALANCE + A_AMOUNT
        WHERE 
            ACCOUNT_ID = A_ACCOUNTID;
        --SET RETURN BALANCE
            CUR_BAL := AA_BALANCE;
        UPDATE
            TRANSACTION_HISTORY
        SET
            DEPOSIT = A_AMOUNT
        WHERE
            ACCOUNT_ID = A_ACCOUNTID;
    ELSE
        CUR_BAL := 0;
    END IF;
    COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
        CUR_BAL := 0;
        ROLLBACK;
END;
/

