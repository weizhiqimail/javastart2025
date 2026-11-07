package exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Logger;

public class CustomException {

    public static void main(String[] args) throws Exception {
        exceptionFn3();
    }

    public static void exceptionFn1() {
        byte[] bs = toGBK1("中文");
        System.out.println(Arrays.toString(bs));
    }

    public static byte[] toGBK1(String str) {
        try {
            return str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            System.out.println("报错了");
            System.out.println(e);
            return str.getBytes();
        }
    }

    public static void exceptionFn2() throws Exception {
        byte[] bs = toGBK2("中文");
        System.out.println(Arrays.toString(bs));
    }

    public static byte[] toGBK2(String str) throws UnsupportedEncodingException {
        return str.getBytes("GBK");
    }

    public static void exceptionFn3() throws Exception {
        Exception originException = null;
        Logger logger = Logger.getLogger(CustomException.class.getName());
        logger.info("start process...");

        try {
            process1();
        } catch (Exception e) {
            logger.fine("catch Exception(e)" + e);
            originException = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (originException != null) {
                e.addSuppressed(originException);
            }
            logger.fine("finally Exception(e)" + e);
            throw e;
        }
    }

    public static void process1() {
        try {
            process2(null);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void process2(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
    }


}
