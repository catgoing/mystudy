-- SCOTT
/*37)DECODE 또는 CASE WHEN THEN 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로
모든 사원의 등급을 표시하시오.

업무        등급
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
기타         0
*/

SELECT ENAME, job AS 업무,
    DECODE(SUBSTR(JOB, 1, 5),
    'PRESI', 'A',
    'ANALY', 'B',
    'MANAG', 'C',
    'SALES', 'D',
    'CLERK', 'E',
    '기타', '0') AS 등급
    
FROM emp;

SELECT ENAME, JOB,
    CASE job
    WHEN 'PRESIDENT' THEN 'A'
    WHEN 'ANALYST' THEN 'B'
    WHEN 'MANAGER' THEN 'C'
    WHEN 'SALESMAN' THEN 'D'
    WHEN 'CLERK' THEN 'E'
    ELSE '0'
    END AS GRADE
FROM EMP;


-- 60) BLAKE와 같은 부서에 있는 사원들의 이름과 입사일을 구하는데 
-- BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                FROM EMP
                WHERE ENAME = 'BLAKE')
        AND ENAME != 'BLAKE';



-- 61) 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을 출력하는데 
-- 월급이 높은 사람순으로 출력하시오.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;




-- 62) 10번부서에서 급여를 가장 적게 받는 사원과 동일한 급여를 받는 사원의 이름을 출력하시오.
SELECT ENAME, sal
FROM EMP
WHERE SAL = (SELECT MIN(sal) FROM EMP WHERE DEPTNO = 10);


-- 63) 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력하시오.
SELECT d.dname, COUNT(E.EMPNO)
FROM EMP E, DEPT D
WHERE e.deptno = d.deptno
GROUP BY D.DNAME
HAVING COUNT(E.EMPNO) > 3;
        
SELECT E.ENAME, e.deptno, N.dname
FROM EMP E, (SELECT COUNT(*), D.DEPTNO
            FROM EMP E, DEPT D
            WHERE e.deptno = d.deptno
            GROUP BY D.DEPTNO
            HAVING COUNT(*) > 3) D,
            (SELECT COUNT(*), D.DNAME
            FROM EMP E, DEPT D
            WHERE e.deptno = d.deptno
            GROUP BY D.DNAME
            HAVING COUNT(*) > 3) N
            
WHERE E.DEPTNO = D.DEPTNO;
             
-- 64) 사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 출력하시오.
SELECT ENAME, HIREDATE
FROM EMP
WHERE HIREDATE < (SELECT hiredate
            FROM emp
            WHERE EMPNO = 7844);

SELECT E.ENAME, E.HIREDATE
FROM EMP E, (SELECT hiredate
            FROM emp
            WHERE EMPNO = 7844) A
WHERE E.HIREDATE < A.hiredate;

-- 65) 직속상사가 KING인 모든 사원의 이름과 급여를 출력하시오. (안 좋은 문제)
SELECT ENAME, SAL, MGR
FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');


SELECT E.ENAME, e.sal, E.MGR, m.empno, m.ename
FROM EMP E, (SELECT ENAME, EMPNO
                FROM EMP
                WHERE ENAME = 'KING') M
WHERE E.MGR = m.eMPNO;



-- 66) 20번 부서에서 가장 급여를 많이 받는 사원과 동일한 급여를 받는 
-- 사원의 이름과 부서명,급여, 급여등급을 출력하시오.(emp, dept, salgrade)
SELECT e.ename, d.dname, e.sal, s.grade
FROM EMP e, dept d, SALGRADE S
WHERE SAL IN (SELECT MAX(SAL)
                FROM EMP
                WHERE DEPTNO = 20)
        AND e.deptno = d.deptno
        AND E.SAL BETWEEN s.losal AND s.hisal ;


SELECT e.ename, d.dname, e.sal, s.grade
FROM EMP E, DEPT D, salgrade S
WHERE SAL IN(SELECT MIN(SAL)
            FROM EMP
            WHERE DEPTNO = 20)
        AND e.deptno = d.deptno
        AND E.SAL BETWEEN s.losal AND s.hisal ;


