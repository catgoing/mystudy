SELECT
    *
FROM EMPLOYEES;


select * from employees;

-- �� �� �ּ���
/*
���� �ּ���
*/

-- table    : column(�׸�), row(�ϳ��� ������)
-- tabelspace memory���� -> ����

-- table ����
/*
CREATE TABLE ���̺��(
    �÷���1 �ڷ���,
    �÷���2 �ڷ���,
    �÷���3 �ڷ���
)
DROP TABLE ���̺��; -- ���̺� �����
*/

-- �ڷ���
/*
    Java        Oracle
    int         Integer, NUMBER
    double      NUMBER(����, �Ҽ�)
    String      VARCHAR2, CHAR, LONG
    Date        DATE
*/    

-- ���ڿ�
-- CHAR

CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

/*
    INSERT INTO ���̺��(�÷���1, �÷���2, �÷���3)
    VALUES(��1, ��2, ��3);
    
    INTEGER -> 123
    STRING -> 'HELLO'
    
    ���� 1���� -> 1BYTE
    �ѱ� 1���� -> 3BYTE
    
*/

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('��', '����', '������');

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM tb_char;

/*
    CHAR : 10BYTE ---> 00000 00000
            ABC �Է� -> ABC00 00000
            �� �Է� --> ��0000  00000  / 3����Ʈ + ������ 9����Ʈ = 12����Ʈ
            

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
VALUES('������', '������', '������');

SELECT
    *
FROM tb_varchar;

SELECT COL1, COL2, COL3, LENGTHB(COL1), LENGTHB(COL2), LENGTHB(COL3)
FROM tb_varchar;

/*
LONG
  �ִ� 2GB���� ����
  1�� TABLE �� 1���� ��� ����
  select 
    
*/    

/* ����
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

-- SELECT COL1, LENGTHB(COL1) / LONG�� LENGTHB ��� �Ұ�
-- FROM TB_LONG;

-- ����(����, �Ҽ�)
-- INTEGER

CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123, 456.1);

SELECT * FROM tb_integer;

INSERT INTO tb_integer(COL1, COL2)
VALUES('123', '456');  -- ���ڿ��� �ִ� �͵� ������

-- NUMBER ����, �Ҽ�
CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES(1234.5678, 12345.12, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

-- ��¥ DATE

-- ��, ��, ��, ��, ��, ��
CREATE TABLE TB_DATE(
    COL1 DATE,
    COL2 DATE
);

INSERT INTO TB_DATE(COL1, COL2)
VALUES(SYSDATE, SYSDATE -1);

SELECT * FROM TB_DATE;

-- TO_DATE(��¥ ���ڿ�, ���� ���ڿ�)
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






