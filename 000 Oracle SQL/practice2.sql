--   scott
--23) emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력하시오.
SELECT INITCAP(JOB)
FROM EMP;


--24) emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만 추출하여 출력
SELECT LPAD(ENAME, 3)
FROM EMP
WHERE ENAME LIKE '%A%';


--25) 이름의 세번째 문자가 A인 모든 사원의 이름을 표시하시오.
SELECT ENAME
FROM EMP
WHERE (INSTR(ENAME, 'A')) = 3;

SELECT ENAME
FROM EMP
WHERE SUBSTR(ENAME, 3, 1) = 'A';

--26) 이름이 J,A 또는 M으로 시작하는 모든 사원의 이름(첫 글자는 대문자로, 나머지 글자는 소문자로
--    표시) 및 이름의 길이를 표시하시오.(열 레이블은 name과 length로 표시)
SELECT INITCAP(ENAME), LENGTH(ENAME)
FROM EMP
WHERE ENAME LIKE 'J%' OR ENAME LIKE 'A%' OR ENAME LIKE 'M%';


--27) 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오
SELECT LOWER(ENAME)
FROM EMP
WHERE LENGTH(ENAME) >= 6;



--28) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 출력하시오.
SELECT LOWER(LPAD(ENAME, 3))
FROM EMP
WHERE LENGTH(ENAME) >= 6;

SELECT LOWER(SUBSTR(ENAME, 1, 3))
FROM EMP
WHERE LENGTH(ENAME) >= 6;

--29) 모든 사원의 이름과 급여를 표시하시오. 급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로
--   표기하고 열레이블을 SALARY로 지정하시오.
SELECT ENAME, LPAD(sal, 15, '$') AS SALARY
FROM EMP;


--30) 오늘부터 이번달의 마지막날까지의 남은 날 수를 구하시오.
SELECT TRUNC(LAST_DAY('20/12/01') - SYSDATE) AS "남은 일 수"
FROM DUAL;

SELECT LAST_DAY(SYSDATE) - SYSDATE AS "남은 일 수"
FROM DUAL;

--31) emp테이블에서 각 사원에 대해 사원번호, 이름, 급여 및 15% 인상된 급여를 정수(반올림)로 표시하시오.
--    인상된 급여열의 레이블을 New Salary로 지정하시오.
SELECT EMPNO, ENAME, SAL, round(SAL*1.15) AS "New Salary"
from emp;


--32) emp테이블에서 월급의 4의 배수(mod(sal,4)=0)인 사원의 이름과 월급을 출력하시오.(세자리 단위 쉼표 표시)
SELECT ENAME, TO_CHAR(sal, '999,999') AS sal
FROM emp
WHERE MOD(sal, 4) = 0;


--33) 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달수)를 계산하여
--열 레이블을 MONTHS_WORKED로 지정하시오. 결과는 정수로 반올림하여 표시하고 근무달 수를
--기준으로 오름차순으로 정렬하시오.
SELECT ENAME, ROUND((SYSDATE - HIREDATE) / 30) AS MONTHS_WORKED
FROM EMP
ORDER BY MONTHS_WORKED ASC;

SELECT ENAME, ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONTHS_WORKED
FROM EMP
ORDER BY MONTHS_WORKED ASC;

--34)emp테이블에서 이름, 업무, 근무연차를 출력하시오.
SELECT ENAME, JOB, (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY') + 1) AS 근무연차
FROM EMP;

SELECT ENAME, JOB, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE) / 12) AS 근무연차
FROM EMP;

--35)emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력.
--단, NULL값은 나타나지 않게 작성하시오.
SELECT ENAME, SAL, SAL + NVL(COMM, 0) AS 실급여
FROM EMP;


--36)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,업무,월급,커미션,고용날짜
--를 출력하시오. 단, 고용날짜는 1980-12-17 형태로 출력하시오.
SELECT ENAME, JOB, SAL, NVL(COMM, 0), TO_CHAR(HIREDATE, 'YYYY-MM-DD')
FROM EMP
WHERE SAL + NVL(COMM, 0) >= 2000;



