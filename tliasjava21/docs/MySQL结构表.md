
## dept 表

```mysql
-- 部门表
CREATE TABLE dept
(
    id          INT PRIMARY KEY AUTO_INCREMENT COMMENT "部门ID",
    name        VARCHAR(50) NOT NULL COMMENT "部门名称",
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新时间"
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='部门表';

-- 1. 蜀汉军部
INSERT INTO dept (id, name, create_time, update_time)
VALUES (1, '蜀汉军部', '1975-01-01 08:00:00', '1998-04-24 10:00:00');

-- 2. 魏国中枢
INSERT INTO dept (id, name, create_time, update_time)
VALUES (2, '魏国中枢', '1986-01-01 07:00:00', '2015-03-15 16:00:00');

-- 3. 东吴水军
INSERT INTO dept (id, name, create_time, update_time)
VALUES (3, '东吴水军', '1993-01-01 08:30:00', '2012-05-21 11:00:00');

-- 4. 荆州守备
INSERT INTO dept (id, name, create_time, update_time)
VALUES (4, '荆州守备', '2001-01-01 09:00:00', '2020-10-01 12:00:00');

-- 5. 益州政务
INSERT INTO dept (id, name, create_time, update_time)
VALUES (5, '益州政务', '1982-01-01 09:30:00', '2005-08-01 15:00:00');

-- 6. 曹魏骑兵
INSERT INTO dept (id, name, create_time, update_time)
VALUES (6, '曹魏骑兵', '1995-01-01 08:00:00', '2019-01-01 13:00:00');

-- 7. 孙吴都督府
INSERT INTO dept (id, name, create_time, update_time)
VALUES (7, '孙吴都督府', '1978-01-01 09:00:00', '2003-01-01 13:00:00');

-- 8. 汉中防线
INSERT INTO dept (id, name, create_time, update_time)
VALUES (8, '汉中防线', '2008-01-01 10:00:00', '2022-01-01 14:00:00');

-- 9. 洛阳朝廷
INSERT INTO dept (id, name, create_time, update_time)
VALUES (9, '洛阳朝廷', '1989-01-01 07:30:00', '1999-03-15 15:00:00');

-- 10. 江东文署
INSERT INTO dept (id, name, create_time, update_time)
VALUES (10, '江东文署', '1989-01-01 08:00:00', '2018-05-21 12:00:00');
```

