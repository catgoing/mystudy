--   scott
--23) emp���̺��� ����(job)�� ù���ڴ� �빮�� �������� �ҹ��ڷ� ����Ͻÿ�.
SELECT INITCAP(JOB)
FROM EMP;


--24) emp���̺��� ����̸� �� A�� ���Ե� ����̸��� ���ϰ� �� �̸� �� �տ��� 3�ڸ� �����Ͽ� ���
SELECT LPAD(ENAME, 3)
FROM EMP
WHERE ENAME LIKE '%A%';


--25) �̸��� ����° ���ڰ� A�� ��� ����� �̸��� ǥ���Ͻÿ�.
SELECT ENAME
FROM EMP
WHERE (INSTR(ENAME, 'A')) = 3;

SELECT ENAME
FROM EMP
WHERE SUBSTR(ENAME, 3, 1) = 'A';

--26) �̸��� J,A �Ǵ� M���� �����ϴ� ��� ����� �̸�(ù ���ڴ� �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ�
--    ǥ��) �� �̸��� ���̸� ǥ���Ͻÿ�.(�� ���̺��� name�� length�� ǥ��)
SELECT INITCAP(ENAME), LENGTH(ENAME)
FROM EMP
WHERE ENAME LIKE 'J%' OR ENAME LIKE 'A%' OR ENAME LIKE 'M%';


--27) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �ҹ��ڷ� �̸��� ����Ͻÿ�
SELECT LOWER(ENAME)
FROM EMP
WHERE LENGTH(ENAME) >= 6;



--28) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� ����Ͻÿ�.
SELECT LOWER(LPAD(ENAME, 3))
FROM EMP
WHERE LENGTH(ENAME) >= 6;

SELECT LOWER(SUBSTR(ENAME, 1, 3))
FROM EMP
WHERE LENGTH(ENAME) >= 6;

--29) ��� ����� �̸��� �޿��� ǥ���Ͻÿ�. �޿��� 15�� ���̷� ���ʿ� $��ȣ�� ä���� ��������
--   ǥ���ϰ� �����̺��� SALARY�� �����Ͻÿ�.
SELECT ENAME, LPAD(sal, 15, '$') AS SALARY
FROM EMP;


--30) ���ú��� �̹����� �������������� ���� �� ���� ���Ͻÿ�.
SELECT TRUNC(LAST_DAY('20/12/01') - SYSDATE) AS "���� �� ��"
FROM DUAL;

SELECT LAST_DAY(SYSDATE) - SYSDATE AS "���� �� ��"
FROM DUAL;

--31) emp���̺��� �� ����� ���� �����ȣ, �̸�, �޿� �� 15% �λ�� �޿��� ����(�ݿø�)�� ǥ���Ͻÿ�.
--    �λ�� �޿����� ���̺��� New Salary�� �����Ͻÿ�.
SELECT EMPNO, ENAME, SAL, round(SAL*1.15) AS "New Salary"
from emp;


--32) emp���̺��� ������ 4�� ���(mod(sal,4)=0)�� ����� �̸��� ������ ����Ͻÿ�.(���ڸ� ���� ��ǥ ǥ��)
SELECT ENAME, TO_CHAR(sal, '999,999') AS sal
FROM emp
WHERE MOD(sal, 4) = 0;


--33) �� ����� �̸��� ǥ���ϰ� �ٹ� �� ��(�Ի��Ϸκ��� ��������� �޼�)�� ����Ͽ�
--�� ���̺��� MONTHS_WORKED�� �����Ͻÿ�. ����� ������ �ݿø��Ͽ� ǥ���ϰ� �ٹ��� ����
--�������� ������������ �����Ͻÿ�.
SELECT ENAME, ROUND((SYSDATE - HIREDATE) / 30) AS MONTHS_WORKED
FROM EMP
ORDER BY MONTHS_WORKED ASC;

SELECT ENAME, ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONTHS_WORKED
FROM EMP
ORDER BY MONTHS_WORKED ASC;

--34)emp���̺��� �̸�, ����, �ٹ������� ����Ͻÿ�.
SELECT ENAME, JOB, (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY') + 1) AS �ٹ�����
FROM EMP;

SELECT ENAME, JOB, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE) / 12) AS �ٹ�����
FROM EMP;

--35)emp���̺��� ����̸�, ����, ���ް� Ŀ�̼��� ���� ���� �÷��� �Ǳ޿���� �ؼ� ���.
--��, NULL���� ��Ÿ���� �ʰ� �ۼ��Ͻÿ�.
SELECT ENAME, SAL, SAL + NVL(COMM, 0) AS �Ǳ޿�
FROM EMP;


--36)���ް� Ŀ�̼��� ��ģ �ݾ��� 2,000�̻��� �޿��� �޴� ����� �̸�,����,����,Ŀ�̼�,��볯¥
--�� ����Ͻÿ�. ��, ��볯¥�� 1980-12-17 ���·� ����Ͻÿ�.
SELECT ENAME, JOB, SAL, NVL(COMM, 0), TO_CHAR(HIREDATE, 'YYYY-MM-DD')
FROM EMP
WHERE SAL + NVL(COMM, 0) >= 2000;



