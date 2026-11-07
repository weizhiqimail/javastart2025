package date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.*;


public class DateTest1 {

    public static void main(String[] args) {
        dateFn5();
    }

    public static void dateFn1() {
        int n = 123400;
        System.out.println("n = " + n);
        System.out.println("n hex = " + Integer.toHexString(n));
        System.out.println("美国货币格式：" + NumberFormat.getCurrencyInstance(Locale.US).format(n));
        System.out.println("中国货币格式：" + NumberFormat.getCurrencyInstance(Locale.CHINA).format(n));
        System.out.println("英国货币格式：" + NumberFormat.getCurrencyInstance(Locale.UK).format(n));
        System.out.println("法国货币格式：" + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(n));
        System.out.println("日本货币格式：" + NumberFormat.getCurrencyInstance(Locale.JAPAN).format(n));
        System.out.println("香港货币格式：" + NumberFormat.getCurrencyInstance(Locale.forLanguageTag("zh-HK")).format(n));
        System.out.println("澳门货币格式：" + NumberFormat.getCurrencyInstance(Locale.forLanguageTag("zh-MO")).format(n));
        System.out.println("台湾货币格式：" + NumberFormat.getCurrencyInstance(Locale.TAIWAN).format(n));
        System.out.println("加拿大货币格式：" + NumberFormat.getCurrencyInstance(Locale.CANADA).format(n));
    }

    public static void dateFn2() {
        Date date = new Date();
        System.out.println(date.getYear());
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());

        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }

    public static void dateFn3() {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_WEEK);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.printf("%04d-%02d-%02d %02d:%02d:%02d.%03d", year, month, date, hour, minute, second, ms);
    }

    public static void dateFn4(){
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);

        LocalDate ld1 = ldt.toLocalDate();
        LocalTime lt1 = ldt.toLocalTime();
        System.out.println(ld1);
        System.out.println(lt1);

        LocalDateTime startTime = LocalDateTime.of(2026, 11, 1, 18, 30, 0);
        LocalDateTime endTime = LocalDateTime.of(2026, 11, 2, 20, 20, 30);
        Duration d = Duration.between(startTime, endTime);
        System.out.println(d);

        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2021, 2, 10);
        Period p = startDate.until(endDate);
        System.out.println(p);


    }

    public static void dateFn5(){
        ZonedDateTime zdt = ZonedDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        System.out.println(formatter.format(zdt));
    }
}
