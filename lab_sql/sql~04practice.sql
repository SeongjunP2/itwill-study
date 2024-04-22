-- ename의 값을 upper는 대문자, lower는 소문자, initcap은 첫 번째 철자만 대문자로 출력
select upper(ename), lower(ename), initcap(ename) from emp;

-- ename의 값이 scott인 ename과 sal값 출력
select ename, sal from emp where lower(ename) like 'scott'; --> ename의 값을 lower(ename)으로 소문자로 바꾸고 like로 같은지 매치

-- 특정 문자열 출력
select substr('SMITH',1,3) from dual; --> substr 함수로 1에서 3까지의 철자를 출력
select substr('SMITH',3) from dual; --> 철자 위치 3부터 출력

-- 문자열 길이 출력
select ename, length(ename) from emp; --> length 함수로 ename의 문자열 길이를 출력

-- 철자 위치 출력
select instr('SMITH', 'M') from dual; --> M이라는 철자가 SMITH의 몇번째 철자에 위치해 있는지 출력
select instr('SMIMTH', 'M') from dual; --> M이라는 철자가 여러개 존재하여도 처음으로 마주한 M 철자의 위치를 출력

select substr('abcdefgh@naver.com', instr('abcdefgh@naver.com','@')+1) from dual; --> naver.com만 출력

-- 특정 철자 변경
select ename, replace(sal, 0, '*') from emp; --> sal 값에 0이 포함될 경우 0을 *로 변경
select ename, regexp_replace(sal, '[0-3]', '*') as SALARY from emp; --> sal의 값에 0~3까지 숫자가 포함될 경우 *로 변경
