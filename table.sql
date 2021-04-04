CREATE TABLE userInfo(
    user_id VARCHAR2(20) PRIMARY KEY,
    user_pw VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(20) NOT NULL,
    user_birth NUMBER NOT NULL,
    user_phone NUMBER NOT NULL
    );
    
CREATE TABLE calendar(
		c_no NUMBER PRIMARY KEY,
	    c_id VARCHAR2(50) NOT NULL,
	    c_date NUMBER NOT NULL,
	    c_category VARCHAR2(50) NOT NULL,
	    c_name VARCHAR2(50) NOT NULL,
	    c_price NUMBER NOT NULL
	    );
	    
CREATE SEQUENCE calendar_seq
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE
START WITH 1;