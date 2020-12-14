/* ����1 ) EMPLOYEES ���̺��� �μ����� �ο��� ��� �޿� �޿��� �� �ּ� �޿�
�ִ� �޿��� �����ϴ� EMP_DEPTNO ���̺��� �����϶�*/
CREATE TABLE EMP_DEPTNO(DEPTNO, NUM, AG, SM, MN, MX )
AS SELECT department_id, COUNT(employee_id), ROUND(AVG(salary)), SUM(salary), MIN(salary), MAX(salary)
FROM employees
GROUP BY department_id;

DROP TABLE EMP_DEPTNO;

-- ����2) EMP_DEPTNO ���̺� ETC COLUMN �� �߰��϶� . �� �ڷ����� VARCHAR2(50) ����϶�
ALTER TABLE EMP_DEPTNO
ADD
"ETC COLUMN" VARCHAR2(50);

-- ����3) EMP_DEPTNO ���̺� ETC COLUMN �� ���� �϶� . �ڷ����� VARCHAR2(15) �� �϶�
ALTER TABLE EMP_DEPTNO
MODIFY
"ETC COLUMN" VARCHAR2(15);

-- ����4) EMP_DEPTNO ���̺� �ִ� ETC �� �����ϰ� Ȯ���϶�
ALTER TABLE EMP_DEPTNO
DROP
COLUMN "ETC COLUMN";

-- ����5) ������ ������ EMP_DEPTNO ���̺��� �̸��� EMP_DEPT �� �����϶�
ALTER TABLE EMP_DEPTNO
RENAME
TO EMP_DEPT;

-- ����6) EMP_DEPT ���̺� �� �����϶�
DROP TABLE EMP_DEPT;

-- ����7) EMPLOYEES ���̺� �� EMP ���̺��� �����ϰ� �����ϵ��� �϶� (������ ����)
CREATE TABLE EMP
AS SELECT
    *
FROM employees;

/* ����8) EMP ���̺� row �� �߰��� ���ϴ�
�ٸ�, �ݵ�� �����͸� ������ ���ص� �Ǹ� , NULL �� �����ϵ��� �Ѵ� */
INSERT INTO EMP(EMPLOYEE_ID, FIRST_NAME)
VALUES(999, GALAXY);

/* ����9) EMPLOYEES ���̺��� EMPNO,ENAME,SAL,HIREDATE �� COLUMN ��
�����Ͽ� EMP_10 ���̺��� ���� ������ ������ �� �� 10 �� �μ��� �����Ͽ�
�̿� �����ϴ� ���� EMP_10 ���̺� �Է��϶� */