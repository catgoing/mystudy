-- SCOTT
/*37)DECODE �Ǵ� CASE WHEN THEN �Լ��� ����Ͽ� ���� �����Ϳ� ���� JOB���� ���� ��������
��� ����� ����� ǥ���Ͻÿ�.

����        ���
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
��Ÿ         0
*/

SELECT ENAME, job AS ����,
    DECODE(SUBSTR(JOB, 1, 5),
    'PRESI', 'A',
    'ANALY', 'B',
    'MANAG', 'C',
    'SALES', 'D',
    'CLERK', 'E',
    '��Ÿ', '0') AS ���
    
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


-- 60) BLAKE�� ���� �μ��� �ִ� ������� �̸��� �Ի����� ���ϴµ� 
-- BLAKE�� �����ϰ� ����Ͻÿ�.(BLAKE�� �������� �� ����)
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                FROM EMP
                WHERE ENAME = 'BLAKE')
        AND ENAME != 'BLAKE';



-- 61) ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������ ����ϴµ� 
-- ������ ���� ��������� ����Ͻÿ�.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;




-- 62) 10���μ����� �޿��� ���� ���� �޴� ����� ������ �޿��� �޴� ����� �̸��� ����Ͻÿ�.
SELECT ENAME, sal
FROM EMP
WHERE SAL = (SELECT MIN(sal) FROM EMP WHERE DEPTNO = 10);


-- 63) ������� 3���� �Ѵ� �μ��� �μ���� ������� ����Ͻÿ�.
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
             
-- 64) �����ȣ�� 7844�� ������� ���� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
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

-- 65) ���ӻ�簡 KING�� ��� ����� �̸��� �޿��� ����Ͻÿ�. (�� ���� ����)
SELECT ENAME, SAL, MGR
FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');


SELECT E.ENAME, e.sal, E.MGR, m.empno, m.ename
FROM EMP E, (SELECT ENAME, EMPNO
                FROM EMP
                WHERE ENAME = 'KING') M
WHERE E.MGR = m.eMPNO;



-- 66) 20�� �μ����� ���� �޿��� ���� �޴� ����� ������ �޿��� �޴� 
-- ����� �̸��� �μ���,�޿�, �޿������ ����Ͻÿ�.(emp, dept, salgrade)
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


--67) �ѱ޿�sal+comm�� ��� �޿����� ���� �޿��� �޴� ����� �μ���ȣ, �̸�, �ѱ޿�, 
--    Ŀ�̼��� ����Ͻÿ�.(Ŀ�̼��� ��(O),��(X)�� ǥ���ϰ� �÷����� "comm����" ���)
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


-- 68) CHICAGO �������� �ٹ��ϴ� ����� ��� �޿����� ���� �޿��� �޴� ����� �̸��� �޿�,
--    �������� ����Ͻÿ�.

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
            
-- 69) ������ SALESMAN�� ������ 2�� �̻��� �μ��� �̸�, �ٹ��ϴ� ����� �̸�, ������ ���
--    �Ͻÿ�.(�÷����� �μ���, �����, ������ ���)

SELECT d.dname �μ���, e.ename �����, E.JOB ����
FROM EMP E, DEPT D
WHERE E.DEPTNO = d.deptno
    AND D.DEPTNO IN (SELECT DEPTNO
                    FROM EMP
                    WHERE JOB = 'SALESMAN'
                    GROUP BY DEPTNO
                    HAVING COUNT(JOB) >= 2);

                    
-- 70) Ŀ�̼��� ���� ����� �� ������ ���� ���� ����� �̸��� �޿������ ����Ͻÿ�.
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



-- 71) SMITH�� �������� �̸��� �μ���, �ٹ������� ����Ͻÿ�. 
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
-- ����1) EMPLOYEES ���̺��� Kochhar�� �޿����� ���� ����� ������ ���
-- ��ȣ,�̸�,������,�޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE LAST_NAME = 'Kochhar');


