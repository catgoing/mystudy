/*    FUNC    */

-- LIKE, ���Ե� ���� �˻�
SELECT first_name
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'G_ra_d';  --  _ -> �� ����

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'Al%';  --  ���Ե� ����

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%ex%';

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'K%y';

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%y';

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE first_name = ALL('Julia', 'John');
-- WHERE FIRST_NAME = 'Shanta' and first_name = 'John';

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE first_name = ANY('Julia', 'John');
-- WHERE FIRST_NAME = 'Shanta' OR first_name = 'John';

-- IN,   NOT IN
SELECT FIRST_NAME, salary
FROM employees
WHERE salary IN(8000, 3200, 6000); -- OR�� ����

SELECT FIRST_NAME, salary
FROM employees
WHERE salary NOT IN(8000, 3200, 6000);  -- OR�� �ݴ�

-- BETWEEN,  NOT BETWEEN : ����������
/*
 SALARY >= 3000 AND SALARY<= 9000
 SALARY BETWEEN 3200 AND 9000
*/

SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 3200 AND 9000;

SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY NOT BETWEEN 3200 AND 9000;

-- �������� ASC, �������� ���� DESC
SELECT ENAME, JOB, sal
FROM EMP
ORDER BY JOB ASC, SAL DESC;

-- NULL ��� ����
SELECT ENAME, comm
FROM EMP
ORDER BY COMM NULLS FIRST;

SELECT ENAME, comm
FROM EMP
ORDER BY COMM NULLS LAST;

/*
NVL(����� �Ǵ� �÷�, ��) NUMBER
����� �Ǵ� �÷� != NULL �̸�- ---> ����� �Ǵ� �÷� ���
����� �Ǵ� �÷� == NULL�̸�  ---> ������
*/

SELECT FIRST_NAME, NVL(COMMISSION_PCT,0)
FROM employees;

/*
NVL2(����� �Ǵ� �÷�, ��1, ��2) NUMBER
����� �Ǵ� �÷� != NULL �̸�- ---> ��1
����� �Ǵ� �÷� == NULL�̸�  ---> ��2
*/

SELECT FIRST_NAME, NVL2(COMMISSION_PCT,1, 0)
FROM employees;

/*   ��¥, �޷�, �ϼ� ����   */
-- �� ��¥ ���� ����(�� ����)
SELECT MONTHS_BETWEEN(SYSDATE, '2021-04-13')
FROM DUAL;

-- Ư�� ��¥ ���� ������ ���� ���� �ش� ��¥�� ��ȯ
SELECT ADD_MONTHS('2020-12-01', 6)
FROM DUAL;

-- ��¥ ���� ����, ��, ��, ��, ��, ��
-- year, month, day, hour, minute, second
select extract(year from sysdate) as ����,
    --extract(year from to_date('201202', 'yymmdd')) as ����,
    extract(month from sysdate) as ��,
    extract(day from sysdate) as ��,
    extract(hour from cast(sysdate as timestamp)) as ��,
    extract(minute from cast(sysdate as timestamp)) as ��,
    extract(second from cast(sysdate as timestamp)) as ��
from dual;



/*
    join
    �� �� �̻��� ���̺��� �����ؼ� �����͸� �˻��ϴ� ��
    ���� �� �� �̻��� ����� ����� �� Primary Key(�⺻Ű), Foreign Key(�ܷ�Ű) ����
    ����ؼ� ����
    
    Primary Key: ���̺��� �ߺ����� �ʴ� Ű
    Foreign Key: �ٸ� ���̺� �ִ� Ű
    
    ���� ����
    Ansi SQL
    Oracle
    
  �߿䵵 
    1   inner Join
    3   full outer Join
    3   cross Join
    2   left/right outer Join
    1   self Join
    
*/
/* INNER JOIN */
-- ANSI SQL
SELECT e.employee_id, e.first_name, -- ���� ���̺��� �ִ� �������� ��� X. �����ص� ��) EMPLYEE_ID, FIRST_NAME ó��
    E.department_id, d.department_id,
    d.department_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;
    
-- ORACLE 
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

/* FULL OUTER JOIN */
-- ANSI SQL
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;

/* CROSS JOIN */
-- ORACLE
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d;

