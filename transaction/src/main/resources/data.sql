CREATE TABLE IF NOT EXISTS TRANSACTION (ID BIGINT NOT NULL AUTO_INCREMENT, ACCOUNT_NUMBER VARCHAR(17),
 CREATED_DATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),UPDATED_DATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  PLAYER_ID BIGINT NOT NULL, STATUS INTEGER NOT NULL ,TYPE INTEGER NOT NULL , TRANSACTION_ID UUID NOT NULL , PRIMARY KEY (ID), UNIQUE (TRANSACTION_ID) );

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, '593ace26-3af3-49a2-a9f9-a44e16c4c7f4');

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, '05806489-b1d4-4b58-8355-ea2cfffe82eb');

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257466', 1, 1, 1, 'ac10e8fa-bb14-47bd-ba22-84788be7e996');

INSERT INTO TRANSACTION (ACCOUNT_NUMBER, PLAYER_ID, STATUS, TYPE, TRANSACTION_ID)  VALUES ('00000058398257467', 2, 1, 1, '8c10c408-0bfb-48ab-bca4-bd9db953a3cc');

COMMIT ;