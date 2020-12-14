
--1
SELECT last_name, first_name, salary
FROM employees
WHERE salary < 7000 OR salary > 10000
-- salary not between 7000 and 10000
ORDER BY salary ASC;

--2
SELECT last_name, first_name, salary, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary desc, commission_pct DESC;

--3
SELECT employee_id, last_name, first_name, SALARY, ROUND(SALARY*1.123), department_id
FROM employees
where department_id = 60;

--4
SELECT INITCAP(first_name), INITCAP(last_name), upper(job_id)
FROM employees
WHERE last_name LIKE '%s';

--5
SELECT first_name, last_name, salary, NVL2(commission_pct, 'SAL+COM', 'SAL ONLY'), (SALARY + SALARY*NVL(commission_pct,0))*12 AS 연봉
FROM employees
ORDER BY 연봉 DESC;


--6
SELECT department_id, TO_CHAR(SUM(salary), '$999,999'), TO_CHAR(AVG(salary), '$999,999'), TO_CHAR(MAX(salary), '$999,999'), TO_CHAR(MIN(salary), '$999,999')
FROM employees
GROUP BY department_id;


--7
SELECT job_id, SUM(salary)
FROM employees
GROUP BY job_id
HAVING job_id <> 'CLERK'
    AND SUM(SALARY) > 10000
ORDER BY SUM(SALARY) DESC;

--8
SELECT 'Han-Bit' Company_Name, e.last_name, e.first_name, e.job_id, D.DEPARTMENT_NAME, L.CITY
FROM employees E, departments D, locations L
WHERE e.department_id = d.department_id
    and d.location_id = l.location_id
    AND D.LOCATION_ID = 2500;

-- VIEW를 사용할 경우 출력 (아래처럼 ALIAS를 모두 지워야 출력 가능)
SELECT 'Han-Bit' Company_Name, last_name, first_name, job_id, DEPARTMENT_NAME, CITY
FROM emp_details_view;

--9
SELECT d.department_name, count(e.employee_id)
FROM employees e, departments d
where e.department_id = d.department_id
group by d.department_name
having count(employee_id) >= 5
order by count(employee_id) desc;

-- department id와 name을 같이 출력하고 싶으면 그룹을 둘 다 잡아주면 됨
SELECT d.department_id, d.department_name, count(e.employee_id)
FROM employees e, departments d
where e.department_id = d.department_id
group by d.department_name, d.department_id
having count(employee_id) >= 5
order by count(employee_id) desc;
 

--10
SELECT e.first_name, e.last_name, e.job_id, d.department_name, e.hire_date, e.salary, j.grade_level
FROM employees E, departments D, job_grades J
where e.department_id = d.department_id
    and e.salary between j.lowest_sal and j.highest_sal;
    
-- 단순 월급 등급만 파악할 경우
SELECT e.first_name, e.last_name, e.job_id, e.hire_date, e.salary, j.grade_level
FROM employees E, job_grades J
where e.salary between j.lowest_sal and j.highest_sal;


CREATE TABLE JOB_GRADES (
    GRADE_LEVEL VARCHAR2(3),
    LOWEST_SAL NUMBER,
    HIGHEST_SAL NUMBER
);
INSERT INTO JOB_GRADES VALUES ('A', 1000, 2999);
INSERT INTO JOB_GRADES VALUES ('B', 3000, 5999);
INSERT INTO JOB_GRADES VALUES ('C', 6000, 9999);
INSERT INTO JOB_GRADES VALUES ('D', 10000, 14999);
INSERT INTO JOB_GRADES VALUES ('E', 15000, 24999);
INSERT INTO JOB_GRADES VALUES ('F', 25000, 40000);
COMMIT;

