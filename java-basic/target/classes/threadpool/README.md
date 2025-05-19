# 线程池

- 线程池就是一个可以复用线程的技术。
- 不使用线程的问题
  - 用于每发起一个请求，后台就需要创建一个新线程来处理。创建新线程开销很大，请求过多时，会产生大量的线程，影响系统性能。
- 工作原理
  - 工作线程 work thread
  - 任务队列 work queue
- 创建线程池
  - 接口：ExecutorService。
  - 实现类：ThreadPoolExecutor。或使用Executors工具类创建线程池。



