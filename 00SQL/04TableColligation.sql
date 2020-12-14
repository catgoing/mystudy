
/*
    Table 
        가로 row, 세로 column
        
        명령어
    만들기 create
    지우기 drop
    바꾸기 alter
        
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
    
    
-- TABLE COPY(데이터 포함)
CREATE TABLE TB_TEST03
AS SELECT
    *
FROM employees;

-- DROP TABLE TB_TEST03;

CREATE TABLE TB_TEST03(EMPNO, ENAME, SAL) -- 원하는 컬럼명으로
AS SELECT employee_id, first_name, salary -- 원하는 데이터만 선택
FROM employees;

CREATE TABLE TB_DEPTGROUP(DNUM, DCOUNT)
AS SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;

-- TABLE COPY(데이터 미포함)
CREATE TABLE TB_TEST04
AS SELECT
    *
FROM departments
WHERE 1 = 2;

CREATE TABLE DEPT_EMP(EMPNO, SAL, DNAME, LOC)
AS SELECT e.employee_id, e.salary, d.department_name, d.location_id
FROM employees E, departments D
WHERE e.department_id = d.department_id;
    -- AND 1 = 2; -- 데이터까지 복사할 때는 이 부분 삭제
    
/* 테이블 수정 */
-- 테이블명 변경
ALTER TABLE TB_TEST04
RENAME
TO
TB_TEST99;

-- 컬럼 추가
ALTER TABLE TB_TEST99 -- 하나의 컬럼 추가
ADD
NEWCOL VARCHAR2(20);

ALTER TABLE TB_TEST99  -- 다수의 컬럼 추가
ADD
(COLNEW1 NUMBER, COLNEW2 DATE);

-- 컬럼 수정
ALTER TABLE TB_TEST99
MODIFY
NEWCOL VARCHAR(30);

ALTER TABLE TB_TEST99
MODIFY
(COLNEW1 VARCHAR(20), COLNEW2 NUMBER);

-- 컬럼 삭제
ALTER TABLE TB_TEST99
DROP
COLUMN NEWCOL;

ALTER TABLE TB_TEST99
DROP
(COLNEW1, COLNEW2);

-- 컬럼명 수정
ALTER TABLE TB_TEST99
RENAME
COLUMN DEPARTMENT_ID
TO DEPTNO;

DROP TABLE TB_TEST99;

-- 휴지통 비우기 ---몰라도 됨 이건
--PURGE RECYCLEBIN;

-- INSERT
INSERT INTO TB_TEST04(department_id, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES(100, '기획부', 20, 200);

INSERT INTO TB_TEST04(department_id, DEPARTMENT_NAME)
VALUES(100, '기획부');

INSERT INTO TB_TEST04
VALUES(101, '관리부', 30, 400);

INSERT INTO TB_TEST04(MANAGER_ID, LOCATION_ID, department_id, DEPARTMENT_NAME)
VALUES(50, 500, 102, '영업부');

SELECT  *
FROM TB_TEST04;

-- DELETE
DELETE FROM tb_test04
WHERE manager_id = 20;


-- UPDATE
UPDATE tb_test04
SET MANAGER_ID = 40
WHERE department_name = '영업부';

UPDATE tb_test04
SET MANAGER_ID = 10, location_id = 100, department_id = 1000
WHERE department_name = '영업부';


/*
    무결성: column에 적용
            column에 지정하는 정실
            
    Primary Key: 기본키. Null이나 중복값 허용 X
    UNIQUE KEY: 고유키, 중복값 허용X,  NULL은 허용O
    FOREIGN KEY: 외래키, JOIN에 사용
                    외래키로 연결된 컬럼은 연결된 테이블에서
                    PK, UK로 설정되어 있어야 함
    CHECK:  범위를 설정. NULL 허용O
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

INSERT INTO TBTEST(COL2) -- 오류, COL1에 데이터가 없는 ROW이기 때문에
VALUES('222');

INSERT INTO TBTEST(COL1, COL2) -- 오류
VALUES('', '111');

DROP TABLE TBTEST
CASCADE CONSTRAINTS; -- 무결성이 있을 때에는 이 쿼리를 넣어줘야 다 지워짐

-- PRIMARY KEY = NOT NULL + UNIQUE
CREATE TABLE TBTEST(
    COLP VARCHAR2(10) CONSTRAINT PK_TEST PRIMARY KEY, -- = COLP VARCHAR2(10) PRIMARY KEY
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30) );
    
INSERT INTO TBTEST(COLP, COL1, COL2)
VALUES('AAA','111','aaa');

INSERT INTO TBTEST(COLP, COL1, COL2) -- COLP값 중복값 허용 안 됨
VALUES('AAA','112','aaa'); 
    
INSERT INTO TBTEST(COLP, COL1, COL2)
VALUES('BBB','111','aaa');    

INSERT INTO TBTEST(COL1, COL2) 
VALUES('111','aaa'); -- COLP에 NULL 허용 안 됨

INSERT INTO TBTEST(COLP, COL1, COL2) 
VALUES('', '111','aaa'); -- COLP에 NULL 허용 안 됨

SELECT
    *
FROM TBTEST;

DROP TABLE TBTEST;

-- UNIQUE: 컬럼에 중복값 허용 X, NULL은 허용 O
CREATE TABLE TBTEST(
    COLU VARCHAR2(10) CONSTRAINT UK_TEST UNIQUE, -- = COLU VARCHAR2(10) UNIQUE
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(20) );
    
INSERT INTO TBTEST(COLU, COL1, COL2)
VALUES('AAA','111','222');

INSERT INTO TBTEST(COLU, COL1, COL2) -- 오류, COLU에 같은 값 입력 불가
VALUES('AAA','112','222');

INSERT INTO TBTEST(COL1, COL2)  -- COLU에 NULL은 허용
VALUES('111','222');

ALTER TABLE TBTEST
DROP CONSTRAINT UK_TEST; -- COLU의 UNIQUE 지우기 


-- FOREIGN KEY
CREATE TABLE TBPARENT(
    COL_PK VARCHAR2(10) CONSTRAINT PK_PARENT PRIMARY KEY,
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(20)
    );

CREATE TABLE TBCHILD(
    KEY1 VARCHAR2(10),
    KEY2 VARCHAR2(10),
    COL_PK VARCHAR2(10), -- 외래키로 사용할 부분, PRIMARY KEY의 데이터 형식보다 크거나 같게 설정되어야 함
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
VALUES('55', '555', 'AA3'); -- 오류, FOREIGN KEY는 PRIMARY KEY와 대응되어야 함, 혹은 값이 NULL이거나
    
INSERT INTO TBCHILD(KEY1, KEY2)
VALUES('55', '555'); -- FOREIGN KEY에 NULL은 허용
    
SELECT
    *
FROM TBCHILD;

-- CHECK :  지정된 값 외에는 넣을 수 없고, NULL은 허용O
CREATE TABLE TBCHECK(
    COL1 VARCHAR2(10),
    KEY1 VARCHAR2(10),
    CONSTRAINT TB_CHK1 CHECK( COL1 IN('사과', '배', '바나나') ),
    CONSTRAINT TB_CHK2 CHECK( KEY1 > 0 AND KEY1 <= 100)
    );
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('사과', 12);
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('배', 0); -- 오류 KEY1 값 범위 밖의 값임
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('', 25); -- NULL 허용
    
    INSERT INTO TBCHECK(COL1, KEY1)
    VALUES('', ''); -- NULL 허용
    
SELECT
    *
FROM TBCHECK;
    
    