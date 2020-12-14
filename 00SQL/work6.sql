
/*
    inner join
    full outer join
    cross join
    left/ right outer join
    self join
    
*/

SELECT e.first_name, d.department_name, j.job_title
FROM employees E, departments D, JOBS J
WHERE e.department_id = d.department_id
    AND e.job_id = j.job_id
    AND e.first_name = 'Lex';
    
SELECT emp.first_name AS 직원명, mana.first_name AS 상사명
FROM employees EMP, employees MANA
WHERE emp.manager_id = MANA.employee_id;