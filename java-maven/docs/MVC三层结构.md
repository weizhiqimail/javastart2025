# MVC三层结构

- 三层架构的流程
  - Http Request
  - Controller
    - 接收请求
    - 调用Service
    - 响应结果
  - Service
    - 使用 Mapper 接口
  - Mapper
    - DB 操作
  - Http Response