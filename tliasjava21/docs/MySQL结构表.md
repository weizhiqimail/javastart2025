
## dept 表

```mysql
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


INSERT INTO dept(id, name, create_time, update_time)
VALUES (1, '人事部', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
       (2, '财务部', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
       (3, '研发部', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
       (4, '市场部', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
       (5, '销售部', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
       (6, '客服部', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
       (7, 'IT部', '2023-10-01 10:00:00', '2023-10-01 10:00:00'),
       (8, '法务部', '2023-10-01 10:00:00', '2023-10-01 10:00:00');
```