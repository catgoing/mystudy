/*����1) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� Cartesian
Product(��� ������ ����� Join)�Ͽ� �����ȣ,�̸�,����,�μ���ȣ,�μ���,
�ٹ����� ����Ͽ���.*/
SELECT e.employee_id, e.last_name, e.job_id, e.department_id,
    d.department_name, d.location_id
FROM employees e, departments d;
    
    

/* ����2) EMPLOYEES ���̺��� �����ȣ,�̸�,����, EMPLOYEES ���̺���
�μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ��� */
SELECT e.employee_id, e.LAst_name, e.job_id,
    e.department_id,
    d.department_id, d.department_name, d.location_id
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;
    
-- ����3) Alexander Hunold �� �μ����� ����϶�
SELECT e.first_name|| ' ' || e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.last_name = 'Hunold';
    
-- ����4) ������ �μ����� �ٹ��ϰ� �ִ� ������� ����϶�.
SELECT d.department_name, e.last_name
FROM employees e, departments D
WHERE e.department_id = d.department_id
    AND d.department_name = 'Sales';

/* ����5) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� �μ���ȣ�� �����ϰ�
SA_MAN ������� �����ȣ,�̸�,�޿�,�μ���,�ٹ����� ����϶�.
(Alias�� ���)*/
SELECT e.employee_id, e.last_name, e.salary,
    d.department_name, d.location_id,
    e.job_id
FROM employees E, departments D
WHERE e.department_id = d.department_id
    AND e.job_id = 'SA_MAN';

/* ����6) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� DEPARTMENTS ��
�̺� �ִ� ��� �ڷḦ �����ȣ,�̸�,����, EMPLOYEES ���̺��� �μ���
ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ���
(Outer Join)*/
SELECT e.employee_id, e.first_name, e.job_id, e.department_id,
    d.department_id, d.department_name,
    D.LOCATION_ID
FROM employees E FULL OUTER JOIN departments D
    ON e.department_id = d.department_id;

-- ����7) EMPLOYEES ���̺��� Self join�Ͽ� ������(�Ŵ���)�� ����Ͽ���
SELECT a.last_name || '�� �����ڴ� ' || b.last_name || '�̴�'
FROM employees A, employees B
WHERE a.manager_id = b.employee_id
CONNECT BY a.manager_id = A.employee_id;

/* ����8) EMPLOYEES ���̺��� left join�Ͽ� ������(�Ŵ���)�� ����ϰ�
�Ŵ��� ���̵� ���� ����� �����ϰ� ��������� �ϸ�, �޿��� ��������
����϶�. */

SELECT e.last_name, e.manager_iD,   
    a.employee_id, a.last_name, A.salary
FROM employees E LEFT OUTER JOIN employees A
    ON e.manager_id = A.employee_id
WHERE e.manager_id IS NOT NULL
CONNECT BY  e.manager_id = PRIOR E.employee_id
ORDER BY a.salary ASC;

SELECT a.employee_id, a.first_name,
    a.manager_id AS "����� ���", b.employee_id,
    b.first_name AS ���
FROM employees a, employees b   -- A: ���    B: ���
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; -- �����
CONNECT BY a.manager_id = PRIOR a.employee_id; -- �����

/* ����9) EMPLOYEES ���̺��� right join�Ͽ� ������(�Ŵ���)�� 108��
��������� �޿��� �������� ����϶�*/
SELECT a.employee_id, a.first_name, a.manager_id, a.salary,
    b.employee_id, b.first_name
FROM employees A, employees B
WHERE a.manager_id(+) = b.employee_id
CONNECT BY PRIOR a.manager_id = A.employee_id
ORDER BY a.salary ASC;


----- SCOTT
-- 50) ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�.(emp,dept)
SELECT e.ename, e.deptno, d.dname
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE E.ENAME IS NOT NULL;

