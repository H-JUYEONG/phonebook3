-- --------------------------------------------
# phonebook 계정에서 실행
-- --------------------------------------------
-- db 선택(phonebook 계정에서 실행)
use phonebook_db;

-- table 삭제
drop table person;

-- person 테이블 생성(phonebook 계정에서 실행)
create table person(
   person_id integer primary key auto_increment,
    name varchar(30) not null,
    hp varchar(20),
    company varchar(20)
);

-- 조회
select * from person;

select    person_id,
      name,
        hp,
        company
from person;

-- 등록
insert into person
values(null, '정우성', '010-1111-1111', '02-1111-1111');

insert into person
values(null, '이효리', '010-2222-2222', '02-2222-2222');

insert into person
values(null, '강호동', '010-3333-3333', '02-3333-3333');

-- 수정
update person
set name = '강호동',
   hp = '010-9999-9999',
    company = '02-9999-9999'
where person_id = 3 ;

-- 삭제
delete from person
where person_id = 1;