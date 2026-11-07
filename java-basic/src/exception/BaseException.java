package exception;

// 自定义异常
public class BaseException extends RuntimeException {

    public BaseException() {
        super();
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

}

class UserNotFoundException extends  BaseException {}
class LoginFailedException extends  BaseException {}
