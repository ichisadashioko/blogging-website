-- post (title, content, date)

CREATE DATABASE Blogging
GO
USE Blogging
GO

DROP TABLE POSTS
GO

CREATE TABLE visit_history (
	id char(32) not null primary key,
	time_visit DATETIME not null,
	request_url TEXT not null
)

drop table visit_history

select * from visit_history

-- 3 types of posts
-- every post has (heading, date_create)
-- each post has its own icon class
-- article type (paragraph,  image(optional))
-- quote type (quote, author)
-- photo type (image)

-- post type table to store post type and icon class
drop table post_types

create table post_types (
	p_type varchar(32) not null primary key,
	icon_class varchar(32),
)

insert into post_types(p_type, icon_class) values
('article', 'pencil'),
('quote', 'quote-left'),
('photo', 'camera-retro')

select * from post_types

-- a table to store all type of posts with their (heading, date_create, type) with auto id increase
drop table posts

create table posts (
	id char(32) not null primary key,
	heading text not null,
	dc datetime not null default getdate(),
	p_type varchar(32) not null references post_types(p_type)
)

select * from posts

delete from posts where id=1


insert into posts (id, heading, dc, p_type) values
('94f625560dee7c12a8d3e3548efe6306', 'Essential skills for a happy life!', '20151116 23:50:00', 'article'),
('550aa7ab596451ad01118578b3a6703c', 'You''ve gotta dance', '20151116 15:50:00', 'quote'),
('3c26b69190be1f7289b256ff311f04a2', 'Photo', '20151116 07:50:00', 'photo')

-- article table (id, content, images)
drop articles

select * from articles

create table articles (
	id char(32) not null primary key references posts(id),
	content text not null,
	img text
)

insert into articles (id, content, img) values
('94f625560dee7c12a8d3e3548efe6306', 
'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
At eam doctus oportere, eam feugait delectus ne. Quo cu vulputate persecuti. Eum ut natum possim comprehensam, habeo dicta scaevola eu nec. Ea adhuc reformidans eam. Pri dolore epicuri eu, ne cum tantas fierent instructior. Pro ridens intellegam ut, sea at graecis scriptorem eloquentiam.
Per an labitur lucilius ullamcorper, esse erat ponderum ad vim. Possim laoreet suscipit ex pri, vix numquam eruditi feugait in. Nec maluisset complectitur te, at sea decore semper. Falli numquam perpetua sea et, tibique repudiandae an pro. Ut his solum persius postulant. Soluta nemore debitis ne eos, cum an scripta pericula partiendo.', 'images/i283445314544979646._szw480h1280_.jpg')
-- quote table
drop table quotes

select * from quotes

create table quotes (
	id char(32) not null primary key references posts(id),
	content text not null,
	author text not null
)

insert into quotes(id, content, author) values
('550aa7ab596451ad01118578b3a6703c', '"You''ve gotta dance like there''s nobody watching,
Love like you''ll never be hurt,
Sing like there''s nobody listening,
And live like it''s heaven on earth."', 'William W. Purkey')

-- photo table
drop photos

select * from photos

create table photos (
	id char(32) not null primary key references posts(id),
	img text not null,
)

insert into photos (id, img) values
('3c26b69190be1f7289b256ff311f04a2', 'images/i283445314544979644._szw1280h1280_.jpg')

CREATE TABLE POSTS (
    ID INT NOT NULL IDENTITY(1, 1) PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    CONTENT TEXT NOT NULL,
    DATE_CREATED DATE NOT NULL DEFAULT GETDATE()
)
GO

SELECT * FROM POSTS

DELETE FROM POSTS

INSERT INTO POSTS (TITLE, CONTENT, DATE_CREATED) VALUES
('Essential skills for a happy life!','<div class="img-simple span6 pull-left"><div class="image"><img src="images/i283445314544979646._szw480h1280_.jpg"></div></div><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p><p>At eam doctus oportere, eam feugait delectus ne. Quo cu vulputate persecuti. Eum ut natum possim comprehensam, habeo dicta scaevola eu nec. Ea adhuc reformidans eam. Pri dolore epicuri eu, ne cum tantas fierent instructior. Pro ridens intellegam ut, sea at graecis scriptorem eloquentiam.</p><p>Per an labitur lucilius ullamcorper, esse erat ponderum ad vim. Possim laoreet suscipit ex pri, vix numquam eruditi feugait in. Nec maluisset complectitur te, at sea decore semper. Falli numquam perpetua sea et, tibique repudiandae an pro. Ut his solum persius postulant. Soluta nemore debitis ne eos, cum an scripta pericula partiendo.</p>','20151116'),
('You''ve gotta dance','<blockquote class="pull-right"><p>"“You''ve gotta dance like there''s nobody watching,<br>Love like you''ll never be hurt,<br>Sing like there''s nobody listening,<br>And live like it''s heaven on earth.” "</p><small><cite title="William W. Purkey">William W. Purkey</cite></small></blockquote>','20151115'),
('Photo','<div class="img-simple"><div class="image"><img src="image/i283445314544979644._szw1280h1280_.jpg"></div></div>','20151114')