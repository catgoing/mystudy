-- DML
-- INSERT DELETE SELECT UPDATE
/*
    QUERY
    
    SELECT
        (값, COLUMN, 함수, SUB QUERY)
    FROM
        (TABLE 이름, SUB QUERY)

*/

SELECT 1 FROM DUAL;

SELECT
    *
FROM employees;

SELECT employee_id, FIRST_NAME, SALARY
FROM employees;

-- ALIAS
SELECT EMPLOYEE_ID AS "사원 번호", FIRST_NAME as "이름", SALARY "월급"
FROM employees;

SELECT EMPLOYEE_ID AS "사원번호", FIRST_NAME as "이름", SALARY "월급"
FROM employees;

-- SELECT EMPLOYEE_ID AS 사원 번호, FIRST_NAME as "이름", SALARY "월급" 이건 에러
-- FROM employees;

SELECT EMPLOYEE_ID || FIRST_NAME  || SALARY
FROM employees;

SELECT FIRST_NAME, LAST_NAME, SALARY, SALARY*12 AS "연봉"
FROM employees;