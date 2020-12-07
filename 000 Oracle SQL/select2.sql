SELECT
    *
FROM EMP;

-- ���� ��Ű���� ��� ���̺� ���
SELECT
    *
FROM TAB;

-- ���̺��� �÷� ���
DESC EMP;

SELECT EMPNO, ENAME, SAL
FROM EMP;

-- DUAL: �������̺�
SELECT SYSDATE FROM DUAL;
SELECT 4*7 FROM DUAL;

-- ���ڿ� ����, ���ڿ� ������ ���굵 ����
SELECT '4' * 7 FROM DUAL;
SELECT '4' * '7' FROM DUAL;
-- ���ڿ� ��ġ��
SELECT 'HELLO'|| ' ' ||'ORACLE ' FROM DUAL;
-- �ݿø�
SELECT ROUND(10.5) FROM DUAL;

SELECT ENAME, SAL, SAL * 12
FROM EMP;

-- ALIAS(�÷�����), AS = as, as �� �ᵵ ��
SELECT ENAME AS �̸�, SAL as ����, SAL * 12 "�� ��"
FROM EMP;

-- DISTINCT: �ߺ��� �൥���� ����, GROUP BY
SELECT DISTINCT deptno
FROM EMP;

SELECT DISTINCT JOB FROM EMP;

--1 �����ȣ, ����̸�, ���� ���
SELECT EMPNO, ENAME, SAL FROM EMP;

--2 ����̸�, ����  -> �� ��, �� ������ ���
SELECT ENAME AS "�� ��", SAL AS "�� ��" FROM EMP;

--3 �����ȣ, ����̸�, ����, ���� ---> �����ȣ, ����̸�, ����, �������� ���
SELECT EMPNO AS �����ȣ, ENAME AS ����̸�, SAL AS ����, SAL*12 AS ���� FROM EMP;

--4 JOB�� �ߺ��� �����ϰ� ���
SELECT DISTINCT JOB FROM EMP;

--5 ������ ������ �����ϰ� EMPLOYEE AND JOB���� �÷� ����
SELECT ENAME || ', ' || JOB AS "EMPLOYEE AND JOB" FROM EMP;