--   hr
--문제1) EMPLOYEES 테이블에서 King의 정보를 소문자로 검색하고 사원번호, 성명, 담당업무(소문자로),부서번호를 출력하라.
SELECT employee_iD, LOWER(last_name), lower(JOB_ID), department_id
FROM employees
WHERE lower(laST_NAME) = 'king';

--문제2) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 사원번호,성명, 담당업무(대문자로),부서번호를 출력하라.
SELECT employee_iD, UPPER(last_name), upper(JOB_ID), department_id
FROM employees
WHERE upper(laST_NAME) = 'KING';

--문제3) DEPARTMENTS 테이블에서 부서번호와 부서이름, 부서이름과 위치번호를 합하여 출력하도록 하라.
SELECT department_id || ' ' || DEPARTMENT_NAME, DEPARTMENT_NAME || ' ' || LOCATION_ID,
    concat(department_id, DEPARTMENT_NAME),
    concat(DEPARTMENT_NAME, LOCATION_ID)
FROM DEPARTMENTS;


--문제4) EMPLOYEES 테이블에서 이름의 첫 글자가‘K’ 보다 크고‘Y’보다 적은 사원의 정보를 사원번호, 이름, 업무, 급여, 부서번호를 출력하라. 단 이름순으로 정렬하여라.
SELECT employee_iD, last_name, job_id, SALARY, department_id
FROM employees
WHERE last_name >= 'L' AND last_name < 'Y'

SELECT employee_iD, last_name, job_id, SALARY, department_id
FROM employeeS
WHERE SUBSTR(last_name, 1, 1) > 'K' AND SUBSTR(LAST_NAME, 1, 1) < 'Y'
ORDER BY last_name ASC;

ORDER BY last_name ASC;
--문제5) EMPLOYEES 테이블에서 20번 부서 중 이름의 길이 및 급여의 자릿수를 사원번호, 이름, 이름의 자릿수, 급여, 급여의 자릿수를 출력하라.
SELECT employee_iD, last_name, LENGTH(last_name), SALARY, LENGTH(SALARY)
FROM employees
WHERE DEPARTMENT_ID = 20;

--문제6) EMPLOYEES 테이블에서 이름 중 ‘e’자의 위치를 출력하라.
SELECT INSTR(LAST_NAME, 'e')
FROM employees;

SELECT FIRST_NAME, INSTR(first_name, 'e', 1, 2)
FROM employees;

--문제7) 다음의 쿼리를 실행하고 결과를 분석하라. SELECT ROUND(4567.678),ROUND(4567.678,0),ROUND(4567.678,2),ROUND(4567.678,-2)FROM dual;
SELECT ROUND(4567.678), ROUND(4567.678,0),ROUND(4567.678,2),ROUND(4567.678,-2)
FROM dual;

--문제8) EMPLOYEES 테이블에서 부서번호가 80인 사람의 급여를 30으로 나눈 나머지를 구하여 출력하라.
SELECT MOD(SALARY, 30)
--SELECT SUM(SALARY)
FROM employees
WHERE department_id = 80;

--문제9) EMPLOYEES 테이블에서 30번 부서 중 이름과 담당업무를 연결하여 출력하여라. 단 담당업무를 한 줄 아래로 출력하라.보이기엔 한 줄처럼 보이지만 그리드를 더블클릭하면 개행되었다는 것을 확인할 수 있습니다.
SELECT LAST_NAME || ' ' || CHR(10)|| JOB_ID
FROM employees
WHERE department_id = 30;

--문제10) EMPLOYEES 테이블에서 현재까지 근무일 수가 몇 주 몇 일인가를 출력하여라. 단 근무일 수가 많은 사람순으로 출력하여라.
SELECT LAST_NAME, TRUNC((TO_DATE(SYSDATE) - TO_DATE(HIRE_DATE)) / 7) AS "근무 주수", MOD(TO_DATE(SYSDATE) - TO_DATE(HIRE_DATE), 7 ) AS "근무 일수"
FROM employees
ORDER BY "근무 주수" DESC;

--문제11) EMPLOYEES 테이블에서 부서50에서 급여 앞에 $를 삽입하고 3자리마다 ,를 출력하라
SELECT department_id, TO_CHAR(SALARY, '$999,999') AS 급여
FROM employees
WHERE department_id = 50;


