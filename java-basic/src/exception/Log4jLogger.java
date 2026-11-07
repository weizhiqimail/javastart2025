package exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLogger {
    private static final Logger logger = LogManager.getLogger(CustomException.class);

    public static void main(String[] args) {
        loggerFn1();
    }

    public static void loggerFn1() {
        logger.trace("trace 日志");
        logger.debug("debug 日志");
        logger.info("info 日志：username = {}, age = {}", "jack", 18);

        logger.warn("warn 日志");
        logger.error("error 日志");
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            logger.error("计算错误", e);
        }
    }
}