/* LEFT/RIGHT OUTER JOIN */
-- ANSI
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
    ON e.department_id = d.department_id;

-- ORACLE
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+); -- LEFT OUTER JOIN
-- +�� �پ��ִ� �� ���� ������ ���ν�Ų�ٴ� ����

SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+) -- LEFT OUTER JOIN
    AND e.department_id IS NULL; -- EMPLOYEES���� �ش��ϴ� ������ ���
    
/* SELF JOIN */ -- ������ ���̺� JOIN
SELECT a.employee_id, a.first_name,
    a.manager_id, b.employee_id,
    b.first_name
FROM employees a, employees b   -- A: ���    B: ���
WHERE a.manager_id = b.employee_id; -- A�� �Ŵ�����ȣ = B�� �����ȣ

-- ������ ���� ����, ����
SELECT a.employee_id, a.first_name,
    a.manager_id AS "����� ���", b.employee_id,
    b.first_name AS ���
FROM employees a, employees b   -- A: ���    B: ���
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; -- �����
CONNECT BY a.manager_id = PRIOR a.employee_id; -- �����


/*
    Ư�� QUERY
    CASE
    DECODE

*/

-- CASE -> �ڹ��� ����ġ�� �����
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
    WHEN '515' THEN '����'
    WHEN '590' THEN '�λ�'
    WHEN '650' THEN '����'
    WHEN '603' THEN '����'
    ELSE '��Ÿ'
    END
FROM employees;


SELECT employee_id, first_name, phone_number,
    CASE
    WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '����'
    WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '�λ�'
    WHEN SUBSTR(phone_number, 1, 3) = '650' THEN '����'
    WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '����'
    ELSE '��Ÿ'
    END
FROM employees;

-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE(SUBSTR(phone_number, 1, 3),
        '515', '����',
        '590', '�λ�',
        '650', '����',
        '603', '����',
        '��Ÿ')
FROM employees;


/*
    SUB QUERY
    QUERY ���� QUERY
    
    SELECT ���� ROW , ���� COLUMN
    FROM ���� ROW, ���� COLUMN
    WHERE ���� ROW, ���� COLUMN
    
    
*/

-- SELECT
SELECT employee_id, first_name, (SELECT first_name
                                FROM employees 
                                WHERE employee_id = 100)
FROM employees;

/* ����
-- COLUMN 1, ROW 5
SELECT employee_id, first_name, (SELECT first_name
                                FROM employees 
                                WHERE JOB_id = 'IT_PROG')
FROM employees;

-- COLUMN 2, ROW 1
SELECT employee_id, first_name, (SELECT first_name, LAST_NAME
                                FROM employees 
                                WHERE employee_id = 100)
FROM employees;
*/

-- FROM
SELECT employee_id, FIRST_NAME, salary
FROM (SELECT employee_id, FIRST_NAME, salary
        FROM employees);
        
SELECT employee_id, FIRST_NAME
FROM (SELECT employee_id, FIRST_NAME, salary
        FROM employees);
        
/* ����
SELECT employee_id, FIRST_NAME, salary
FROM (SELECT employee_id, FIRST_NAME
        FROM employees);
        */
        
SELECT EMPNO, FIRST_NAME, salary
FROM (SELECT employee_id AS EMPNO, FIRST_NAME, salary
        FROM employees
        WHERE JOB_ID = 'IT_PROG')
WHERE SALARY > 5000;

-- �μ���ȣ�� 50, �޿��� 6000 �̻�
SELECT
    *
FROM employees
WHERE department_id = 50 AND salary > 6000;

SELECT
    *
FROM (SELECT
        *
        FROM employees
        WHERE department_id = 50)
WHERE SALARY > 6000; 

-- �޿��� �հ�, �ο���, �����, ����
SELECT e.first_name, e.salary,
    E.job_id, J.job_ID,
    j.salsum AS "�޿��հ�", J."�հ�" AS "�հ�"
FROM employees E, ( SELECT JOB_ID, SUM(SALARY) AS SALSUM, COUNT(*) AS "�հ�"
                    FROM employees
                    GROUP BY JOB_ID) J
WHERE e.job_id = J.JOB_ID;

-- WHERE
SELECT first_name, salary
FROM employees
WHERE SALARY > (SELECT AVG(SALARY) FROM employeeS);

