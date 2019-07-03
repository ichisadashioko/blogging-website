use Blogging


CREATE TABLE visit_history (
	--id char(32) not null primary key,
	ip nvarchar(128) not null,
	time_visit DATETIME not null,
	request_url TEXT not null
)

drop table visit_history

select * from visit_history

select count(time_visit) as c from visit_history

select count(*) as c from visit_history


drop table BlogTypes

CREATE TABLE BlogTypes(
    id varchar(32) NOT NULL PRIMARY KEY,
    icon_class varchar(32)
)

insert into BlogTypes(id, icon_class) values
('article', 'pencil'),
('quote', 'quote-left'),
('photo', 'camera-retro')

select * from BlogTypes

drop table BlogPosts

CREATE TABLE BlogPosts (
    id INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
    title nvarchar(256) NOT NULL,
    dc DATETIME NOT NULL DEFAULT GETDATE(),
    blog_type varchar(32) NOT NULL REFERENCES BlogTypes(id),
    content TEXT,
    img TEXT,
    author TEXT
)

INSERT INTO BlogPosts (title, dc, blog_type, content, img, author) VALUES

('Essential skills for a happy life!', '20151116 23:50:00', 'article', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
At eam doctus oportere, eam feugait delectus ne. Quo cu vulputate persecuti. Eum ut natum possim comprehensam, habeo dicta scaevola eu nec. Ea adhuc reformidans eam. Pri dolore epicuri eu, ne cum tantas fierent instructior. Pro ridens intellegam ut, sea at graecis scriptorem eloquentiam.
Per an labitur lucilius ullamcorper, esse erat ponderum ad vim. Possim laoreet suscipit ex pri, vix numquam eruditi feugait in. Nec maluisset complectitur te, at sea decore semper. Falli numquam perpetua sea et, tibique repudiandae an pro. Ut his solum persius postulant. Soluta nemore debitis ne eos, cum an scripta pericula partiendo.', 'images/i283445314544979646._szw480h1280_.jpg', ''),
('You''ve gotta dance', '20151116 15:50:00', 'quote', '"You''ve gotta dance like there''s nobody watching,
Love like you''ll never be hurt,
Sing like there''s nobody listening,
And live like it''s heaven on earth."','', 'William W. Purkey'),
('Photo', '20151116 07:50:00', 'photo', '', 'images/i283445314544979644._szw1280h1280_.jpg', '')

select * from BlogPosts

select top(3) p.id, p.title, p.dc, p.blog_type, p.content, p.img, p.author, t.icon_class from BlogPosts as p join BlogTypes as t on p.blog_type=t.id order by p.dc desc

select * from (
select ROW_NUMBER() over(order by dc desc) as rownum, id, title, dc, blog_type, content, img, author
from BlogPosts
) as s
where s.rownum > 1 and s.rownum < 5

select * from (select ROW_NUMBER() over(order by dc desc) as rownum, id, title, dc from BlogPosts) as s where s.rownum >= 1 and s.rownum < 5


create table about (
    dc datetime default getdate() not null,
    content text not null
)

select * from about

drop table about