create table t_book
(
    id     int auto_increment comment '主键'
        primary key,
    name   varchar(255) null comment '书名',
    cover  varchar(500) null comment '封面图',
    author varchar(255) null comment '作者'
);

INSERT INTO javaweb.t_book (id, name, cover, author)
VALUES (1, 'Java 8实战', 'https://mqxu-upload.oss-cn-hangzhou.aliyuncs.com/book/6.jpeg', '厄马');
INSERT INTO javaweb.t_book (id, name, cover, author)
VALUES (2, '深入理解Java虚拟机', 'https://mqxu-upload.oss-cn-hangzhou.aliyuncs.com/book/5.jpeg', '周志明');
INSERT INTO javaweb.t_book (id, name, cover, author)
VALUES (3, 'Java设计模式
', 'https://mqxu-upload.oss-cn-hangzhou.aliyuncs.com/book/3.jpeg', '刘伟');
INSERT INTO javaweb.t_book (id, name, cover, author)
VALUES (4, 'Effective Java中文版', 'https://mqxu-upload.oss-cn-hangzhou.aliyuncs.com/book/4.jpeg', '[美] Joshua Bloch');
INSERT INTO javaweb.t_book (id, name, cover, author)
VALUES (5, 'Java核心技术', 'https://mqxu-upload.oss-cn-hangzhou.aliyuncs.com/book/1.jpeg', '[美] 凯 S.霍斯特曼');
INSERT INTO javaweb.t_book (id, name, cover, author)
VALUES (6, 'Java编程思想', 'https://mqxu-upload.oss-cn-hangzhou.aliyuncs.com/book/2.jpeg', '[美] Bruce Eckel');