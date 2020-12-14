/*    FUNC    */

-- LIKE, 포함된 문자 검색
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

-- 오름차순 ASC, 내림차순 정렬 DESC
SELECT ENAME, JOB, sal
FROM EMP
ORDER BY JOB ASC, SAL DESC;

-- NULL 출력 순서
SELECT ENAME, comm
FROM EMP
ORDER BY COMM NULLS FIRST;

SELECT ENAME, comm
FROM EMP
ORDER BY COMM NULLS LAST;

/*
NVL(대상이 되는 컬럼, 값) NUMBER
대상이 되는 컬럼 != NULL 이면- ---> 대상이 되는 컬럼 출력
대상이 되는 컬럼 == NULL이면  ---> 지정값
*/

SELECT FIRST_NAME, NVL(COMMISSION_PCT,0)
FROM employees;

/*
NVL2(대상이 되는 컬럼, 값1, 값2) NUMBER
대상이 되는 컬럼 != NULL 이면- ---> 값1
대상이 되는 컬럼 == NULL이면  ---> 값2
*/

SELECT FIRST_NAME, NVL2(COMMISSION_PCT,1, 0)
FROM employees;

/*   날짜, 달력, 일수 관련   */
-- 두 날짜 간의 월수(월 간격)
SELECT MONTHS_BETWEEN(SYSDATE, '2021-04-13')
FROM DUAL;

-- 특정 날짜 월에 정수를 더한 다음 해당 날짜를 반환
SELECT ADD_MONTHS('2020-12-01', 6)
FROM DUAL;

-- 날짜 정보 연도, 월, 일, 시, 분, 초
-- year, month, day, hour, minute, second
select extract(year from sysdate) as 연도,
    --extract(year from to_date('201202', 'yymmdd')) as 연도,
    extract(month from sysdate) as 월,
    extract(day from sysdate) as 일,
    extract(hour from cast(sysdate as timestamp)) as 시,
    extract(minute from cast(sysdate as timestamp)) as 분,
    extract(second from cast(sysdate as timestamp)) as 초
from dual;



/*
    join
    두 개 이상의 테이블을 연결해서 데이터를 검색하는 것
    보통 두 개 이상의 행들의 공통된 값 Primary Key(기본키), Foreign Key(외래키) 값을
    사용해서 연결
    
    Primary Key: 테이블에서 중복되지 않는 키
    Foreign Key: 다른 테이블에 있는 키
    
    문법 종류
    Ansi SQL
    Oracle
    
  중요도 
    1   inner Join
    3   full outer Join
    3   cross Join
    2   left/right outer Join
    1   self Join
    
*/
/* INNER JOIN */
-- ANSI SQL
SELECT e.employee_id, e.first_name, -- 한쪽 테이블에만 있는 데이터의 경우 X. 생략해도 됨) EMPLYEE_ID, FIRST_NAME 처럼
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
-- +가 붙어있는 걸 없는 쪽으로 조인시킨다는 개념

SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+) -- LEFT OUTER JOIN
    AND e.department_id IS NULL; -- EMPLOYEES에만 해당하는 데이터 출력
    
/* SELF JOIN */ -- 동일한 테이블 JOIN
SELECT a.employee_id, a.first_name,
    a.manager_id, b.employee_id,
    b.first_name
FROM employees a, employees b   -- A: 사원    B: 상사
WHERE a.manager_id = b.employee_id; -- A의 매니저번호 = B의 사원번호

-- 계층형 구조 오름, 내림
SELECT a.employee_id, a.first_name,
    a.manager_id AS "사원의 상사", b.employee_id,
    b.first_name AS 상사
FROM employees a, employees b   -- A: 사원    B: 상사
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; -- 상향식
CONNECT BY a.manager_id = PRIOR a.employee_id; -- 하향식


/*
    특수 QUERY
    CASE
    DECODE

*/

-- CASE -> 자바의 스위치와 비슷함
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
    WHEN '515' THEN '서울'
    WHEN '590' THEN '부산'
    WHEN '650' THEN '광주'
    WHEN '603' THEN '강릉'
    ELSE '기타'
    END
FROM employees;


SELECT employee_id, first_name, phone_number,
    CASE
    WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '서울'
    WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '부산'
    WHEN SUBSTR(phone_number, 1, 3) = '650' THEN '광주'
    WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '강릉'
    ELSE '기타'
    END
FROM employees;

-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE(SUBSTR(phone_number, 1, 3),
        '515', '서울',
        '590', '부산',
        '650', '광주',
        '603', '강릉',
        '기타')
FROM employees;


/*
    SUB QUERY
    QUERY 안의 QUERY
    
    SELECT 단일 ROW , 단일 COLUMN
    FROM 다중 ROW, 다중 COLUMN
    WHERE 다중 ROW, 다중 COLUMN
    
    
*/

-- SELECT
SELECT employee_id, first_name, (SELECT first_name
                                FROM employees 
                                WHERE employee_id = 100)
FROM employees;

/* 오류
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
        
/* 오류
SELECT employee_id, FIRST_NAME, salary
FROM (SELECT employee_id, FIRST_NAME
        FROM employees);
        */
        
SELECT EMPNO, FIRST_NAME, salary
FROM (SELECT employee_id AS EMPNO, FIRST_NAME, salary
        FROM employees
        WHERE JOB_ID = 'IT_PROG')
WHERE SALARY > 5000;

-- 부서번호가 50, 급여가 6000 이상
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

