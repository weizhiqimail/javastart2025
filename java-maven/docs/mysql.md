# sql

- DDL(Data Definition Language) 数据定义语言，用来定义数据库对象（数据库、数据表、字段）。
- DML(Data Manipulation Language) 数据操作语言，用来对数据进行增、删、改等操作。不包括查询操作。
- DQL(Data Query Language) 数据查询语言，用来查询数据。
- DCL(Data Control Language) 数据控制语言，用来控制数据的访问权限。

# mysql 操作

## 基本操作

+ 创建数据表

```mysql
CREATE TABLE user
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    age    INT,
    gender ENUM ('男', '女', '未知')
);
```

+ 添加数据

```mysql
INSERT INTO user (name, age, gender) VALUES ('郭靖', 35, '男');
INSERT INTO user (name, age, gender) VALUES ('黄蓉', 32, '女');
INSERT INTO user (name, age, gender) VALUES ('杨过', 28, '男');
INSERT INTO user (name, age, gender) VALUES ('小龙女', 29, '女');
INSERT INTO user (name, age, gender) VALUES ('张无忌', 22, '男');
INSERT INTO user (name, age, gender) VALUES ('赵敏', 20, '女');
INSERT INTO user (name, age, gender) VALUES ('萧峰', 33, '男');
INSERT INTO user (name, age, gender) VALUES ('阿朱', 21, '女');
INSERT INTO user (name, age, gender) VALUES ('令狐冲', 25, '男');
INSERT INTO user (name, age, gender) VALUES ('任盈盈', 24, '女');
```

+ 查看数据表

```mysql
-- 查看数据表结构

DESCRIBE user;

SHOW COLUMNS FROM user;

-- 查看创建表的完整 SQL 语句

SHOW CREATE TABLE user;
```
