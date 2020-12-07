/*
    order by = sorting
    
    DB -> SORTING -> JAVA   �̰� ������ �� ����
    DB -> JAVA -> SORTING
    
    SELECT *
    FROM TABLE
    ORDER BY SAL ASC  ---> ��������
    ORDER BY SAL DESC ---> ��������
    

*/

SELECT ENAME, SAL
FROM emp
ORDER BY SAL ASC;

SELECT ENAME, SAL
FROM emp
ORDER BY SAL DESC;

-- ALIAS
SELECT EMPNO, ENAME, SAL * 12 AS ANNSAL
FROM EMP
ORDER BY ANNSAL DESC;

SELECT ENAME, comm
FROM EMP
ORDER BY COMM NULLS FIRST;

SELECT ENAME, comm
FROM EMP
ORDER BY COMM NULLS LAST;

SELECT ENAME, JOB, sal
FROM EMP
ORDER BY JOB ASC, SAL DESC;

-- �� ��¥ ���� ����(�� ����)
SELECT MONTHS_BETWEEN(SYSDATE, '2021-04-13')
FROM DUAL;

-- Ư�� ��¥ ���� ������ ���� ���� �ش� ��¥�� ��ȯ
SELECT ADD_MONTHS('2020-12-01', 6)
FROM DUAL;

-- ��¥ ���� ����, ��, ��, ��, ��, ��
-- year, month, day, hour, minute, second
select extract(year from sysdate) as ����,
    --extract(year from to_date('201202', 'yymmdd')) as ����,
    extract(month from sysdate) as ��,
    extract(day from sysdate) as ��,
    extract(hour from cast(sysdate as timestamp)) as ��,
    extract(minute from cast(sysdate as timestamp)) as ��,
    extract(second from cast(sysdate as timestamp)) as ��
from dual;