## emp 表
```mysql

CREATE TABLE emp
(
    id          INT AUTO_INCREMENT PRIMARY KEY COMMENT '员工ID，主键自增',
    username    VARCHAR(50)  NOT NULL UNIQUE COMMENT '用户名，唯一且非空',
    password    VARCHAR(100) NOT NULL COMMENT '密码，非空',
    name        VARCHAR(50)  NOT NULL COMMENT '姓名，非空',
    gender      TINYINT        DEFAULT NULL COMMENT '性别，0表示女，1表示男',
    phone       VARCHAR(20)    DEFAULT NULL COMMENT '电话号码',
    job         VARCHAR(50)    DEFAULT NULL COMMENT '职位',
    salary      DECIMAL(10, 2) DEFAULT 0.00 COMMENT '薪资，精确到两位小数',
    entry_date  DATE           DEFAULT NULL COMMENT '入职日期',
    image       VARCHAR(255)   DEFAULT NULL COMMENT '员工图片路径',
    dept_id     INT            DEFAULT NULL COMMENT '部门ID，外键',
    create_time DATETIME     NOT NULL COMMENT '创建时间',
    update_time DATETIME     NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC
    COMMENT = '员工表';



INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (1, 'liubei01', 'xuande123', '刘备', 1, '12345670001', '统帅', 10000.00, '1985-06-15', NULL, 1,
        '1985-06-15 09:00:00', '2010-03-20 14:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (2, 'guanyu01', 'yunchang456', '关羽', 1, '12345670002', '将军', 8000.00, '1987-09-22', NULL, 1,
        '1987-09-22 10:15:00', '2015-11-10 16:45:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (3, 'zhangfei01', 'yide789', '张飞', 1, '12345670003', '将军', 7500.00, '1989-02-13', NULL, 1,
        '1989-02-13 08:30:00', '2018-07-25 12:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (4, 'zhaoyun01', 'zilong606', '赵云', 1, '12345670004', '将军', 7800.00, '1990-11-05', NULL, 1,
        '1990-11-05 11:00:00', '2020-04-15 13:20:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (5, 'machao01', 'mengqi707', '马超', 1, '12345670005', '将军', 7600.00, '1992-08-19', NULL, 1,
        '1992-08-19 09:45:00', '2019-09-30 15:10:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (6, 'huangzhong01', 'hansheng808', '黄忠', 1, '12345670006', '将军', 7400.00, '1994-03-27', NULL, 1,
        '1994-03-27 14:00:00', '2021-12-05 10:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (7, 'weiyan01', 'changsheng', '魏延', 1, '12345670007', '将军', 7200.00, '1996-07-10', NULL, 1,
        '1996-07-10 12:30:00', '2023-01-15 11:15:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (8, 'jiangwei01', 'boyue', '姜维', 1, '12345670008', '将军', 7900.00, '1998-12-01', NULL, 1,
        '1998-12-01 15:00:00', '2024-06-20 09:45:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (9, 'wangping01', 'zhongxian', '王平', 1, '12345670009', '副将', 6800.00, '2000-05-14', NULL, 1,
        '2000-05-14 10:00:00', '2017-08-25 14:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (10, 'liuyan01', 'junlang', '刘琰', 1, '12345670010', '副将', 6500.00, '2002-09-30', NULL, 1,
        '2002-09-30 13:15:00', '2016-03-10 16:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (11, 'caocao01', 'mengde202', '曹操', 1, '12345670011', '统帅', 12000.00, '1980-04-25', NULL, 2,
        '1980-04-25 08:00:00', '2005-11-15 15:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (12, 'simayi01', 'zhongda909', '司马懿', 1, '12345670012', '军师', 8800.00, '1983-07-12', NULL, 2,
        '1983-07-12 09:30:00', '2012-09-20 14:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (13, 'guojia01', 'fengxiao1313', '郭嘉', 1, '12345670013', '谋士', 8200.00, '1986-10-08', NULL, 2,
        '1986-10-08 11:00:00', '2008-02-25 12:45:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (14, 'xunyu01', 'wenruo', '荀彧', 1, '12345670014', '谋士', 8500.00, '1988-01-19', NULL, 2,
        '1988-01-19 10:15:00', '2010-06-30 13:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (15, 'xushu01', 'yuanzhi1414', '徐庶', 1, '12345670015', '谋士', 7800.00, '1991-03-27', NULL, 2,
        '1991-03-27 14:00:00', '2015-12-10 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (16, 'caopi01', 'zixuan', '曹丕', 1, '12345670016', '皇帝', 11000.00, '1993-06-14', NULL, 2,
        '1993-06-14 12:30:00', '2018-04-05 11:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (17, 'caozhi01', 'zijian', '曹植', 1, '12345670017', '文臣', 7000.00, '1995-09-22', NULL, 2,
        '1995-09-22 09:45:00', '2020-07-15 13:15:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (18, 'chenqun01', 'changwen', '陈群', 1, '12345670018', '文臣', 7200.00, '1997-12-03', NULL, 2,
        '1997-12-03 15:00:00', '2022-10-20 14:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (19, 'zhongyao01', 'yuanchang', '钟繇', 1, '12345670019', '文臣', 7400.00, '1999-02-18', NULL, 2,
        '1999-02-18 10:00:00', '2023-03-25 12:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (20, 'jiakui01', 'liangdao', '贾逵', 1, '12345670020', '谋士', 7100.00, '2001-05-09', NULL, 2,
        '2001-05-09 11:30:00', '2019-08-30 16:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (21, 'sunquan01', 'zhongmou303', '孙权', 1, '12345670021', '统帅', 9500.00, '1982-08-11', NULL, 3,
        '1982-08-11 09:00:00', '2015-05-20 14:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (22, 'zhouyu01', 'gongjin404', '周瑜', 1, '12345670022', '都督', 8500.00, '1984-11-25', NULL, 3,
        '1984-11-25 10:30:00', '2010-09-15 12:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (23, 'luxun01', 'boyan1717', '陆逊', 1, '12345670023', '都督', 8600.00, '1987-03-14', NULL, 3,
        '1987-03-14 12:00:00', '2018-12-10 15:45:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (24, 'ganning01', 'xingba1717', '甘宁', 1, '12345670024', '将军', 7200.00, '1989-06-30', NULL, 3,
        '1989-06-30 13:15:00', '2016-04-25 11:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (25, 'lvmeng01', 'ziming', '吕蒙', 1, '12345670025', '将军', 7800.00, '1991-09-17', NULL, 3,
        '1991-09-17 14:30:00', '2020-02-20 13:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (26, 'huanggai01', 'gongfu', '黄盖', 1, '12345670026', '将军', 7000.00, '1993-12-05', NULL, 3,
        '1993-12-05 09:45:00', '2017-07-15 12:15:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (27, 'zhoutai01', 'youping', '周泰', 1, '12345670027', '将军', 7100.00, '1996-02-22', NULL, 3,
        '1996-02-22 11:00:00', '2021-10-30 14:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (28, 'dingfeng01', 'chengyuan', '丁奉', 1, '12345670028', '将军', 6900.00, '1998-05-13', NULL, 3,
        '1998-05-13 12:30:00', '2023-03-25 15:15:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (29, 'lingtong01', 'gongji', '凌统', 1, '12345670029', '将军', 6700.00, '2000-08-09', NULL, 3,
        '2000-08-09 14:00:00', '2019-06-20 11:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (30, 'panjun01', 'chengming', '潘濬', 1, '12345670030', '副将', 6500.00, '2002-11-27', NULL, 3,
        '2002-11-27 09:15:00', '2024-01-10 13:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (31, 'guanyu02', 'yunchang456', '关羽', 1, '12345670031', '守将', 8000.00, '1981-07-03', NULL, 4,
        '1981-07-03 10:00:00', '2010-05-15 14:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (32, 'guanyinping01', 'yinping', '关银屏', 0, '12345670032', '副将', 6000.00, '1983-10-19', NULL, 4,
        '1983-10-19 11:30:00', '2012-08-25 12:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (33, 'guanping01', 'pingan', '关平', 1, '12345670033', '副将', 6200.00, '1985-12-07', NULL, 4,
        '1985-12-07 13:00:00', '2015-03-10 15:45:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (34, 'zhoucang01', 'zhongfu', '周仓', 1, '12345670034', '将军', 6500.00, '1988-04-22', NULL, 4,
        '1988-04-22 09:45:00', '2017-09-30 11:15:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (35, 'liaohua01', 'yuanjian', '廖化', 1, '12345670035', '将军', 6700.00, '1990-07-15', NULL, 4,
        '1990-07-15 14:00:00', '2019-12-05 13:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (36, 'mifang01', 'zifang', '糜芳', 1, '12345670036', '副将', 6100.00, '1992-09-28', NULL, 4,
        '1992-09-28 10:15:00', '2021-06-20 12:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (37, 'fushi01', 'wenwei', '傅士仁', 1, '12345670037', '副将', 6000.00, '1995-01-13', NULL, 4,
        '1995-01-13 12:30:00', '2023-04-15 14:45:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (38, 'wangfu01', 'zhongwei', '王甫', 1, '12345670038', '谋士', 6300.00, '1997-03-30', NULL, 4,
        '1997-03-30 09:00:00', '2020-10-25 11:30:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (39, 'zhaoji01', 'wenji', '赵济', 1, '12345670039', '副将', 6400.00, '1999-06-17', NULL, 4,
        '1999-06-17 11:00:00', '2018-02-10 13:15:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (40, 'liuzhang01', 'zongxian', '刘璋', 1, '12345670040', '文官', 6600.00, '2001-09-05', NULL, 4,
        '2001-09-05 14:30:00', '2024-07-20 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (41, 'zhugeliang01', 'kongming101', '诸葛亮', 1, '12345670041', '丞相', 9000.00, '207-01-01', NULL, 5,
        '207-01-01 09:30:00', '234-08-01 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (42, 'pangtong01', 'shiyuan1515', '庞统', 1, '12345670042', '谋士', 7800.00, '211-01-01', NULL, 5,
        '211-01-01 09:30:00', '214-01-01 14:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (43, 'fazheng01', 'xiaozhi', '法正', 1, '12345670043', '谋士', 7600.00, '211-01-01', NULL, 5,
        '211-01-01 09:30:00', '220-01-01 13:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (44, 'mizhu01', 'zirong', '糜竺', 1, '12345670044', '文官', 7000.00, '207-01-01', NULL, 5, '207-01-01 09:30:00',
        '234-08-01 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (45, 'jianyon01', 'xianhe', '简雍', 1, '12345670045', '文官', 6800.00, '207-01-01', NULL, 5,
        '207-01-01 09:30:00', '234-08-01 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (46, 'sunqian01', 'gongyou', '孙乾', 1, '12345670046', '文官', 6700.00, '207-01-01', NULL, 5,
        '207-01-01 09:30:00', '234-08-01 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (47, 'yiji01', 'jibo', '伊籍', 1, '12345670047', '文官', 6600.00, '207-01-01', NULL, 5, '207-01-01 09:30:00',
        '234-08-01 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (48, 'donghe01', 'gongren', '董和', 1, '12345670048', '文官', 6500.00, '207-01-01', NULL, 5,
        '207-01-01 09:30:00', '234-08-01 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (49, 'liyan01', 'zhengfang', '李严', 1, '12345670049', '文官', 7200.00, '211-01-01', NULL, 5,
        '211-01-01 09:30:00', '234-08-01 15:00:00');

INSERT INTO emp (id, username, password, name, gender, phone, job, salary, entry_date, image, dept_id, create_time,
                 update_time)
VALUES (50, 'feiyi01', 'wenwei', '费祎', 1, '12345670050', '文官', 7400.00, '221-01-01', NULL, 5, '221-01-01 09:30:00',
        '253-01-01 14:00:00');
```

## expr 表

```mysql
CREATE TABLE IF NOT EXISTS expr
(
    id           INT AUTO_INCREMENT PRIMARY KEY COMMENT '招式的唯一标识，自增主键',
    emp_id       INT          NOT NULL COMMENT '关联emp表的 id',
    company_name VARCHAR(100) NOT NULL COMMENT '公司名称，最大长度为 100 个字符',
    job          VARCHAR(100) NOT NULL COMMENT '职位名称，最大长度为 100 个字符',
    start_date   DATE         NOT NULL COMMENT '开始日期',
    end_date     DATE         NOT NULL COMMENT '结束日期'
) COMMENT '工作经历' ENGINE = InnoDB
                     DEFAULT CHARSET = utf8mb4;

```




