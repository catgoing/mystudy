
/*38)��� ����� �޿��� �ְ��, ������, �Ѿ� �� ��վ��� ǥ���Ͻÿ�. �� ���̺��� ����
   maximum,minimum,sum �� average�� �����ϰ� ����� ������ �ݿø��ϰ� ���ڸ� ������
   ,�� ����Ͻÿ�.*/
    
SELECT TO_CHAR(MAX(SAL), '999,999'), TO_CHAR(MIN(SAL), '999,999'), TO_CHAR(SUM(SAL), '999,999'), TO_CHAR( ROUND(AVG(SAL)), '999,999') 
FROM EMP;

-- 39) ������ ������ ��� ���� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�.
SELECT JOB, COUNT(*) AS �����
FROM EMP
GROUP BY JOB;


-- 40) emp���̺��� 30���μ��� ������� ���Ͻÿ�.
SELECT DEPTNO, COUNT(*) AS �����
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO = 30;

SELECT COUNT(*)
FROM EMP
where DEPTNO = 30;

-- 41) emp���̺��� ������ �ְ� ������ ���ϰ� ����,�ְ� ������ ����Ͻÿ�.
SELECT JOB, MAX(SAL)
FROM EMP
GROUP BY JOB;


-- 42) emp���̺��� 20���μ��� �޿� �հ踦 ���ϰ� �޿� �հ� �ݾ��� ����Ͻÿ�.
SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO = 20;


-- 43) emp���̺��� �μ����� ���޵Ǵ� �ѿ��޿��� �ݾ��� 7,000�̻��� �μ���ȣ, �ѿ����� ����Ͻÿ�.
SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) >= 7000;

-- 44) emp���̺��� �������� ����� ���� ���� ����� ���ϰ� �� ��� ������ ����� 79�� �����ϴ� ����� �����ֽÿ�.
SELECT JOB, MAX(EMPNO)
FROM EMP
GROUP BY JOB
HAVING MAX(EMPNO) LIKE '79%';

-- 45) emp���̺��� ������ �ѿ����� ����ϴµ� ������ 'MANAGER'�� ������� �����ϰ� 
--     �ѿ����� 5,000���� ū ������ �ѿ��޸� ����Ͻÿ�.
SELECT JOB, SUM(SAL)
FROM EMP
GROUP BY JOB
HAVING JOB != 'MANAGER'
    AND SUM(SAL) >= 5000;


-- 46)emp���̺��� �������� ������� 4�� �̻��� ������ �ο����� ����Ͻÿ�.
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
HAVING COUNT(*) >= 4;

-- 47)emp���̺��� ������� 5���� �Ѵ� �μ��� �μ���ȣ�� ������� ���Ͻÿ�.
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) > 5;

-- 48)emp���̺��� �μ��� �޿������ ���� �� �Ҽ��� 3�ڸ����� �ݿø��ؼ� 2�ڸ�����
--    ���ϰ� �μ���ȣ, �޿������ ����Ͻÿ�.
SELECT DEPTNO, ROUND(AVG(SAL), 2)
FROM EMP
GROUP BY DEPTNO;
