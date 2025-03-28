package exception;

// 自定义编译异常
public class CustomCompilerException extends RuntimeException {

  public CustomCompilerException(String message) {
    super(message);
  }

  public CustomCompilerException() {

  }

}
