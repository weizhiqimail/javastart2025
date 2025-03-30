## MVC三层结构

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

## 简单http参数获取
- 使用 HttpServletRequest 获取请求参数。
- 使用 @RequestParam 注解获取请求参数，使用后参数默认为必传。
- 参数名与形参变量名一致。

## 全局异常处理




