CREATE TABLE IF NOT EXISTS PLAYER (ID BIGINT NOT NULL AUTO_INCREMENT, ACCOUNT_NUMBER VARCHAR(17) NOT NULL, FIRST_NAME VARCHAR(255) NOT NULL,
                                            LAST_NAME VARCHAR(255) NOT NULL , STATUS INTEGER, CREATED_DATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
                                            UPDATED_DATE_TIME TIMESTAMP, PRIMARY KEY (ID), UNIQUE (ACCOUNT_NUMBER));

INSERT INTO PLAYER (ACCOUNT_NUMBER, FIRST_NAME, LAST_NAME, STATUS)  values ('00000058398257466', 'Mohammad', 'Taghipour', 1);
INSERT INTO PLAYER (ACCOUNT_NUMBER, FIRST_NAME, LAST_NAME, STATUS)  values ('00000058398257467', 'Mohammad', 'Torabi', 1);