--67) 총급여sal+comm가 평균 급여보다 많은 급여를 받는 사람의 부서번호, 이름, 총급여, 
--    커미션을 출력하시오.(커미션은 유(O),무(X)로 표시하고 컬럼명은 "comm유무" 출력)
SELECT DEPTNO, ENAME, SAL + NVL(COMM, 0), NVL(COMM, 0), NVL2(COMM, 'O', 'X')
FROM EMP
WHERE SAL + NVL(COMM, 0) > (SELECT AVG(SAL) FROM EMP);

SELECT E.DEPTNO, E.ENAME, E.SAL+COMM, E.COMM,
 CASE COMM
            WHEN NULL THEN 'X'
            ELSE 'O'
            END
FROM EMP E
WHERE  (SAL + COMM) > (SELECT AVG(SAL) FROM EMP);


-- 68) CHICAGO 지역에서 근무하는 사원의 평균 급여보다 높은 급여를 받는 사원의 이름과 급여,
--    지역명을 출력하시오.

SELECT E.ENAME, E.SAL, D.LOC
FROM EMP E, DEPT D
WHERE SAL > (SELECT AVG(SAL)
            FROM EMP
            WHERE DEPTNO IN (SELECT DEPTNO
                            FROM DEPT
                            WHERE LOC = 'CHICAGO') )
    AND e.deptno = d.deptno;                        






SELECT E.ENAME, E.SAL, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
    AND E.SAL > (SELECT AVG(SAL)
            FROM EMP E, DEPT D
            WHERE e.deptno = d.deptno
            AND LOC = 'CHICAGO');
            
-- 69) 업무가 SALESMAN인 직원이 2명 이상인 부서의 이름, 근무하는 사원의 이름, 업무를 출력
--    하시오.(컬럼명은 부서명, 사원명, 업무로 출력)

SELECT d.dname 부서명, e.ename 사원명, E.JOB 업무
FROM EMP E, DEPT D
WHERE E.DEPTNO = d.deptno
    AND D.DEPTNO IN (SELECT DEPTNO
                    FROM EMP
                    WHERE JOB = 'SALESMAN'
                    GROUP BY DEPTNO
                    HAVING COUNT(JOB) >= 2);

                    
-- 70) 커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름과 급여등급을 출력하시오.
SELECT E.ENAME, S.GRADE
FROM EMP E, salgrade S
WHERE SAL = (SELECT MAX(SAL)
            FROM EMP
            WHERE COMM IS NULL OR COMM = 0)
    AND SAL BETWEEN S.LOSAL AND S.HISAL;


SELECT E.ENAME, E.SAL, s.grade
FROM (SELECT ENAME, SAL
    FROM EMP
    WHERE COMM IS NULL
    OR COMM = 0) E,
    salgrade S
WHERE E.SAL = (SELECT MAX(SAL) FROM EMP WHERE COMM IS NULL
                        OR COMM = 0)
AND E.SAL BETWEEN S.LOSAL AND S.HISAL;



-- 71) SMITH의 관리자의 이름과 부서명, 근무지역을 출력하시오. 
SELECT E.ENAME, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.EMPNO IN (SELECT MGR
                FROM EMP
                WHERE ENAME = 'SMITH')
    AND e.deptno = d.deptno;

SELECT MG.ENAME, D.DNAME, D.LOC
FROM (SELECT ENAME, MGR
    FROM EMP
    WHERE ENAME = 'SMITH') EN,
    (SELECT ENAME, MGR, EMPNO, DEPTNO
    FROM EMP) MG,
    DEPT D
WHERE EN.MGR = MG.EMPNO
    AND MG.DEPTNO = D.DEPTNO;

-- HR
-- 문제1) EMPLOYEES 테이블에서 Kochhar의 급여보다 많은 사원의 정보를 사원
-- 번호,이름,담당업무,급여를 출력하라.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE LAST_NAME = 'Kochhar');


