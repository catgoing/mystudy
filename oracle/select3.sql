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

-- LIKE
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



select first_name, hire_date
from employees
where hire_date like '06%';
 -- 06�⵵�� �Ի��� ���


select first_name, hire_date
from employees
where hire_date >= '06/01/01' and hire_date < '07/01/01';  -- 06�� 1���� �Ի��� ���