--   hr
--����1) EMPLOYEES ���̺��� King�� ������ �ҹ��ڷ� �˻��ϰ� �����ȣ, ����, ������(�ҹ��ڷ�),�μ���ȣ�� ����϶�.
SELECT employee_iD, LOWER(last_name), lower(JOB_ID), department_id
FROM employees
WHERE lower(laST_NAME) = 'king';

--����2) EMPLOYEES ���̺��� King�� ������ �빮�ڷ� �˻��ϰ� �����ȣ,����, ������(�빮�ڷ�),�μ���ȣ�� ����϶�.
SELECT employee_iD, UPPER(last_name), upper(JOB_ID), department_id
FROM employees
WHERE upper(laST_NAME) = 'KING';

--����3) DEPARTMENTS ���̺��� �μ���ȣ�� �μ��̸�, �μ��̸��� ��ġ��ȣ�� ���Ͽ� ����ϵ��� �϶�.
SELECT department_id || ' ' || DEPARTMENT_NAME, DEPARTMENT_NAME || ' ' || LOCATION_ID,
    concat(department_id, DEPARTMENT_NAME),
    concat(DEPARTMENT_NAME, LOCATION_ID)
FROM DEPARTMENTS;


--����4) EMPLOYEES ���̺��� �̸��� ù ���ڰ���K�� ���� ũ��Y������ ���� ����� ������ �����ȣ, �̸�, ����, �޿�, �μ���ȣ�� ����϶�. �� �̸������� �����Ͽ���.
SELECT employee_iD, last_name, job_id, SALARY, department_id
FROM employees
WHERE last_name >= 'L' AND last_name < 'Y'

SELECT employee_iD, last_name, job_id, SALARY, department_id
FROM employeeS
WHERE SUBSTR(last_name, 1, 1) > 'K' AND SUBSTR(LAST_NAME, 1, 1) < 'Y'
ORDER BY last_name ASC;

ORDER BY last_name ASC;
--����5) EMPLOYEES ���̺��� 20�� �μ� �� �̸��� ���� �� �޿��� �ڸ����� �����ȣ, �̸�, �̸��� �ڸ���, �޿�, �޿��� �ڸ����� ����϶�.
SELECT employee_iD, last_name, LENGTH(last_name), SALARY, LENGTH(SALARY)
FROM employees
WHERE DEPARTMENT_ID = 20;

--����6) EMPLOYEES ���̺��� �̸� �� ��e������ ��ġ�� ����϶�.
SELECT INSTR(LAST_NAME, 'e')
FROM employees;

SELECT FIRST_NAME, INSTR(first_name, 'e', 1, 2)
FROM employees;

--����7) ������ ������ �����ϰ� ����� �м��϶�. SELECT ROUND(4567.678),ROUND(4567.678,0),ROUND(4567.678,2),ROUND(4567.678,-2)FROM dual;
SELECT ROUND(4567.678), ROUND(4567.678,0),ROUND(4567.678,2),ROUND(4567.678,-2)
FROM dual;

--����8) EMPLOYEES ���̺��� �μ���ȣ�� 80�� ����� �޿��� 30���� ���� �������� ���Ͽ� ����϶�.
SELECT MOD(SALARY, 30)
--SELECT SUM(SALARY)
FROM employees
WHERE department_id = 80;

--����9) EMPLOYEES ���̺��� 30�� �μ� �� �̸��� �������� �����Ͽ� ����Ͽ���. �� �������� �� �� �Ʒ��� ����϶�.���̱⿣ �� ��ó�� �������� �׸��带 ����Ŭ���ϸ� ����Ǿ��ٴ� ���� Ȯ���� �� �ֽ��ϴ�.
SELECT LAST_NAME || ' ' || CHR(10)|| JOB_ID
FROM employees
WHERE department_id = 30;

--����10) EMPLOYEES ���̺��� ������� �ٹ��� ���� �� �� �� ���ΰ��� ����Ͽ���. �� �ٹ��� ���� ���� ��������� ����Ͽ���.
SELECT LAST_NAME, TRUNC((TO_DATE(SYSDATE) - TO_DATE(HIRE_DATE)) / 7) AS "�ٹ� �ּ�", MOD(TO_DATE(SYSDATE) - TO_DATE(HIRE_DATE), 7 ) AS "�ٹ� �ϼ�"
FROM employees
ORDER BY "�ٹ� �ּ�" DESC;

--����11) EMPLOYEES ���̺��� �μ�50���� �޿� �տ� $�� �����ϰ� 3�ڸ����� ,�� ����϶�
SELECT department_id, TO_CHAR(SALARY, '$999,999') AS �޿�
FROM employees
WHERE department_id = 50;