-- 문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 정보를 
-- 사원번호,이름,담당업무,급여,부서번호를 출력하여라.
SELECT employee_id, first_name, job_id, department_id, salary
FROM employees
WHERE SALARY < (SELECT AVG(salary) FROM employees);

-- 문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가
-- 많은 다른 모든 부서를 출력하라


SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(SALARY) > (SELECT min(salary)
                        FROM employees
                        where department_id = 100);

-- 문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라. 
-- 단 업무별로 정렬하여라.
SELECT employee_id, first_name, job_id, department_id, salary
FROM employees
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary) FROM employees GROUP BY JOB_ID);

-- 문제5) EMPLOYEES 과 DEPARTMENTS 테이블에서 업무가 세일드맨 사원의 정보를 
-- 이름,업무,부서명,근무지를 출력하라.
SELECT e.first_name, e.job_id, D.DEPARTMENT_NAME, D.LOCATION_ID
FROM (SELECT FIRST_NAME, job_id, department_id
    FROM employees
    WHERE job_id = 'SA_MAN') E, departments D
WHERE E.department_id = d.department_id;

--문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의
--사원번호를 출력하라.
SELECT manager_id, COUNT(*)
FROM employees
GROUP BY manager_id
HAVING COUNT(MANAGER_id) = (SELECT MAX(COUNT(*))
                            FROM employees
                            GROUP BY manager_id);
                            
-- 문제7) EMPLOYEES 테이블에서 가장 많은 사원이 속해있는
-- 부서번호와 사원수를 출력하라.
SELECT department_id, COUNT(department_id)
FROM employees
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(COUNT(*))
                                FROM employees
                                GROUP BY department_id);

/* 문제8) EMPLOYEES 테이블에서 사원번호가 123인 사원의 직업과 같고
사원번호가 192인 사원의 급여(SAL)보다 많은 사원의 사원번호, 이름,
직업, 급여를 출력하라. */
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE job_id = (SELECT job_id FROM employees WHERE employee_id = 123)
    AND salary > (SELECT salary FROM employees WHERE employee_id = 192);


-- 문제9) 직업(JOB)별로 최소 급여를 받는 사원의 정보를 사원번호, 이름, 업무, 부서명을 출력하라.
-- 조건1 : 직업별로 내림차순 정렬
SELECT employee_id, first_name, job_id, D.DEPARTMENT_NAME, e.salary
FROM employees E, departments D
WHERE (job_id, SALARY) IN (SELECT job_id, MIN(salary) FROM employees
                            GROUP BY job_id)
        AND e.department_id = d.department_id
ORDER BY e.job_id DESC;


-- 문제10) EMPLOYEES 테이블에서 업무별로 최소 급여와 같은 급여를 받는 사원의 정보를 
-- 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라
SELECT employee_id, first_name, job_id, D.DEPARTMENT_NAME, e.salary
FROM employees E, departments D
WHERE SALARY IN (SELECT MIN(salary) FROM employees
                            GROUP BY job_id)
        AND e.department_id = d.department_id;

/* 문제11) EMPLOYEES 테이블에서 50번 부서의 최소 급여를 받는 사원 보다 많은 급여를 받는 
사원의 정보를 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 단 50번은 제외 */
SELECT employee_id, first_name, job_id, hire_date, SALARY, department_id
FROM employees
WHERE salary > (SELECT MIN(salary)
                FROM employees
                WHERE department_id = 50)
    AND department_id <> 50;


/* 문제12) EMPLOYEES 테이블에서 50번 부서의 최고 급여를 받는 사원 보다
많은 급여를 받는 사원의 정보를 사원번호,이름,업무,입사일자,급여,부서번호를
출력하라. 단50번은 제외 */

-- 11번 문제와 같음.. 최소냐 최고냐 차이


-- 문제13) 최근 입사한 사원 순으로 작성해서 1 ~ 10번째, 11 ~ 20 사원의 정보를 출력하시오

