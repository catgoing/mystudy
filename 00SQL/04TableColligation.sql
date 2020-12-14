
/*
    Table 
        ���� row, ���� column
        
        ��ɾ�
    ����� create
    ����� drop
    �ٲٱ� alter
        
        Data
            insert
            delete
            select
            update

*/

CREATE TABLE TB_TEST01(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(10),
    COL3 VARCHAR2(10)
    );


CREATE TABLE TB_TEST02(
    COL1 VARCHAR2(10),
    COL2 NUMBER(5, 1),
    COL3 DATE
    );
    
    
-- TABLE COPY(������ ����)
CREATE TABLE TB_TEST03
AS SELECT
    *
FROM employees;

-- DROP TABLE TB_TEST03;

CREATE TABLE TB_TEST03(EMPNO, ENAME, SAL) -- ���ϴ� �÷�������
AS SELECT employee_id, first_name, salary -- ���ϴ� �����͸� ����
FROM employees;

CREATE TABLE TB_DEPTGROUP(DNUM, DCOUNT)
AS SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;

-- TABLE COPY(������ ������)
CREATE TABLE TB_TEST04
AS SELECT
    *
FROM departments
WHERE 1 = 2;

CREATE TABLE DEPT_EMP(EMPNO, SAL, DNAME, LOC)
AS SELECT e.employee_id, e.salary, d.department_name, d.location_id
FROM employees E, departments D
WHERE e.department_id = d.department_id;
    -- AND 1 = 2; -- �����ͱ��� ������ ���� �� �κ� ����
    
/* ���̺� ���� */
-- ���̺�� ����
ALTER TABLE TB_TEST04
RENAME
TO
TB_TEST99;

-- �÷� �߰�
ALTER TABLE TB_TEST99 -- �ϳ��� �÷� �߰�
ADD
NEWCOL VARCHAR2(20);

ALTER TABLE TB_TEST99  -- �ټ��� �÷� �߰�
ADD
(COLNEW1 NUMBER, COLNEW2 DATE);

-- �÷� ����
ALTER TABLE TB_TEST99
MODIFY
NEWCOL VARCHAR(30);

ALTER TABLE TB_TEST99
MODIFY
(COLNEW1 VARCHAR(20), COLNEW2 NUMBER);

-- �÷� ����
ALTER TABLE TB_TEST99
DROP
COLUMN NEWCOL;

ALTER TABLE TB_TEST99
DROP
(COLNEW1, COLNEW2);

-- �÷��� ����
ALTER TABLE TB_TEST99
RENAME
COLUMN DEPARTMENT_ID
TO DEPTNO;

DROP TABLE TB_TEST99;

-- ������ ���� ---���� �� �̰�
--PURGE RECYCLEBIN;

-- INSERT
INSERT INTO TB_TEST04(department_id, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES(100, '��ȹ��', 20, 200);

INSERT INTO TB_TEST04(department_id, DEPARTMENT_NAME)
VALUES(100, '��ȹ��');

INSERT INTO TB_TEST04
VALUES(101, '������', 30, 400);

INSERT INTO TB_TEST04(MANAGER_ID, LOCATION_ID, department_id, DEPARTMENT_NAME)
VALUES(50, 500, 102, '������');

SELECT  *
FROM TB_TEST04;

-- DELETE
DELETE FROM tb_test04
WHERE manager_id = 20;


-- UPDATE
UPDATE tb_test04
SET MANAGER_ID = 40
WHERE department_name = '������';

UPDATE tb_test04
SET MANAGER_ID = 10, location_id = 100, department_id = 1000
WHERE department_name = '������';


/*
    ���Ἲ: column�� ����
            column�� �����ϴ� ����
            
    Primary Key: �⺻Ű. Null�̳� �ߺ��� ��� X
    UNIQUE KEY: ����Ű, �ߺ��� ���X,  NULL�� ���O
    FOREIGN KEY: �ܷ�Ű, JOIN�� ���
                    �ܷ�Ű�� ����� �÷��� ����� ���̺���
                    PK, UK�� �����Ǿ� �־�� ��
    CHECK:  ������ ����. NULL ���O
    NOT NULL

*/

-- NOT NUMM
CREATE TABLE TBTEST(
    COL1 VARCHAR2(10) NOT NULL,
    COL2 VARCHAR2(20) );

INSERT INTO TBTEST(COL1, COL2)
VALUES('AAA', '111');

INSERT INTO TBTEST(COL1)
VALUES('BBB');

INSERT INTO TBTEST(COL2) -- ����, COL1�� �����Ͱ� ���� ROW�̱� ������
VALUES('222');

INSERT INTO TBTEST(COL1, COL2) -- ����
VALUES('', '111');

DROP TABLE TBTEST
CASCADE CONSTRAINTS; -- ���Ἲ�� ���� ������ �� ������ �־���� �� ������

-- PRIMARY KEY = NOT NULL + UNIQUE
CREATE TABLE TBTEST(
    COLP VARCHAR2(10) CONSTRAINT PK_TEST PRIMARY KEY, -- = COLP VARCHAR2(10) PRIMARY KEY
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30) );
    
