CREATE TABLE userInfo(
    user_id VARCHAR2(20) PRIMARY KEY,
    user_pw VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(20) NOT NULL,
    user_birth NUMBER NOT NULL,
    user_phone NUMBER NOT NULL
    );
    
CREATE TABLE calender(
    c_id VARCHAR2(20) NOT NULL,
    c_date NUMBER NOT NULL,
    c_category VARCHAR2(20) NOT NULL,
    c_name VARCHAR2(30) NOT NULL,
    c_price NUMBER NOT NULL
    );