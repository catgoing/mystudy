-- WHERE
/*
 표현식
 SELECT
 FROM
 WHERE 순으로
 
 비교연산자(=, >, <, !=, <=, >=, <>)
 NULL
 =NULL(X), IS NULL(O)
            IS NOT NULL(O)
 ( ), NOT, AND(&&), OR(||) 등 사용
 
 
 */
 
 -- FIRST_NAME == JULIA
 SELECT FIRST_NAME, LAST_NAME, SALARY
 FROM EMPLOYEES
 WHERE FIRST_NAME = 'Julia';
 
 -- 월급이 9000이상인 사원
 SELECT FIRST_NAME, SALARY
 FROM EMPLOYEES
 WHERE SALARY >= 9000;
 
 -- 이름이 shanta보다 큰 이름
 SELECT FIRST_NAME
 FROM EMPLOYEES
 WHERE FIRST_NAME > 'Shanta';
 
 -- a의 아스키코드 값이 대문자 A~Z보다 커서 검색결과 없음
 SELECT FIRST_NAME
 FROM employees
 WHERE FIRST_NAME > 'a';
 
 SELECT FIRST_NAME, MANAGER_ID
 FROM employees
 WHERE MANAGER_ID = ''; -- ''와 NULL은 다름
 
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
    
-- 이름이 JOHN, 월급 500 이상
SELECT FIRST_NAME, salary
FROM EMPLOYEES
WHERE FIRST_NAME = 'John'
    AND SALARY >= 5000;
    
-- 2007년 12월 31일 이후에 입사한 사원 정보
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
WHERE salary IN(8000, 3200, 6000); -- OR와 같음

SELECT FIRST_NAME, salary
FROM employees
WHERE salary NOT IN(8000, 3200, 6000);  -- OR의 반대

-- BETWEEN,  NOT BETWEEN : 범위연산자
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
WHERE FIRST_NAME LIKE 'G_ra_d';  --  _ -> 한 문자

SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'Al%';  --  포함된 문자

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
 -- 06년도에 입사한 사원


select first_name, hire_date
from employees
where hire_date >= '06/01/01' and hire_date < '07/01/01';  -- 06년 1월에 입사한 사원