-- EMPLOYEES ���̺��� �Ի����� ������ �����Ͽ� �����ȣ, �̸�, ����, �޿�, �Ի�����, �μ���ȣ�� ����϶�.
select empno, ename, job, sal, hiredate, deptno
from emp
order by hiredate asc;

-- EMPLOYEES ���̺��� ���� �ֱٿ� �Ի��� ������ �����ȣ, �̸�, ����, �޿�, �Ի�����, �μ���ȣ�� ����϶�
select empno, ename, job, sal, hiredate, deptno
from emp
order by hiredate desc;

-- EMPLOYEES ���̺��� �μ���ȣ�� ������ �� �μ���ȣ�� ���� ��� �޿��� ���� ������ �����Ͽ� �����ȣ, ����, ����, �μ���ȣ, �޿��� ����Ͽ���
select empno, ename, job, hiredate, deptno, sal
from emp
order by deptno asc, sal desc;

-- EMPLOYEES ���̺��� ù ��° ������ �μ���ȣ�� �� ��° ������ ������ �� ��° ������ �޿��� ���� ������ �����Ͽ� �����ȣ, ����, �Ի�����, �μ���ȣ, ����, �޿��� ����Ͽ���.
select empno, ename, hiredate, deptno, job, sal
from emp
order by deptno asc, job asc, sal desc;