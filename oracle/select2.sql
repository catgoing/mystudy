SELECT
    *
FROM EMP;

-- 현재 스키마의 모든 테이블 출력
SELECT
    *
FROM TAB;

-- 테이블의 컬럼 출력
DESC EMP;

SELECT EMPNO, ENAME, SAL
FROM EMP;

-- DUAL: 가상테이블
SELECT SYSDATE FROM DUAL;
SELECT 4*7 FROM DUAL;

-- 문자와 숫자, 문자와 문자의 연산도 가능
SELECT '4' * 7 FROM DUAL;
SELECT '4' * '7' FROM DUAL;
-- 문자열 합치기
SELECT 'HELLO'|| ' ' ||'ORACLE ' FROM DUAL;
-- 반올림
SELECT ROUND(10.5) FROM DUAL;

SELECT ENAME, SAL, SAL * 12
FROM EMP;

-- ALIAS(컬럼정보), AS = as, as 안 써도 됨
SELECT ENAME AS 이름, SAL as 월급, SAL * 12 "연 봉"
FROM EMP;

-- DISTINCT: 중복된 행데이터 삭제, GROUP BY
SELECT DISTINCT deptno
FROM EMP;

SELECT DISTINCT JOB FROM EMP;

--1 사원번호, 사원이름, 월급 출력
SELECT EMPNO, ENAME, SAL FROM EMP;

--2 사원이름, 월급  -> 이 름, 월 급으로 출력
SELECT ENAME AS "이 름", SAL AS "월 급" FROM EMP;

--3 사원번호, 사원이름, 월급, 연봉 ---> 사원번호, 사원이름, 월급, 연봉으로 출력
SELECT EMPNO AS 사원번호, ENAME AS 사원이름, SAL AS 월급, SAL*12 AS 연봉 FROM EMP;

--4 JOB을 중복값 제외하고 출력
SELECT DISTINCT JOB FROM EMP;

--5 사원명과 업무를 연결하고 EMPLOYEE AND JOB으로 컬럼 설정
SELECT ENAME || ', ' || JOB AS "EMPLOYEE AND JOB" FROM EMP;



