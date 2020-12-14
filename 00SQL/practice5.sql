/*문제1) EMPLOYEES 테이블과 DEPARTMENTS 테이블을 Cartesian
Product(모든 가능한 행들의 Join)하여 사원번호,이름,업무,부서번호,부서명,
근무지를 출력하여라.*/
SELECT e.employee_id, e.last_name, e.job_id, e.department_id,
    d.department_name, d.location_id
FROM employees e, departments d;
    
    

/* 문제2) EMPLOYEES 테이블에서 사원번호,이름,업무, EMPLOYEES 테이블의
부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라 */
SELECT e.employee_id, e.LAst_name, e.job_id,
    e.department_id,
    d.department_id, d.department_name, d.location_id
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;
    
-- 문제3) Alexander Hunold 의 부서명을 출력하라
SELECT e.first_name|| ' ' || e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.last_name = 'Hunold';
    
-- 문제4) 세일즈 부서에서 근무하고 있는 사람들을 출력하라.
SELECT d.department_name, e.last_name
FROM employees e, departments D
WHERE e.department_id = d.department_id
    AND d.department_name = 'Sales';

/* 문제5) EMPLOYEES 테이블과 DEPARTMENTS 테이블의 부서번호를 조인하고
SA_MAN 사원만의 사원번호,이름,급여,부서명,근무지를 출력하라.
(Alias를 사용)*/
SELECT e.employee_id, e.last_name, e.salary,
    d.department_name, d.location_id,
    e.job_id
FROM employees E, departments D
WHERE e.department_id = d.department_id
    AND e.job_id = 'SA_MAN';

/* 문제6) EMPLOYEES 테이블과 DEPARTMENTS 테이블에서 DEPARTMENTS 테
이블에 있는 모든 자료를 사원번호,이름,업무, EMPLOYEES 테이블의 부서번
호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라
(Outer Join)*/
SELECT e.employee_id, e.first_name, e.job_id, e.department_id,
    d.department_id, d.department_name,
    D.LOCATION_ID
FROM employees E FULL OUTER JOIN departments D
    ON e.department_id = d.department_id;

-- 문제7) EMPLOYEES 테이블에서 Self join하여 관리자(매니저)를 출력하여라
SELECT a.last_name || '의 관리자는 ' || b.last_name || '이다'
FROM employees A, employees B
WHERE a.manager_id = b.employee_id
CONNECT BY a.manager_id = A.employee_id;

/* 문제8) EMPLOYEES 테이블에서 left join하여 관리자(매니저)를 출력하고
매니저 아이디가 없는 사람은 배제하고 하향식으로 하며, 급여는 역순으로
출력하라. */

SELECT e.last_name, e.manager_iD,   
    a.employee_id, a.last_name, A.salary
FROM employees E LEFT OUTER JOIN employees A
    ON e.manager_id = A.employee_id
WHERE e.manager_id IS NOT NULL
CONNECT BY  e.manager_id = PRIOR E.employee_id
ORDER BY a.salary ASC;

SELECT a.employee_id, a.first_name,
    a.manager_id AS "사원의 상사", b.employee_id,
    b.first_name AS 상사
FROM employees a, employees b   -- A: 사원    B: 상사
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; -- 상향식
CONNECT BY a.manager_id = PRIOR a.employee_id; -- 하향식

/* 문제9) EMPLOYEES 테이블에서 right join하여 관리자(매니저)가 108번
상향식으로 급여는 역순으로 출력하라*/
SELECT a.employee_id, a.first_name, a.manager_id, a.salary,
    b.employee_id, b.first_name
FROM employees A, employees B
WHERE a.manager_id(+) = b.employee_id
CONNECT BY PRIOR a.manager_id = A.employee_id
ORDER BY a.salary ASC;


----- SCOTT
-- 50) 모든 사원의 이름, 부서번호, 부서이름을 표시하시오.(emp,dept)
SELECT e.ename, e.deptno, d.dname
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE E.ENAME IS NOT NULL;

