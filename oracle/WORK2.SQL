-- NO1
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary
FROM EMPLOYEES
WHERE SALARY >= 3000;

-- NO2
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, department_id
FROM EMPLOYEES
WHERE JOB_ID = 'ST_MAN';

-- NO3
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, hire_date, department_id
FROM EMPLOYEES
WHERE hire_date > '82-01-01';
-- where hire_date > to_date('060101', 'yymmdd');

-- NO4
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, department_id
FROM EMPLOYEES
WHERE SALARY BETWEEN 3000 AND 5000;

SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, department_id
FROM EMPLOYEES
WHERE SALARY >= 3000 AND SALARY <= 5000;

-- NO5
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, hire_date
FROM EMPLOYEES
WHERE employee_id IN (145, 152, 203);

SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, hire_date
FROM EMPLOYEES
WHERE employee_id = 145 OR employee_id =  152 OR  employee_id =  203;

-- NO6
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, hire_date, department_id
FROM EMPLOYEES
WHERE hire_date LIKE '05%';

-- NO7
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, hire_date, commission_pct, department_id
FROM EMPLOYEES
WHERE commission_pct IS NULL;

--NO8
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, hire_date, commission_pct, department_id
FROM EMPLOYEES
WHERE SALARY >= 1100 AND job_id = 'ST_MAN';

--NO9
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, hire_date, commission_pct, department_id
FROM EMPLOYEES
WHERE SALARY >= 10000 OR job_id = 'ST_MAN';

--NO10
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, department_id
FROM employees
WHERE JOB_ID NOT IN('ST_MAN', 'SA_MAN', 'SA_REP')

--NO11
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary
FROM employees
WHERE job_id = 'AD_PRES' 
    AND SALARY >= 12000 
        OR job_id = 'SA_MAN';

--NO12
SELECT EMPLOYEE_ID, lAST_NAME, JOB_ID, salary, DEPARTMENT_ID
FROM employees
WHERE JOB_ID IN('AD_PRES', 'SA_MAN') AND SALARY >= 12000;