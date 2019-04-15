CREATE TABLE BOARD(
	BOARD_ID NUMBER PRIMARY KEY,
	TITLE VARCHAR2(256) NOT NULL,
	WRITER VARCHAR2(50) NOT NULL,
	PASSWORD VARCHAR2(20) NOT NULL,
	READ_CNT NUMBER DEFAULT(0),
	CONTENT CLOB,
	REG_DATE DATE DEFAULT(SYSDATE),
	UPDATE_DATE DATE DEFAULT(SYSDATE)
)
select * from board;
CREATE SEQUENCE BOARD_SEQ;

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
	USER_ID VARCHAR2(10 CHAR) PRIMARY KEY,
	PASSWORD VARCHAR2(256 CHAR),
	NAME VARCHAR2(20 CHAR),
	SALT VARCHAR2(16),
	USER_LEVEL VARCHAR2(20 CHAR),
	EMAIL VARCHAR2(40 CHAR),
	PHONE VARCHAR2(20 CHAR),
	ADDRESS VARCHAR2(200 CHAR),
	REG_DATE DATE DEFAULT sysdate,
	UPDATE_DATE DATE DEFAULT sysdate
);

create sequence member_seq;
select * from member;

insert into member(user_id, password, name, salt,
					user_level, email, phone, address)
	values('hyunholee', 000000, '?씠?쁽?샇', '?땲誘?',
			'怨⑤뱶', 'hyunholee@gmail.com', 010, '?꽌?슱 媛뺣궓援?');


CREATE table gallery(
	gallery_id number primary key,
	owner varchar2(50),
	password varchar2(50),
	title	varchar2(256 char),
	description varchar2(512 char),
	read_cnt number default 0,
	reg_date date default sysdate,
	update_date date default sysdate
);
create sequence gallery_seq;

drop table image;
drop sequence image_seq;
create table image(
	image_id number primary key,
	gallery_id number references gallery(gallery_id),
	original_name varchar2(128 char),
	file_size number,
	mime_type varchar2(56),
	reg_date date default sysdate
);

create sequence image_seq;

			
create table avata(
	user_id varchar(20) primary key,
	image blob

);

DROP TABLE BLOG;
drop sequence blog_seq;
CREATE TABLE BLOG(
	
	blog_id NUMBER PRIMARY KEY,
	user_id VARCHAR2(50),
	title VARCHAR2(256 CHAR),
	description VARCHAR2(512 CHAR),
	good_cnt NUMBER,
	reg_date DATE DEFAULT SYSDATE,
	update_date DATE DEFAULT SYSDATE
);

CREATE SEQUENCE BLOG_SEQ;

insert into blog
  values(3, 'hyunho3', '사용자테스트3', '블로그테스트3', 3, sysdate, sysdate);

alter table blog user_id refence


delete post
where post_ID=2;

drop table post;
drop sequence post_seq;
CREATE TABLE POST(
	post_id NUMBER PRIMARY KEY,
	blog_id NUMBER REFERENCES BLOG(blog_id),
	title VARCHAR2(256 CHAR),
	description VARCHAR2(512 CHAR),
	good_cnt NUMBER,
	reg_date DATE DEFAULT SYSDATE,
	update_date DATE DEFAULT SYSDATE
);
create sequence post_seq;

-- 블로그 사용자 테스트
insert into post(post_id, blog_id, title, description)
  values(3, 3, 'hyunho3의 첫 게시글', 'hyunho3의 게시글에 대한 내용입니다');
  
  
  
  
  
  
  
  
  
  
