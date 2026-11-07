package safe;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class EncodeTest {

    public static void main(String[] args) throws Exception {
        encodeFn2();
        encodeFn3();
        encodeFn4();
    }

    public static void encodeFn1() {
        String encoded = URLEncoder.encode("你好", StandardCharsets.UTF_8);
        System.out.println(encoded);

        String decoded = URLDecoder.decode("%E4%BD%A0%E5%A5%BD", StandardCharsets.UTF_8);
        System.out.println(decoded);
    }

    public static void encodeFn2() throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("Hello".getBytes(StandardCharsets.UTF_8));
        md.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest();
        System.out.println(HexFormat.of().formatHex(result));
    }

    public static void encodeFn3() throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        sha1.update("Hello".getBytes(StandardCharsets.UTF_8));
        sha1.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result = sha1.digest();
        System.out.println(HexFormat.of().formatHex(result));
    }

    public static void encodeFn4() throws Exception {
        // 密钥生成器
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        // 生成一个随机密钥（所以每次运行结果都不同）
        SecretKey key = keyGen.generateKey();
        // 把密钥转成字节数组，便于保存或传输
        byte[] skey = key.getEncoded();
        System.out.println(HexFormat.of().formatHex(skey));

        // 创建 HMAC 计算器
        Mac mac = Mac.getInstance("HmacMD5");
        // 用密钥初始化
        mac.init(key);
        // 输入数据，可多次调用
        mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        // 计算结果，HmacMD5 输出 16 字节
        byte[] result = mac.doFinal();
        System.out.println(HexFormat.of().formatHex(result));
    }
}
