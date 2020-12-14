/* 문제1 ) EMPLOYEES 테이블에서 부서별로 인원수 평균 급여 급여의 합 최소 급여
최대 급여를 포함하는 EMP_DEPTNO 테이블을 생성하라*/
CREATE TABLE EMP_DEPTNO(DEPTNO, NUM, AG, SM, MN, MX )
AS SELECT department_id, COUNT(employee_id), ROUND(AVG(salary)), SUM(salary), MIN(salary), MAX(salary)
FROM employees
GROUP BY department_id;

DROP TABLE EMP_DEPTNO;

-- 문제2) EMP_DEPTNO 테이블에 ETC COLUMN 을 추가하라 . 단 자료형은 VARCHAR2(50) 사용하라
ALTER TABLE EMP_DEPTNO
ADD
"ETC COLUMN" VARCHAR2(50);

-- 문제3) EMP_DEPTNO 테이블에 ETC COLUMN 을 수정 하라 . 자료형은 VARCHAR2(15) 로 하라
ALTER TABLE EMP_DEPTNO
MODIFY
"ETC COLUMN" VARCHAR2(15);

-- 문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라
ALTER TABLE EMP_DEPTNO
DROP
COLUMN "ETC COLUMN";

-- 문제5) 이전에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT 로 변경하라
ALTER TABLE EMP_DEPTNO
RENAME
TO EMP_DEPT;

-- 문제6) EMP_DEPT 테이블 을 삭제하라
DROP TABLE EMP_DEPT;

-- 문제7) EMPLOYEES 테이블 을 EMP 테이블을 생성하고 복제하도록 하라 (데이터 포함)
CREATE TABLE EMP
AS SELECT
    *
FROM employees;

/* 문제8) EMP 테이블에 row 를 추가해 봅니다
다만, 반드시 데이터를 기입을 안해도 되면 , NULL 로 설정하도록 한다 */
INSERT INTO EMP(EMPLOYEE_ID, FIRST_NAME)
VALUES(999, GALAXY);

/* 문제9) EMPLOYEES 테이블에서 EMPNO,ENAME,SAL,HIREDATE 의 COLUMN 만
선택하여 EMP_10 테이블을 생성 데이터 미포함 한 후 10 번 부서만 선택하여
이에 대응하는 값을 EMP_10 테이블에 입력하라 */