--51) 업무가 MANAGER인 사원의 정보를 이름,업무,부서명,근무지 순으로
--    출력하시오.(emp,dept)
SELECT e.ename, e.job, e.deptno, d.dname, d.loc
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE e.job = 'MANAGER';


-- 52) 커미션을 받고 급여가 1,600이상인 사원의 사원이름,부서명,근무지를 출력하시오
SELECT e.ename, d.dname, d.loc,
    e.comm, e.sal
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE e.comm IS NOT NULL
    AND e.sal >= 1600;

-- 53) 근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을 표시하시오.
SELECT e.ename, e.job, e.deptno, d.dname,
    D.LOC
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE D.LOC = 'CHICAGO';

-- 54) 근무지별로 근무하는 사원의 수가 5명 이하인 경우, 인원이 적은 도시순으로 정렬하시오.
-- (근무 인원이 0명인 곳도 표시)
SELECT D.LOC, COUNT(e.empno) AS "사원수"
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
GROUP BY d.loc
HAVING COUNT(e.empno) < 6
ORDER BY COUNT(*);

-- 55) 사원의 이름 및 사원 번호를 관리자의 이름과 관리자 번호와 함께 표시하고 
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하시오.
SELECT A.ENAME AS EMPLOYEE, A.EMPNO AS EMP#, B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE a.mgr(+) = B.empno
    AND A.ENAME IS NOT NULL
CONNECT BY a.mgr = a.empno;

-- 56) 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 표시하고 관리자보다 입사일이 빠른 사원을 산출하라.
-- 열 레이블을 각각 employee, emp hired, manager, mgr hired로 지정
SELECT A.ENAME, A.HIREDATE, B.ENAME, b.hiredate
FROM EMP A, EMP B
WHERE a.mgr = b.empno
    AND a.hiredate < b.hiredate
CONNECT BY A.MGR = A.empno;


-- 57) 사원의 이름 및 사원번호를 관리자의 이름과 관리자 번호와 함께 표시하고 
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하는데 
-- King을 포함하여 관리자가 없는 모든 사원을 표시하도록 하고 
-- 결과를 사원번호를 기준으로 정렬
SELECT A.ENAME AS EMPLOYEE, A.EMPNO AS EMP#, B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE a.mgr = B.empno(+)
CONNECT BY a.mgr = a.empno
ORDER BY A.EMPNO;

-- 58) 지정한 부서번호, 사원이름 및 지정한 사원과 동일한 부서에서 근무하는 
-- 모든 사원을 표시하도록 질의를 작성하고 
-- 부서번호는 department, 사원이름은 employee, 동일한 부서에서 근무하는 사원은 colleague로 표시하시오.
-- (부서번호, 사원이름,동료 순으로 오름차순 정렬) 
SELECT A.deptno AS department, A.ename AS employee, B.ename AS colleague, B.deptno
FROM emp A, EMP B
WHERE A.deptno(+) = B.deptno 
    AND A.ENAME != B.ENAME
ORDER BY A.DEPTNO, A.ENAME, B.ENAME ASC;

--CONNECT BY A.DEPTNO = B.DEPTNO;





-- 59)10번 부서에서 근무하는 사원들의 
-- 부서번호, 부서이름, 사원이름, 월급, 급여등급을 출력하시오.
SELECT d.deptno, d.dname, e.ename, e.sal, s.grade
FROM EMP E, DEPT D, salgrade S
WHERE E.deptno = D.deptno
    AND E.SAL BETWEEN S.LOSAL AND s.hisal
    AND E.DEPTNO = 10;

SELECT d.deptno, d.dname, e.ename, e.sal
FROM EMP E RIGHT OUTER JOIN DEPT D
    on E.deptno = D.deptno
    AND E.DEPTNO = 10;