-- ����2) EMPLOYEES ���̺��� �޿��� ��պ��� ���� ����� ������ 
-- �����ȣ,�̸�,������,�޿�,�μ���ȣ�� ����Ͽ���.
SELECT employee_id, first_name, job_id, department_id, salary
FROM employees
WHERE SALARY < (SELECT AVG(salary) FROM employees);

-- ����3) EMPLOYEES ���̺��� 100�� �μ��� �ּ� �޿����� �ּ� �޿���
-- ���� �ٸ� ��� �μ��� ����϶�


SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(SALARY) > (SELECT min(salary)
                        FROM employees
                        where department_id = 100);

-- ����4) �������� �ּ� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�μ���ȣ�� ����Ͽ���. 
-- �� �������� �����Ͽ���.
SELECT employee_id, first_name, job_id, department_id, salary
FROM employees
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary) FROM employees GROUP BY JOB_ID);

-- ����5) EMPLOYEES �� DEPARTMENTS ���̺��� ������ ���ϵ�� ����� ������ 
-- �̸�,����,�μ���,�ٹ����� ����϶�.
SELECT e.first_name, e.job_id, D.DEPARTMENT_NAME, D.LOCATION_ID
FROM (SELECT FIRST_NAME, job_id, department_id
    FROM employees
    WHERE job_id = 'SA_MAN') E, departments D
WHERE E.department_id = d.department_id;

--����6) EMPLOYEES ���̺��� ���� ���� ����� ���� MANAGER��
--�����ȣ�� ����϶�.
SELECT manager_id, COUNT(*)
FROM employees
GROUP BY manager_id
HAVING COUNT(MANAGER_id) = (SELECT MAX(COUNT(*))
                            FROM employees
                            GROUP BY manager_id);
                            
-- ����7) EMPLOYEES ���̺��� ���� ���� ����� �����ִ�
-- �μ���ȣ�� ������� ����϶�.
SELECT department_id, COUNT(department_id)
FROM employees
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(COUNT(*))
                                FROM employees
                                GROUP BY department_id);

/* ����8) EMPLOYEES ���̺��� �����ȣ�� 123�� ����� ������ ����
�����ȣ�� 192�� ����� �޿�(SAL)���� ���� ����� �����ȣ, �̸�,
����, �޿��� ����϶�. */
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE job_id = (SELECT job_id FROM employees WHERE employee_id = 123)
    AND salary > (SELECT salary FROM employees WHERE employee_id = 192);


-- ����9) ����(JOB)���� �ּ� �޿��� �޴� ����� ������ �����ȣ, �̸�, ����, �μ����� ����϶�.
-- ����1 : �������� �������� ����
SELECT employee_id, first_name, job_id, D.DEPARTMENT_NAME, e.salary
FROM employees E, departments D
WHERE (job_id, SALARY) IN (SELECT job_id, MIN(salary) FROM employees
                            GROUP BY job_id)
        AND e.department_id = d.department_id
ORDER BY e.job_id DESC;


-- ����10) EMPLOYEES ���̺��� �������� �ּ� �޿��� ���� �޿��� �޴� ����� ������ 
-- �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�
SELECT employee_id, first_name, job_id, D.DEPARTMENT_NAME, e.salary
FROM employees E, departments D
WHERE SALARY IN (SELECT MIN(salary) FROM employees
                            GROUP BY job_id)
        AND e.department_id = d.department_id;

/* ����11) EMPLOYEES ���̺��� 50�� �μ��� �ּ� �޿��� �޴� ��� ���� ���� �޿��� �޴� 
����� ������ �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. �� 50���� ���� */
SELECT employee_id, first_name, job_id, hire_date, SALARY, department_id
FROM employees
WHERE salary > (SELECT MIN(salary)
                FROM employees
                WHERE department_id = 50)
    AND department_id <> 50;


/* ����12) EMPLOYEES ���̺��� 50�� �μ��� �ְ� �޿��� �޴� ��� ����
���� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ��
����϶�. ��50���� ���� */

-- 11�� ������ ����.. �ּҳ� �ְ�� ����


-- ����13) �ֱ� �Ի��� ��� ������ �ۼ��ؼ� 1 ~ 10��°, 11 ~ 20 ����� ������ ����Ͻÿ�

