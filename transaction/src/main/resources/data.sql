CREATE TABLE IF NOT EXISTS TRANSACTION (ID BIGINT NOT NULL AUTO_INCREMENT, ACCOUNT_NUMBER VARCHAR(17),
 CREATED_DATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),UPDATED_DATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP(), PLAYER_ID BIGINT NOT NULL, STATUS INTEGER NOT NULL ,TYPE INTEGER NOT NULL ,
  TRANSACTION_ID VARCHAR(36) NOT NULL , PRIMARY KEY (ID));

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, 'BECDE22B-4CCB-42F3-966E-AFEBFCA930A1');

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, 'BECDE22B-4CCB-42F3-966E-AFEBFCA930A2');

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, 'BECDE22B-4CCB-42F3-966E-AFEBFCA930A3');

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, 'BECDE22B-4CCB-42F3-966E-AFEBFCA930A4');

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, 'BECDE22B-4CCB-42F3-966E-AFEBFCA930A5');

COMMIT ;