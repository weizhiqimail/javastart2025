## io 流

- io 流的作用：读写数据（磁盘数据、网络数据） 
- 方向：输入流、输出流 
- 流的内容： 
- 字节流：适合所有类型文件，图片、音视频的复制、转移等 
  - 字节输入流 InputStream；
  - 实现类：
    - FileInputStream：文件字节输入流。把文件中的数据读入到内存中。
    - BufferedInputStream：缓冲字节输入流
    - ByteArrayInputStream：字节数组输入流
  - 字节输出流 OutputStream；
  - 实现类：
    - FileOutputStream：文件字节输出流
    - BufferedOutputStream：缓冲字节输出流
    - ByteArrayOutputStream：字节数组输出流
- 字符流：操作纯文本文件，比如txt、html文件等 
  - 字符输入流 Reader；
  - 实现类：
    - FileReader：文件字符输入流
    - BufferedReader：缓冲字符输入流
    - CharArrayReader：字符数组输入流
  - 符输出流 Writer；
  - 实现类
    - FileWriter：文件字符输出流
    - BufferedWriter：缓冲字符输出流
    - CharArrayWriter：字符数组输出流



