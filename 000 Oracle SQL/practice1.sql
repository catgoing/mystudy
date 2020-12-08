-- EMPLOYEES ���̺��� �Ի����� ������ �����Ͽ� �����ȣ, �̸�, ����, �޿�, �Ի�����, �μ���ȣ�� ����϶�.
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
order by hire_date asc;

-- employeeS ���̺��� ���� �ֱٿ� �Ի��� ������ �����ȣ, �̸�, ����, �޿�, �Ի�����, �μ���ȣ�� ����϶�
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
order by hire_date desc;

-- employeeS ���̺��� �μ���ȣ�� ������ �� �μ���ȣ�� ���� ��� �޿��� ���� ������ �����Ͽ� �����ȣ, ����, ����, �μ���ȣ, �޿��� ����Ͽ���
select employee_id, first_name, job_id, hire_date, department_id, salary
from employees
order by department_id asc, salary desc;

-- employeeS ���̺��� ù ��° ������ �μ���ȣ�� �� ��° ������ ������ �� ��° ������ �޿��� ���� ������ �����Ͽ� �����ȣ, ����, �Ի�����, �μ���ȣ, ����, �޿��� ����Ͽ���.
select employee_id, first_name, hire_date, department_id, job_id, salary
from employees
order by department_id asc, job_id asc, salary desc;


-- 19) emp ���̺��� �����ȣ, ����̸�, �Ի����� ����ϴµ� 
-- �Ի����� ���� ��������� �����Ͻÿ�.
select empno, ename, hiredate
from emp
order by hiredate asc;


-- 20) emp ���̺��� ����̸�, �޿�, ������ ���ϰ� ������ ���� ������ �����Ͻÿ�.

select ename, sal, sal*12 as ����
from emp
order by ���� desc;


--21)10�� �μ��� 20���μ����� �ٹ��ϰ� �ִ� ����� �̸��� �μ���ȣ�� ����ϴµ� 
-- �̸��� �����ڼ����� ǥ���Ͻÿ�.
select ename, deptno
from emp
where deptno in(10, 20)
order by ename asc;

--22) Ŀ�̼��� �޴� ��� ����� �̸�,�޿� �� 
-- Ŀ�̼��� Ŀ�̼��� �������� ������������ �����Ͽ� ǥ���Ͻʽÿ�.
select ename, sal, comm
from emp
where comm is not null
    and comm != 0
order by comm desc;