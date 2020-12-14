--����1) EMPLOYEES ���̺��� ������ ��� SA�� ���Ͽ� �޿��� ���, �ְ��, ������, �հ踦 ���Ͽ� ����Ͽ���.
SELECT JOB_ID, AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY)
FROM employees
GROUP BY JOB_ID
HAVING JOB_ID like 'SA%';

SELECT AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY)
FROM employees
WHERE JOB_ID like 'SA%';

--����2) EMPLOYEES ���̺��� �μ����� �ο���, ��� �޿�, �����޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� ����϶�.
SELECT DEPARTMENT_ID, COUNT(*), ROUND(AVG(SALARY)), MIN(SALARY), MAX(SALARY), SUM(SALARY)
FROM employees
GROUP BY department_id;


--����3) EMPLOYEES ���̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, COUNT(*), SUM(SALARY)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4;


--����4) EMPLOYEES ���̺��� �޿��� �ִ��� 10000�̻��� �μ��� ���ؼ� �μ���ȣ, ��� �޿�, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, ROUND(AVG(SALARY)), SUM(SALARY)
FROM employees
GROUP BY department_id
HAVING MAX(SALARY) >= 10000;


--����5) EMPLOYEES ���̺��� ��ü ������ 10000�� �ʰ��ϴ� �� ������ ���ؼ� ������ ���޿� �հ踦 ����϶�. ��, �Ǹſ�(SA)�� �����ϰ� �� �޿� �հ�� ����(��������)�϶�.
SELECT JOB_ID, SUM(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING SUM(SALARY) > 10000
        AND JOB_ID NOT LIKE 'SA%'
ORDER BY SUM(SALARY) DESC;

SELECT JOB_ID, SUM(SALARY)
FROM employees
WHERE JOB_ID NOT LIKE 'SA%'
GROUP BY JOB_ID
HAVING SUM(SALARY) > 10000
ORDER BY SUM(SALARY) DESC;
