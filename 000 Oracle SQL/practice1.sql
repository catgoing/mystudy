-- EMPLOYEES 테이블에서 입사일자 순으로 정렬하여 사원번호, 이름, 업무, 급여, 입사일자, 부서번호를 출력하라.
select empno, ename, job, sal, hiredate, deptno
from emp
order by hiredate asc;

-- EMPLOYEES 테이블에서 가장 최근에 입사한 순으로 사원번호, 이름, 업무, 급여, 입사일자, 부서번호를 출력하라
select empno, ename, job, sal, hiredate, deptno
from emp
order by hiredate desc;

-- EMPLOYEES 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여 사원번호, 성명, 업무, 부서번호, 급여를 출력하여라
select empno, ename, job, hiredate, deptno, sal
from emp
order by deptno asc, sal desc;

-- EMPLOYEES 테이블에서 첫 번째 정렬은 부서번호로 두 번째 정렬은 업무로 세 번째 정렬은 급여가 많은 순으로 정렬하여 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라.
select empno, ename, hiredate, deptno, job, sal
from emp
order by deptno asc, job asc, sal desc;