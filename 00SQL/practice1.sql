-- EMPLOYEES 테이블에서 입사일자 순으로 정렬하여 사원번호, 이름, 업무, 급여, 입사일자, 부서번호를 출력하라.
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
order by hire_date asc;

-- employeeS 테이블에서 가장 최근에 입사한 순으로 사원번호, 이름, 업무, 급여, 입사일자, 부서번호를 출력하라
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
order by hire_date desc;

-- employeeS 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여 사원번호, 성명, 업무, 부서번호, 급여를 출력하여라
select employee_id, first_name, job_id, hire_date, department_id, salary
from employees
order by department_id asc, salary desc;

-- employeeS 테이블에서 첫 번째 정렬은 부서번호로 두 번째 정렬은 업무로 세 번째 정렬은 급여가 많은 순으로 정렬하여 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라.
select employee_id, first_name, hire_date, department_id, job_id, salary
from employees
order by department_id asc, job_id asc, salary desc;


-- 19) emp 테이블에서 사원번호, 사원이름, 입사일을 출력하는데 
-- 입사일이 빠른 사람순으로 정렬하시오.
select empno, ename, hiredate
from emp
order by hiredate asc;


-- 20) emp 테이블에서 사원이름, 급여, 연봉을 구하고 연봉이 많은 순으로 정렬하시오.

select ename, sal, sal*12 as 연봉
from emp
order by 연봉 desc;


--21)10번 부서와 20번부서에서 근무하고 있는 사원의 이름과 부서번호를 출력하는데 
-- 이름을 영문자순으로 표시하시오.
select ename, deptno
from emp
where deptno in(10, 20)
order by ename asc;

--22) 커미션을 받는 모든 사원의 이름,급여 및 
-- 커미션을 커미션을 기준으로 내림차순으로 정렬하여 표시하십시오.
select ename, sal, comm
from emp
where comm is not null
    and comm != 0
order by comm desc;