-- DEPARTMENT_ID = 90�� JOB_ID ����
SELECT job_id, first_name, department_id
FROM employees
WHERE department_id = 90;

SELECT job_id, first_name, department_id
FROM employees
WHERE job_id IN (   SELECT JOB_ID
                    FROM employees
                    WHERE department_id = 90);

-- �μ����� ���� ������ ���� �޴� ����� ���� ������ �޴� ���
SELECT first_name, salary, department_id
FROM employees
WHERE salary IN (SELECT MIN(salary) 
                FROM employees
                GROUP BY DEPARTMENT_ID);
                
-- �μ����� ���� ������ ���� �޴� ����� ����
/* ����
SELECT department_id, MIN(salary), first_name
FROM employees
GROUP BY department_id;
*/

SELECT department_id, first_name, SALARY
FROM employees
WHERE (department_id, SALARY)       IN(SELECT department_id, MIN(SALARY)
                FROM employees
                GROUP BY department_id)


/*
    ���� �Լ�
    RANK() 1 2 3 3 5 6
    DENSE_RANK() 1 2 3 3 4 5
    ROW_NUMBER() 1 2 3 4 5 6
    ROWNUM() 1 2 3 4 5 6
    
*/

SELECT employee_id, first_name
FROM employees
WHERE employee_id >= 100 AND employee_id <= 109;

SELECT first_name,
    rank() OVER (ORDER BY salary DESC) AS RANK,
    DENSE_RANK() OVER(ORDER BY salary DESC) AS DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY salary DESC) AS ROW_NUMBER
FROM employees;

--ROWNUM
SELECT ROWNUM, employee_id, FIRST_NAME
FROM employees
WHERE ROWNUM <= 10;

SELECT ROWNUM, employee_id, FIRST_NAME
FROM employees
WHERE ROWNUM <= 10;

/*
1. ������ ����
2. ��ȣ�� �Ҵ�
3. ������ ����
*/

SELECT RNUM, employee_id, first_name, salary    
FROM (  SELECT ROWNUM AS RNUM, employee_id, first_name, salary -- 2.
        FROM (  SELECT employee_id, first_name, salary -- 1.
                FROM employees
                ORDER BY salary DESC))
WHERE RNUM BETWEEN 11 AND 20;   -- 3.




/* OVER()
  1. SELECT �������� ���
  2. GROUP BY�� �����ϱ� ���� ������� �Լ�
*/

SELECT department_id, COUNT(*)OVER()
FROM employees;
-- ������ �������� ������ OVER �� ����� ��� ����

SELECT department_name, COUNT(*)OVER(PARTITION BY department_id) -- department_id�� �����
FROM departments;

-- VIEW
SELECT * 
FROM EMP_DETAILS_VIEW; -- VIEW ��¹��. ��� ���̺� �����Ͽ� ����� ��
-- ������ �ٲ� ���������� ����� ���� ����
-- SELECT�� �� �� �ִ� �뵵�� ���




-- INSERT DELETE SELECT UPDATE
/*
    QUERY
    
    SELECT
        (��, COLUMN, �Լ�, SUB QUERY)
    FROM
        (TABLE �̸�, SUB QUERY)

*/

SELECT 1 
FROM DUAL;

SELECT
    *
FROM employees;

SELECT employee_id, FIRST_NAME, SALARY
FROM employees;

-- ALIAS
-- as�� �ٿ��� �ǰ� �� �ٿ��� ��.
-- ""�� �ص� �ǰ� �� �ص� ��, ������ ���⸦ �� ���� �ݵ�� "" �ʿ�.
-- ������ ""�� ��Ÿ ������ �浹 ���ɼ� ������ �� ���� �ʰ� ����� _�� ��ü��
SELECT EMPLOYEE_ID AS "��� ��ȣ", FIRST_NAME as "�̸�", SALARY "����"
FROM employees;

SELECT EMPLOYEE_ID AS "�����ȣ", FIRST_NAME as �̸�, SALARY "����"
FROM employees;
-- SELECT EMPLOYEE_ID AS ��� ��ȣ, FIRST_NAME as "�̸�", SALARY "����" �̰� ����
-- FROM employees;