INSERT INTO TBTEST(COLP, COL1, COL2)
VALUES('AAA','111','aaa');

INSERT INTO TBTEST(COLP, COL1, COL2) -- COLP�� �ߺ��� ��� �� ��
VALUES('AAA','112','aaa'); 
    
INSERT INTO TBTEST(COLP, COL1, COL2)
VALUES('BBB','111','aaa');    

INSERT INTO TBTEST(COL1, COL2) 
VALUES('111','aaa'); -- COLP�� NULL ��� �� ��

INSERT INTO TBTEST(COLP, COL1, COL2) 
VALUES('', '111','aaa'); -- COLP�� NULL ��� �� ��

SELECT
    *
FROM TBTEST;

DROP TABLE TBTEST;

-- UNIQUE: �÷��� �ߺ��� ��� X, NULL�� ��� O
CREATE TABLE TBTEST(
    COLU VARCHAR2(10) CONSTRAINT UK_TEST UNIQUE, -- = COLU VARCHAR2(10) UNIQUE
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(20) );
    
INSERT INTO TBTEST(COLU, COL1, COL2)
VALUES('AAA','111','222');

INSERT INTO TBTEST(COLU, COL1, COL2) -- ����, COLU�� ���� �� �Է� �Ұ�
VALUES('AAA','112','222');

INSERT INTO TBTEST(COL1, COL2)  -- COLU�� NULL�� ���
VALUES('111','222');

ALTER TABLE TBTEST
DROP CONSTRAINT UK_TEST; -- COLU�� UNIQUE ����� 


-- FOREIGN KEY
CREATE TABLE TBPARENT(
    COL_PK VARCHAR2(10) CONSTRAINT PK_PARENT PRIMARY KEY,
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(20)
    );

CREATE TABLE TBCHILD(
    KEY1 VARCHAR2(10),
    KEY2 VARCHAR2(10),
    COL_PK VARCHAR2(10), -- �ܷ�Ű�� ����� �κ�, PRIMARY KEY�� ������ ���ĺ��� ũ�ų� ���� �����Ǿ�� ��
    CONSTRAINT FK_CHILD FOREIGN KEY(COL_PK) REFERENCES TBPARENT(COL_PK)
);

INSERT INTO TBPARENT(COL_PK, COL1, COL2)
VALUES('AAA', '11', '222');

INSERT INTO TBPARENT(COL_PK, COL1, COL2)
VALUES('AA1', '22', '333');

INSERT INTO TBPARENT(COL_PK, COL1, COL2)
VALUES('AA2', '33', '444');


INSERT INTO TBCHILD(KEY1, KEY2, COL_PK)
VALUES('55', '555', 'AAA');

INSERT INTO TBCHILD(KEY1, KEY2, COL_PK)
VALUES('55', '555', 'AA3'); -- ����, FOREIGN KEY�� PRIMARY KEY�� �����Ǿ�� ��, Ȥ�� ���� NULL�̰ų�
    
INSERT INTO TBCHILD(KEY1, KEY2)
VALUES('55', '555'); -- FOREIGN KEY�� NULL�� ���
    
SELECT
    *
FROM TBCHILD;

-- CHECK :  ������ �� �ܿ��� ���� �� ����, NULL�� ���O
CREATE TABLE TBCHECK(
    COL1 VARCHAR2(10),
    KEY1 VARCHAR2(10),
    CONSTRAINT TB_CHK1 CHECK( COL1 IN('���', '��', '�ٳ���') ),
    CONSTRAINT TB_CHK2 CHECK( KEY1 > 0 AND KEY1 <= 100)
    );
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('���', 12);
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('��', 0); -- ���� KEY1 �� ���� ���� ����
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('', 25); -- NULL ���
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('', ''); -- NULL ���
    
SELECT
    *
FROM TBCHECK;
    
    