create table t_user
(
    id          int auto_increment comment '主键'
        primary key,
    account     varchar(200)                       not null comment '账号',
    password    varchar(32)                        not null comment '密码',
    nickname    varchar(32)                        null comment '昵称',
    avatar      varchar(255)                       null comment '头像',
    address     varchar(255)                       null comment '地址',
    create_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '创建时间',
    constraint username
        unique (account)
);

INSERT INTO javaweb.t_user (id, account, password, nickname, avatar, address, create_time)
VALUES (1, 'mqxu@qq.com', '698d51a19d8a121ce581499d7b701668', '陶然然',
        'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.jpg', '江苏南京', '2022-02-27 17:55:16');
INSERT INTO javaweb.t_user (id, account, password, nickname, avatar, address, create_time)
VALUES (2, 'aaa@qq.com', '698d51a19d8a121ce581499d7b701668', '用户aaa',
        'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/1.jpg', '浙江杭州', '2022-02-27 17:57:26');
INSERT INTO javaweb.t_user (id, account, password, nickname, avatar, address, create_time)
VALUES (5, 'bbb@qq.com', '698d51a19d8a121ce581499d7b701668', '用户bbb',
        'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/2.jpg', '湖北武汉', '2022-02-27 17:57:29');