SELECT EMPLOYEE_ID || FIRST_NAME  || SALARY
FROM employees;

SELECT FIRST_NAME, LAST_NAME, SALARY, SALARY*12 AS ����
FROM employees;


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

-- ����
SELECT TRUNC(10.5) FROM DUAL;

SELECT ENAME, SAL, SAL * 12
FROM EMP;

-- ALIAS(�÷�����), AS = as, as �� �ᵵ ��
SELECT ENAME AS �̸�, SAL as ����, SAL * 12 "�� ��"
FROM EMP;

-- DISTINCT: �ߺ��� �൥���� ����, GROUP BY
SELECT DISTINCT deptno
FROM EMP;

SELECT DISTINCT JOB 
FROM EMP;

--1 �����ȣ, ����̸�, ���� ���
SELECT EMPNO, ENAME, SAL 
FROM EMP;

--2 ����̸�, ����  -> �� ��, �� ������ ���
SELECT ENAME AS "�� ��", SAL AS "�� ��" 
FROM EMP;
-- ������ �ڹٳ� ��Ÿ ������ �������� ���� �߻� ���ɼ��� �־� ""�� �� ���� ����
-- ���� '_'�� ���⸦ ǥ��

--3 �����ȣ, ����̸�, ����, ���� ---> �����ȣ, ����̸�, ����, �������� ���
SELECT EMPNO AS �����ȣ, ENAME AS ����̸�, SAL AS ����, SAL*12 AS ���� 
FROM EMP;

--4 JOB�� �ߺ��� �����ϰ� ���
SELECT DISTINCT JOB 
FROM EMP;

--5 ������ ������ �����ϰ� EMPLOYEE AND JOB���� �÷� ����
SELECT ENAME || ', ' || JOB AS "EMPLOYEE AND JOB" 
FROM EMP;


-- WHERE
/*
 ǥ����
 SELECT
 FROM
 WHERE ������
 
 �񱳿�����(=, >, <, !=, <=, >=, <>)
 NULL
 =NULL(X), IS NULL(O)
            IS NOT NULL(O)
 ( ), NOT, AND(&&), OR(||) �� ���
 
 
 */
 
 -- FIRST_NAME == JULIA
 SELECT FIRST_NAME, LAST_NAME, SALARY
 FROM EMPLOYEES
 WHERE FIRST_NAME = 'Julia';
 
 -- ������ 9000�̻��� ���
 SELECT FIRST_NAME, SALARY
 FROM EMPLOYEES
 WHERE SALARY >= 9000;
 
 -- �̸��� shanta���� ū �̸�
 SELECT FIRST_NAME
 FROM EMPLOYEES
 WHERE FIRST_NAME > 'Shanta';
 
 -- a�� �ƽ�Ű�ڵ� ���� �빮�� A~Z���� Ŀ�� �˻���� ����
 SELECT FIRST_NAME
 FROM employees
 WHERE FIRST_NAME > 'a';
 
 SELECT FIRST_NAME, MANAGER_ID
 FROM employees
 WHERE MANAGER_ID = ''; -- ''�� NULL�� �ٸ�
 
 SELECT FIRST_NAME, MANAGER_ID
 FROM employees
 WHERE MANAGER_ID IS NULL;
 
-- AND
SELECT first_name, last_name
FROM EMPLOYEES
WHERE FIRST_NAME = 'Shanta'
    and first_name = 'John';
    
-- OR
SELECT first_name, last_name
FROM EMPLOYEES
WHERE FIRST_NAME = 'Shanta'
    OR first_name = 'John';
    
-- �̸��� JOHN, ���� 500 �̻�
SELECT FIRST_NAME, salary
FROM EMPLOYEES
WHERE FIRST_NAME = 'John'
    AND SALARY >= 5000;
    
-- 2007�� 12�� 31�� ���Ŀ� �Ի��� ��� ����
SELECT FIRST_NAME, HIRE_DATE
FROM employees
WHERE HIRE_DATE > TO_DATE('071231', 'YYMMDD');



-- 06�⵵�� �Ի��� ���
select first_name, hire_date
from employees
where hire_date like '06%';

select first_name, hire_date
from employees
where hire_date >= '06/01/01' and hire_date < '07/01/01';