--51) ������ MANAGER�� ����� ������ �̸�,����,�μ���,�ٹ��� ������
--    ����Ͻÿ�.(emp,dept)
SELECT e.ename, e.job, e.deptno, d.dname, d.loc
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE e.job = 'MANAGER';


-- 52) Ŀ�̼��� �ް� �޿��� 1,600�̻��� ����� ����̸�,�μ���,�ٹ����� ����Ͻÿ�
SELECT e.ename, d.dname, d.loc,
    e.comm, e.sal
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE e.comm IS NOT NULL
    AND e.sal >= 1600;

-- 53) �ٹ����� CHICAGO�� ��� ����� �̸�,����,�μ���ȣ �� �μ��̸��� ǥ���Ͻÿ�.
SELECT e.ename, e.job, e.deptno, d.dname,
    D.LOC
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
WHERE D.LOC = 'CHICAGO';

-- 54) �ٹ������� �ٹ��ϴ� ����� ���� 5�� ������ ���, �ο��� ���� ���ü����� �����Ͻÿ�.
-- (�ٹ� �ο��� 0���� ���� ǥ��)
SELECT D.LOC, COUNT(e.empno) AS "�����"
FROM emp E FULL OUTER JOIN dept D
    ON e.deptno = d.deptno
GROUP BY d.loc
HAVING COUNT(e.empno) < 6
ORDER BY COUNT(*);

-- 55) ����� �̸� �� ��� ��ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����Ͻÿ�.
SELECT A.ENAME AS EMPLOYEE, A.EMPNO AS EMP#, B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE a.mgr(+) = B.empno
    AND A.ENAME IS NOT NULL
CONNECT BY a.mgr = a.empno;

-- 56) �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ǥ���ϰ� �����ں��� �Ի����� ���� ����� �����϶�.
-- �� ���̺��� ���� employee, emp hired, manager, mgr hired�� ����
SELECT A.ENAME, A.HIREDATE, B.ENAME, b.hiredate
FROM EMP A, EMP B
WHERE a.mgr = b.empno
    AND a.hiredate < b.hiredate
CONNECT BY A.MGR = A.empno;


-- 57) ����� �̸� �� �����ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����ϴµ� 
-- King�� �����Ͽ� �����ڰ� ���� ��� ����� ǥ���ϵ��� �ϰ� 
-- ����� �����ȣ�� �������� ����
SELECT A.ENAME AS EMPLOYEE, A.EMPNO AS EMP#, B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE a.mgr = B.empno(+)
CONNECT BY a.mgr = a.empno
ORDER BY A.EMPNO;

-- 58) ������ �μ���ȣ, ����̸� �� ������ ����� ������ �μ����� �ٹ��ϴ� 
-- ��� ����� ǥ���ϵ��� ���Ǹ� �ۼ��ϰ� 
-- �μ���ȣ�� department, ����̸��� employee, ������ �μ����� �ٹ��ϴ� ����� colleague�� ǥ���Ͻÿ�.
-- (�μ���ȣ, ����̸�,���� ������ �������� ����) 
SELECT A.deptno AS department, A.ename AS employee, B.ename AS colleague, B.deptno
FROM emp A, EMP B
WHERE A.deptno(+) = B.deptno 
    AND A.ENAME != B.ENAME
ORDER BY A.DEPTNO, A.ENAME, B.ENAME ASC;

--CONNECT BY A.DEPTNO = B.DEPTNO;





-- 59)10�� �μ����� �ٹ��ϴ� ������� 
-- �μ���ȣ, �μ��̸�, ����̸�, ����, �޿������ ����Ͻÿ�.
SELECT d.deptno, d.dname, e.ename, e.sal, s.grade
FROM EMP E, DEPT D, salgrade S
WHERE E.deptno = D.deptno
    AND E.SAL BETWEEN S.LOSAL AND s.hisal
    AND E.DEPTNO = 10;

SELECT d.deptno, d.dname, e.ename, e.sal
FROM EMP E RIGHT OUTER JOIN DEPT D
    on E.deptno = D.deptno
    AND E.DEPTNO = 10;




