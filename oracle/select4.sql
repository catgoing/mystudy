/*
    order by = sorting
    
    DB -> SORTING -> JAVA   이게 성능이 더 좋음
    DB -> JAVA -> SORTING
    
    SELECT *
    FROM TABLE
    ORDER BY SAL ASC  ---> 오름차순
    ORDER BY SAL DESC ---> 내림차순
    

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

-- 두 날짜 간의 월수(월 간격)
SELECT MONTHS_BETWEEN(SYSDATE, '2021-04-13')
FROM DUAL;

-- 특정 날짜 월에 정수를 더한 다음 해당 날짜를 반환
SELECT ADD_MONTHS('2020-12-01', 6)
FROM DUAL;

-- 날짜 정보 연도, 월, 일, 시, 분, 초
-- year, month, day, hour, minute, second
select extract(year from sysdate) as 연도,
    --extract(year from to_date('201202', 'yymmdd')) as 연도,
    extract(month from sysdate) as 월,
    extract(day from sysdate) as 일,
    extract(hour from cast(sysdate as timestamp)) as 시,
    extract(minute from cast(sysdate as timestamp)) as 분,
    extract(second from cast(sysdate as timestamp)) as 초
from dual;


