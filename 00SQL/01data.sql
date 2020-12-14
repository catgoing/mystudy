SELECT
    *
FROM EMPLOYEES;


select * from employees;

-- 한 줄 주석문
/*
범위 주석문
*/

-- table    : column(항목), row(하나의 데이터)
-- tabelspace memory공간 -> 파일

-- table 생성
/*
CREATE TABLE 테이블명(
    컬럼명1 자료형,
    컬럼명2 자료형,
    컬럼명3 자료형
)
DROP TABLE 테이블명; -- 테이블 지우기
*/

-- 자료형
/*
    Java        Oracle
    int         Integer, NUMBER
    double      NUMBER(정수, 소수)
    String      VARCHAR2, CHAR, LONG
    Date        DATE
*/    

-- 문자열
-- CHAR

CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

/*
    INSERT INTO 테이블명(컬럼명1, 컬럼명2, 컬럼명3)
    VALUES(값1, 값2, 값3);
    
    INTEGER -> 123
    STRING -> 'HELLO'
    
    영어 1문자 -> 1BYTE
    한글 1문자 -> 3BYTE
    
*/

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('가', '가나', '가나다');

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM tb_char;

/*
    CHAR : 10BYTE ---> 00000 00000
            ABC 입력 -> ABC00 00000
            가 입력 --> 가0000  00000  / 3바이트 + 나머지 9바이트 = 12바이트
            

*/

-- VARCHAR2
CREATE TABLE TB_VARCHAR(
    COL1 VARCHAR2(10 BYTE),
    COL2 VARCHAR2(10 CHAR),
    COL3 VARCHAR2(10)
);

INSERT INTO tb_varchar(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');

INSERT INTO tb_varchar(COL1, COL2, COL3)
VALUES('가나다', '가나다', '가나다');

SELECT
    *
FROM tb_varchar;

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM tb_varchar;

/*
LONG
  최대 2GB까지 저장
  1개 TABLE 당 1개만 사용 가능
  select 
    
*/    

/* 오류
CREATE TABLE TB_LONG(
    COL1 LONG,
    COL2 LONG
);
*/

CREATE TABLE TB_LONG(
    COL1 LONG
);


CREATE TABLE BOOK(
    TITLE VARCHAR2(20),
    BOOKCONTENT LONG,
    NO NUMBER,
    PRICE NUMBER
);

INSERT INTO TB_LONG(COL1)
VALUES('FIEFJDKFJDFIEJFIDJFIEJIFJADBVB');

INSERT INTO TB_LONG(COL1)
VALUES('FIEFJDKFJDFIEJFIDJFIEJIFJADBVBASDASD');

SELECT * FROM TB_LONG;

-- SELECT COL1, LENGTHB(COL1) / LONG은 LENGTHB 사용 불가
-- FROM TB_LONG;

-- 숫자(정수, 소수)
-- INTEGER

CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123, 456.1);

SELECT * FROM tb_integer;

INSERT INTO tb_integer(COL1, COL2)
VALUES('123', '456');  -- 문자열로 넣는 것도 가능함

-- NUMBER 정수, 소수
CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES(1234.5678, 12345.12, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

-- 날짜 DATE

-- 연, 월, 일, 시, 분, 초
CREATE TABLE TB_DATE(
    COL1 DATE,
    COL2 DATE
);

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, SYSDATE -1);

SELECT * FROM TB_DATE;

-- TO_DATE(날짜 문자열, 형식 문자열)
INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('2020-12-25 12:30:25', 'YYYY-MM-DD HH:MI:SS'));

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, TO_DATE('20201225123025', 'YYYYMMDDHHMISS'));

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '2020-12-31');

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, '20/12/30');

SELECT * FROM TB_DATE;

DROP TABLE TB_CHAR;
DROP TABLE TB_VARCHAR;
DROP TABLE TB_LONG;
DROP TABLE TB_NUMBER;
DROP TABLE TB_INTEGER;
DROP TABLE TB_DATE;
DROP TABLE TN_INTEGER;






