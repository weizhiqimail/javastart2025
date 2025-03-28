-- 查看所有数据库
SHOW DATABASES;

-- 选中数据库
use javastart;

-- 查看当前数据库
SHOW TABLES;

-- 查看当前数据库
SELECT DATABASE();

-- 创建[学生]数据表，指定 utf8m64 字符集
CREATE TABLE if not exists `student`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `name`  varchar(50) DEFAULT NULL,
    `phone` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 插入一条数据
INSERT INTO `student` (`name`, `phone`) VALUES ('张三', '13800138000');

-- 插入多条数据
INSERT INTO `student` (`name`, `phone`) VALUES ('李四', '13800138001'), ('王五', '13800138002');

-- 查询所有数据
SELECT * FROM `student`;

-- 查询所有数据，按 id 降序排列
SELECT * FROM `student` ORDER BY id DESC;

-- 查询所有数据，按 id 升序排列
SELECT * FROM `student` ORDER BY id ASC;

-- 查询所有数据，按 id 升序排列，限制查询 2 条数据
SELECT * FROM `student` ORDER BY id ASC LIMIT 2;


-- 查询所有数据，按 id 升序排列，限制查询 2 条数据，从第 1 条开始
SELECT * FROM `student` ORDER BY id ASC LIMIT 2 OFFSET 1;

-- 删除一条数据
DELETE FROM `student` WHERE id = 1;

-- 删除一张数据表的所有数据
DELETE FROM `student`;

-- 删除表
DROP TABLE IF EXISTS `student`;

