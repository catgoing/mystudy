-- DML
-- INSERT DELETE SELECT UPDATE
/*
    QUERY
    
    SELECT
        (��, COLUMN, �Լ�, SUB QUERY)
    FROM
        (TABLE �̸�, SUB QUERY)

*/

SELECT 1 FROM DUAL;

SELECT
    *
FROM employees;

SELECT employee_id, FIRST_NAME, SALARY
FROM employees;

-- ALIAS
SELECT EMPLOYEE_ID AS "��� ��ȣ", FIRST_NAME as "�̸�", SALARY "����"
FROM employees;

SELECT EMPLOYEE_ID AS "�����ȣ", FIRST_NAME as "�̸�", SALARY "����"
FROM employees;

-- SELECT EMPLOYEE_ID AS ��� ��ȣ, FIRST_NAME as "�̸�", SALARY "����" �̰� ����
-- FROM employees;

SELECT EMPLOYEE_ID || FIRST_NAME  || SALARY
FROM employees;

SELECT FIRST_NAME, LAST_NAME, SALARY, SALARY*12 AS "����"
FROM employees;