-- 급여의 합계, 인원수, 사원명, 월급
SELECT e.first_name, e.salary,
    E.job_id, J.job_ID,
    j.salsum AS "급여합계", J."합계" AS "합계"
FROM employees E, ( SELECT JOB_ID, SUM(SALARY) AS SALSUM, COUNT(*) AS "합계"
                    FROM employees
                    GROUP BY JOB_ID) J
WHERE e.job_id = J.JOB_ID;

-- WHERE
SELECT first_name, salary
FROM employees
WHERE SALARY > (SELECT AVG(SALARY) FROM employeeS);

-- DEPARTMENT_ID = 90의 JOB_ID 산출
SELECT job_id, first_name, department_id
FROM employees
WHERE department_id = 90;

SELECT job_id, first_name, department_id
FROM employees
WHERE job_id IN (   SELECT JOB_ID
                    FROM employees
                    WHERE department_id = 90);

-- 부서별로 가장 월급을 적게 받는 사원과 같은 월급을 받는 사원
SELECT first_name, salary, department_id
FROM employees
WHERE salary IN (SELECT MIN(salary) 
                FROM employees
                GROUP BY DEPARTMENT_ID);
                
-- 부서별로 가장 월급을 적게 받는 사원과 월급
/* 오류
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
    순위 함수
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
1. 순위를 설정
2. 번호를 할당
3. 범위를 설정
*/

SELECT RNUM, employee_id, first_name, salary    
FROM (  SELECT ROWNUM AS RNUM, employee_id, first_name, salary -- 2.
        FROM (  SELECT employee_id, first_name, salary -- 1.
                FROM employees
                ORDER BY salary DESC))
WHERE RNUM BETWEEN 11 AND 20;   -- 3.




/* OVER()
  1. SELECT 절에서만 사용
  2. GROUP BY를 보강하기 위해 만들어진 함수
*/

SELECT department_id, COUNT(*)OVER()
FROM employees;
-- 원래는 오류나는 쿼리가 OVER 를 사용해 출력 가능

SELECT department_name, COUNT(*)OVER(PARTITION BY department_id) -- department_id로 묶어라
FROM departments;

-- VIEW
SELECT * 
FROM EMP_DETAILS_VIEW; -- VIEW 출력방법. 모든 테이블 연결하여 출력할 때
-- 쿼리를 바꿔 선택적으로 출력할 수도 있음
-- SELECT만 할 수 있는 용도로 사용




-- INSERT DELETE SELECT UPDATE
/*
    QUERY
    
    SELECT
        (값, COLUMN, 함수, SUB QUERY)
    FROM
        (TABLE 이름, SUB QUERY)

*/

SELECT 1 
FROM DUAL;

SELECT
    *
FROM employees;

SELECT employee_id, FIRST_NAME, SALARY
FROM employees;

-- ALIAS
-- as를 붙여도 되고 안 붙여도 됨.
-- ""를 해도 되고 안 해도 됨, 하지만 띄어쓰기를 할 경우는 반드시 "" 필요.
-- 하지만 ""는 기타 언어와의 충돌 가능성 때문에 잘 쓰지 않고 띄어쓰기는 _로 대체함
SELECT EMPLOYEE_ID AS "사원 번호", FIRST_NAME as "이름", SALARY "월급"
FROM employees;

SELECT EMPLOYEE_ID AS "사원번호", FIRST_NAME as 이름, SALARY "월급"
FROM employees;
-- SELECT EMPLOYEE_ID AS 사원 번호, FIRST_NAME as "이름", SALARY "월급" 이건 에러
-- FROM employees;

SELECT EMPLOYEE_ID || FIRST_NAME  || SALARY
FROM employees;

SELECT FIRST_NAME, LAST_NAME, SALARY, SALARY*12 AS 연봉
FROM employees;


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

-- 버림
SELECT TRUNC(10.5) FROM DUAL;

SELECT ENAME, SAL, SAL * 12
FROM EMP;

-- ALIAS(컬럼정보), AS = as, as 안 써도 됨
SELECT ENAME AS 이름, SAL as 월급, SAL * 12 "연 봉"
FROM EMP;

-- DISTINCT: 중복된 행데이터 삭제, GROUP BY
SELECT DISTINCT deptno
FROM EMP;

SELECT DISTINCT JOB 
FROM EMP;

--1 사원번호, 사원이름, 월급 출력
SELECT EMPNO, ENAME, SAL 
FROM EMP;

--2 사원이름, 월급  -> 이 름, 월 급으로 출력
SELECT ENAME AS "이 름", SAL AS "월 급" 
FROM EMP;
-- 하지만 자바나 기타 언어와의 연동에서 오류 발생 가능성이 있어 ""는 잘 쓰지 않음
-- 보통 '_'로 띄어쓰기를 표현

--3 사원번호, 사원이름, 월급, 연봉 ---> 사원번호, 사원이름, 월급, 연봉으로 출력
SELECT EMPNO AS 사원번호, ENAME AS 사원이름, SAL AS 월급, SAL*12 AS 연봉 
FROM EMP;

--4 JOB을 중복값 제외하고 출력
SELECT DISTINCT JOB 
FROM EMP;

--5 사원명과 업무를 연결하고 EMPLOYEE AND JOB으로 컬럼 설정
SELECT ENAME || ', ' || JOB AS "EMPLOYEE AND JOB" 
FROM EMP;


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



-- 06년도에 입사한 사원
select first_name, hire_date
from employees
where hire_date like '06%';

select first_name, hire_date
from employees
where hire_date >= '06/01/01' and hire_date < '07/01/01';


